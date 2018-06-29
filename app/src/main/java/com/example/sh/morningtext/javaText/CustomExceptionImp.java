package com.example.sh.morningtext.javaText;

public class CustomExceptionImp {

    public static void main(String[] args){
        fun1();
    }

    private static void fun1() {
        try {
            fun2();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.print("捕捉到MyException");
        }
    }

    private static void fun2() throws MyException {
        throw new MyException("测试自定义exception",1);
    }


}
