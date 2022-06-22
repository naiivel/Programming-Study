package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelperTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DBHelper.getConnection();
		System.out.println("연결성공 : " + conn);
		Connection conn2 = DBHelper.getConnection();
		System.out.println("연결성공 : " + conn2);
		
		Statement stmt = conn.createStatement();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM emp");
		ResultSet rs = pstmt.executeQuery();
		
		DBHelper.close(rs, pstmt,stmt,conn);
		//여러번 호출하면 귀찮음
		/*
		DBHelper.close(conn);
		DBHelper.close(rs);
		DBHelper.close(pstmt);
		DBHelper.close(stmt);
		*/
		
	}	
}