package com.example.group2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Setter
@Getter
public class PostListEntity {
    private int id;
    private String title;
    private int refer;
    private String userName;
    private String postTime;
    private int likeCount;
    private int collectionCount;
}
