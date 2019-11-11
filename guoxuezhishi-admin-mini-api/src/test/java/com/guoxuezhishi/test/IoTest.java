package com.guoxuezhishi.test;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: jiang
 * @date: 2019/8/8
 */
public class IoTest {
    @Test
    public void testIo() {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        String body = "hello world~\n";
        String dir = "D:/demo/jsptest/jsptest.txt";
        File file = new File(dir);
        if (file.getParentFile() != null || !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(body.getBytes());
            bufferedOutputStream.write(body.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}


