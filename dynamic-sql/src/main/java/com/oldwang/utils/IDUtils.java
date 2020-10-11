package com.oldwang.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {

    public static String getUUID(){
       return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        String uuid = IDUtils.getUUID();
        System.out.println(uuid);
    }

}
