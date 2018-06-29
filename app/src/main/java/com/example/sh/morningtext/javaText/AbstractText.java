package com.example.sh.morningtext.javaText;

public abstract class AbstractText {

    //1.含有抽象方法的类必须是抽象类
    //2.抽象方法不能有body实现
    public abstract String getName();
}

//继承抽象类必须实现抽象方法
class AbstractDemo extends AbstractText{

    @Override
    public String getName() {
        return null;
    }

    public static void main(String[] args) {

        AbstractText abstractText = new AbstractDemo();
        AbstractText abstractText1 = new AbstractText() {
            @Override
            public String getName() {
                return null;
            }
        };
    }
}
