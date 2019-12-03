package com.guoxuezhishi.controller.wechat;

import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.wechat.Zhongyaoxue;
import com.guoxuezhishi.service.ZhongyaoxueService;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: jiang
 * @date: 2019/12/2
 */
@RestController
@Api(value = "中药XML上传解析", tags = "中药XML上传解析")
public class ZhongyaoUploadController extends BaseController {
    @Autowired
    private ZhongyaoxueService zhongyaoxueService;

    @PostMapping(value = "/xmlUpload", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "中药XML上传解析", notes = "中药XML上传解析")
    @ApiImplicitParam(name = "xueke", value = "xueke", required = true, dataType = "String", paramType = "query", defaultValue = "国学")
    public GXJSONResult upload(String xueke, @RequestParam("file") MultipartFile file) throws Exception {
        //上传文件
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        String fileSpase = "D:/guoxuezhishi";
        String uploadPathDB = "/" + xueke;
        String fileName = file.getOriginalFilename();
        try {
            if (file != null && file.getSize() > 0) {
                if (StringUtils.isNotBlank(fileName)) {
                    String finalXmlPath = fileSpase + uploadPathDB + "/" + fileName;
                    File outfile = new File(finalXmlPath);
                    if (outfile.getParentFile() == null || !outfile.getParentFile().isDirectory()) {
                        outfile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outfile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return GXJSONResult.errorMsg("上传出错！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return GXJSONResult.errorMsg("上传出错！");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        //解析文件
        Workbook workbook;
        if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        } else if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            return GXJSONResult.errorMsg("文件格式非excl");
        }
        //判断第一页不为空
        Sheet sheetAt = workbook.getSheetAt(0);
        if (null != sheetAt) {
            //总行数
            int totalNum = sheetAt.getLastRowNum();
            logger.info("总记录数：" + totalNum);
            //读取excel第二行，从1开始
            for (int rowNumofSheet = 1; rowNumofSheet <= totalNum; rowNumofSheet++) {
                //当前行记录
                Row row = sheetAt.getRow(rowNumofSheet);
                if (null != row) {
                    logger.info("当前记录为：" + rowNumofSheet);
                    Zhongyaoxue zhongyaoxue = new Zhongyaoxue();
                    Cell cell0 = row.getCell(0);
                    Cell cell1 = row.getCell(1);
                    Cell cell2 = row.getCell(2);
                    Cell cell3 = row.getCell(3);
                    Cell cell4 = row.getCell(4);
                    zhongyaoxue.setFenlei(cell0.getStringCellValue());
                    zhongyaoxue.setZhongyaoming(cell1.getStringCellValue());
                    zhongyaoxue.setXingwei(cell2.getStringCellValue());
                    zhongyaoxue.setGuijing(cell3.getStringCellValue());
                    zhongyaoxue.setZuoyong(cell4.getStringCellValue());
                    logger.info(zhongyaoxue.toString());
                    zhongyaoxueService.saveZhongyao(zhongyaoxue);
                }
            }
        }
        return GXJSONResult.ok();
    }
}
