package io.gabby.community.user.controller;

import com.alibaba.fastjson.JSON;
import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.service.impl.ForumUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author GabbyYam
 * @date 2020/12/31
 */
@RestController
@RequestMapping("/user/forum-login")
@ResponseBody
public class ForumLoginController {
    @Autowired
    ForumUserServiceImpl service;

    @GetMapping
    String login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password, HttpServletResponse response) {
        ForumUser forumUser = service.checkAndLoginUser(userName, password);
        if (forumUser == null) response.setStatus(400);
        else response.setStatus(200);
        return JSON.toJSONString(forumUser);
    }
}
