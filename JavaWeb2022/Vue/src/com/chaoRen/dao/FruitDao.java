package com.chaoRen.dao;

import com.chaoRen.pojo.Fruit;

import java.util.List;

public interface FruitDao {

    public int addFruit(Fruit Fruit);

    public int deleteFruitById(Integer id);

    public Fruit queryFruitById(Integer id);

    public List<Fruit> queryFruits();

    public Integer queryForPageTotalCount();



}
