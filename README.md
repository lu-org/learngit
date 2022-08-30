# 工程简介
定义SQL语句：
（１）select:
id :唯一的标识符.
parameterType:传给此语句的参数的全路径名或别名 例:com.test.poso.User或user;
resultType :语句返回值类型或别名。注意，如果是集合，那么这里填写的是集合的泛型，
而不是集合本身（resultType 与resultMap 不能并用）;
（２）insert 标签：
id :唯一的标识符
parameterType:传给此语句的参数的全路径名或别名 例:com.test.poso.User
insert 标签:
id :唯一的标识符
parameterType:传给此语句的参数的全路径名或别名 例:com.test.poso.User
（3）delete 标签:
　　　　<delete id="deleteUser" parameterType="int"> 
　　　　　　delete from user 
　　　　　　where id = #{id} 
　　　　</delete>
（4）update 标签类似于insert；
配置对象属性与查询结果集

二．
<sql>用来封装SQL语句, <include>来调用
//sql封装
    <sql id="allColumn">
        username,pickname,realname,password
    </sql>
 
//调用
    <select id="selectALL">
        select <include refid="allColumn"></include>
        frome users
    </select>




# 延伸阅读

