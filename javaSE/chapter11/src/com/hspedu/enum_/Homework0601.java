package com.hspedu.enum_;

public class Homework0601 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", VehiclesFactory.boat());
        person.common();
        person.passRiver();
        person.flameMountain();
    }
}



interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("马正在行走。。。");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("小船正在漂泊。。。");
    }
}

class Aircraft implements Vehicles {
    @Override
    public void work() {
        System.out.println("飞机正在天上飞行。。。");
    }
}

class VehiclesFactory {
    private final static Horse HORSE = new Horse();

    private VehiclesFactory() { }

    public static Horse horse() {
        return HORSE;
    }

    public static Boat boat() {
        return new Boat();
    }

    public static Aircraft aircraft() {
        return new Aircraft();
    }

}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void common() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.horse();
        }
        vehicles.work();
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.boat();
        }
        vehicles.work();
    }

    public void flameMountain() {
        if (!(vehicles instanceof Aircraft)) {
            vehicles = VehiclesFactory.aircraft();
        }
        vehicles.work();
    }
}