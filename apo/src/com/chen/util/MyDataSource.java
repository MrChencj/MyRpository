package com.chen.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSource {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return cpds;
	}
}
