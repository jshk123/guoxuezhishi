package com.guoxuezhishi.utils;

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
public class MergeVideoMp3 {
    private String ffmpegEXE;

    public MergeVideoMp3(String ffmpegEXE) {
        this.ffmpegEXE = ffmpegEXE;
    }

    public void convertor(String videoInputPath,String mp3InputPath,double seconds, String videoOutputPath) throws IOException {
        List<String> command = new ArrayList<>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(videoInputPath);
        command.add("-i");
        command.add(mp3InputPath);
        command.add("-t");
        command.add(String.valueOf(seconds));
        command.add("-y");
        command.add(videoOutputPath);
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        for (String i : command) {
            System.out.print(i + " ");
        }
        System.out.println("");
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
        MergeVideoMp3 ffmpeg = new MergeVideoMp3("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpeg.convertor("D:\\ffmpeg\\bin\\ceshi.mp4","D:\\ffmpeg\\bin\\bgm.mp3" ,16.01,"D:\\ffmpeg\\bin\\output.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
