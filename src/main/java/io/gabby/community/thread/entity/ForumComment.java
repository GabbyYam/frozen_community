package io.gabby.community.thread.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author GabbyYam
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ForumComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer parentCommentId;

    private Integer parentCommentUserId;

    private Integer likes;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
