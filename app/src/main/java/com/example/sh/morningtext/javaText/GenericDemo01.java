package com.example.sh.morningtext.javaText;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo01 {

    public static void main(String[] args) {

//        defaultText();

//        genericText();
//
//        genericRunningText();
//
//        genericClassText();

//        genericFatherText();
//
//        genericMethod(new GenericDemo<Object>());

//        genericExtend();

          genericExtend2();
    }

    private static void genericExtend2() {

        List<? extends Frulit> list = new ArrayList<>();
//        list.add(new Frulit());//error 上边界 编译器无法确定List所持有的类型，所以无法安全的向其中添加对象
//        list.add(new Apple());//error
        list.add(null);

        Frulit frulit = list.get(0);
        List<Frulit> list1 = new ArrayList<Frulit>();
//        list1.add(new Apple());

        getericExtendChild(list1);

        List<Apple> list2 = new ArrayList<>();


        List<? extends Frulit> list3 = new ArrayList<Apple>();


        List<GreenApple> list4 = new ArrayList<>();
//
//        genericSuperChild(list4);


    }

    private static void genericSuperChild(List<? super Apple> list2) {
        Frulit apple = (Frulit) list2.get(0);
        GreenApple apple1 = (GreenApple) list2.get(0);
    }


    private static void getericExtendChild(List<? extends Frulit> list) {
        Frulit apple = list.get(0);

    }

    /**
     *
     * 泛型上下边界
     */
    private static void genericExtend() {

        GenericExtends<Integer> integerGenericExtends = new GenericExtends<>();
            //String 不是 Number的子类
//        GenericExtends<String> genericExtends = new GenericExtends();


    }

    /**
     * 泛型方法
     * @param <T>
     * @return
     */
    public static <T> T genericMethod(GenericDemo<T> genericDemo){
        T test = genericDemo.getName();
        return test;
    }
    /**
     * 测试泛型父类
     * 1.GenericDemo<Integer> 不是 GenericDemo<Number>的子类
     * 2.不同类型的泛型是不兼容的
     */
    private static void genericFatherText() {
        GenericDemo<Integer> integerGenericDemo = new GenericDemo<>(123);
        GenericDemo<Number> numberGenericDemo = new GenericDemo<Number>(456);
        showDiff(integerGenericDemo);
        showDiff(numberGenericDemo);
    }

    /**
     * 通配符的使用
     * 此处的“？”先当于Integer Number String 的父类
     * @param numberGenericDemo
     */
    private static void showDiff(GenericDemo<?> numberGenericDemo) {

        System.out.println(numberGenericDemo.getName());
    }

    /**
     * 泛型类
     */
    private static void genericClassText() {

        GenericDemo<String> generic = new GenericDemo<>();
        generic.setName("zhangsan");
        System.out.println(generic.getName());


        GenericDemo<Integer> generic1 = new GenericDemo<>();
        generic1.setName(1);
        System.out.println(generic1.getName());


        GenericDemo generic2 = new GenericDemo();
        generic2.setName(1.00);
        System.out.println(generic2.getName());

        GenericDemo<String> generic3 = new GenericDemo<>("lisi");
        System.out.println(generic3.getName());
    }


    /**
     * 测试泛型只在编译期有效
     * 1.泛型信息在编译后 泛型信息擦除
     * 2.泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     */
    private static void genericRunningText() {

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        Class strClass = stringList.getClass();
        Class intClass = integerList.getClass();

        if (strClass.equals(intClass)) {
            System.out.println("类型相同");
        } else {
            System.out.println("类型不同");
        }
    }

    /**
     * 使用泛型对集合进行操作
     */
    private static void genericText() {
        List<String> list = new ArrayList<>();
//        list.add(1);  //1.这种写法编译时会报错
        list.add("xiaoming");
        list.add("baby");

        for (int i = 0; i < list.size(); i++) {
            //2.不需要强制转换
            String str = list.get(i);
            System.out.println(str);
        }

    }

    /**
     * 不适用泛型对集合进行操作
     */
    private static void defaultText() {
        List list = new ArrayList();
        list.add(1);
        list.add("1");
        list.add(1.0);

        for (int i = 0; i < list.size(); i++) {
            //1.编译时发现不出问题，运行出错
            //2.需要强制转换，容易出现转换异常
            String string = (String) list.get(i);
        }
    }


}

/**
 * 泛型类
 *
 * @param <T> 表示是泛型类
 */
class GenericDemo<T> {

    public T name;

    public GenericDemo() {

    }


    public GenericDemo(T name) {
        this.name = name;
    }


    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}


/**
 * 泛型接口
 */
interface GenericIn<T> {

    T next();
    String loop(T loop);
}

/**
 * 实现泛型接口第一种方式
 */

class GenericIm01 implements GenericIn<String>{

    @Override
    public String next() {
        return null;
    }

    @Override
    public String loop(String loop) {
        return null;
    }
}

/**
 * 实现泛型接口第二种方式
 */

class GenericIm02<T> implements GenericIn<T>{

    @Override
    public T next() {
        return null;
    }

    @Override
    public String loop(T loop) {
        return null;
    }
}

class GenericExtends<T extends Number>{

    public GenericExtends(){

    }
}

class Frulit{

}

class Apple extends Frulit{

}

class Banner extends Frulit{

}

class GreenApple extends Apple{

}

