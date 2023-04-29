package com.hspedu.dao_.test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.dao.GoodsDAO;
import com.hspedu.dao_.domain.Actor;
import com.hspedu.dao_.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        ActorDAO actorDAO = new ActorDAO();
        String sql = "insert into actor values(null,?,?,?,?)";
//        List<Actor> actors = actorDAO.queryMulti(sql, Actor.class, null);
//        System.out.println(actors);
        int i = actorDAO.update(sql, "曹操", "男", "2005-5-5", "13888888888");
        System.out.println(i > 0 ? "成功" : "表未修改");
    }

    @Test
    public void testGoods() {
        GoodsDAO goodsDAO = new GoodsDAO();
        String sql = "delete from goods where id = ?";
        int i = goodsDAO.update(sql, 40);
        System.out.println(i > 0 ? "成功" : "失败");
    }
}
