package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.service.api.facade.UserService;
import com.yapt.demo.test.core.service.api.model.base.MsgResult;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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


    @Test
    public void testSort() {
        int[] arr = {17, -27, 3, 21, -5, 2, 18, -40};

        for(int i=0; i<arr.length-1; i++) {
            //外层循环每执行一遍，末尾位置就确定一个元素。 比如：第一次循环完，确定 index=arr.length-1的元素；
            //第二次循环，确定 index=arr.length-2的元素
            for(int j=0; j<arr.length-1-i; j++) {
                if(Math.abs(arr[j]) > Math.abs(arr[j+1])) {
                    int tmp = arr[j+1];//交换相邻两个元素
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for(int one:arr) {
            System.out.print(one);
            System.out.print(",");
        }
    }

}
