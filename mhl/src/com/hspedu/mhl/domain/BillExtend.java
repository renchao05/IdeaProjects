package com.hspedu.mhl.domain;

import java.util.Date;

public class BillExtend extends Bill{
    private String name;

    public BillExtend() {}

    public BillExtend(String name) {
        this.name = name;
    }

    public BillExtend(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId, Date billDate, String state, String name) {
        super(id, billId, menuId, nums, money, diningTableId, billDate, state);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() +"\t\t" + name +"\t\t" + getNums() + "\t\t" + getMoney()
                + "\t" + getDiningTableId() + "\t\t" + getBillDate() + "\t\t" + getState();
    }
}
