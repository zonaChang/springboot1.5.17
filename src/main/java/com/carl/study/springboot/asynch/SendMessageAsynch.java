package com.carl.study.springboot.asynch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author changez
 * @desc 异步使用
 * @date 2019/3/13 16:46
 * @note
 *  1. 被@Async修饰的方法不能是static
 *  2. 使用时需要用spring bean的使用方式，通过注入获取bean， 然后调用方法
 *  3. 需要开启springboot的允许异步调用 @EnableAsync
 */
@Component
@Slf4j
public class SendMessageAsynch {

	/**
	 * @desc 异步操作测试
	 * @author changez
	 * @date 2019/3/13 16:53
	 * @param
	 * @return
	 */
	@Async
	public void sendMessage(){
		try {
			log.info("waiting...");
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
