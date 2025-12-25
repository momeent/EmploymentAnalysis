package com.example.group2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * 专门用来接收前端post的类
 * 发布帖子用
 */

@Data
@Getter
@Setter
public class PostEntity {
    private String title;
    private String content;
    private int refer;
}
