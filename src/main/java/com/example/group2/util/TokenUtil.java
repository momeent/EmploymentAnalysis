package com.example.group2.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.group2.Common.common;
import com.example.group2.entity.User;

import java.util.Date;
public class TokenUtil {


    /**
     * 生成签名 sign
     * 返回字符串token
     *
     * @param user user对象,包括id,name,password,userphone
     * @return String token
     */
    public static String sign(User user) {

        Date date = new Date(System.currentTimeMillis() +common.TOKEN_EXPIRE_TIME); // 设置token过期时间为7天后

        String token = null;
        try {
            token = JWT.create()
                    .withIssuer(common.TOKEN_ISSUER)
                    .withExpiresAt(date)
                    .withClaim("userId",user.getUserId())
                    .withClaim("username", user.getUserName())
                    .withClaim("password",user.getPassword())
                    .withClaim("userphone",user.getUserPhone())
                    .sign(Algorithm.HMAC256(common.TOKEN_KEY));
            System.out.println("token: "+token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 签名验证 verify
     * 返回Result。验证成功则返回Result.success()，否则返回Result.error(),message中记录错误原因
     * @param token 令牌
     * @return Result
     */
    public static Result verify(String token) {
        try {
            JWTVerifier jwtVerifier =
                    JWT.require(Algorithm.HMAC256(common.TOKEN_KEY))
                            .withIssuer(common.TOKEN_ISSUER).build();
            DecodedJWT jwt = jwtVerifier.verify(token);

            System.out.println("TokenUtil: token认证通过");
//            System.out.println("username：" + jwt.getClaim("username").asString());
//            System.out.println("password：" + jwt.getClaim("password").asString());
            System.out.println("userId：" + jwt.getClaim("userId"));
//            System.out.println("token:"+jwt.getToken());
//            System.out.println("signature:"+jwt.getSignature());
//            System.out.println("Algorithm"+jwt.getAlgorithm());
//            System.out.println("过期时间：" + jwt.getExpiresAt());
//            System.out.println("issuer: "+jwt.getIssuer());
//            System.out.println("Audience: "+jwt.getAudience());
//            System.out.println("KeyId: "+jwt.getKeyId());
            return Result.success(jwt);
        } catch (TokenExpiredException e) {
            return Result.error("this token is expired");
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("wrong token");
        }
        return Result.error("wrong token");
    }
}
