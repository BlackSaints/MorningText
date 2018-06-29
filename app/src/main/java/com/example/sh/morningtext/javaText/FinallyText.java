package com.example.sh.morningtext.javaText;

public class FinallyText{

    final String str = "abc";
    final int i = 10;
    public String ss;
    public static void main(String[] args) {
        FinallyText finallyText = new FinallyText();
//        final修饰的变量不能被修改
//        finallyText.str = "1231231";

        text(finallyText.i);
        text2(finallyText,finallyText.ss);
    }

    private static void text2(FinallyText finallyText, final String ss) {

        finallyText.text1(new ClickListener() {
            @Override
            public void click(String msg) {
                msg = msg +ss;
            }
        });
    }

    private static void text(int i) {
        //此处i是局部参数
        i = 23;

    }

    public void text1(ClickListener clickListener){

    }


}

final class FinalInner{

}


interface ClickListener{
    void click(String msg);
}
//final 修饰的类不能被继承
//class ChildFianl extends FinalInner{
//
//}
