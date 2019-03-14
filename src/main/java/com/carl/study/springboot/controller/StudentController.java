package com.carl.study.springboot.controller;

import com.carl.study.springboot.bean.Student;
import com.carl.study.springboot.dao.mapper.StudentMapper;
import com.carl.study.springboot.service.StudentService;
import com.carl.study.springboot.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changez
 * @desc 学生类控制器
 * @date 2019/3/10 11:13
 */
@RestController
@Lazy
@RequestMapping("/api/student/")
public class StudentController {

	@Value("${student.country.cn}")
	private String countryCN;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentMapper studentMapper;

	@RequestMapping(value = "queryPropertie")
	public void queryPropertie(){
		System.out.println("countryCN="+countryCN);
	}

	@RequestMapping(value = "addStudent")
	public Object addStudent(@RequestBody Student student){

		if ("carl".equals(student.getName())) {
			throw new RuntimeException("未明确定义异常");
		}
		int num = studentService.addStudent(student);
		return  num == 0 ? "student add fail" : "student add success";
	}

	@RequestMapping("queryStudentById")
	public Student queryStudentById(Integer stuId) {

		Student student = studentMapper.queryStudentById(stuId);
		System.out.println(stuId);
		return student;
	}

	@RequestMapping("modifyStudentByIdQuery")
	public String modifyStudentByIdQuery(Student student) {

		Student stu = studentMapper.queryStudentById(student.getId());
		stu.setAddress(student.getAddress());
		int num = studentMapper.modifyStudentById(stu);

		return  num == 0 ? "student add fail" : "student add success";

	}
}
