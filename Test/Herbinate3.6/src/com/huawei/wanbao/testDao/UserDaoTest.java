package com.huawei.wanbao.testDao;

import com.huawei.wanbao.test.User;

public class UserDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao dto = new UserDao();
		/*System.out.println(dto.findAll());
		System.out.println(dto.findAll(0,2));
		System.out.println(dto.getById(2));
		User user = dto.getById(1);
		user.setName("wanbao");
		dto.update(user);
		//user.setName();
		dto.delete(1);*/
		
		System.out.println(dto.getByIdCriteria(2));
		System.out.println();
	}

}
