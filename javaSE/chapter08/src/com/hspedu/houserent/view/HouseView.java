package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(3);

    //修改房屋信息
    public void amendHouse() {
        System.out.print("请输入需要修改房屋ID:");
        int amendId = Utility.readInt();
        House house = houseService.lookUp(amendId);
        if (house == null) {
            System.out.println("==========没有该房屋信息==========");
        } else {
            System.out.println("==========修改房屋信息==========");
            System.out.print("姓名：");
            house.setName(Utility.readString(5));
            System.out.print("电话：");
            house.setPhone(Utility.readString(12));
            System.out.print("地址：");
            house.setAddress(Utility.readString(20));
            System.out.print("租金：");
            house.setRent(Utility.readInt(5));
            System.out.print("状态：");
            house.setState(Utility.readString(3));
        }
    }

    //查找房屋信息。。
    public void lookupHouse() {
        System.out.println("==========查找房屋信息==========");
        System.out.print("请输入房屋ID:");
        House house = houseService.lookUp(Utility.readInt());
        if (house == null) {
            System.out.println("==========没有该房屋信息==========");
        } else {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
            System.out.println(house);
        }
    }

    //退出系统
    public void exit() {
        System.out.println("==========你确认退出吗？==========");
        if (Utility.readConfirmSelection() == 'Y') {
            loop = false;
        }
    }

    //删除房屋信息。
    public void delHouse() {
        System.out.println("==========删除房屋信息==========");
        System.out.print("请输入待删除房屋信息的编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("==========放弃删除==========");
            return;
        }
        if (Utility.readConfirmSelection() == 'Y') {
            if (houseService.del(delId)){
                System.out.println("==========删除成功==========");
                return;
            }
            System.out.println("==========删除失败==========");
        } else {
            System.out.println("==========放弃删除==========");
        }

    }

    //添加房屋菜单。
    public void addHouse() {
        System.out.println("==========添加房屋信息==========");
        System.out.print("姓名：");
        String name = Utility.readString(5);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(20);
        System.out.print("租金：");
        int rent = Utility.readInt(5);
        System.out.print("状态：");
        String state = Utility.readString(3);

        House house = new House(0,name,phone,address,rent,state);
        if (houseService.addTo(house)) {
            System.out.println("添加房屋信息成功。。。。");
        } else {
            System.out.println("房屋信息添加失败。。。。！");
        }


    }

    //房屋列表菜单
    public void listHouses() {
        System.out.println("==========房屋列表=========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i].toString());
        }

    }

    //主菜单
    public void mainMenu() {
        do {
            System.out.println("\n==========房屋出租系统菜单=========");
            System.out.println("\t\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退      出");
            System.out.print("请输入你的选择(1-6):");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    addHouse();
                    //System.out.println("新增");
                    break;
                case '2' :
                    lookupHouse();
                    //System.out.println("查找");
                    break;
                case '3' :
                    delHouse();
                    //System.out.println("删除");
                    break;
                case '4' :
                    amendHouse();
                    //System.out.println("修改");
                    break;
                case '5' :
                    //System.out.println("列表");
                    listHouses();
                    break;
                case '6' :
                    exit();
//                    System.out.println("退出");
//                    loop = false;
                    break;

            }
        }while (loop);
    }
}
