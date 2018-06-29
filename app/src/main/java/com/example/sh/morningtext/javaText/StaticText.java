package com.example.sh.morningtext.javaText;

public class StaticText {

    public static void m(){
        System.out.println("父类的静态方法");
    }
}

class ChildText extends StaticText{

    public static void m(){
        System.out.println("子类的静态方法");
    }
}
