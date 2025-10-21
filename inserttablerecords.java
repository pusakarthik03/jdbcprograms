package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class inserttablerecords {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String username="root";
	static final String password="root";

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection(jdbc_url,username,password);
			Statement st= con.createStatement()){
			Scanner sc=new Scanner(System.in);
			System.out.println("entr no of records to insert");
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("entr details for record:"+(i+1));
			
			System.out.println("entr employee id");
			int eno=sc.nextInt();
			System.out.println("entr employee name");
			String ename=sc.next();
			System.out.println("entr employee salary");
			double esal=sc.nextDouble();
			System.out.println("entr employee address");
			String eadr=sc.next();
			String inssql="insert into employee(eno,ename,esal,eadr)"
					+"values("+ eno+ ",'"+ ename+ "',"+esal+",'"+ eadr +"')";
			int rowsAffected=st.executeUpdate(inssql);
			if(rowsAffected==1) {
				System.out.println("records"+(i+1)+" inserted successfully");
			}
			else {
				System.out.println("failed to insert record");
			}	
		}
		}
		catch(SQLException e) { 
			e.printStackTrace();
		}
		

	}

}
