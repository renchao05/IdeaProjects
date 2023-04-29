package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.BillDAO;
import com.hspedu.mhl.dao.BillExtendDAO;
import com.hspedu.mhl.domain.Bill;
import com.hspedu.mhl.domain.BillExtend;

import java.util.List;
import java.util.UUID;

public class BillService {
    private final BillDAO billDAO = new BillDAO();
    private final BillExtendDAO billExtendDAO = new BillExtendDAO();
    private final DiningTableService diningTableService = new DiningTableService();

    public boolean setBill(int menuId, int nums, double money, int diningTableId) {
        int billId = Math.abs(UUID.randomUUID().toString().hashCode());
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, money, diningTableId);
        return update > 0;
    }

    public List<Bill> list(int diningTableId) {
        return billDAO.queryMulti("select * from bill where diningTableId = ?", Bill.class,diningTableId);
    }

    public List<Bill> unpaidList(int diningTableId) {
        return billDAO.queryMulti("select * from bill where state = '未结账' and diningTableId = ?", Bill.class,diningTableId);
    }

    public boolean checkOut(int diningTableId,String state) {
        int update = billDAO.update("update bill set state = ? where diningTableId = ?", state, diningTableId);
        boolean b = diningTableService.reset(diningTableId);
        return update > 0 && b;
    }

    public List<BillExtend> list2(int diningTableId) {
        return billExtendDAO.queryMulti("SELECT bill.*,menu.name AS `name` FROM bill,menu WHERE menuId = menu.id AND diningTableId = ?", BillExtend.class,diningTableId);
    }
}
