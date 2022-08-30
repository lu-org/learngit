package com.curddemo.demo.service;

import com.curddemo.demo.pojo.userdemo;
import com.curddemo.demo.usermapper.DaoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 *接口的使用：
 * 类使用implements关键字来实现接口。在类的声明中，implements关键字是跟在class声明之后的
 * 【访问权限修饰符】 class 类名 implements 接口名1，… ， 接口名n { }
 * public class MyInterfaceImpl implements MyInterface1，MyIntereFace2 {}
 * 接口与继承的结合
 * 【访问权限修饰符】class 类名 extends 父类名 implements 接口名1，… ， 接口名n { }
 * public class MyInterfaceImpl extends fulei implements MyInterface1，MyIntereFace2 {}
 */
@Service
public class UserServiceImpl implements UserService {

    //@Autowired   使用aut ...装备坏报错故推荐这个
    // @Autowired
    @Resource
    private DaoMapper daoMappers;

    @Override
    public List<userdemo> findall() {
        return  daoMappers.findall();
    }

    @Override
    public List<userdemo> findid(int id) {
        return daoMappers.findid(id);
    }

    @Override
    public List<userdemo> findlike(String like) {
        return daoMappers.findlike(like);
    }

    @Override
    public int delectAll() {
        return daoMappers.delectAll();
    }

    @Override
    public int delectId(int id) {
        return daoMappers.delectId(id);
    }

    @Override
    public int addOnce(List<userdemo> userdemos) {
        return daoMappers.addOnce(userdemos);
    }

    @Override
    public int updateid(userdemo userdemo) {
        return daoMappers.updateid(userdemo);
    }

}
