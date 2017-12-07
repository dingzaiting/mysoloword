package com.dzt.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dzt.dao.EmpDao;
import com.dzt.entity.Emp;
import com.dzt.entity.EmpSome;
import com.dzt.factory.MySqlSessionFactory;

public class EmpDaoImp implements EmpDao {

	public Emp selectEmpByEmpno(int empno) {
		SqlSession session=null;
		try {
			session=MySqlSessionFactory.getMySqlSession();
			Emp emp = session.selectOne("com.dzt.entity.Emp.selectEmpByEmpno",empno);
			return emp;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Emp> selectAllEmp() {
		SqlSession session=null;
		try {
			session=MySqlSessionFactory.getMySqlSession();
			List<Emp> emp = session.selectList("com.dzt.entity.Emp.selectAllEmp");
			return emp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Emp> selectAllEmpInfo() {
		SqlSession session=null;
		try {
			session=MySqlSessionFactory.getMySqlSession();
			List<Emp> emp = session.selectList("com.dzt.entity.Emp.selectAllEmpInfo");
			return emp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Emp> selectEmpBySome(EmpSome empSome) {
		SqlSession session=null;
		
		try {
			session=MySqlSessionFactory.getMySqlSession();
			List<Emp> emp = session.selectList("com.dzt.entity.Emp.selectEmpBySome",empSome);
			return emp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
