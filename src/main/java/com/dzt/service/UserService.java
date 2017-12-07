package com.dzt.service;

import com.dzt.entity.Users;
public interface UserService {
	public int addUser(Users users);
	public Users selectUserByUserid(int userid);
	public Users selectUserByLogin(Users users) ;

}
