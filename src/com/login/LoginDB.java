package com.login; 
import java.sql.*;
public class LoginDB {
	String login(String uname,String password,String role) throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://localhost:3306/login";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "SELECT * FROM login";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("id").equals(uname) && rs.getString("password").equals(password) && rs.getString("role").equals(role) && role=="A")
			{
				rs.close();
				st.close();
				con.close();
				return uname;
			}
			else if(rs.getString("id").equals(uname) && rs.getString("password").equals(password) && rs.getString("role").equals(role) && role=="S")
			{
				rs.close();
				st.close();
				con.close();
				return uname;
			}
		}
		rs.close();
		st.close();
		con.close();
		return null;
	}
	static void registerStud(String fname,String lname,String Uname,String Pass,int cls,String doa,String phone) throws SQLException
	{
		try {
		String url = "jdbc:mysql://localhost:3306/stud_details";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String role = "S";
		String query = "INSERT INTO stud_details.stud_details values('"+fname+"','"+lname+"','"+Uname+"','"+Pass+"','"+cls+"','"+doa+"','"+role+"','"+phone+"')";
		st.executeUpdate(query);
		registerLogin(Uname,Pass,role);
		System.out.println("Registered new student");
		st.close();
		con.close();
		}
		catch(Exception e){
			System.out.println("Duplicate Username");
		}
		
	}
	public static String getPassword(String username,String phoneNo) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/login";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "select uname,pass,phone from stud_details.stud_details where uname='"+username+"'";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("uname").equals(username) && rs.getString("phone").equals(phoneNo))
			{
				return rs.getString("pass");
			}
		}
		return null;
		
	}
	public static void registerLogin(String uname,String pass,String role) throws SQLException
	{
		String url ="jdbc:mysql://localhost:3306/login";
		String username = "root";
		String passsword = "root";
		Connection con = DriverManager.getConnection(url, username, passsword);
		Statement st = con.createStatement();
		String query = "INSERT INTO login.login values ('"+uname+"','"+pass+"','"+role+"')";
		st.executeUpdate(query);
		
		System.out.println("Login details updated");
		st.close();
		con.close();
				
	}
	public static int due(String tableName) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/bill";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "select due from bill."+tableName;
		ResultSet x = st.executeQuery(query);
		int totalDue = 0;
		while(x.next())
		{
			int temp = Integer.valueOf(x.getString("due"));
			totalDue=totalDue + temp;
		}
		return totalDue;
	}
	public static int paid(String tableName) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/bill";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "select paid from bill."+tableName;
		ResultSet x = st.executeQuery(query);
		int totalDue = 0;
		while(x.next())
		{
			int temp = Integer.valueOf(x.getString("paid"));
			totalDue=totalDue + temp;
		}
		return totalDue;
	}
	public int verifyUsername(String uname) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/login";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "SELECT id FROM login";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("id").equals(uname))
			{
//				System.out.println("gotcha");
				return 1;
			}
		}
		return 0;
	}
	public static void deleteUser(String uname) throws SQLException
	{
		String url ="jdbc:mysql://localhost:3306/login";
		String username = "root";
		String passsword = "root";
		Connection con = DriverManager.getConnection(url, username, passsword);
		Statement st = con.createStatement();
		String query = "delete from login where id='"+uname+"'";
		st.executeUpdate(query);
		
//		System.out.println("Login details updated");
		st.close();
		con.close();
	}
	
	
	public static void main(String[] Args) throws SQLException, ClassNotFoundException
	{
//		registerLogin("sldfsldjflasjdlfjalskdjflasjlf","root","A");
//		paid("class1");
//		deleteUser("aaa");
		System.out.println(LoginDB.getPassword("Hafiz11","016464645"));
	}
	
	
}
