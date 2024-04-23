package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Phonebook {

public static void main(String[] args) throws ClassNotFoundException, SQLException {

Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","");


// Statement st=con.createStatement();

Scanner s=new Scanner(System.in);
int a=1;
while(a==1)
{
System.out.println("Choose Your work");
System.out.println("");
System.out.println("1.Contact Save");
System.out.println("");
System.out.println("2.Contact Delect");
System.out.println("");
System.out.println("3.Contact Update");
System.out.println("");
System.out.println("4.Contact Search");
System.out.println(""); 
System.out.println("5.Contact Available Show all");
System.out.println("");
System.out.println("Enter your Choice");
int n1=s.nextInt();
switch(n1)
{
case 1:
System.out.println("You are select save Contact");
System.out.println("Enter rollno");
int rollno=s.nextInt();
System.out.println("");
System.out.println("Enter FristName");
String fristname=s.next();
System.out.println("");
System.out.println("Enter LastName");
String lastname=s.next();
System.out.println("");
System.out.println("Enter Contact");
String contact=s.next();
System.out.println("");
System.out.println("Enter Your Email-Id");
String email=s.next();

Statement st1=con.createStatement();
int n=st1.executeUpdate("insert into phone values("+rollno+",\""+fristname+"\",\""+lastname+"\",\""+contact+"\",\""+email+"\")");

if(n>0)
{
System.out.println("Data Insert Successfull");
}

ResultSet rs=st1.executeQuery("select * from phone");
while(rs.next())
{
System.out.println("rollno= "+rs.getInt(1)+"FristName= "+rs.getString(2)+"LastName= "+rs.getString(3)+"Contact= "+rs.getString(4)+"E-mail="+rs.getString(5));
}
     

break;

case 2:
  {
    System.out.println("Your chauice is Delete Contact ");
System.out.println("");
System.out.println("Your All Contact Save Avalable");
    Statement st10=con.createStatement();
ResultSet rs10=st10.executeQuery("select * from phone");
System.out.println("Your Save All Contact");
while(rs10.next())
{
System.out.println("rollno= "+rs10.getInt(1)+"FristName= "+rs10.getString(2)+"LastName= "+rs10.getString(3)+"Contact= "+rs10.getString(4)+"E-mail="+rs10.getString(5));
}
    System.out.println("Enter Your Delete S.No");
    int d=s.nextInt();
    Statement st2=con.createStatement();
int n3=st2.executeUpdate("delete from phone where  rollno="+d+"");
if(n3>0)
{
System.out.println("no delete"+n3);
}
ResultSet rs1=st2.executeQuery("select * from phone");
while(rs1.next())
{
System.out.println("rollno= "+rs1.getInt(1)+"FristName= "+rs1.getString(2)+"LastName= "+rs1.getString(3)+"Contact= "+rs1.getString(4)+"E-mail="+rs1.getString(5));
}
break;  
 
  }
case 3:
{
System.out.println("You are select Update Contact");
System.out.println("Pleas Enter Update Filed");
System.out.println(" ");
System.out.println("Enter rollno Update");

System.out.println("Enter FristName Update ");

System.out.println("Enter LastName Update");

System.out.println("Enter Contact Update ");

System.out.println("Enter Your Email-Id Update ");

int up=s.nextInt();
switch(up)
{
case 1:
  System.out.println("Your choice is rollno Update");
  System.out.println("Pleas Enter set rollno");
  int roll=s.nextInt();
      System.out.println("please Enter Frist Nmae changing rollno");
      String co=s.next();
//       System.out.println("please Enter Frist Nmae changing rollno");
//       String c=s.next();
//       System.out.println("please Enter fn");
//       String fn=s.next();
  Statement st2=con.createStatement();
  int n4=st2.executeUpdate("update phone set rollno="+roll+" where fristname="+co+"");

if(n4>0)
{
System.out.println("Data Update Successfull");
}

ResultSet rs1=st2.executeQuery("select * from phone");
while(rs1.next())
{
System.out.println("rollno= "+rs1.getInt(1)+"FristName= "+rs1.getString(2)+"LastName= "+rs1.getString(3)+"Contact= "+rs1.getString(4)+"E-mail="+rs1.getString(5));
}
   
break;

case 2:
   System.out.println(" Enter SET FRIST NAME Update location Nmae");
      String co1=s.next();
      System.out.println("please Enter  WHERE ROLLNO");
       int fn=s.nextInt();
  Statement st3=con.createStatement();
  int n5=st3.executeUpdate("update phone set fristname=\""+co1+"\" where rollno="+fn+"");

if(n5>0)
{
System.out.println("Data Upadate Successfull");
}

ResultSet rs2=st3.executeQuery("select * from phone");
while(rs2.next())
{
System.out.println("rollno= "+rs2.getInt(1)+"FristName= "+rs2.getString(2)+"LastName= "+rs2.getString(3)+"Contact= "+rs2.getString(4)+"E-mail="+rs2.getString(5));
}
break;

case 3:
  System.out.println(" Enter SET LAST NAME Update location Nmae");
      String co2=s.next();
      System.out.println("please Enter  WHERE ROLLNO");
       int fn1=s.nextInt();
  Statement st4=con.createStatement();
  int n6=st4.executeUpdate("update phone set lastname="+co2+" where rollno="+fn1+"");

if(n6>0)
{
System.out.println("Data Update Successfull");
}

ResultSet rs3=st4.executeQuery("select * from phone");
while(rs3.next())
{
System.out.println("rollno= "+rs3.getInt(1)+"FristName= "+rs3.getString(2)+"LastName= "+rs3.getString(3)+"Contact= "+rs3.getString(4)+"E-mail="+rs3.getString(5));
}
break;

case 4:
  System.out.println(" Enter SET CONTACT Update location Nmae");
      String co3=s.next();
      System.out.println("please Enter  WHERE ROLLNO");
       int fn2=s.nextInt();
  Statement st5=con.createStatement();
  int n7=st5.executeUpdate("update phone set contact="+co3+" where rollno="+fn2+"");

if(n7>0)
{
System.out.println("Data Update Successfull");
}

ResultSet rs4=st5.executeQuery("select * from phone");
while(rs4.next())
{
System.out.println("rollno= "+rs4.getInt(1)+"FristName= "+rs4.getString(2)+"LastName= "+rs4.getString(3)+"Contact= "+rs4.getString(4)+"E-mail="+rs4.getString(5));
}
case 5:
System.out.println(" Enter SET E-MAIL-Id Update  Nmae");
      String co4=s.next();
      System.out.println("please Enter  WHERE ROLLNO");
       int fn3=s.nextInt();
  Statement st6=con.createStatement();
  int n8=st6.executeUpdate("update phone set email="+co4+" where rollno="+fn3+"");

if(n8>0)
{
System.out.println("Data Update Successfull");
}

ResultSet rs6=st6.executeQuery("select * from phone");
while(rs6.next())
{
System.out.println("");

System.out.println("rollno= "+rs6.getInt(1)+"FristName= "+rs6.getString(2)+"LastName= "+rs6.getString(3)+"Contact= "+rs6.getString(4)+"E-mail="+rs6.getString(5));
}

break;

}

break;
}

case 4:
System.out.println("Please Enter Frist name Frist charecter ");
String ch=s.next();
Statement st7=con.createStatement();

// ResultSet n9=st7.executeQuery(" select from phone where fristname 'a%'");
//
// while(n9>0)
// {
// System.out.println("Data Insert Successfull");
// }

ResultSet rs7=st7.executeQuery("select * from phone where fristname like  a% ");
while(rs7.next())
{
System.out.println("rollno= "+rs7.getInt(1)+"FristName= "+rs7.getString(2)+"LastName= "+rs7.getString(3)+"Contact= "+rs7.getString(4)+"E-mail="+rs7.getString(5));
}


case 5:
Statement st10=con.createStatement();
ResultSet rs10=st10.executeQuery("select * from phone");
System.out.println("Your Save All Contact");
while(rs10.next())
{
System.out.println("rollno= "+rs10.getInt(1)+"FristName= "+rs10.getString(2)+"LastName= "+rs10.getString(3)+"Contact= "+rs10.getString(4)+"E-mail="+rs10.getString(5));
}
break;
}
System.out.println("You Want To Continue Or Not");
System.out.println("if Continue then press 1 ");
System.out.println("if You Stop then Press 0");
a=s.nextInt();
}
}

}


