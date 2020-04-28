package com.yapt.demo.test.core.manager.convert;

import com.yapt.demo.test.core.dao.model.UserDO;
import com.yapt.demo.test.core.service.api.model.req.UserReqDTO;
import com.yapt.demo.test.core.service.api.model.res.UserResDTO;

/**
 * @author hurui
 * @version Id: UserLoginConvert.java, v 0.1 2020/1/9 15:14 YaphetS Exp $$
 */
public class UserLoginConvert {

    public static final UserLoginConvert INSTANCE = new UserLoginConvert();

    /**
     * 参数转换
     *
     * @param req
     * @return
     */
    public UserResDTO convert(UserDO req) {
        if (req == null) {
            return null;
        }
        UserResDTO res = new UserResDTO();
        res.setName(req.getName());
        res.setPhone(req.getPhone());
        res.setEmail(req.getEmail());
        res.setPassword(req.getPassword());
        res.setCityId(req.getCityId());
        res.setSex(req.getSex());
        res.setCreateTime(req.getCreateTime());
        return res;
    }



    /**
     * 参数转换
     *
     * @param req
     * @return
     */
    public UserDO convert(UserReqDTO req) {
        if (req == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setName(req.getName());
        userDO.setPhone(req.getPhone());
        userDO.setEmail(req.getEmail());
        userDO.setPassword(req.getPassword());
        userDO.setCityId(req.getCityId());
        userDO.setCreateTime(req.getCreateTime());
        userDO.setSex(req.getSex());
        return userDO;
    }
}