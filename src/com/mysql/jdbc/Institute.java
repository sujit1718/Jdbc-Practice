package com.mysql.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Institute {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","");
		
		Scanner s=new Scanner(System.in);
		int a=1;
		int n;
		int refees = 0;
		while(a==1)
		{
		System.out.println("");
		System.out.println("1. Teachers ");
		System.out.println("");
		int n1=s.nextInt();
		switch(n1)
		{
		
		case 1:
			System.out.println("Enter Student ROllno : ");
			int rollno=s.nextInt();
			System.out.println("Enter Student Name : ");
		    String name=s.next();
		    System.out.println("Enter Subject calss : ");
		    String sub=s.next();
			System.out.println("Student Total Fees : 17,000");
			int totalfees=17000;
			System.out.println("Payable Fees : ");
			int payable=s.nextInt();
			if(payable==17000)
			{
				System.out.println("Payment Successful....!!!!!");
			}
			else
			{
				refees=17000-payable;
				System.out.println("Remaining Fess : "+refees);
			}
			
			
			Statement st=con.createStatement();
			n=st.executeUpdate("insert into institute values("+rollno+",\""+name+"\",\""+sub+"\",\""+totalfees+"\",\""+payable+"\",\""+refees+"\")");
			
			ResultSet rs1=st.executeQuery("select * from institute");
			while(rs1.next())
			{
			System.out.println("Rollno = "+rs1.getInt(1)+"Name = "+rs1.getString(2)+"Subject = "+rs1.getString(3)+"Totalfees = "+rs1.getInt(4)+"Payable = "+rs1.getInt(5)+"Remainingfees = "+rs1.getInt(6));
			}
         break;
			
		
			
		}
	

	}
}
}
