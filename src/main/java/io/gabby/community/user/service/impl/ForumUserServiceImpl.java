package io.gabby.community.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.mapper.ForumUserMapper;
import io.gabby.community.user.service.IForumUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
@Service
public class ForumUserServiceImpl extends ServiceImpl<ForumUserMapper, ForumUser> implements IForumUserService {
    @Autowired
    ForumUserMapper userMapper;

    @Override
    public ForumUser checkAndLoginUser(String userName, String password) {
        QueryWrapper<ForumUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName).eq("password", password);
        ForumUser user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public List<ForumUser> searchUser(String userName, LocalDateTime createTime) {
        QueryWrapper<ForumUser> wrapper = new QueryWrapper<ForumUser>();
        if (userName   != null) wrapper.eq("user_name", userName);
        if (createTime != null) wrapper.ge("create_time", createTime);
        List<ForumUser> users = userMapper.selectList(wrapper);
        return users;
    }

    @Override
    public int patchUser(String userId, String userName, String password, String introduction, String avartarUrl) {
        ForumUser user = new ForumUser();
        user.setUpdateTime(LocalDateTime.now());
        user.setUserId(userId);
        if (userName    != null)    user.setUserName(userName);
        if (password    != null)    user.setPassword(password);
        if (avartarUrl  != null)    user.setAvartarUrl(avartarUrl);
        if (introduction != null)   user.setIntroduction(introduction);
        return userMapper.updateById(user);
    }

    @Override
    public int insertUser(String userName, String password, String introduction) {
        ForumUser user = new ForumUser();
        String userId = UUID.randomUUID().toString();
        System.out.println(userId);
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setIntroduction(introduction);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.insert(user);
    }

    @Override
    public int banUser(String userId) {
        ForumUser user = userMapper.selectById(userId);
        Boolean status = user.getIsDeleted();
        status = status == null ? false : !status;
        user.setIsDeleted(status);
        return userMapper.updateById(user);
    }
}
