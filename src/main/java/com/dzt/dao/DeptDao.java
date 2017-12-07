package com.dzt.dao;

import java.util.List;

import com.dzt.entity.Dept;

public interface DeptDao {
	public Dept selectDeptByDeptno(int deptno);
	public List<Dept> selectAllDept();

}
