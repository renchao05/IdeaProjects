package com.hspedu.extend_.Exercise;

public class ExtendsExercise03 {
//    编写 Computer 类，包含 CPU、内存、硬盘等属性，getDetails 方法用于返回 Computer 的详细信息
//    编写 PC 子类，继承 Computer 类，添加特有属性【品牌 brand】
//    编写 NotePad 子类，继承 Computer 类，添加特有属性【color】
//    编写 Test 类，在 main 方法中创建 PC 和 NotePad 对象，分别给对象中特有的属性赋值，以及从 Computer 类继承的
//    属性赋值，并使用方法并打印输出信息
}

class Test {
    public static void main(String[] args) {
        PC pc = new PC("i54900", "8G", "1T", "联想");
        NotePad notePad = new NotePad("M1", "8G", "512G", "白色");
        System.out.println(pc.getinfo());
        System.out.println(notePad.getinfo());
    }
}

class Computer {
    String cpu;
    String mem;
    String disk;

    public Computer(String cpu, String mem, String disk) {
        this.cpu = cpu;
        this.mem = mem;
        this.disk = disk;
    }

    public String getDetails() {
        return "CPU:" + cpu + "\t内存:" + mem + "\t硬盘:" + disk;
    }
}

class PC extends Computer {
    String brand;

    public PC(String cpu, String mem, String disk, String brand) {
        super(cpu, mem, disk);
        this.brand = brand;
    }
    public String getinfo() {
        return getDetails() + "\t品牌：" + brand;
    }
}

class NotePad extends Computer {
    String color;

    public NotePad(String cpu, String mem, String disk, String color) {
        super(cpu, mem, disk);
        this.color = color;
    }

    public String getinfo() {
        return getDetails() + "\t颜色：" + color;
    }
}