package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
	static final String driver_name="com.mysql.cj.jdbc.Driver";
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String username="root";
	static final String password="root";
	public static void main(String[] args) throws Exception {
		Connection con=null;
		Statement st=null;
		try {
			//1.load and register the driver
			Class.forName(driver_name);
			//2.establish connection to database.
			con=DriverManager.getConnection(jdbc_url,username,password);
			//3.create statement object
			st= con.createStatement();
			String query="create table if not exists employee("
					+ "eno int auto_increment primary key,"
					+"ename varchar(100),"
					+"esal decimal(10,2),"
					+"eadr varchar(50)"+")";
			//4.send our sql query to the database.
			st.execute(query);
			System.out.println("Table created");
			}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(st!=null) {
				try {
					((Connection) st).close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
