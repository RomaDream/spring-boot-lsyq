package org.chenhui.study.springbootstudy.entity.result;

import java.io.Serializable;

public class LoginFail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6684274517333441676L;
	private int code;
	private String msg;
	public LoginFail() {
		super();
	}
	public LoginFail(int code, String msg) {
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
