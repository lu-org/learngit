package com.curddemo.demo.service;

import com.curddemo.demo.pojo.userdemo;

import java.util.List;


/**
 * 接口：interface,使用interface关键字来声明一个接口
 * 接口的类中
 * 所有的属性默认为：public static final
 * 所有的方法默认为：public abstract
 */
public interface UserService {
    List<userdemo> findall();

    List<userdemo> findid(int id);

    List<userdemo> findlike(String like);

    int delectAll();

    int delectId(int id);

    int addOnce(List<userdemo> userdemos);

    int updateid(userdemo userdemo);
}
