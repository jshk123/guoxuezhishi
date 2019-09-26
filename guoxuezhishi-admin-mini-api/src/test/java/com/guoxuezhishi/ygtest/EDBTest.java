package com.guoxuezhishi.ygtest;

import com.yuangou.ecp.bp.comp.expr.YGExpUtil;
import com.yuangou.ecp.bp.core.common.exception.YGException;
import com.yuangou.ecp.bp.core.common.message.YGEDB;
import com.yuangou.ecp.bp.core.common.message.YGEDBFactory;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jiang
 * @date: 2019/8/20
 */
public class EDBTest {
    /**
     * 创建edb 并转为xml
     */
    @Test
    public void ygedbxml() {
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

    @Test
    public void ygedbdate() throws YGException {
        //普通方法
/*        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date nowdate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowdate);
        calendar.add(Calendar.DATE, 3);
        Date lastdate = calendar.getTime();
        String last = df.format(lastdate);
        System.out.println("last:" + last);*/
        // YGExpUtil方法
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date nowdate = new Date();
        String last = df.format(nowdate);
        System.out.println("last:" + last);
//        last = YGExpUtil.calc_date(last, "-", "d", 3);
        last = YGExpUtil.calc_time(last, "+", "m", -10, "yyyyMMddHHmmss").substring(8);
        System.out.println("last:" + last);
    }

    @Test
    public void timeTest() throws YGException {
        String time = YGExpUtil.get_date_time("yyyy-MM-dd HH:mm:ss");
        System.out.println(time);
    }

}
