package com.chaoren.demo01.Webflux;

import java.util.Observable;
import java.util.Observer;

public class ObserverDemo extends Observable {
    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();
        observer.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("发生变化");
            }
        });

        observer.addObserver((o, arg) -> System.out.println("手动被观察者通知，准备改变"));

        observer.setChanged();
        observer.notifyObservers();
    }
}
