package com.yc.ums.util;

import java.io.IOException;
import java.io.InputStream;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{
		//加载mybatis框架的配置文件
		InputStream in=null;
		try {
			in = Resources.getResourceAsStream("mybatis.xml");
			
			//通过配置文件数据流创建SqlSessionFactory对象
			factory=new SqlSessionFactoryBuilder().build(in);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	//获得带事务的SqlSession对象
	public static SqlSession getSession(){
		//return factory.openSession();
		
		
		return factory.openSession(true);//自动事务提交
	}
	//获得自动事务的SqlSession对象
	public static SqlSession getAutoTransSession(){
		//return factory.openSession();
	
		return factory.openSession();//自动事务提交
	}
	public static void close(SqlSession session){
		if(session!=null){
			session.close();
			
		}
	}

}
