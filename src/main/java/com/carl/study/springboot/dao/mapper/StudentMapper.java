package com.carl.study.springboot.dao.mapper;

import com.carl.study.springboot.bean.Student;

/**
 * @author changez
 * @desc
 * @date 2019/3/10 15:58
 */
public interface StudentMapper {
	int addStudent(Student student);
	Student queryStudentById(Integer id);

	int modifyStudentById(Student student);
}
