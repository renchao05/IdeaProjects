package com.renchao.fund.mapper;

import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.AuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int countByExample(AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int deleteByExample(AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int insert(Auth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int insertSelective(Auth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    List<Auth> selectByExample(AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    Auth selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int updateByPrimaryKeySelective(Auth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auth
     *
     * @mbggenerated Fri May 20 16:29:32 CST 2022
     */
    int updateByPrimaryKey(Auth record);
}