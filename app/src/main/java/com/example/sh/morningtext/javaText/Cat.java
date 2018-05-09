package com.example.sh.morningtext.javaText;

public class Cat {

    public static int sid = 100;
    public int id;
    public String name;
    private int m;
    public Cat(int id,String name){
        this.id = id;
        this.name = name;
    }


    public static void main(String[] args){
        int id = Cat.sid;
        Cat cat1 = new Cat(1,"mimi");
        Cat cat2 = new Cat(2,"pipi");
    }

}
