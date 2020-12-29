package io.gabby.community.thread.service.impl;

import io.gabby.community.thread.entity.ForumComment;
import io.gabby.community.thread.mapper.ForumCommentMapper;
import io.gabby.community.thread.service.IForumCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ForumCommentServiceImpl extends ServiceImpl<ForumCommentMapper, ForumComment> implements IForumCommentService {

}
