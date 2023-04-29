package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private final DiningTableDAO diningTableDAO = new DiningTableDAO();

    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select id,state from diningTable", DiningTable.class, null);
    }

    public boolean bookDiningTable(int id, String name, String tel) {
        int i = diningTableDAO.update("update diningTable set state = '已经预订', orderName = ?, orderTel = ? where id = ?", name, tel, id);
        return i > 0;
    }

    public Object getDiningTable(int id) {
        return diningTableDAO.queryScalar("select state from diningTable where id = ?", id);
    }

    public boolean updateDiningTableState(int id, String state) {
        int update = diningTableDAO.update("update diningTable set state = ? where id = ?", state, id);
        return update > 0;
    }

    public boolean reset(int id) {
        int update = diningTableDAO.update("update diningTable set state = '空',orderName='',orderTel='' where id = ?", id);
        return update > 0;
    }
}
