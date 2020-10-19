package com.yapt.demo.test.core.common.exception;

import java.text.MessageFormat;

/**
 * @author hurui
 * @version Id: MessageHelper.java, v 0.1 2020/10/15 14:04 YaphetS Exp $$
 */
public class MessageHelper {

    public MessageHelper() {

    }

    public static String formatMsg(String msgTemplate, Object... positionValues) {
        try {
            return MessageFormat.format(msgTemplate, positionValues);
        } catch (Exception var5) {
            StringBuilder sb = new StringBuilder("资源信息占位符替换异常，占位符参数信息：");

            for(int i = 0; i < positionValues.length; ++i) {
                sb.append(" arg[").append(i).append("]=").append(positionValues[i]);
            }

            return sb.toString();
        }
    }
}