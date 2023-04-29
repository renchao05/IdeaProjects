package com.chaoRen.mediator;

public class Client {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();

        System.out.println("-------------");
        c2.send();
    }
}
