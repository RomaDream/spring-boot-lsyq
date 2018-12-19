package org.chenhui.study.springbootredis.redis.message;

import org.springframework.stereotype.Component;

/**
 * 消息监听
 * 
 * @author  chenhui
 * @time    2018年12月19日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@Component
public class Listener {
	
	//自定义一个方法用于接收消息
	public void onMessage(String message) {
		System.out.println("receiver : " + message);
	}

}
