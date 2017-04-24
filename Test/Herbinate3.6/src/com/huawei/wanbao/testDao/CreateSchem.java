package com.huawei.wanbao.testDao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateSchem {

	/**
	 * 根据配置生成表结构
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
