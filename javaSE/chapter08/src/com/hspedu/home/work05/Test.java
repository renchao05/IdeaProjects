package com.hspedu.home.work05;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker("张工", 4500);
        Peasant peasant = new Peasant("李农", 3600);
        Waiter waiter = new Waiter("王芙", 4100);
        Teacher teacher = new Teacher("马老师", 4700, 23, 150);
        Scientist scientist = new Scientist("周科", 6000, 50000);
        worker.Print();
        peasant.Print();
        waiter.Print();
        teacher.Print();
        scientist.Print();
    }
}
