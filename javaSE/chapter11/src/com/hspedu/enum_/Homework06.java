//package com.hspedu.enum_;
//
//public class Homework06 {
//    public static void main(String[] args) {
//        String traffic = "大河";
//        Vehicles vehicles = null;
//        if (traffic.equals("大河")) {
//            vehicles = Vehicle.boat();
//        } else {
//            vehicles = Vehicle.horse();
//        }
//        Person person = new Person("唐僧",vehicles);
//        person.work();
//
//    }
//}
//
//interface Vehicles {
//    public void work();
//}
//
//class Horse implements Vehicles {
//    @Override
//    public void work() {
//        System.out.println("马正在工作。。。");
//    }
//}
//
//class Boat implements Vehicles {
//    @Override
//    public void work() {
//        System.out.println("小船正在运输。。");
//    }
//}
//
//class Vehicle {
//    public static Horse horse() {
//        return new Horse();
//    }
//    public static Boat boat() {
//        return new Boat();
//    }
//}
//
//class Person {
//    private String name;
//    private Vehicles vehicles;
//
//    public Person(String name, Vehicles vehicles) {
//        this.name = name;
//        this.vehicles = vehicles;
//    }
//
//    public void work() {
//        vehicles.work();
//    }
//}