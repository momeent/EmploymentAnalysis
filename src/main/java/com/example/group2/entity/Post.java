package com.example.group2.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private int refer;
    private String content;
    private int userId;
    private Timestamp postTime;
    private boolean isCommentable;
    private boolean onShow;
    private int likeCount;
    private int collectionCount;
}
