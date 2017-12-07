package com.dzt.dao;

import java.util.List;

import com.dzt.entity.Emp;
import com.dzt.entity.EmpSome;

public interface EmpDao {
	public Emp selectEmpByEmpno(int empno);
	public List<Emp> selectAllEmp();
	public List<Emp> selectAllEmpInfo();
	public List<Emp> selectEmpBySome(EmpSome empSome);
	

}
