package org.chenhui.study.springbootstudy;

import java.util.Date;

import org.chenhui.study.springbootstudy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStudyApplicationTests {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void contextLoads() {
		
	}

	@Test
	public void redisTest(){
		User user = new User(1l, "张三", "xxxx", "xoo@qq.com", "d:/xx/xx.jpg", new Date(), '男');
		redisTemplate.opsForValue().set("key1", "value1");
		redisTemplate.opsForValue().set("user", user);
		User user1 = (User)redisTemplate.opsForValue().get("user");
		System.out.println(user1);
	}
}

