package com.ssm.service;

import com.ssm.model.Student;
import com.ssm.model.StudentKey;
import com.ssm.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:09
 */
public interface LoginService {
    //loginname是登陆名称
    //password是密码
    Map<String,Object> login(String username, String password);

    List<User> getAllUser();

    List<Student> getAllStudent();

    User getUserById(Integer id);

    Student getStudentByKey(Integer id, String no);

    Student getStudentByKey(StudentKey key);
}