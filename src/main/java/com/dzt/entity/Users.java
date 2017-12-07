package com.dzt.entity;

import java.io.Serializable;

public class Users implements Serializable {
	private Integer userid;
	private String loginname;
	private String loginpwd;
	private String realname;
	
	public Users() {
		super();
	}
	public Users(String loginname, String loginpwd) {
		super();
		this.loginname = loginname;
		this.loginpwd = loginpwd;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	

}
