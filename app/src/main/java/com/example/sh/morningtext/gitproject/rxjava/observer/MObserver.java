package com.example.sh.morningtext.gitproject.rxjava.observer;

public class MObserver implements Observer {
    @Override
    public void update() {
        System.out.println("接收到一条通知");
    }
}
