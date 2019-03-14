package com.carl.study.springboot.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author changez
 * @desc
 * @date 2019/3/10 11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException{

	private Integer code = 0;
	public BizException(Integer code, String errMsg, Exception e) {
		super(errMsg, e);
		this.code = code == null ? this.code : code;
	}
	public BizException(Integer code, String errMsg) {
		super(errMsg);
		this.code = code == null ? this.code : code;
	}


}
