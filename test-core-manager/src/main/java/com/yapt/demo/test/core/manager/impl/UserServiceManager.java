package com.yapt.demo.test.core.manager.impl;

import com.yapt.demo.test.core.dao.mapper.UserMapper;
import com.yapt.demo.test.core.dao.model.UserDO;
import com.yapt.demo.test.core.manager.convert.UserLoginConvert;
import com.yapt.demo.test.core.service.api.model.base.MsgResult;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hurui
 * @version Id: UserServiceManager.java, v 0.1 2020/1/29 13:31 YaphetS Exp $$
 */
@Slf4j
@Component
public class UserServiceManager {

    @Resource
    private UserMapper userMapper;

    /**
     * 新增用户信息
     *
     * @param reqDTO
     * @return
     */
    public MsgResult<Boolean> addUserInfo(UserReqDTO reqDTO) {
        MsgResult<Boolean> result = new MsgResult<>(Boolean.TRUE);
        UserDO req = UserLoginConvert.getInstance() .convert(reqDTO);
        log.info("UserServiceManager.addUserInfo,新增用户信息,param:{}", req);
        int count = userMapper.save(req);
        log.info("UserServiceManager.addUserInfo,新增用户信息,return:{}", count);
        return result;
    }

    /**
     * 查询用户信息
     *
     * @param reqDTO
     * @return
     */
    public MsgResult<UserResDTO> queryUserInfo(UserReqDTO reqDTO) {
        MsgResult<UserResDTO> result = new MsgResult<>();
        UserDO req = UserLoginConvert.getInstance().convert(reqDTO);
        log.info("UserServiceManager.addUserInfo,查询用户信息,param:{}", req);
        req = userMapper.get(req);
        log.info("UserServiceManager.addUserInfo,查询用户信息,return:{}", req);
        UserResDTO res = UserLoginConvert.getInstance().convert(req);
        result.setResult(res);
        return result;
    }
}