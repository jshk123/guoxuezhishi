package com.guoxuezhishi.ygtest;

import com.yuangou.ecp.bp.core.common.message.YGEDB;
import com.yuangou.ecp.bp.core.common.message.YGEDBFactory;
import com.yuangou.ecp.bp.core.common.message.YGXmlEDB;

/**
 * @author: jiang
 * @date: 2019/8/20
 */
public class EDBTest {
    public static void main(String[] args) {
        YGEDB ygedb = YGEDBFactory.createEDB();
//        YGEDB ygedb = new YGXmlEDB();
        ygedb.setChildValue("acc", "111");
        ygedb.setChildValue("ordNo", "222");
        ygedb.setChildValue("payAcno", "333");
        ygedb.setChildValue("payAcname", "444");
        ygedb.setChildValue("amt", "555");
        String edbString1 = ygedb.getXmlString();
        System.out.println(edbString1);
    }
}
