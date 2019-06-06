package com.how2j.tmall_springboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuss.
 * @date 2019/6/6 14:29
 */
public class GloabalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if (null != e.getCause() && constraintViolationException == e.getCause().getClass()) {
            return "违反了约束，多半是外键约束";
        }
        return e.getMessage();
    }
}
