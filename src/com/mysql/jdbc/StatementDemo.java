package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class StatementDemo {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practise","root"," ");
		Statement<?, ?> st=(Statement<?, ?>) con.createStatement();
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter rollno :");
			int rollno=s.nextInt();
			System.out.println("Enter nmae : ");
			String name=s.next();
			System.out.println("Enter Address : ");
			String address=s.next();
			System.out.println("Enter Mobile : ");
			String mobile=s.next();
			
			String sql="insert into student values("+rollno+",\""+name+"\",\""+address+"\",\""+mobile+"\")";
			System.out.println(sql);
			int n=((java.sql.Statement) st).executeUpdate(sql);
			if(n>0)
			{
				System.out.println("data inserted Successfully");
			}
			else
			{
				System.out.println("data is not inserted");
			}
		}
		ResultSet rs= ((java.sql.Statement) st).executeQuery("select * from student");
	  
	   while(rs.next())
	   {
		  System.out.println("Rollno : "+rs.getInt(1)+"Name : "+rs.getString(2)+"Address : "+rs.getString(3)+"Mobile : "+rs.getString(4)); 
	   }
		
	}

}
