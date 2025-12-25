package com.example.group2.dao;

import com.example.group2.entity.Study;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudyMapper {

    @Select("SELECT * FROM study JOIN type ON study.type = type.smalltype WHERE type.bigtype = #{type};")
    List<Study> getByType(String type);

    @Select("SELECT study.name, study.link, study.num, study.time, study.pic \n" +
            "FROM study\n" +
            "ORDER BY \n" +
            "  CASE \n" +
            "    WHEN num LIKE '%万%' THEN CAST(SUBSTRING_INDEX(num, '万', 1) AS DECIMAL(10,2)) * 10000\n" +
            "    ELSE CAST(num AS DECIMAL(10,2))\n" +
            "  END DESC\n" +
            "LIMIT 5;")
    List<Study> getHot();

    /**
     * 根据大类名称得到大类中的所有小类
     * @param type
     * @return
     */
    @Select("select smalltype from type where bigtype = #{type}")
    String[] getTypes(String type);
}
