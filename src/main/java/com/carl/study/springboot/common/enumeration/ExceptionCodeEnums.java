package com.carl.study.springboot.common.enumeration;

import lombok.Getter;

/**
 * @author changez
 * @desc
 * @date 2019/3/13 10:30
 */
public enum ExceptionCodeEnums {

	LACK_OF_PARAM(1, "参数不正确"),
	unknow_error(1, "未知异常");

	@Getter
	private Integer code;
	@Getter
	private String desc;
	ExceptionCodeEnums(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
