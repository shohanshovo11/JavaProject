package com.login; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginDB {
	static String url = "jdbc:mysql://localhost:3306/login";
	static String un = "root";
	static String pass = "root";
	int login(String uname,String password,String role) throws ClassNotFoundException, SQLException
	{
		///1 means admin
		///2 means student
		///0 means wrong
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "SELECT * FROM login";
		ResultSet rs = st.executeQuery(query);
//		System.out.println("x");
		while(rs.next())
		{
//			System.out.println(rs.getString("id")+"\t"+rs.getString("password")+"\t"+rs.getString("role"));
			if(rs.getString("id").equals(uname) && rs.getString("password").equals(password) && rs.getString("role").equals(role) && role=="A")
			{
//				System.out.println("Admin login Successful");
				rs.close();
				st.close();
				con.close();
				return 1;
			}
			else if(rs.getString("id").equals(uname) && rs.getString("password").equals(password) && rs.getString("role").equals(role) && role=="S")
			{
//				System.out.println("Student login successful");
				rs.close();
				st.close();
				con.close();
				return 2;
			}
		}
		rs.close();
		st.close();
		con.close();
		return 0;
	}
	
//	public static void main(String[] Args) throws SQLException, ClassNotFoundException
//	{
//		login("shohanshovo17","root","S");
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection(url,un,pass);
//		Statement st = con.createStatement();
//		String query = "SELECT * FROM login";
//		ResultSet rs = st.executeQuery(query);
//		while(rs.next())
//		{
//			System.out.println(rs.getString("id")+"\t"+rs.getString("password")+"\t"+rs.getString("role"));
//		}
//		rs.close();
//		st.close();
//		con.close();
//	}
	
	
}
