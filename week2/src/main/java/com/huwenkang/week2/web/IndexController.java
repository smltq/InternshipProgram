package com.huwenkang.week2.web;

import com.huwenkang.week2.model.User;
import com.huwenkang.week2.model.UserArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    UserArray userArray = new UserArray();

    //根据用户名获取账户和密码
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public User postUser(@RequestParam(value = "userName") String username) {

        if (userArray.getUserArray() != null) {
            for (User user : userArray.getUserArray()) {
                if (user != null && user.getUserName().equals(username)) {
                    return user;
                }
            }
        }
        return null;
    }

    //更改用户密码
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public String getUser(@RequestParam("userName") String username,
                          @RequestParam("userPassWord") String password) {
        if (userArray.getUserArray()[0] == null) {

            userArray.getUserArray()[0] = new User(username, password);
            userArray.setLength(userArray.getLength() + 1);
        } else if (userArray.getUserArray().length != userArray.getLength()) {
            for (User user : userArray.getUserArray()) {
                if (user != null && user.getUserName().equals(username)) {
                    return "用户已存在 ";
                }
            }
            userArray.getUserArray()[userArray.getLength()] = new User(username, password);
            userArray.setLength(userArray.getLength() + 1);
        }
        return "添加成功";
    }

    //根据用户名删除用户
    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteUser(@RequestParam("userName") String username) {
        for (int i = 0; i < userArray.getLength(); i++) {
            if (userArray.getUserArray()[i] != null && userArray.getUserArray()[i].getUserName().equals(username)) {
                userArray.getUserArray()[i] = null;
                return "删除成功";
            }
        }
        return "没有该用户";
    }

    //增加用户
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public User putUser(@RequestParam("userName") String username,
                        @RequestParam("userPassWord") String password) {
        for (User user : userArray.getUserArray()) {
            if (user.getUserName().equals(username)) {
                user.setUserPassWord(password);
                return user;
            }
        }
        return null;
    }
}
