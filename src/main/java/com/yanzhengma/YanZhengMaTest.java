package com.yanzhengma;

/**
 * @author: jiang
 * @date: 2019/10/11
 */
public class YanZhengMaTest {

    public static void main(String[] args) {

        //原始验证码地址
        String OriginalImg = "D:\\demo\\oi.jpg";
        //识别样本输出地址
        String ocrResult = "D:\\demo\\or.jpg";
        System.out.println("去噪点");
        //去噪点
        com.yanzhengma.ImgUtils.removeBackground(OriginalImg, ocrResult);
        System.out.println("裁剪边角");
        //裁剪边角
        com.yanzhengma.ImgUtils.cuttingImg(ocrResult);
        System.out.println("OCR识别");
        //OCR识别
        String code = com.yanzhengma.Tess4J.executeTess4J(ocrResult);
        //输出识别结果
        System.out.println("Ocr识别结果: \n" + code);

    }

}
