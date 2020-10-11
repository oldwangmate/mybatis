package com.oldwang.dao;

import com.oldwang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //添加数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //查询
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询1,2,3记录的博客
    List<Blog> getBlog(List<String> list);
}
