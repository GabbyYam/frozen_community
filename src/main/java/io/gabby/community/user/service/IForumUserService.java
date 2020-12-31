package io.gabby.community.user.service;

import io.gabby.community.user.entity.ForumUser;
import com.baomidou.mybatisplus.extension.service.IService;
import io.gabby.community.user.mapper.ForumUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
public interface IForumUserService extends IService<ForumUser> {
    ForumUser checkAndLoginUser(String userName, String password);
    List<ForumUser> searchUser(String userName, LocalDateTime createTime);
    int patchUser(String userId, String userName, String password, String introduction, String avartarUrl);
    int insertUser(String userName, String password, String introduction);
    int banUser(String userId);
}
