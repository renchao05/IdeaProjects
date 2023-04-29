package com.hspedu.extend_;

public class Sub extends Base {
    public Sub(int n2,int n3) {
        this(2);
        System.out.println("子类Sub(int n2,int n3)构造器被调用....");
    }
    public Sub(){
        super(4,6);
        System.out.println("子类Sub()构造器被调用....");
    }

    public Sub(int n1){
        super(4,6);
        System.out.println("子类Sub(int n1)构造器被调用....");
    }
    public void sayOk(){
        System.out.println(n1+"\t"+n2+"\t"+n3);
        test100();
        test200();
        test300();
        //test400();
        System.out.println(getN4());
        callTest400();
    }
}
