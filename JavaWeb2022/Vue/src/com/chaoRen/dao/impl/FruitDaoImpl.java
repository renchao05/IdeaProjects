package com.chaoRen.dao.impl;

import com.chaoRen.dao.FruitDao;
import com.chaoRen.pojo.Fruit;

import java.util.List;

public class FruitDaoImpl extends BaseDao<Fruit> implements FruitDao {
    @Override
    public int addFruit(Fruit Fruit) {
        String sql = "insert into t_fruit(`name`,`price`,`count`,`remark`) value(?,?,?,?)";
        return update(sql, Fruit.getName(),Fruit.getPrice(),
                Fruit.getCount(),Fruit.getRemark());
    }

    @Override
    public int deleteFruitById(Integer id) {
        String sql = "delete from t_fruit where id=?";
        return update(sql,id);
    }

    @Override
    public Fruit queryFruitById(Integer id) {
        String sql = "select * from t_fruit where id=?";
        return querySingle(sql, Fruit.class, id);
    }

    @Override
    public List<Fruit> queryFruits() {
        String sql = "select * from t_fruit";
        return queryMulti(sql, Fruit.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_fruit";
        return Integer.parseInt(queryScalar(sql));
    }

}
