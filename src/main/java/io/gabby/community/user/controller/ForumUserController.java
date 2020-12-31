package io.gabby.community.user.controller;


import com.alibaba.fastjson.JSON;
import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.service.impl.ForumUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
@RestController
@RequestMapping("/user/forum-user")
@ResponseBody
public class ForumUserController {
    @Autowired
    ForumUserServiceImpl userService;

    @GetMapping
    String searchUser(@RequestParam(value = "userName", required = false)   String userName,
                      @RequestParam(value = "createTime", required = false) String createTime,
                      HttpServletResponse response) {
        if (userName == null && createTime == null) {
            response.setStatus(400);
            return "please give at least one conditon for search!";
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = createTime == null ? LocalDateTime.MIN : LocalDateTime.parse(createTime, df);
        List<ForumUser> users = userService.searchUser(userName, time);
        return JSON.toJSONString(users);
    }

    @PostMapping
    String userSignUp(@RequestParam("userName")     String userName,
                      @RequestParam("password")     String password,
                      @RequestParam(value = "introduction", required = false) String introduction,
                      HttpServletResponse response) {
        int res = userService.insertUser(userName, password, introduction);
        if (res == 0) response.setStatus(400);
        String msg = res == 0 ? "Sign up failed, please try again later!" : "ok";
        return msg;
    }

    @PutMapping
    String userPatch(@RequestParam(value = "userId")                            String userId,
                     @RequestParam(value = "userName", required = false)        String userName,
                     @RequestParam(value = "password", required = false)        String password,
                     @RequestParam(value = "introduction", required = false)    String introduction,
                     @RequestParam(value = "avartarUrl", required = false)     String url,
                     HttpServletResponse response) {
        int res = userService.patchUser(userId, userName, password, introduction, url);
        if (res != 0) response.setStatus(200);
        else response.setStatus(400);
        return "ok";
    }

    @DeleteMapping
    String userBan(@RequestParam(value = "userId") String userId, HttpServletResponse response) {
        int res = userService.banUser(userId);
        if (res == 0) {
            response.setStatus(400);
            return "Operation failed";
        }
        response.setStatus(200);
        return "ok";
    }

}
