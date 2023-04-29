package com.renchao.fund.service;

import com.renchao.fund.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MenuService {

    Menu getRoot();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(Integer id);
}
