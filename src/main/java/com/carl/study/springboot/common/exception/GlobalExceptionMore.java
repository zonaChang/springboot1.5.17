package com.carl.study.springboot.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author changez
 * @desc 自动被容器管理， 无需将其显式纳入容器管理。 异常发生后，会根据最精确范围匹配要使用的处理方法
 * @date 2019/3/13 10:56
 */
@RestControllerAdvice
public class GlobalExceptionMore {

	@ExceptionHandler(Exception.class)
	public void exceptionHandle(){
		System.out.println("exceptionHandle..................");
	}

	@ExceptionHandler(BizException.class)
	private void bizExceptionHandler(){
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		System.out.println("bizExceptionHandler.............");

	}

	@ExceptionHandler(UnkonwException.class)
	public void unknowExceptionHandler(){
		System.out.println("unknowExceptionHandler.............");
	}
}
