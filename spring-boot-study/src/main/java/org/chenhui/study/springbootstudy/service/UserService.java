package org.chenhui.study.springbootstudy.service;

import org.chenhui.study.springbootstudy.dao.user.UserMapper;
import org.chenhui.study.springbootstudy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户处理业务层
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;
	/**
	 * 根据用户名和密码登录
	 * 
	 * @auth   chenhui
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		User user = null;
		try{
			user = userMapper.login(username, password);
		}catch(Exception e){
			logger.error("根据用户，密码查询用户异常", e);
		}
		return user;
	}
}
