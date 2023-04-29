package com.renchao.fund.mvc.controller;

import com.renchao.fund.entity.Menu;
import com.renchao.fund.service.MenuService;
import com.renchao.fund.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询
     */
    @GetMapping
    public ResultEntity<Menu> getWholeTree() {
        Menu root = menuService.getRoot();
        return ResultEntity.successWithData(root);
    }

    /**
     * 保存
     */
    @PostMapping
    public ResultEntity<Menu> saveMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        Menu root = menuService.getRoot();
        return ResultEntity.successWithData(root);
    }

    /**
     * 修改
     */
    @PutMapping
    public ResultEntity<Menu> updateMenu(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
        Menu root = menuService.getRoot();
        return ResultEntity.successWithData(root);
    }

    /**
     * 删除
     */
    @DeleteMapping
    public ResultEntity<Menu> deleteMenu(@RequestBody Menu menu) {
        menuService.deleteMenu(menu.getId());
        Menu root = menuService.getRoot();
        return ResultEntity.successWithData(root);
    }

}
