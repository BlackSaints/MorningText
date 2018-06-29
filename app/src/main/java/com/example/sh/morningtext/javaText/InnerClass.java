package com.example.sh.morningtext.javaText;

/**
 * 内部类作用
 * 1.隐藏内部实现
 * 2.实现多重继承
 * 3.
 */
public class InnerClass {
    private String name = "zhangsan";
    //成员内部类
    private class Factory{
        public String getName(){
            //1.访问外部类
            return name;
        }
    }

    public Factory getFactory(){
        return new Factory();
    }

    public void setInner(final String name1){

        new Inner() {
            String name ;
            @Override
            public String getName() {

                return name;
            }

            @Override
            public void setName() {
                this.name = name1;
                System.out.println("name===="+name);
            }
        }.setName();
    }

    public void text(Bird bird){
        System.out.println(bird.getName()+"准备"+bird.fly());
    }

    public static void main(String[] args){
        InnerClass innerClass = new InnerClass();
//        System.out.println("name=="+innerClass.getFactory().getName());;
//        innerClass.setInner("lisi");

        innerClass.text(new Bird(){

            @Override
            public String getName() {
                return "小黄鸟";
            }

            @Override
            public String fly() {
                return "展翅翱翔";
            }
        });



    }

    public interface Inner{
        public String getName();
        public void  setName();
    }


    public abstract static class Bird{

        private String name;

        public String getName(){
            return name;
        };

        public void setName(String name){
            this.name = name;
        };

        public abstract String fly();


    }

}
