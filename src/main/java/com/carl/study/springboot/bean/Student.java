package com.carl.study.springboot.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * @author changez
 * @desc
 * @date 2019/3/10 11:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class Student extends BeanBasic{


	private String name;
	private String address;

	public static String isElig(Student student){
		if (student == null) {
			return "etity is null";
		}

		StringBuilder errMsg = new StringBuilder(200);
		if (StringUtils.isBlank(student.getName())) {
			errMsg.append("name is blank");
		}

		return errMsg.length() == 0 ? null : errMsg.toString();
	}
}
