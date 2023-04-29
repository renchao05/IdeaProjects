package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.Menu;

import java.util.List;

public class MenuService {
    private final MenuDAO menuDAO = new MenuDAO();

    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class, null);
    }

    public Menu getMenu(int menuId) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, menuId);
    }
}
