package com.oldwang.dao;

import com.oldwang.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //添加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //map插入用户
    int addUserByMap(Map<String, Object> map);

    //模糊查询
    List<User> getUserByLike(String userName);

    //分页查询
    List<User> getLimitUser(Map<String,Integer> map);

    //分页查询 RowBounds
    List<User> getUserByRowBounds(RowBounds rowBounds);

    //注解开发
    @Select("select * from user")
    List<User> getListUser();
}
