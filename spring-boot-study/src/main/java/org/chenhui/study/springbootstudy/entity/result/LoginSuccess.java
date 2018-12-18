package org.chenhui.study.springbootstudy.entity.result;

import java.io.Serializable;

/**
 * 登录成功返回数据
 * 
 * @author  chenhui
 * @time    2018年12月13日
 * @e-mail  personalmessage@foxmail.com
 * @company nikey
 */
public class LoginSuccess implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4633292468322546409L;
	private int code;
	private String msg;
	public LoginSuccess() {
		super();
	}
	public LoginSuccess(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
