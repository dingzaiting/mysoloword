package com.dzt.dao;

import com.dzt.entity.Users;

public interface UsersDao {
	public int addUser(Users users);
	public Users selectUserByUserid(int userid);
	public Users selectUserByLogin(Users users);

}
