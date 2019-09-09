package com.guoxuezhishi.test;

import java.io.IOException;
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
        processBuilder.start();
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
