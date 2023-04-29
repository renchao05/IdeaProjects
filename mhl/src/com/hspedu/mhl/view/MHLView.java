package com.hspedu.mhl.view;

import com.hspedu.mhl.domain.*;
import com.hspedu.mhl.service.BillService;
import com.hspedu.mhl.service.DiningTableService;
import com.hspedu.mhl.service.EmployeeService;
import com.hspedu.mhl.service.MenuService;
import com.hspedu.mhl.utils.Utility;

import java.util.List;

public class MHLView {
    private boolean loop = true;
    private String key;
    private final EmployeeService employeeService = new EmployeeService();
    private final DiningTableService diningTableService = new DiningTableService();
    private final MenuService menuService = new MenuService();
    private final BillService billService = new BillService();

    /**
     * 主方法
     */
    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //显示主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("=============满汉楼=============");
            System.out.println("\t\t1 登陆满汉楼\n\t\t2 退出满汉楼");
            System.out.print("请输入您的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入员工号：");
                    String id = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(id, pwd);
                    if (employee != null) {
                        System.out.println("=============【" + employee.getName() + "】登陆成功=============");
                        twoMenu();
                    } else
                        System.out.println("=============登陆失败=============");
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误。。。");
            }
        }
        System.out.println("退出满汉楼系统");
    }

    //显示餐桌状态
    public void listDiningTable() {
        List<DiningTable> state = diningTableService.list();
        System.out.println("餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : state) {
            System.out.println(diningTable);
        }
    }

    //预订餐桌
    public void bookDiningTable() {
        System.out.println("=============预订餐桌=============");
        while (true) {
            System.out.print("请选择餐桌编号(-1退出):");
            int id = Utility.readInt();
            if (id == -1)
                break;
            Object diningTable = diningTableService.getDiningTable(id);
            if (diningTable != null && diningTable.equals("空")) {
                System.out.println("确认是否预订?");
                char c = Utility.readConfirmSelection();
                if (c == 'Y') {
                    System.out.print("预定人姓名:");
                    String name = Utility.readString(20);
                    System.out.print("预定人电话:");
                    String tel = Utility.readString(12);
                    if (diningTableService.bookDiningTable(id, name, tel))
                        System.out.println("=============预订成功=============");
                    else
                        System.out.println("=============预订失败=============");
                    return;
                }
            } else if (diningTable == null)
                System.out.println("餐桌不存在。。。");
            else
                System.out.println("用餐中。。。");
        }
    }

    //显示菜品
    public void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }

    }

    //点餐服务
    public void order() {
        System.out.println("=============点餐服务=============");
        System.out.print("请选择点餐的桌号(-1退出):");
        int id = Utility.readInt();
        if (id == -1)
            return;
        Object diningTable = diningTableService.getDiningTable(id);
        if (diningTable == null && diningTable.equals("空")) {
            System.out.println("餐桌未预订或者不存在。");
            return;
        }
        System.out.print("请选择菜品的编号(-1退出):");
        int menuId = Utility.readInt();
        if (menuId == -1)
            return;
        Menu menu = menuService.getMenu(menuId);
        if (menu == null) {
            System.out.println("菜品不存在。。。");
            return;
        }
        System.out.print("请选择菜品的数量(-1退出):");
        int nums = Utility.readInt();
        if (nums == -1)
            return;
        if (nums < 1) {
            System.out.println("数量至少选择1");
            return;
        }
        System.out.println("确认是否点这个菜?");
        char c = Utility.readConfirmSelection();
        if (c == 'N')
            return;
        boolean b2 = diningTableService.updateDiningTableState(id, "用餐中");
        boolean b = billService.setBill(menuId, nums, menu.getPrice() * nums, id);
        if (b && b2)
            System.out.println("点餐结果=" + nums + "\n=============点餐成功=============");
        else
            System.out.println("=============点餐失败=============");
    }

    //查看账单
    public void viewBill() {
        System.out.print("请选择桌号(-1退出):");
        int id = Utility.readInt();
        if (id == -1)
            return;
        List<BillExtend> list = billService.list2(id);
        if (list == null) {
            System.out.println("没有查询到账单。");
            return;
        }
        System.out.println("编号\t\t菜品名\t\t数量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        for (BillExtend bill : list) {
            System.out.println(bill);
        }
    }

    //结账
    public void checkOut() {
        System.out.println("=============结账服务=============");
        System.out.print("请选择要结账的桌号(-1退出):");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1)
            return;
        List<Bill> list = billService.unpaidList(diningTableId);
        if (list == null) {
            System.out.println("没有找到的账单。");
            return;
        }
        System.out.println("结账的方式(现金/支付宝/微信) 回车表示退出:");
        String state = Utility.readString(10);
        if (state.equals(""))
            return;
        System.out.println("确认是否结账？");
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            boolean b = billService.checkOut(diningTableId, state);
            if (b)
                System.out.println("=============结账完成=============");
            else
                System.out.println("=============结账失败=============");
        }
    }

    public void twoMenu() {
        while (loop) {
            System.out.println("=============满汉楼二级菜单=============");
            System.out.println("\t\t1 显示餐桌状态\n\t\t2 预定餐桌\n\t\t3 显示所有菜品\n\t\t4 点餐服务\n\t\t5 查看账单\n\t\t6 结账\n\t\t9 退出满汉楼");
            System.out.print("请输入您的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    listDiningTable();
                    break;
                case "2":
                    bookDiningTable();
                    break;
                case "3":
                    listMenu();
                    break;
                case "4":
                    while (true) {
                        order();
                        System.out.println("是否继续点餐?");
                        char c = Utility.readConfirmSelection();
                        if (c == 'N')
                            break;
                    }
                    break;
                case "5":
                    viewBill();
//                    System.out.println("查看账单。。。。");
                    break;
                case "6":
                    checkOut();
//                    System.out.println("结账。。。。");
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误！");

            }
        }
    }
}
