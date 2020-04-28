
package com.yapt.demo.test.core.service.api.model.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * @author hurui
 * @version Id: BaseDTO.java, v 0.1 2019/8/20 9:55 YaphetS Exp $$
 */
@Getter
@Setter
@ToString
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = -1241152434763239319L;

    /**
     * 日志ID
     */
    @NotNull(message = "日志号不能为空")
    private String traceLogId;
}