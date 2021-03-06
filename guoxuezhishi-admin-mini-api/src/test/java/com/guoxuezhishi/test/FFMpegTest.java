package com.guoxuezhishi.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiang
 * @date: 2019/9/5
 */
public class FFMpegTest {
    private String ffmpegEXE;

    public FFMpegTest(String ffmpegEXE) {
        this.ffmpegEXE = ffmpegEXE;
    }

    public void convertor(String videoInputPath, String videoOutputPath) throws IOException {
        List<String> command = new ArrayList<>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(videoInputPath);
        command.add(videoOutputPath);
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        for (String i : command) {
            System.out.print(i + " ");
        }
        Process process = processBuilder.start();
        //处理错误流
        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        if (br != null) {
            br.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }

    }

    public static void main(String[] args) {
        FFMpegTest ffmpeg = new FFMpegTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpeg.convertor("D:\\ffmpeg\\bin\\测试视频.mp4", "D:\\ffmpeg\\bin\\测试视频-output.avi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
