package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/9/21
 **/
public class UserServiceImpl implements UserService{
	@Override
	public final String getUserByName(String name) {
//		System.out.println("从数据库中查询到:" + name);
		return name;
	}

}
