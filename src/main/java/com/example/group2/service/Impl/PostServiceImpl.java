package com.example.group2.service.Impl;

import com.example.group2.dao.PostMapper;
import com.example.group2.entity.Post;
import com.example.group2.entity.PostDetail;
import com.example.group2.entity.PostEntity;
import com.example.group2.entity.PostListEntity;
import com.example.group2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    PostMapper postMapper;

    @Override
    public int addPost(PostEntity postEntity, int userId) {
        Post post = new Post();
        post.setUserId(userId);
        post.setContent(postEntity.getContent());
        post.setTitle(postEntity.getTitle());
        post.setCommentable(true);
        Date date = new Date();
        post.setPostTime(new Timestamp(date.getTime()));
        post.setOnShow(true);
        post.setLikeCount(0);
        post.setCollectionCount(0);
        post.setRefer(postEntity.getRefer());
        postMapper.addPost(post);
        return post.getId();
    }

    @Override
    public List<PostListEntity> postList() {
        List<PostListEntity> postList = postMapper.postList();
//        System.out.println(postList);
        return postList;
    }

    @Override
    public PostDetail getPostDetails(int postId) {
        PostDetail post = postMapper.getPostDetails(postId);
        System.out.println(post.getPostTime());
        return post;
    }

    @Override
    public PostDetail[] getComments(int postId) {
        PostDetail[] postDetails = postMapper.getComments(postId);
        return postDetails;
    }

    @Override
    public PostDetail getReferPost(int postId) {
        PostDetail referPost = postMapper.getReferPost(postId);
        return referPost;
    }

    @Override
    public List<PostListEntity> getPostByUid(int userId) {
        List<PostListEntity> postListEntities = postMapper.getPostByUid(userId);
        return postListEntities;
    }
}
