package com.yapt.demo.test.core.manager.impl;

import com.yapt.demo.test.core.common.exception.BaseServiceException;
import com.yapt.demo.test.core.common.exception.ErrorCodeEnum;
import com.yapt.demo.test.core.dao.mapper.CommonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author hurui
 * @version Id: CommonServiceManager.java, v 0.1 2020/10/14 11:21 YaphetS Exp $$
 */
@Slf4j
@Component
public class CommonServiceManager {

    @Resource
    private CommonMapper commonMapper;

    /**
     * 基本操作数据库
     * @param map
     * @return
     */
    public Object commonOperate(Map<String,String> map){
        String sql = map.get("sql");
        log.info("sql:{}",sql);
        String operator = sql.substring(0,6).toLowerCase();
        log.info("operator:{}",operator);
        if("insert".equalsIgnoreCase(operator)){
            return commonMapper.addObject(sql);
        }else if("select".equalsIgnoreCase(operator)){
            return commonMapper.queryObject(sql);
        }else if("update".equalsIgnoreCase(operator)){
            return commonMapper.updateObject(sql);
        }else if("delete".equalsIgnoreCase(operator)){
            return commonMapper.deleteObject(sql);
        }else{
            throw new BaseServiceException(ErrorCodeEnum.ILLEGE_PARAMETER);
        }
    }
}