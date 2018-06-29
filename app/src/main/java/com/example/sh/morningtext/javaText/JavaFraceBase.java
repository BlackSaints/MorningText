package com.example.sh.morningtext.javaText;

import java.util.HashSet;

public class JavaFraceBase {

    public static void main(String[] args){
//        equalsText();
//        equalsText1();
//        hashcodeText();
//        integerText();
        StringText();
    }

    private static void StringText() {
        String s0 = "a";
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = s0+"bc";
        String s5 = new String("ab")+"c";
        // 常量池中只有一个内存地址
        if(s1 == s2){
            System.out.println("s1==s2"); //true
        }
        //常量池中
        if(s1 == s4){
            System.out.println("s1 == s4");//false
        }

        if(s1 == s5){
            System.out.println("s1 == s5");//false
        }

        if(s3 == s5){
            System.out.println("s3 == s5");//false
        }










    }

    /**
     * Integer 使用
     */
    private static void integerText() {
        Integer i = 9;
        Integer i1 = new Integer(9);
        if(i == i1){
            System.out.println("==");
        }else{
            System.out.println("!=");
        }

        if(i.equals(i1)){
            System.out.println("equals");
        }else{
            System.out.println("!equals");
        }


    }

    /**
     * hashcode 使用
     */
    private static void hashcodeText() {

        HashSet<PersonModel> hashSet = new HashSet<>();
        PersonModel p1 = new PersonModel(1);
        PersonModel p2 = new PersonModel(1);

        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println("hashSet size = "+hashSet.size());

    }

    /**
     * equals
     */
    private static void equalsText1() {
        String s1 = "hello";
        String s2 = "hello";


        PersonModel m1 = new PersonModel(1);

        PersonModel m2 = new PersonModel(2);

        if(s1.equals(s2)){
            System.out.println("s1 equals s2");
        }else {
            System.out.println("s1 !equals s2");
        }


        if(m1.equals(m2)){
            System.out.println("m1 equals m2");
        }else {
            System.out.println("m1 !equals m2");
        }

        if(m1.hashCode() == m2.hashCode()){
            System.out.println("m1.hashCode = "+m1.hashCode());
        }else{
            System.out.println("m1.hashCode = "+m1.hashCode());
            System.out.println("m2.hashCode = "+m2.hashCode());
        }
        System.out.println("s1.hashCode = "+s1.hashCode());
        System.out.println("s2.hashCode = "+s2.hashCode());
    }

    /*
    *  ==
    *
    * */
    private static void equalsText() {
        int a1 = 5;
        int a2 = 6;
        String s1 = "hello";
        String s2 = "hello";
        boolean b1 = true;
        boolean b2 = false;
        char c1 = 'a';
        char c2 = 'a';
        PersonModel m1 = new PersonModel(1);

        PersonModel m2 = new PersonModel(2);

        if(a1 == a2){
            System.out.println("a1=a2");
        }else{
            System.out.println("a1!=a2");
        }
        //字符串存在常量池中，如果常量池存在则不会分配新的内存地址
        if(s1 == s2){
            System.out.println("s1==s2");
        }else {
            System.out.println("s1!=s2");
        }

        if(b1 == b2){
            System.out.println("b1==b2");
        }else {
            System.out.println("b1!=b2");
        }

        if(c1 == c2){
            System.out.println("c1 == c2");
        }else{
            System.out.println("c1!=c2");
        }
        //引用数据类型 == 判断的是内存中的地址是否是同一个
//        m2 = m1;
        if(m1 == m2){
            System.out.println("m1 == m2");
        }else {
            System.out.println("m1 != m2");
        }
    }
}

class PersonModel{
    int id;
    String name;
    public PersonModel(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        PersonModel antherObj = (PersonModel) obj;
        if(obj != null){
            if(this.id == antherObj.id){
                return true;
            }
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {

        return id+5;
    }
}
