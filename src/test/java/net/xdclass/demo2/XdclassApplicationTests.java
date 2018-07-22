package net.xdclass.demo2;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {XdclassApplication.class})
public class XdclassApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("test hello");
		TestCase.assertEquals(1, 0);
	}

	@Before
	public void testBefore(){
		System.out.println("before");
	}
	@After
	public void testAfter(){
		System.out.println("after");
	}
}
