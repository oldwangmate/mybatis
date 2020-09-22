package com.oldwang.dao;

import com.oldwang.pojo.User;
import com.oldwang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
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
}
