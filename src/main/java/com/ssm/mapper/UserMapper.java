package com.ssm.mapper;

import com.ssm.model.User;
import com.ssm.model.UserExample;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserMapper继承基类
 */
@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete("delete from tb_user where id = #{id,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer id);

    @Insert(" insert into tb_user (username, `password`) values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}))")
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update("update tb_user set username = #{username,jdbcType=VARCHAR}, `password` = #{password,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}")
    int updateByPrimaryKey(User record);

    @Select("select * from tb_user")
    List<User> getAllUser();

    @Select("select * from tb_user where username = #{username}")
    List<User> login(String username);
}