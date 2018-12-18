package org.chenhui.study.springbootstudy.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户实体对象
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4512940227916024539L;
	/*
	 * 		ID       	bigint(20) NOT NULL主键，用户唯一标识
			NAME     	varchar(767) NOT NULL用户名
			PWD      	varchar(1024) NOT NULL密码
			EMIAL		varchar(1024) NOT NULL邮箱地址
			HEADIMGPATH varchar(1024) NOT NULL用户头像
			BIRTHDAY	date NOT NULL生日
			GENDER		char(1) NOT NULL性别
	 */
	private Long id;
	private String name;
	private String pwd;
	private String emial;
	private String headImgPath;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Character gender;
	public User() {
		super();
	}
	public User(Long id, String name, String pwd, String emial,
			String headImgPath, Date birthday, Character gender) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.emial = emial;
		this.headImgPath = headImgPath;
		this.birthday = birthday;
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getHeadImgPath() {
		return headImgPath;
	}
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", emial=" + emial + ", headImgPath=" + headImgPath
				+ ", birthday=" + birthday + ", gender=" + gender + "]";
	}
}
