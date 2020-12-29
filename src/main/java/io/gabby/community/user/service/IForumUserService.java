package io.gabby.community.user.service;

import io.gabby.community.user.entity.ForumUser;
import com.baomidou.mybatisplus.extension.service.IService;
import io.gabby.community.user.mapper.ForumUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
public interface IForumUserService extends IService<ForumUser> {
    ForumUser getById(Integer id);
}
