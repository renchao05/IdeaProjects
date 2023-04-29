package com.chaoren.demo;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.chaoren.demo.bean.User;
import com.chaoren.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class MyTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testAllUser() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert() {
        User user = new User(null, "任超11", 28, "5426@qq.com",null);
        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user.getUid());
    }

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(1503577240189595649L);
        System.out.println("删除行数：" + i);
    }

    @Test
    public void testDeleteBatchIds() {
        List<Long> ids = Arrays.asList(1503936216823570436L, 1503936216823570435L, 1503936216823570434L);
        int i = userMapper.deleteBatchIds(ids);
        System.out.println("删除行数：" + i);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "任超3");
        map.put("age", 28);
        int i = userMapper.deleteByMap(map);
        System.out.println("删除行数：" + i);
    }

    @Test
    public void testUpdateById() {
        User user = new User(1503582937086234625L, "王道月", 32, "782@qq.com",null);
        int i = userMapper.updateById(user);
        System.out.println("删除行数：" + i);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1503582937086234625L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> ids = Arrays.asList(4L, 3L);
        List<User> users = userMapper.selectBatchIds(ids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "王道月");
        map.put("age", 32);
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectMapById() {
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

    @Test
    public void test02() {
        String  id = IdWorker.getTimeId();
        System.out.println(id);
    }

}
