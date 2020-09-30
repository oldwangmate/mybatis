package com.oldwang.dao;

import com.oldwang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    //查询老师对应的学生
    Teacher getTeacher(@Param("tid") int tid);


}
