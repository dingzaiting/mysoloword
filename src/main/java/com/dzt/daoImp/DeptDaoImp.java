package com.dzt.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dzt.dao.DeptDao;
import com.dzt.entity.Dept;
import com.dzt.factory.MySqlSessionFactory;

public class DeptDaoImp implements DeptDao {

	public Dept selectDeptByDeptno(int deptno) {
		SqlSession session=null;
		try {
			session=MySqlSessionFactory.getMySqlSession();
			Dept dept = session.selectOne("com.dzt.entity.Dept.selectDeptByDeptno", deptno);
			return dept;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Dept> selectAllDept() {
		SqlSession session=null;
		try {
			session=MySqlSessionFactory.getMySqlSession();
			List<Dept> list = session.selectList("com.dzt.entity.Dept.selectAllDept");
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		return null;
	}

}
