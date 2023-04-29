package com.renchao.fund;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Admin;
import com.renchao.fund.entity.AdminExample;
import com.renchao.fund.entity.Role;
import com.renchao.fund.mapper.AdminMapper;
import com.renchao.fund.mapper.RoleMapper;
import com.renchao.fund.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// 指定 Spring 给 Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 Spring 配置文件的注解
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdSpringTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleMapper roleMapper;

    Logger logger = LoggerFactory.getLogger(CrowdSpringTest.class);

    @Test
    public void testAddRole() {
        for (int i = 0; i < 233; i++) {
            Role role = new Role(null, "Role" + i);
            roleMapper.insertSelective(role);
        }
    }

    @Test
    public void testAdminMapper() {
        PageHelper.startPage(2, 3);
        List<Admin> adminList = adminMapper.selectByKeyword("ao7");
        PageInfo<Admin> adminPageInfo = new PageInfo<>(adminList);
        List<Admin> list = adminPageInfo.getList();
        System.out.println(adminPageInfo);
    }

    @Test
    public void testAddAdmin() {
        for (int i = 45; i < 113; i++) {
            Admin admin = new Admin(null, "renchao" + i, i * 432 + "", "任超" + i, i * 66 + "@qq.com", LocalDate.now().toString());
            adminMapper.insert(admin);
        }
    }

    @Test
    public void testGetAll() {
        List<Admin> all = adminService.getAll();
        System.out.println(all);
    }

    @Test
    public void testService() {
        Admin admin = new Admin(null, "tom2", "123", "汤姆", "344@qq.com", "2022,5");
        adminService.saveAdmin(admin);
    }

    @Test
    public void testLogback() {
        Logger logger = LoggerFactory.getLogger(CrowdSpringTest.class);
        logger.debug("1、DEBUG，hello!!");
        logger.debug("1、DEBUG，hello!!");
        logger.info("2、INFO，hello!!");
        logger.info("2、INFO，hello!!");
        logger.warn("3、WARN，hello!!");
        logger.warn("3、WARN，hello!!");
        logger.error("4、ERROR，hello!!");
        logger.error("4、ERROR，hello!!");

    }


    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
