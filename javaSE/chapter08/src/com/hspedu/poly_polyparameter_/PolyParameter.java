package com.hspedu.poly_polyparameter_;

public class PolyParameter {
    public static void main(String[] args) {
        WorkEmployee zhangshan = new WorkEmployee("张三", 6500);
        Manage lishi = new Manage("李四", 6700, 35000);
        Test test = new Test();
        test.testWork(zhangshan);
        System.out.println(test.showEmployee(zhangshan));
        test.testWork(lishi);
        System.out.println(test.showEmployee(lishi));
    }
}
