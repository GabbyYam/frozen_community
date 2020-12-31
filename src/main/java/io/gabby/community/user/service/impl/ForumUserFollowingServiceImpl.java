package io.gabby.community.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.entity.ForumUserFollowing;
import io.gabby.community.user.mapper.ForumUserFollowingMapper;
import io.gabby.community.user.mapper.ForumUserMapper;
import io.gabby.community.user.service.IForumUserFollowingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
@Service
public class ForumUserFollowingServiceImpl extends ServiceImpl<ForumUserFollowingMapper, ForumUserFollowing> implements IForumUserFollowingService {
    @Autowired
    ForumUserFollowingMapper followingMapper;

    @Autowired
    ForumUserMapper userMapper;

    @Override
    public boolean isFollowed(String userId, String targetId) {
        QueryWrapper<ForumUserFollowing> wrapper = new QueryWrapper<ForumUserFollowing>();
        wrapper.eq("user_id", userId).eq("user_following_id", targetId);
        ForumUserFollowing one = followingMapper.selectOne(wrapper);
        return one != null;
    }

    @Override
    public int follow(String userId, String targetId) {
        if (!isFollowed(userId, targetId)) {
            ForumUserFollowing record = new ForumUserFollowing();
            record.setUserId(userId);
            record.setUserFollowingId(targetId);
            LocalDateTime time = LocalDateTime.now();
            record.setCreateTime(time);
            record.setUpdateTime(time);
            return followingMapper.insert(record);
        }
        return 0;
    }

    @Override
    public int unfollow(String userId, String targetId) {
        if (isFollowed(userId, targetId)) {
            QueryWrapper<ForumUserFollowing> wrapper = new QueryWrapper<ForumUserFollowing>();
            wrapper.eq("user_id", userId).eq("user_following_id", targetId);
            return followingMapper.delete(wrapper);
        }
        return 0;
    }

    @Override
    public List<ForumUser> listUserFollowing(String userId) {
        QueryWrapper<ForumUserFollowing> wrapper = new QueryWrapper<ForumUserFollowing>();
        wrapper.eq("user_id", userId);
        List<ForumUserFollowing> userFollowings = followingMapper.selectList(wrapper);
        List<String> ids = new ArrayList<>();
        System.out.println(userFollowings);
        for (ForumUserFollowing record : userFollowings)
            ids.add(record.getUserFollowingId());
        return ids.isEmpty() ? null : userMapper.selectBatchIds(ids);
    }

    @Override
    public List<ForumUser> listUserFollower(String userId) {
        QueryWrapper<ForumUserFollowing> wrapper = new QueryWrapper<ForumUserFollowing>();
        wrapper.eq("user_following_id", userId);
        List<ForumUserFollowing> userFollowers = followingMapper.selectList(wrapper);
        List<String> ids = new ArrayList<>();
        System.out.println(userFollowers);
        for (ForumUserFollowing record : userFollowers)
            ids.add(record.getUserFollowingId());
        return ids.isEmpty() ? null : userMapper.selectBatchIds(ids);
    }
}
