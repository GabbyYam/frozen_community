package io.gabby.community.user.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.mapper.ForumUserMapper;
import io.gabby.community.user.service.impl.ForumUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    ForumUserMapper mapper;

    @RequestMapping(value = "/finduser")
    String getUserById(@RequestParam("id") Integer id) {
        // QueryWrapper wrapper = new QueryWrapper();
        // wrapper.eq("user_name", "GabbyYam");
        // ForumUser user = mapper.selectOne(wrapper);
        ForumUser user = mapper.selectById(id);
        String res = new String();
        res = JSON.toJSONString(user);
        return res;
    }

    @RequestMapping(value = "hello")
    String hello() {return "hello!";}
}
