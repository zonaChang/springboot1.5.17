package com.carl.study.springboot.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

/**
 * @author changez
 * @desc 声明后需要显式将其纳入容器 webMvcConfigureAdapter.configureHandlerExceptionResolvers
 *       HandlerExceptionResolver的优先级高于@ExceptionHandler， 共存时如果不做其他配置，则会使用HandlerExceptionResolver的处理逻辑
 * @date 2019/3/13 9:29
 */
@Component
@Slf4j
public class GlobalException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

		log.error("into global exception", e);
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView()).addAllObjects(Collections.emptyMap());

		//返回null，会导致这个全局异常执行两次
		return mv;
	}
}
