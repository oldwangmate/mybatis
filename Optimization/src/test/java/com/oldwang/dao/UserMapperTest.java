package com.oldwang.dao;

import com.oldwang.pojo.User;
import com.oldwang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class UserMapperTest {

    @Test
    public void getUserList(){
        //获取SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取UserMapper对象 方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行SQL
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);
        //获取UserMapper对象 方式二
        List<User> users = sqlSession.selectList("com.oldwang.dao.UserMapper.getUserList", User.class);
        users.forEach(System.out::println);
        //释放资源
        sqlSession.close();
    }


    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test  //增删改需要提交事务
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("张三");
        user.setPwd("123");
        mapper.addUser(user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("张三");
        user.setPwd("123345");
        mapper.updateUser(user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",4);
        map.put("name","张三");
        map.put("pwd","123456");
        mapper.addUserByMap(map);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserByLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByLike = mapper.getUserByLike("test");
        userByLike.forEach(System.out::println);
        sqlSession.close();
    }


    @Test
    public void getLimitUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> stringStringMap = new HashMap();
        stringStringMap.put("start",1);
        stringStringMap.put("end",2);
        List<User> userByLike = mapper.getLimitUser(stringStringMap);
        userByLike.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1,2);
        List<User> userByRowBounds = mapper.getUserByRowBounds(rowBounds);
        userByRowBounds.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getListUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> listUser = mapper.getListUser();
        listUser.forEach(System.out::println);
    }
}
