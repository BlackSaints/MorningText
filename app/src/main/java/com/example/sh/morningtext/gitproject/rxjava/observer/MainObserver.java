package com.example.sh.morningtext.gitproject.rxjava.observer;

public class MainObserver {

    public static void main(String[] args){
        MSubject subject = new MSubject();
        MObserver s1 = new MObserver();
        subject.registObserver(s1);
        MObserver s2 = new MObserver();
        subject.registObserver(s2);

        subject.changeData();

    }
}
