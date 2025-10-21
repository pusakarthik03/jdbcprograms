package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deletewithenduser {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String username="root";
	static final String password="root";

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection(jdbc_url,username,password);
				Statement st= con.createStatement()){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter employee id to delete:");
			int eno=sc.nextInt();
			String delsql="delete from employee where eno="+eno;
			int rowsAffected=st.executeUpdate(delsql);
			if(rowsAffected==1) {
				System.out.println("Records deleted successfully");
			}
			else {
				System.out.println("Record not found");
			}
		}
		catch(SQLException e) { 
			e.printStackTrace();
		}
		

	}

}
