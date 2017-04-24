package com.huawei.wanbao.testDao;

import java.util.List;

import com.huawei.wanbao.test.User;

public class QueryResult {

	private int total;
	private List<User> list;
	
	public QueryResult(int total, List<User> list)
	{
		this.total = total;
		this.list = list;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
}
