package com.yapt.demo.test.core.service.api.facade;

import com.yapt.demo.test.core.service.api.model.base.MsgResult;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;

/**
 * @author hurui
 * @version Id: UserService.java, v 0.1 2020/4/28 18:57 YaphetS Exp $$
 */
public interface UserService {

    /**
     * 新增用户信息
     *
     * @param reqDTO
     * @return
     */
    MsgResult<Boolean> addUserInfo(UserReqDTO reqDTO);

    /**
     * 查询用户信息
     *
     * @param reqDTO
     * @return
     */
    MsgResult<UserResDTO> queryUserInfo(UserReqDTO reqDTO);
}