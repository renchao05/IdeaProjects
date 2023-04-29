package com.hspedu.poly_polyparameter_;

public class Test {
    public double showEmployee(Employee e) {
        return e.getAnnual();
    }
    public void testWork(Employee e){
        if(e instanceof WorkEmployee){
            ((WorkEmployee) e).work();
        } else if(e instanceof Manage) {
            ((Manage) e).employee();
        }
    }
}
