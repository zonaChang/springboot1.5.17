package com.carl.study.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changez
 * @desc
 * @date 2019/3/10 18:17
 */
public final class DateUtils {

	private static final String FORMATE_YYYYMMDDHH24MMSS = "yyyyMMddHHmmss";


	public static Long currTime() {
		try {
			String curTime = new SimpleDateFormat(FORMATE_YYYYMMDDHH24MMSS).format(new Date());
			return Long.parseLong(curTime);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}
}
