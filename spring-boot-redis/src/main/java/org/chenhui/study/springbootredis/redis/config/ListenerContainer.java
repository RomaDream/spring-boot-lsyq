package org.chenhui.study.springbootredis.redis.config;

import org.chenhui.study.springbootredis.redis.message.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class ListenerContainer {
	
	@Autowired
	private Listener listener;
	
	/**
	 * 将RedisMessageListenerContainer注册到springbean
	 * 
	 * @param redisConnectionFactory
	 * @param adapter
	 * @return
	 */
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
			MessageListenerAdapter adapter, MessageListenerAdapter otherAdapter){
		RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
		//配置redis连接信息
		redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
		//订阅一个匹配（支持Ant通配符）message-*的通道
		//这里可以添加多个消息监听
		redisMessageListenerContainer.addMessageListener(adapter, new PatternTopic("message-*"));
		redisMessageListenerContainer.addMessageListener(otherAdapter, new PatternTopic("otherMessage-*"));
		return redisMessageListenerContainer;
	}
	
	/**
	 * 消息侦听器适配器，
	 * 它通过反射将消息处理委托给目标侦听器方法，具有灵活的消息类型转换。
	 * 允许侦听器方法操作消息内容类型，完全独立于Redis API。
	 * 
	 * @return
	 */
	@Bean
	public MessageListenerAdapter adapter(){
		//这里的onMessage必须与listener方法名保持一致
		return new MessageListenerAdapter(listener, "onMessage");
	}
	
	@Bean
	public MessageListenerAdapter otherAdapter(){
		return new MessageListenerAdapter(listener, "otherMessage");
	}
	
	/**
	 * StringRedisTemplate：专注于String操作的RedisTemplate的扩展。
	 * <br/>
	 * 由于针对Redis的大多数操作都是基于字符串的，因此该类提供了一个专用类，可以最小化其更通用模板的配置，尤其是在序列化器方面。
	 * @return
	 */
	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
		return new StringRedisTemplate(redisConnectionFactory);
	}
}
