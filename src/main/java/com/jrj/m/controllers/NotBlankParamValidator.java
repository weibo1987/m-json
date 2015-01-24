package com.jrj.m.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;

/**
 * 
 * @ClassName: NotBlankParamValidator
 * @Description: TODO
 * @author ping.lv ping.lv@jrj.com.cn
 * @date 2015年1月22日 上午10:51:58
 *
 */
public class NotBlankParamValidator implements ParamValidator {

	@Override
	public boolean supports(ParamMetaData metaData) {
		return metaData.getAnnotation(NotBlank.class) != null;
	}

	@Override
	public Object validate(ParamMetaData metaData, Invocation inv,
			Object target, Errors errors) {
		String paramName = metaData.getParamName();
		String value = inv.getParameter(paramName);
		if (StringUtils.isBlank(value)) {
			return "@参数不能为空";
		}
		return null;
	}

}
