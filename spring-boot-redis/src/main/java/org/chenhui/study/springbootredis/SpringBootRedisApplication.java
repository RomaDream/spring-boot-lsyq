package org.chenhui.study.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class SpringBootRedisApplication {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}
	
	@Scheduled(fixedDelay = 2000)
	public void sendTask(){
		stringRedisTemplate.convertAndSend("message-test", "this is a message from sendTask");
	}
	
}

