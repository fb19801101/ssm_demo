package com.ssm.service.impl;

import com.ssm.mapper.StudentMapper;
import com.ssm.model.Student;
import com.ssm.model.StudentKey;
import com.ssm.model.User;
import com.ssm.mapper.UserMapper;
import com.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:11
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Map<String, Object> login(String username, String password) {
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andUsernameEqualTo(username);
//
//        User u = new User();
//        u.setId(10);
//        u.setUsername("jsp-test");
//        u.setPassword("456");
//        userMapper.insert(u);

        HashMap<String, Object> mapMsg = new HashMap<>();
        List<User> users = userMapper.login(username);//根据用户名在数据库查找对应的用户
        if ((users.size() == 0)) {//如果size=0就是没找到这个用户
            mapMsg.put("status", "404");
            mapMsg.put("message", "用户失效!");
        }
        else if ((users.size() > 1)) {//如果size>1就是这数据有问题了，不应该存在两个一样的用户名
            mapMsg.put("status", "500");
            mapMsg.put("message", "用户重复!");
        }
        else {
            User user = users.get(0);//取集合里第一个
            if (!password.equals(user.getPassword())) {
                mapMsg.put("status", "100");
                mapMsg.put("message", "密码错误！");
            } else {
                mapMsg.put("status", "200");
                mapMsg.put("message", "登陆成功!");
            }
        }

        return mapMsg;//把map集合里的状态码和信息提示返回给controller
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student getStudentByKey(Integer id, String no) {
        StudentKey key = new StudentKey();
        key.setId(id);
        key.setUserNo(no);
        return studentMapper.selectByPrimaryKey(key);
    }

    @Override
    public Student getStudentByKey(StudentKey key) {
        return studentMapper.selectByPrimaryKey(key);
    }
}