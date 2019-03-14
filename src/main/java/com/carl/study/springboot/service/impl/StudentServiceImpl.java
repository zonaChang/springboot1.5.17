package com.carl.study.springboot.service.impl;

import com.carl.study.springboot.bean.Student;
import com.carl.study.springboot.common.enumeration.ExceptionCodeEnums;
import com.carl.study.springboot.common.exception.BizException;
import com.carl.study.springboot.common.exception.UnkonwException;
import com.carl.study.springboot.dao.mapper.StudentMapper;
import com.carl.study.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author changez
 * @desc
 * @date 2019/3/13 10:24
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int addStudent(Student student) {

		if ("carl".equals(student.getName())) {
			throw new RuntimeException("未明确定义异常");
		}
		if ("add".equals(student.getAddress())) {
			throw new UnkonwException(ExceptionCodeEnums.unknow_error.getCode(), "未知");
		}
		String errMsg = Student.isElig(student);
		if (errMsg != null) {
			throw new BizException(ExceptionCodeEnums.LACK_OF_PARAM.getCode(), errMsg);
		}
//		student.setCreateTime(DateUtils.currTime());
//		student.setUpdateTime(DateUtils.currTime());
		int num = studentMapper.addStudent(student);
		return num;
	}
}
