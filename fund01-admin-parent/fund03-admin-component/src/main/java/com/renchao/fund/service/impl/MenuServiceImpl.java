package com.renchao.fund.service.impl;

import com.renchao.fund.entity.Menu;
import com.renchao.fund.mapper.MenuMapper;
import com.renchao.fund.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu getRoot() {
        List<Menu> menus = menuMapper.selectByExample(null);
        Map<Integer, Menu> map = new HashMap<>();
        Menu root = null;
        Integer pid;

        menus.forEach(menu -> map.put(menu.getId(),menu));

        for (Menu menu : menus) {
            pid = menu.getPid();
            if (pid == null) {
                root = menu;
            } else {
                map.get(pid).addChild(menu);
            }
        }
        return root;
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }

}
