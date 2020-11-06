package com.guoxuezhishi.controller.gongjulei;

import com.guoxuezhishi.utils.GXJSONResult;
import com.spire.doc.Document;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.widget.PdfPageCollection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Description TODO
 * @Created jiang
 */
@RestController
@Api(value = "小工具", tags = "小工具")
public class UtilsController {


    //  如果是大文件，需要进行切分，保存的子pdf路径
    String splitPath = "./split/";
    //  如果是大文件，需要对子pdf文件一个一个进行转化
    String docPath = "./doc/";

    @PostMapping(value = "/p2wStream", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "PDF转WORD流", notes = "PDF转WORD流的接口")
    public GXJSONResult p2wStream(@ApiParam(value = "pdf文件", required = true) MultipartFile file, HttpServletResponse response) throws Exception {
        String fileName = file.getOriginalFilename();
        String desPath = fileName.substring(0, fileName.length() - 4) + ".docx";
        if (!fileName.endsWith(".pdf")) {
            throw new Exception("非pdf文件");
        }
        long size = file.getSize();
        if (size >= 1024 * 1024 * 20) {
            throw new Exception("文件大于20M了");
        }
        File f = new File(splitPath);
        File f1 = new File(docPath);
        if (!f.exists()) f.mkdirs();
        if (!f1.exists()) f1.mkdirs();

        // 1、加载pdf
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromBytes(file.getBytes());
        //输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // 2、如果pdf的页数小于50，那么直接进行转化
        PdfPageCollection num = pdf.getPages();
        boolean result = false;
        if (num.getCount() <= 50) {
            //流文件
            pdf.saveToStream(os, FileFormat.DOCX);

            //以上Spire.Doc 生成的文件会自带警告信息，这里来删除Spire.Doc 的警告
            XWPFDocument document = new XWPFDocument(new ByteArrayInputStream(os.toByteArray()));
            document.removeBodyElement(0);
            os.reset();
            document.write(os);

        }    // 3、否则输入的页数比较多，就开始进行切分再转化
//        else {
//            // 第一步：将其进行切分,每页一张pdf
//            pdf.split(splitPath + "test{0}.pdf", 0);
//
//            // 第二步：将切分的pdf，一个一个进行转换
//            File[] fs = getSplitFiles(splitPath);
//            for (int i = 0; i < fs.length; i++) {
//                PdfDocument sonpdf = new PdfDocument();
//                sonpdf.loadFromFile(fs[i].getAbsolutePath());
//                sonpdf.saveToFile(docPath + fs[i].getName().substring(0, fs[i].getName().length() - 4) + ".docx", FileFormat.DOCX);
//            }
//            boolean flag = false;
//            //第三步：对转化的doc文档进行合并，合并成一个大的word
//            try {
//                flag = this.merge(docPath, docPath + desPath, os);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            //4、把刚刚缓存的split和doc删除
//            if (flag) {
//                this.clearFiles(splitPath);
//                this.clearFiles(docPath);
//            }
//        }

        response.reset();
        response.setContentType("application/docx");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(desPath.getBytes("UTF-8"), "ISO-8859-1"));
        os.writeTo(response.getOutputStream());
        if (os != null) {
            os.close();
        }
        return GXJSONResult.ok();
    }

    @PostMapping(value = "/p2wFile", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "PDF转WORD文件", notes = "PDF转WORD文件的接口")
    public GXJSONResult p2wFile(@ApiParam(value = "pdf文件", required = true) MultipartFile file, HttpServletResponse response) throws Exception {
        String fileName = file.getOriginalFilename();
        String desPath = fileName.substring(0, fileName.length() - 4) + ".docx";
        if (!fileName.endsWith(".pdf")) {
            throw new Exception("非pdf文件");
        }
        long size = file.getSize();
        if (size >= 1024 * 1024 * 20) {
            throw new Exception("文件大于20M了");
        }
        File f = new File(splitPath);
        File f1 = new File(docPath);
        if (!f.exists()) f.mkdirs();
        if (!f1.exists()) f1.mkdirs();

        //加载pdf
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromBytes(file.getBytes());
        //本地文件
        pdf.saveToFile(docPath + desPath, FileFormat.DOCX);

        //重新读取生成的文档
        InputStream is = new FileInputStream(new File(docPath + desPath));
        XWPFDocument document = new XWPFDocument(is);
        //以上Spire.Doc 生成的文件会自带警告信息，这里来删除Spire.Doc 的警告
        document.removeBodyElement(0);
        //输出word内容文件流，新输出路径位置
        OutputStream os = new FileOutputStream(docPath + desPath);
        try {
            document.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }

        return GXJSONResult.ok();
    }


    // 取得某一路径下所有的pdf
    private static File[] getSplitFiles(String path) {
        File f = new File(path);
        File[] fs = f.listFiles();
        if (fs == null) {
            return null;
        }
        return fs;
    }

    private static boolean merge(String docPath, String desPath, ByteArrayOutputStream os) throws FileNotFoundException {

        File[] fs = getSplitFiles(docPath);
        Document document = new Document(docPath + "test0.docx");

        for (int i = 1; i < fs.length; i++) {
            document.insertTextFromFile(docPath + "test" + i + ".docx", com.spire.doc.FileFormat.Docx_2013);
        }
        //第四步：对合并的doc进行保存2
        document.saveToFile(desPath);
        document.saveToStream(os, com.spire.doc.FileFormat.Docx);
        return true;
    }


    //删除文件和目录
    public void clearFiles(String workspaceRootPath) {
        File file = new File(workspaceRootPath);
        if (file.exists()) {
            deleteFile(file);
        }
    }

    public void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteFile(files[i]);
            }
        }
        file.delete();
    }

}
