package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updatemultiple {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String username="root";
	static final String password="root";

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection(jdbc_url,username,password);
				Statement st= con.createStatement()){
			Scanner sc=new Scanner(System.in);
			System.out.println("enter number of records to update:");
			int n =sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("enter employee id to update for record"+(i+1));
				int eno=sc.nextInt();
				System.out.println("enter new address");
				String eadr=sc.next();
				
				String updatesql="update employee set eadr='"+eadr+"' where eno= "+eno;
				int rowsAffected=st.executeUpdate(updatesql);
				if(rowsAffected==1) {
					System.out.println("Records updated successfully");
				}
				else {
					System.out.println("Record not found");
				}
				
			}
		}
		catch(SQLException e) { 
			e.printStackTrace();
		}
		

	}

}
