package com.oldwang;

import com.oldwang.dao.BlogMapper;
import com.oldwang.pojo.Blog;
import com.oldwang.utils.IDUtils;
import com.oldwang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperTest {

    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getUUID());
        blog.setTitle("mybatis 如此简单");
        blog.setAuthor("oldwang");
        blog.setCreateTime(LocalDateTime.now());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("mybatis 如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("java 如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("spring 如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("微服务 如此简单");
        mapper.addBlog(blog);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("title","spring 如此简单2");
        map.put("author","oldwang");
        map.put("views","9999");
        map.put("id","15eaebc9c65b4b6d932398402eef59e1");
        mapper.queryBlogIF(map);
        sqlSession.commit();
    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blog = mapper.getBlog(Arrays.asList("1","2","3"));
        blog.forEach(System.out::println);
    }
}
