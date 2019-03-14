package com.carl.study.springboot.config;

import com.carl.study.springboot.common.exception.GlobalException;
import com.carl.study.springboot.common.interceptor.AuthInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author changez
 * @desc
 * @date 2019/3/9 17:39
 */
@SpringBootApplication(scanBasePackages = "com.carl.study.springboot.**/*")

// 加载配置文件
@PropertySources({
	@PropertySource("classpath:/config/application.properties") //使用全限定名， 发现暂不支持通配符
})

// mybatis的mapper路径
@MapperScan("com.carl.study.springboot.dao.mapper")

//支持异步方法
@EnableAsync
public class Main extends WebMvcConfigurerAdapter {

	@Autowired
	private AuthInterceptor authInterceptor;

	@Autowired
	private GlobalException globalException;

	public static void main(String[] args) {

		new SpringApplication().run(Main.class);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(authInterceptor)
				.excludePathPatterns("/api/student/queryStudentById")
				.addPathPatterns("/api/student/**");
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		super.configureHandlerExceptionResolvers(exceptionResolvers);
//		exceptionResolvers.add(globalException);
	}
}
