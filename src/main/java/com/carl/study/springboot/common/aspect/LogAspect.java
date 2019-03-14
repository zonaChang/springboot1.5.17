package com.carl.study.springboot.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author changez
 * @desc
 * @date 2019/3/13 15:05
 */
@Aspect
//@Component
@Configuration
@Slf4j
public class LogAspect {
	/*
	第一个'*'：返回值类型， *表示任意返回值
	第一次出现的两个点“..": 当前包的自包及其子孙包
	两个*之间的点'.': 任意类 com.carl.study.springboot.controller.StudentController
	*(..): 表示任意方法，的任意参数。 *表示任意方法， (..)表示任意参数
	 */
	@Pointcut("execution( * com.carl.study.springboot.controller..*.*(..)) " +
			"|| execution(* com.carl.study.springboot.common.exception.GlobalExceptionMore.*(..))")
	public void aopFlag(){}

	@Around("aopFlag()")
	public Object logAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

		log.info("into log aspect");
		// TODO 不要对该方法try， 因这里做出try-catch 会造成全局异常不执行
		Object obj = proceedingJoinPoint.proceed();
		log.info("after log aspect");
		return obj;
	}
}
