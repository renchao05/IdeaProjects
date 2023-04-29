package com.hspedu.enum_;

public class Homework07 {
    public static void main(String[] args) {
        new Car(30).new Air().flow();
        new Car(-5.5).new Air().flow();
        new Car(41).new Air().flow();
    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        void flow() {
            if (temperature > 40) {
                System.out.println("空调正在吹冷风。。。。");
            } else if(temperature < 0) {
                System.out.println("空调正在吹暖气。。。。");
            } else {
                System.out.println("空调关闭。。。。");
            }
        }
    }
}