package com.yapt.demo.test.core.dao.mapper;


import com.yapt.demo.test.core.dao.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hurui
 * @version Id: UserMapper.java, v 0.1 2020/1/13 17:28 YaphetS Exp $$
 */
@Mapper
public interface UserMapper {

    /**
     * 保存
     * @param user
     * @return
     */
    int save(UserDO user);

    /**
     * 查询
     * @param req
     * @return
     */
    UserDO get(UserDO req);
}