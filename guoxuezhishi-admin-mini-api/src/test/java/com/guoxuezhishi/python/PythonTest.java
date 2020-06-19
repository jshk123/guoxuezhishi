package com.guoxuezhishi.python;

import org.junit.Test;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Description python工具类
 * @Created jiang
 */
public class PythonTest {

    //手动编写
    @Test
    public void test2() {
        //解决报错Cannot import site module and its dependencies: No module named site
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("num=[13,7,2,9,14,7,6]; ");
        interpreter.exec("print(sorted(num));");
    }

    //带参数
    @Test
    public void test1() {
        String a = "1";
        String b = "2";
        Process proc = null;
        BufferedReader in = null;
        try {
            String pyRec = this.getClass().getResource("/python/pytest1.py").getPath().substring(1);
            System.out.println(pyRec);
            String[] args = new String[]{"python", pyRec, a, b};
            proc = Runtime.getRuntime().exec(args);
            in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            proc.waitFor();
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
