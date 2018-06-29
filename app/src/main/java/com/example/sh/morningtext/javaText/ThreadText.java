package com.example.sh.morningtext.javaText;

import java.util.Date;

import static java.lang.Thread.NORM_PRIORITY;
import static java.lang.Thread.yield;

public class ThreadText {

    public static void main(String[] args) {
//      textPause();
//        textJoin();
//        textyeild();
        textPriority();
    }

    private static void textPriority() {
        MThread m1 = new MThread();
        m1.start();
        MThread m2 = new MThread();
        m2.start();
        MThread m3 = new MThread();
        m3.start();
        MThread m4 = new MThread();
        m4.start();
        m1.setPriority(NORM_PRIORITY+3);
    }

    private static void textyeild() {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("textJoin======"+i);
                    if(i/10 ==1){
                        yield();
                    }
                }
            }
        });
        t2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread()+"======"+i);
        }
    }

    private static void textJoin() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("textJoin======"+i);
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread()+"======"+i);
        }

    }

    private static void textPause() {
        //第一种方式启动
        MRunable runable = new MRunable();
        Thread thread = new Thread(runable);
        thread.start();

//        MThread mThread = new MThread();
//        mThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        mThread.interrupt();
//        thread.stop();
        runable.flag = false;

//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread()+"======="+i);
//        }
    }
}

class MRunable implements Runnable{
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread()+"======="+new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread()+"=======InterruptedException");
                return;
            }

        }
    }
}

class MThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println(Thread.currentThread()+"======="+new Date());
//            try {
////                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread()+"=======InterruptedException");
//                return;
//            }

        }

    }
}
