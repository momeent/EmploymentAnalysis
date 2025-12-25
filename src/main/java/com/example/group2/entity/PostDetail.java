package com.example.group2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 把userId改成用户名的类
 */
@Data
@Getter
@Setter
public class PostDetail {
    private int id;
    private String title;
    private int refer;
    private String content;
    private String userName;
    private String postTime;
    private boolean isCommentable;
    private boolean onShow;
    private int likeCount;
    private int collectionCount;
}
