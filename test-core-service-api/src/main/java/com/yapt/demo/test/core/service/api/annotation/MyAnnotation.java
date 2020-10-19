package com.yapt.demo.test.core.service.api.annotation;

import java.lang.annotation.*;

/**
 * @author hurui
 * @date 2020/2/1  16:47
 **/
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

}
