package com.example.sh.morningtext.javaText;

public class ArrayText {

    public static int[] a = {1,0,2,6,5,7,8,9,3,4,11,3,4};
    public static void main(String[] args){
        //选择排序
//      selectsort();
      //冒泡排序
      bubblesort();
    }

    private static void bubblesort() {
        print();
        /**
         * 1.从数组后边开始
         * 2.比较两个值大小 小的排上边 如果1》2 交换位置
         */

        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        print();

    }

    private static void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }

    private static void selectsort() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
        System.out.println();


        //排序
        //1.拿第一个给第二个比 1>2  2放在1位置   1<2 位置不变  1和3比较

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                int temp;
                if(a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
    }
}
