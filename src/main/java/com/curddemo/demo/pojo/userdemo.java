package com.curddemo.demo.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
@AllArgsConstructor和@NoArgsConstructor都是lombok中的注解,作用在类上;
@AllArgsConstructor使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor使用后创建一个无参构造函数
 */

@Data  //get/set方法  需提前引入lombok；
@AllArgsConstructor  //有参构造
@NoArgsConstructor   //无参构造
//@Date
public class userdemo {

    private String id; //id String ?
    private String name;
    private String age;   //id String ?
    private String password;
    private Date newdate;




}
