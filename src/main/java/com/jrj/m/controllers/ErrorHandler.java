package com.jrj.m.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

/**
 * 
* @ClassName: ErrorHandler
* @Description: TODO
* @author ping.lv ping.lv@jrj.com.cn
* @date 2015年1月22日 上午10:47:58
*
 */
public class ErrorHandler implements ControllerErrorHandler {

    public Object onError(Invocation inv, Throwable ex) throws Throwable {

        if (ex instanceof RuntimeException) {
            return "@runtime";
        }
        return "@error";
    }
}
