package com.curddemo.demo.usermapper;

import com.curddemo.demo.pojo.userdemo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DaoMapper {

    List<userdemo> findall();


    List<userdemo> findid(int id);

    List<userdemo> findlike(String like);

    int delectAll();

    int delectId(int id);

    int addOnce(List<userdemo> userdemos);

    int updateid(userdemo userdemo);

}
