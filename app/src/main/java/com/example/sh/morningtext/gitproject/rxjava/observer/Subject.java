package com.example.sh.morningtext.gitproject.rxjava.observer;

public interface Subject {


    void registObserver(Observer observer);

    void removeObserver(Observer observer);

    void changeData();
}
