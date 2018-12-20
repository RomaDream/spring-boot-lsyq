package org.chenhui.study.springbootredis;

import org.chenhui.study.springbootredis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	private StringRedisTemplate StringRedisTemplate;
	
	@Test
	public void contextLoads() {
		User user = new User(2l, "张san");
		redisTemplate.opsForValue().set("user", user);
		User user1 = (User) redisTemplate.opsForValue().get("user");
		System.out.println(user1);
	}

	@Test
	public void pubMessage(){
		//我们向管道（或者说频道）message-test发布一条消息
		StringRedisTemplate.convertAndSend("message-test", "this is a message from message-test");
	}
	
	@Test
	public void pubMessages(){
		StringRedisTemplate.convertAndSend("otherMessage-test", "this is a message from otherMessage-test");
	}
}

