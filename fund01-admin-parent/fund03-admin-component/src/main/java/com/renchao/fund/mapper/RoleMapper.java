package com.renchao.fund.mapper;

import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.Role;
import com.renchao.fund.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     */
    int deleteAdminAssignRole(Integer adminId);

    /**
     *
     */
    int deleteRoleAssignAuth(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    Role selectByPrimaryKey(Integer id);


    /**
     * 根据关键词进行查询
     *
     */
    List<Role> selectByKeyword(String keyword);

    /**
     * 根据 admin 查询与之对于的 role
     */
    List<Role> selectAdminAssignRole(Integer id);

    /**
     * 根据 admin 查询与之没有对于的 role
     */
    List<Role> selectAdminNotAssignRole(Integer id);

    /**
     * 保存 admin 与 role 之间的关系
     */
    void insertAdminAssignRole(@Param("adminId") Integer adminId,
                               @Param("rolesId") Integer[] rolesId);

    /**
     * 保存 role 与 auth 之间的关系
     */
    void insertRoleAssignAuth(@Param("roleId") Integer roleId,
                              @Param("authsId") List<Integer> authsId);

    /**
     * 根据 roleId 查询与之对于的 authId
     */
    List<Integer> selectRoleAssignAuth(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Sun May 15 11:19:49 CST 2022
     */
    int updateByPrimaryKey(Role record);
}