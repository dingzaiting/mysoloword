package com.dzt.serviceImp;

import org.springframework.stereotype.Service;

import com.dzt.dao.UsersDao;
import com.dzt.entity.Users;
import com.dzt.service.UserService;
@Service
public class UserServiceImp implements UserService {
private UsersDao userDaoImp;


	public UserServiceImp() {
	super();
	System.out.println("public UserServiceImp()........");
}
	
	
	
	public UserServiceImp(UsersDao usersDaoImp) {
		super();
		System.out.println("public UserServiceImp(UsersDao usersDaoImp)........");
		this.userDaoImp = usersDaoImp;
	}



	public UsersDao getUsersDaoImp() {
	return userDaoImp;
}
	public void setUsersDaoImp(UsersDao usersDaoImp) {
	this.userDaoImp = usersDaoImp;
}
	public int addUser(Users users) {
		System.out.println("addUsers....Service");
		int addUser = userDaoImp.addUser(users);
		return addUser;
	}
	public Users selectUserByUserid(int userid) {
		Users users = userDaoImp.selectUserByUserid(userid);
		return users;
	}

	public Users selectUserByLogin(Users users) {
		Users users2 = userDaoImp.selectUserByLogin(users);
		return users2;
	}

}
