package io.gabby.community.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class ForumUserFollowing implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id")
    private Integer userId;

    private Integer userFollowingId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
