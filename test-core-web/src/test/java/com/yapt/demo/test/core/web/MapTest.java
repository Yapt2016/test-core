package com.yapt.demo.test.core.web;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hurui
 * @version Id: MapTest.java, v 0.1 2020/8/25 11:00 YaphetS Exp $$
 */
public class MapTest extends BaseTest{

    private static final Map<String,Long> MAP = new HashMap<>();

    static {
        MAP.put("202001",1L);
        MAP.put("202002",1L);
        MAP.put("202003",1L);
        MAP.put("202004",1L);
        MAP.put("202005",1L);
        MAP.put("202006",1L);
        MAP.put("202007",1L);
        MAP.put("202008",1L);
        MAP.put("202009",1L);
        MAP.put("202010",1L);
        MAP.put("202011",1L);
        MAP.put("202012",1L);
    }

    private String format(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * map遍历求和
     */
    @Test
    public void test(){
        System.out.println(MAP);
        Long result = MAP.entrySet().stream().filter(entry -> Long.valueOf(entry.getKey()) >= Long.valueOf(format(new Date(),"yyyyMM"))).mapToLong(Map.Entry::getValue).sum();
        System.out.println(result);
    }
}