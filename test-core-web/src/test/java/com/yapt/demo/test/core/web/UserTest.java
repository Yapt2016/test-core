package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.service.api.facade.UserService;
import com.yapt.demo.test.core.service.api.model.base.MsgResult;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

@Slf4j
public class UserTest extends BaseTest{

    @Resource
    private UserService userService;

    @Test
    public void test() {
        UserReqDTO req = new UserReqDTO();
        req.setName("test1");
        req.setCityId(1);
        req.setSex(2);
        MsgResult<UserResDTO> result = userService.queryUserInfo(req);
        log.info("测试结果,return:{}",result);
    }



}
