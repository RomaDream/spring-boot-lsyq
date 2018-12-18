package org.chenhui.study.springbootstudy.service;

import java.io.File;
import java.io.IOException;

import org.chenhui.study.springbootstudy.dao.user.UserMapper;
import org.chenhui.study.springbootstudy.entity.User;
import org.chenhui.study.springbootstudy.util.FileNameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户注册业务层
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@Service
public class RegisterServer {
	private static final Logger logger = LoggerFactory.getLogger(RegisterServer.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@Value("${file.access.url}")
	private String accessUrl;
	
	/**
	 * 用户注册实现
	 * 
	 * @auth   chenhui
	 * @param user
	 * @param file
	 * @return
	 */
	public boolean register(User user, MultipartFile file) {
		boolean b_register = true;
		String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
		user.setHeadImgPath(accessUrl + fileName);
		File dest = new File(uploadPath + fileName);
		if(!dest.exists()){
			try {
				dest.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return b_register = false;
			}
		}
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return b_register = false;
		}
		try{
			userMapper.add(user);
		}catch(Exception e){
			logger.error("注册失败", e);
			return b_register = false;
		}
		return b_register;
	}
	
}
