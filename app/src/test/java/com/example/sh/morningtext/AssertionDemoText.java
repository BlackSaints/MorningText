package com.example.sh.morningtext;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class AssertionDemoText {

    @BeforeClass
    public static void beforeClassText(){
        System.out.println("------beforeClass------");
    }

    @Before
    public void beforeText(){
        System.out.println("------before------");
    }

    @Test
    public void textA(){
        System.out.println("------textA------");

    }

    @Test
    public void textB(){
        System.out.println("------textB------");
    }

    @After
    public void afterText(){
        System.out.println("------after------");
    }

    @AfterClass
    public static void afterClassText(){
        System.out.println("------afterClass------");
    }

    /**
     *  断言两个值相同
     */
    @Test
    public void assertEqualsText(){
        assertEquals(4,2+2);
    }
    /**
     *  断言两个值不相同
     */
    @Test
    public void assertNotEqualsText(){
        assertNotEquals(4,3);
    }

    /**
     *  断言两个对象引用同一个
     */
    @Test
    public void assertSameText(){
        String a = "123";
        String b = "123";
        assertSame(a,b);
    }

    /**
     * 判断某个对象是null
     */
    @Test
    public void assertNullText(){
        String c = null;
        assertNull(c);
    }

    @Test
    public void assertTrueText(){
        boolean d = true;
        assertTrue(d);
    }

    @Test
    public void startWithText(){
        String a = "hello";
        assertThat(a, startsWith("he"));
        assertThat(a,endsWith("lo"));
        assertThat(a,CoreMatchers.containsString("e"));
        assertThat(a, CoreMatchers.equalTo(a));
    }

    @Test
    public void numText(){
        assertThat("hello",CoreMatchers.allOf(startsWith("he"),endsWith("lo")));
        assertThat("htllo",CoreMatchers.anyOf(startsWith("h"),endsWith("h")));
        assertThat("hello",CoreMatchers.both(startsWith("he")).and(endsWith("lo")));
    }


}
