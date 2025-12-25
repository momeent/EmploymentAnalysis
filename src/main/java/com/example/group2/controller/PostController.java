package com.example.group2.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.group2.entity.Post;
import com.example.group2.entity.PostDetail;
import com.example.group2.entity.PostEntity;
import com.example.group2.entity.PostListEntity;
import com.example.group2.service.PostService;
import com.example.group2.util.Result;
import com.example.group2.util.TokenUtil;
import com.sun.net.httpserver.Authenticator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;

    /**
     * 发布帖子
     * @param request
     * @param postEntity title content refer
     * @return
     */
    @PostMapping("/addPost")
    public Result addPost(HttpServletRequest request, @RequestBody PostEntity postEntity){
        String token = request.getHeader("token");
        DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
        int userId = Integer.parseInt(String.valueOf(jwt.getClaim("userId")));
        int postId = postService.addPost(postEntity, userId);
        return Result.success(postId);
    }

    /**
     * 帖子列表
     * @param request
     * @return
     */
    @GetMapping("/postList")
    public Result postList(HttpServletRequest request){
        List<PostListEntity> postList = postService.postList();
        System.out.println(postList.size());
        return Result.success(postList);
    }

    /**
     * 返回帖子的详细信息，和它所有的评论的列表
     * @param request
     * @param postId 帖子id
     * @return 帖子的详细信息，和所有的评论列表
     */
    @GetMapping("/postDetails")
    public Result getPostDetails(HttpServletRequest request, int postId){
        //得到帖子的详细信息
        PostDetail post = postService.getPostDetails(postId);
        //得到帖子的评论列表
        PostDetail[] comments = postService.getComments(postId);
        //得到父帖子
        PostDetail referPost = postService.getReferPost(postId);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postDetails", post);
        jsonObject.put("comments", comments);
        jsonObject.put("referPost", referPost);
        return Result.success(jsonObject);
    }

    @GetMapping("/userPost")
    public Result getUserPost(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
        int userId = Integer.parseInt(String.valueOf(jwt.getClaim("userId")));
        List<PostListEntity> postListEntities = postService.getPostByUid(userId);
        return Result.success(postListEntities);
    }



}
