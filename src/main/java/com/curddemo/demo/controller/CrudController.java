package com.curddemo.demo.controller;

import com.curddemo.demo.pojo.userdemo;
import com.curddemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/curd/")
public class CrudController {

    @Autowired
    public UserService userService;

//    @RequestMapping(value = "abc", method = RequestMethod.POST)
//    @ResponseBody
    @PostMapping("abc")
    public String hello() {
        return "hello  你好";
    }

 //    public static void main(String[] args) {
//
//    }


//     查询全部
    @ResponseBody
    @GetMapping("findall")
    public List<userdemo> findAll() {
        System.out.println("执行controller");
        List<userdemo> findall = userService.findall();
        System.out.println(findall);
        return findall;
    }

    /**
     * 按ID查询
     *http://localhost:6688/user/find/id
     */
    @ResponseBody
    @GetMapping("findid/{id}")
    public List<userdemo> findId(@PathVariable(value = "id") int id) {

        System.out.println("id" + id);
        List<userdemo> le = userService.findid(id);
        return le;
    }

    /**
     * http://localhost:6688/user/find/{like=》模糊查询的数据}
     * 模糊查询 相关数据
     * @return
     */
    @ResponseBody
    @GetMapping("find/{like}")
    public List<userdemo> findLike(@PathVariable String like) {
        System.out.println("like" + like);
        List<userdemo> likes = userService.findlike(like);
        return likes;
    }

    /**
     * http://localhost:6688/user/delectall
     * 删除全部
     * @return
     */
    @ResponseBody
    @GetMapping("delectall")
    public String delectAll() {
        System.out.println("删除全部");
        int delect = userService.delectAll();
        // 返回删除的条数 String.valueOf(delect)
        if (delect > 0) {
            String le = "删除成功,删除了" + delect + "条数据";
            return le;
        } else {

            return "删除失败,或者无可删除数据";
        }
    }

    /**
     * http://localhost:6688/user/delect/id(写删除的id)
     * 根据id删除
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("delect/{id}")
    public String delectId(@PathVariable int id) {
        int le = userService.delectId(id);
        if (le > 0) {
            String lee = "删除成功删除了一条数据 id为" + id;
            return lee;
        } else {
            return "删除失败";
        }

    }

    /**
     * http://localhost:6688/user/delectBatches
     * 刪除多個 傳入多個id即可
     * @return
     */
    @ResponseBody
    @GetMapping("delectBatches")
    public String delectBatches() {
        int le = 0;
        int[] nee = {34, 35};
        for (int i = 0; i < nee.length; i++) {
            le = userService.delectId(nee[i]);
        }
        if (le > 0) {
            String lee = "删除成功";
            return lee;
        } else {
            return "删除失败";
        }
    }

    /**
     * http://localhost:6688/user/addOnce
     *新增一个 或者批量新增
     * @param userdemo
     * @return
     */
    @ResponseBody
    @GetMapping("addOnce") // 一般采用put 请求但是这个demo不涉及前后交互
    public int addOnce(userdemo userdemo) {
        List<userdemo> userdemos = new ArrayList<>();
        Date lee = new Date();
        //新增一个或者多个
        userdemos.add(new userdemo("33", "44", "77", "44", lee));
        userdemos.add(new userdemo("44", "44", "77", "44", lee));
        userdemos.add(new userdemo("55", "44", "77", "44", lee));
        userdemos.add(new userdemo("66", "44", "77", "44", lee));

        int lo = userService.addOnce(userdemos);

        if (lo > 0) {
            System.out.println("您新增了" + lo + "条数据");
        } else {
            System.out.println("无新增");
        }

        return lo;
    }

    /**
     * http://localhost:6688/user/update  修改
     * @param userdemo
     * @return
     */
    @ResponseBody
    @GetMapping("update")
    public int update(userdemo userdemo) {
        //后端直接伪数据  进行赋值  发送新的数据
        userdemo.setId("18");
        userdemo.setName("88");
        userdemo.setAge("88");
        userdemo.setPassword("8888");
        userdemo.setNewdate(new Date());

        System.out.println(userdemo.toString());
        int le=userService.updateid(userdemo);

        if (le>0){
            System.out.println("修改完成");
        }

        return le;

    }

}
