package com.chaoRen.service;

import com.chaoRen.pojo.Fruit;

import java.util.List;

public interface FruitService {

    public int addFruit(Fruit Fruit);

    public void deleteFruitById(Integer id);

    public Fruit queryFruitById(Integer id);

    public List<Fruit> queryFruits();
}
