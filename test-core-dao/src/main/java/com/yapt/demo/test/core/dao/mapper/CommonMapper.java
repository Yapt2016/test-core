package com.yapt.demo.test.core.dao.mapper;

import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author hurui
 * @version Id: CommonMapper.java, v 0.1 2020/10/14 11:14 YaphetS Exp $$
 */
public interface CommonMapper {

    /**
     * 通用新增
     * @param value
     * @return
     */
    @Insert("${value}")
    int addObject(@Param("value")String value);

    /**
     * 通用查询
     * @param value
     * @return
     */
    @Select("${value}")
    List<LinkedHashMap<String, Object>> queryObject (@Param("value") String value);

    /**
     * 通用更新
     * @param value
     * @return
     */
    @Update("${value}")
    int updateObject(@Param("value") String value);

    /**
     * 通用删除
     * @param value
     * @return
     */
    @Delete({"${value}"})
    int deleteObject(@Param("value") String value);
}