package com.dzt.daoImp;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dzt.dao.UsersDao;
import com.dzt.entity.Users;

@Repository
public class UsersDaoImp  extends SqlSessionDaoSupport implements UsersDao {

 @Autowired  
	 public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
	          
	        super.setSqlSessionFactory(sqlSessionFactory);  
	    }  
	public int addUser(Users users) {
		int insert = super.getSqlSession().insert("com.dzt.entity.Users.addUser",users);
		return insert;
		
	}

	public Users selectUserByUserid(int userid) {
		Users users = super.getSqlSession().selectOne("com.dzt.entity.Users.selectUserByUserid", userid);
		return users;
	}
	public Users selectUserByLogin(Users users) {
		Users users2 = super.getSqlSession().selectOne("com.dzt.entity.Users.selectUserBylogin", users);
		return users2;
	}
	
	
	
	

}
