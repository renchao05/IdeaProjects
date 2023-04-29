package com.renchao.java;

public class InterfaceTest {
}


interface A {
    void start();

    void stop();
}

abstract class  B implements A{

}

class C extends B {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}