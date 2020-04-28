package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.service.api.facade.UserService;
import com.yapt.demo.test.core.service.api.model.base.MsgResult;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
class UserTest {

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
