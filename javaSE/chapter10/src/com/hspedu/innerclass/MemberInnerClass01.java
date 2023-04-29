package com.hspedu.innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        DD dd = new DD();
        DD.EE ee = dd.new EE();
        ee.work2();

        DD.EE ee2 = new DD.EE();

        DD.EE nn = dd.NN();

        DD.EE ee1 = new DD().new EE();

        DD.NN().work2();
    }
}

class DD {
    private static int a = 10;
    private String s = "我是成员";
    private static void work() {
        System.out.println("我是外部类的一个工作方法。。");
    }

    public static class EE {
        private int a =55;
        public void work2() {
            System.out.println("我是外部类a的值:" + DD.a + "\n我是内部类a的值：" + a);
            work();
            System.out.println("我是内部类的一个方法。。。。");
        }
    }

    public static EE NN() {
        return new EE();
    }
}