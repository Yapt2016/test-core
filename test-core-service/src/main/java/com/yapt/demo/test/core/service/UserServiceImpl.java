package com.yapt.demo.test.core.service;

import com.yapt.demo.test.core.manager.impl.UserServiceManager;
import com.yapt.demo.test.core.service.api.facade.UserService;
import com.yapt.demo.test.core.service.api.model.base.MsgResult;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hurui
 * @version Id: UserServiceImpl.java, v 0.1 2020/1/29 13:31 YaphetS Exp $$
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserServiceManager userServiceManager;

    /**
     * 新增用户信息
     *
     * @param reqDTO
     * @return
     */
    @Override
    public MsgResult<Boolean> addUserInfo(UserReqDTO reqDTO) {
        return userServiceManager.addUserInfo(reqDTO);
    }

    /**
     * 查询用户信息
     *
     * @param reqDTO
     * @return
     */
    @Override
    public MsgResult<UserResDTO> queryUserInfo(UserReqDTO reqDTO) {
        return userServiceManager.queryUserInfo(reqDTO);
    }
}