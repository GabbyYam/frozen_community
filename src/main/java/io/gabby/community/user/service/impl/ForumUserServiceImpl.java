package io.gabby.community.user.service.impl;

import io.gabby.community.user.entity.ForumUser;
import io.gabby.community.user.mapper.ForumUserMapper;
import io.gabby.community.user.service.IForumUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ForumUser getById(Integer id) {
        ForumUser user = (ForumUser) userMapper.selectById(id);
        System.out.println(user);
        return user;
    }
}
