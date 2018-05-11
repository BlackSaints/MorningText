package com.example.sh.morningtext.javaText;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionText {


    public static void main(String[] args) {
//        setDemo();
        listDemo();
    }

    private static void listDemo() {
        List list = new LinkedList();
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }

        System.out.print("初始list="+list);
        System.out.println();
        Collections.shuffle(list);
        System.out.print("随机排序="+ list);
        System.out.println();
        Collections.sort(list);
        System.out.print("排序="+ list);
        System.out.println();
        Collections.reverse(list);
        System.out.print("逆序="+ list);
        System.out.println();
        System.out.print("折半查找="+ Collections.binarySearch(list,5));
    }

    private static void setDemo() {
        Set s1 = new HashSet();
        s1.add("a");
        s1.add("b");
        s1.add("c");

        Set s2 = new HashSet();
        s2.add("a");
        s2.add("d");
        s2.add("b");

        Set s3 = new HashSet();
        s3.addAll(s1);
//        s3.retainAll(s2);//交集
        System.out.println(s3);

        s3.addAll(s2);
        System.out.println(s3);



    }

}
