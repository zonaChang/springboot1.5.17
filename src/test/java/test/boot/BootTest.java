package test.boot;

import com.carl.study.springboot.asynch.SendMessageAsynch;
import com.carl.study.springboot.config.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author changez
 * @desc
 * @date 2019/3/13 15:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class BootTest {

	@Autowired
	private SendMessageAsynch sendMessageAsynch;

	@Test
	public void asyncTest(){

		for (int i = 0; i < 10; i++) {
			System.out.println("loop-" + i);
			sendMessageAsynch.sendMessage();
		}
	}
}
