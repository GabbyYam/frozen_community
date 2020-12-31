package io.gabby.community.user.controller;


import com.alibaba.fastjson.JSON;
import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.service.impl.ForumUserFollowingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@ResponseBody
@RequestMapping("/user/forum-user-following")
public class ForumUserFollowingController {
    @Autowired
    ForumUserFollowingServiceImpl followingService;

    @PostMapping
    String follow(@RequestParam(value = "userId")   String userId,
                  @RequestParam(value = "targetId") String userFollowingId) {
        String msg = followingService.follow(userId, userFollowingId) == 0 ? "Can not follow repeatly!" : "ok";
        return msg;
    }

    @DeleteMapping
    String unfollow(@RequestParam(value = "userId")   String userId,
                    @RequestParam(value = "targetId") String userFollowingId) {
        String msg = followingService.unfollow(userId, userFollowingId) == 0 ? "You didn't follow this person ever before!" : "ok";
        return msg;
    }

    @GetMapping
    String listFollowing(@RequestParam(value = "userId")       String userId,
                         @RequestParam(value = "isFollowing") Boolean isFollowing) {
        List<ForumUser> users = isFollowing ? followingService.listUserFollowing(userId) : followingService.listUserFollower(userId);
        return JSON.toJSONString(users);
    }
}
