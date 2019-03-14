package com.carl.study.springboot.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.security.auth.Subject;

/**
 * @author changez
 * @desc
 * @date 2019/3/13 13:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UnkonwException extends RuntimeException {
	private Integer code=0;

	public UnkonwException(Integer code, String errMsg) {
		super(errMsg);
		this.code = code;
	}
}
