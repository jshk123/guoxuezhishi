package com.guoxuezhishi.druid;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

/**
 * @Description TODO
 * @Created jiang
 */
public class DruidTest {
    @Test
    public void test1() {
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJTz08lgiP0fX6VmRhS59z0rTq1N19LzDXeauD/CTqg01RJhPZhTvpT/mM0NeliYThajkAyGq09Gatdkdzfo1WECAwEAAQ==";
        String password = "IH5NwKGbYhWra+9xyA8NRarFBeRVlgFIRwO6NnJ2YtoFPtKrivtb5Z7MHUU5gUSzPYVsG2pkzzDhosK8Ye9pFQ==";
        String value = null;
        try {
            value = ConfigTools.decrypt(publicKey, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("解密后：" + value);
    }
}
