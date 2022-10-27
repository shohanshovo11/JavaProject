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
	static void registerLogin(String uname,String pass,String role) throws SQLException
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
				return 0;
			}
		}
		return 1;
	}
	
	
//	public static void main(String[] Args) throws SQLException, ClassNotFoundException
//	{
//		registerLogin("sldfsldjflasjdlfjalskdjflasjlf","root","A");
//	}
	
	
}
