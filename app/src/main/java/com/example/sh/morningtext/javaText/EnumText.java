package com.example.sh.morningtext.javaText;

/**
 * 枚举类型
 */
public class EnumText {

    //定义枚举
    public enum MyDoorOpener{ me , wife};

    public static void main(String[] args) {
        //实例化，必须是枚举默认类型
//        MyDoorOpener m = 0;//错误的
        MyDoorOpener  m = MyDoorOpener.me;
        switch (m) {
            case me:
                System.out.println("me");
                break;
            case wife:
                System.out.println("wife");
                break;
            default:
                System.out.println("default");
                break;
        }
    }

}
