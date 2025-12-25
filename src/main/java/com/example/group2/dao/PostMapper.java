package com.example.group2.dao;

import com.example.group2.entity.Post;
import com.example.group2.entity.PostDetail;
import com.example.group2.entity.PostListEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * 发帖 并把帖子id放入
     * @param post 帖子
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO `careercrafthub`.`post` (`title`, `refer`, `content`, `user_id`, `post_time`, `is_commentable`, `on_show`, `like_count`, `collection_count`) " +
            "VALUES (#{title}, #{refer}, #{content}, #{userId}, #{postTime}, #{isCommentable}, #{onShow}, #{likeCount}, #{collectionCount});")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "postTime", column = "post_time"),
            @Result(property = "isCommentable", column = "is_commentable"),
            @Result(property = "onShow", column = "on_show"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "collectionCount", column = "collection_count"),
    })
    void addPost(Post post);

    @Select("SELECT post.id, post.title, post.refer, user.user_nick_name, post.post_time, post.like_count, post.collection_count\n" +
            "FROM post, user\n" +
            "where post.on_show = 1\n" +
            "and user.user_id = post.user_id\n" +
            "and post.id>5\n" +
            "and post.refer<6")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "postTime", column = "post_time"),
            @Result(property = "isCommentable", column = "is_commentable"),
            @Result(property = "onShow", column = "on_show"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "collectionCount", column = "collection_count"),
            @Result(property = "userName", column = "user_nick_name"),
    })
    List<PostListEntity> postList();

    @Select("SELECT post.id, post.title, post.refer,post.content, user.user_nick_name, post.post_time,post.is_commentable, post.on_show, post.like_count, post.collection_count\n" +
            "FROM post, user\n" +
            "where post.id = #{postId}\n" +
            "and user.user_id = post.user_id")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "postTime", column = "post_time"),
            @Result(property = "isCommentable", column = "is_commentable"),
            @Result(property = "onShow", column = "on_show"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "collectionCount", column = "collection_count"),
            @Result(property = "userName", column = "user_nick_name"),
    })
    PostDetail getPostDetails(int postId);


    @Select("SELECT post.id, post.title, post.refer, post.content,user.user_nick_name, post.post_time,post.is_commentable, post.on_show, post.like_count, post.collection_count\n" +
            "FROM post, user\n" +
            "where post.refer = #{postId}\n" +
            "and user.user_id = post.user_id")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "postTime", column = "post_time"),
            @Result(property = "isCommentable", column = "is_commentable"),
            @Result(property = "onShow", column = "on_show"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "collectionCount", column = "collection_count"),
            @Result(property = "userName", column = "user_nick_name"),
    })
    PostDetail[] getComments(int postId);

    /**
     * 得到帖子所评论的帖子
     * @param postId 帖子id
     * @return 返回评论的帖子
     */
    @Select("SELECT b.id, b.title, b.refer, b.content, c.user_nick_name, b.post_time, b.is_commentable, b.on_show, b.like_count, b.collection_count\n" +
            "FROM post a, post b, user c\n" +
            "where a.id = #{postId} \n" +
            "and a.refer = b.id\n" +
            "and b.user_id = c.user_id")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "postTime", column = "post_time"),
            @Result(property = "isCommentable", column = "is_commentable"),
            @Result(property = "onShow", column = "on_show"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "collectionCount", column = "collection_count"),
            @Result(property = "userName", column = "user_nick_name"),
    })
    PostDetail getReferPost(int postId);

    /**
     * 根据用户id得到发布过的帖子
     * @param userId 用户id
     * @return 发布过的帖子列表
     */
    @Select("SELECT post.id, post.title, post.refer, user.user_nick_name, post.post_time, post.like_count, post.collection_count\n" +
            "FROM post, user\n" +
            "where user.user_id = #{userId}\n" +
            "and user.user_id = post.user_id")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "postTime", column = "post_time"),
            @Result(property = "isCommentable", column = "is_commentable"),
            @Result(property = "onShow", column = "on_show"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "collectionCount", column = "collection_count"),
            @Result(property = "userName", column = "user_nick_name"),
    })
    List<PostListEntity> getPostByUid(int userId);
}
