package com.example.group2.service;

import com.example.group2.entity.Post;
import com.example.group2.entity.PostDetail;
import com.example.group2.entity.PostEntity;
import com.example.group2.entity.PostListEntity;

import java.util.List;

public interface PostService {
    /**
     * 发布帖子
     * @param postEntity  帖子信息，只有标题和内容，refer
     * @param userId  用户id
     */
    int addPost(PostEntity postEntity, int userId);

    /**
     * 列出所有帖子
     * @return 返回帖子的post
     */
    List<PostListEntity> postList();

    /**
     * 得到帖子的详细信息
     * @param postId  帖子id
     * @return 返回帖子所有信息
     */
    PostDetail getPostDetails(int postId);

    /**
     * 得到帖子中的所有评论帖子的 详细信息
     * @param postId 帖子id
     * @return 该帖子的所有评论详细信息
     */
    PostDetail[] getComments(int postId);

    /**
     * 得到父帖子的详细信息
     * @param postId 帖子id
     * @return 返回refer对应的帖子
     */
    PostDetail getReferPost(int postId);

    /**
     * 根据用户id得到发布过的帖子
     * @param userId
     * @return
     */
    List<PostListEntity> getPostByUid(int userId);
}
