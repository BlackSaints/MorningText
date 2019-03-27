package com.example.sh.morningtext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@RunWith(Parameterized.class)
public class DateUtilTest {

    private String time = "2017-10-15";
    private long timeStamp = 1508054402000L;
    private Date date;

    public DateUtilTest(String time){
        this.time = time;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
        date = new Date();
        date.setTime(timeStamp);
    }

    @After
    public void over()throws Exception{
        System.out.println("测试结束");
    }

    @Parameterized.Parameters
    public static Collection parameter(){
        return Arrays.asList(new String[]{
                "2017-10-15",
                "2017-10-15 16:00:00",
                "2017年10月15日 16时00分00秒"
        });
    }

    @Test(expected = ParseException.class)
    public void dateToStamp() throws ParseException {
//        try {
//            assertNotEquals(4,DateUtil.dateToStamp(time));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        DateUtil.dateToStamp(time);
    }

//    @Test
//    public void stampToDate() throws Exception{
//
//        assertEquals("测试时间",DateUtil.stampToDate(timeStamp));
//
//    }
}