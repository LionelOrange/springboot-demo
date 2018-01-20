package com.cc;

import com.cc.mapper.UserMapper;
import com.cc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {

	}

	@Test
	public void testA(){
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user.getName());
		assertNotNull(user);
	}

	@Test
	@Transactional
	public void testB(){
		User user1=new User();
		user1.setEmail("32");
		user1.setName("3432");
		user1.setPassword("3432");
		user1.setRole("sds");
		user1.setRegip("324");
		user1.setRegtime(new Date());
		user1.setStatus(1);
		int count = userMapper.insert(user1);
		for (int i=0;i<10;i++){
			User user=new User();
			user.setEmail("32");
			user.setName("3432");
			user.setPassword("3432");
			user.setRole("sds");
//			user.setRegip("324");
			user.setRegtime(new Date());
			user.setStatus(1);
			int insert = userMapper.insert(user);
			assertTrue(insert>0);
		}
	}
}
