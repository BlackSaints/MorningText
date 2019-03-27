package com.example.sh.morningtext;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sub(){
        String url = "http://1671ye8063.iask.in/account/security/redirectapp?resultInfo.code=0&resultInfo.msg=%E4%BA%B2%EF%BC%8C%E7%B3%BB%E7%BB%9F%E7%B9%81%E5%BF%99%EF%BC%81";
        int start = url.indexOf("%");
        int end = url.length();

        String url1 = null;
        try {
            url1 = URLDecoder.decode(url.substring(start, end), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assertEquals("%E4%BA%B2%EF%BC%8C%E7%B3%BB%E7%BB%9F%E7%B9%81%E5%BF%99%EF%BC%81",url1);
    }
}