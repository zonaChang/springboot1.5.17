package test.lombok;

import com.carl.study.springboot.bean.Student;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author changez
 * @desc Java反射获取类的所有属性.
 * @date 2019/3/10 11:41
 */
public class LombokTest {

	@Test
	public void getParentField(){
		Student stu1 = new Student();
		stu1.setName("student-name")
			.setAddress("student1-address")
			.setId(1)
		;

		Class clazz = Student.class;
		List<Field> allFields = new ArrayList<>(100);

		// 获取当前对象的所有属性字段
		// clazz.getFields()：获取public修饰的字段
		// clazz.getDeclaredFields()： 获取所有的字段包括private修饰的字段
		allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));

		// 获取所有父类的字段， 父类中的字段需要逐级获取
		Class clazzSuper = clazz.getSuperclass();

		// 如果父类不是object，表明其继承的有其他类。 逐级获取所有父类的字段
		while (clazzSuper != Object.class) {
			allFields.addAll(Arrays.asList(clazzSuper.getDeclaredFields()));
			clazzSuper = clazzSuper.getSuperclass();
		}

		allFields.stream().forEach(field -> {

			// 设置字段可访问， 否则无法访问private修饰的变量值
			field.setAccessible(true);
			try {
				// 获取字段名称
				String fieldName = field.getName();

				// 获取指定对象的当前字段的值
				Object fieldVal = field.get(stu1);
				System.out.println(fieldName+"="+fieldVal);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}
}
