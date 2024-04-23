package com.mysql.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cllableStatementDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","");
    CallableStatement call=con.prepareCall("call setstdent(?,?,?,?)");
    call.setInt(1,106);
    call.setString(2,"Karan");
    call.setString(3,"Nilanga");
    call.setString(4,"9876545634");
    int n=call.executeUpdate();
    call=con.prepareCall("call getstdent()");
    ResultSet rs=call.executeQuery();
    while(rs.next())
    {
    	System.out.println("ROllNo :"+rs.getInt(1)+"Name : "+rs.getString(2)+"Address : "+rs.getString(3)+"Mobile : "+rs.getString(4));
    }
    	
}
}