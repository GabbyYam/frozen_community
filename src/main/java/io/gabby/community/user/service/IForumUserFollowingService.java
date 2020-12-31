package io.gabby.community.user.service;

import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.entity.ForumUserFollowing;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.Normalizer;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
public interface IForumUserFollowingService extends IService<ForumUserFollowing> {
    boolean isFollowed(String userId, String targetId);
    int follow(String userId, String targetId);
    int unfollow(String userId, String targetId);
    List<ForumUser> listUserFollowing(String userId);
    List<ForumUser> listUserFollower(String userId);
}
