package com.oldwang.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Blog implements Serializable {
    private String id ;
    private String title;
    private String author;
    private LocalDateTime createTime;  //属性名和字段名不一致 数据库中是下划线
    private int views;
}
