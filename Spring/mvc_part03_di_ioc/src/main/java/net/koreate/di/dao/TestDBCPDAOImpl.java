package net.koreate.di.dao;

import org.springframework.stereotype.Repository;

@Repository("td")
public class TestDBCPDAOImpl implements TestDAO {

	@Override
	public void select(String message) {
		System.out.println(message+" DBCP SELECT" );
	}

}







