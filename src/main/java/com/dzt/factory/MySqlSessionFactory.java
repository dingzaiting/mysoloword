package com.dzt.factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	private static String resource="mybatis_cfg.xml";
	private static Reader reader=null;
	private static SqlSessionFactoryBuilder builder=null;
	private static SqlSessionFactory factory=null;
	//可以在同一线程范围内共享同一对象
	private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
	
	static {
		try {
			reader=Resources.getResourceAsReader(resource);
			builder=new SqlSessionFactoryBuilder();
			factory= builder.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void rebuildfactory(){
		try {
			reader=Resources.getResourceAsReader(resource);
			builder=new SqlSessionFactoryBuilder();
			factory= builder.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public static SqlSession getMySqlSession(){
		
		SqlSession session=threadLocal.get();
		if (session==null) {
			if (factory==null) {
				rebuildfactory();
			}
			session=factory.openSession();
		}
		
		threadLocal.set(session);
		return session;
	}
	
	public static void closeSession(){
		SqlSession session = threadLocal.get();
		if (session!=null) {
			session.close();	
		}
		threadLocal.set(null);
	}
	
	
	

}
