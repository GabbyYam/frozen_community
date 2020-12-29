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
public class ForumUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String introduction;

    private String password;

    private String avartarUrl;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
