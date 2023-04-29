package com.chaoRen.chain;

public class Client {
    public static void main(String[] args) {
        GroupLeader leader = new GroupLeader();
        Manager manager = new Manager();
        CFO cfo = new CFO();

        leader.setNextHandler(manager);
        manager.setNextHandler(cfo);

        System.out.printf("领导您好：由于开发需求，需要购买一台Mac笔记本电脑，预算为%d 望领导批准%n", 95000);
        if (leader.handle(95000)) {
            System.out.println("谢谢领导");
        } else {
            System.out.println("巧妇难为无米之炊，只能划船了...");
        }
    }
}
