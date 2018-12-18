package org.chenhui.study.springbootstudy.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.chenhui.study.springbootstudy.entity.User;

/**
 * 用户数据访问接口
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM `user` WHERE `NAME` = #{username} AND PWD = #{password}")
	User login(@Param("username")String username, @Param("password")String password);

	@Insert("INSERT INTO `user` (NAME,PWD,EMIAL,HEADIMGPATH,BIRTHDAY,GENDER) VALUES "
			+ "(#{user.name},#{user.pwd},#{user.emial},#{user.headImgPath},#{user.birthday},#{user.gender})")
	void add(@Param("user")User user);
	
	@Select("SELECT * FROM `user` WHERE `ID` = #{userId}")
	User one(@Param("userId") Long userId);
}
