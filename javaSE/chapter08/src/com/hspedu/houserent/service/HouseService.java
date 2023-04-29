package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.utils.Utility;

public class HouseService {
    private House[] houses;
    private int pointer = 1;
    private int indexs = 1;

    //初始化一条信息。。
    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1,"王大娘","6765","海门区",18000,"未出租");
    }

    //调取房屋信息列表。
    public House[] list() {
        return houses;
    }

    //添加房屋信息。
    public boolean addTo(House newHouse) {
        if (houses.length == indexs) {
            return false;
        }
        houses[indexs] = newHouse;
        houses[indexs++].setId(++pointer);
        return true;
    }

    //删除房屋信息
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null){
                if (houses[i].getId() == delId) {
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("==========没有查找到房屋信息=========");
            return false;
        }
        for (int i = index; i < houses.length - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--indexs] = null;
        return true;
    }

    //查找房屋信息
    public House lookUp(int lookupId) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                return null;
            }
            if (houses[i].getId() == lookupId) {
                return houses[i];
            }
        }
        return null;
    }

    //修改房屋信息
//    public void amend(House house) {
//        for (int i = 0; i < houses.length; i++) {
//            if (houses[i].getId() == house.getId()) {
//                houses[i] = house;
//                return;
//            }
//        }
//    }
}
