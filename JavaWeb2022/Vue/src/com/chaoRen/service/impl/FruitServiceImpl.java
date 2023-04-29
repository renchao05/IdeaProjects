package com.chaoRen.service.impl;

import com.chaoRen.dao.impl.FruitDaoImpl;
import com.chaoRen.pojo.Fruit;
import com.chaoRen.service.FruitService;

import java.util.List;

public class FruitServiceImpl implements FruitService {
    FruitDaoImpl FruitDao = new FruitDaoImpl();

    @Override
    public int addFruit(Fruit Fruit) {
        return FruitDao.addFruit(Fruit);
    }

    @Override
    public void deleteFruitById(Integer id) {
        FruitDao.deleteFruitById(id);
    }

    @Override
    public Fruit queryFruitById(Integer id) {
        return FruitDao.queryFruitById(id);
    }

    @Override
    public List<Fruit> queryFruits() {
        return FruitDao.queryFruits();
    }
}














