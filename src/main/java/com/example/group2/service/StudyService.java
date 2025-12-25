package com.example.group2.service;

import com.example.group2.entity.Study;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudyService {
    /**
     * 根据大类返回所有的视频
     * @param type  大类类型
     * @return  返回视频数组
     */
    List<Study> getByType(String type);

    /**
     * 返回前5个热门的视频的 图片链接
     * @return 图片链接数组
     */
    List<Study> getHot();

    /**
     * 得到大类中的所有小类
     * @param type  大类
     * @return  小类
     */
    String[] getTypes(String type);
}
