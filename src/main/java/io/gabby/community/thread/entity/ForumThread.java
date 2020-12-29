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
public class ForumThread implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String content;

    private Integer likes;

    private byte[] isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
