package com.example.sh.morningtext.javaText;

import java.util.ArrayList;
import java.util.List;

public class GengerDemo01 {

    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.setName("泛型类String");

        Generic<Integer> integerGeneric = new Generic<>();
        integerGeneric.setName(123);

        System.out.println(generic.getName()+"      "+integerGeneric.getName());
    }

    public static String tell(Generic<Object> generic){
        return (String) generic.getName();
    }
}

/**
 * 泛型类
 * @param <T>
 */
class Generic<T>{
    public T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
    //泛型方法
    public <T> T tell(T type){
        return (T) name;
    }
}

