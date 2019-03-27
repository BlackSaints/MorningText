package com.example.sh.morningtext.gitproject.rxjava.observer;

import java.util.ArrayList;
import java.util.List;

public class MSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    public MSubject() {
        observers = new ArrayList<>();
    }

    public void MSubject(){
        observers = new ArrayList<>();
    }

    @Override
    public void registObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void changeData() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
