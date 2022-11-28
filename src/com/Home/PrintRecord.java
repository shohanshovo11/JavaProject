package com.Home;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.protocol.Resultset;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrintRecord {

	JFrame frame;
	JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintRecord window = new PrintRecord("class1");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrintRecord(String s) {
		initialize(s);
	}

	private void initialize(String s){
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View Record");
		btnNewButton.setBounds(10, 10, 122, 44);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 766, 435);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1.setBounds(144, 10, 122, 44);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/bill";
					String un = "root";
					String pass = "root";
					try {
						Connection con = DriverManager.getConnection(url,un,pass);
						Statement st = con.createStatement();
						String query = "select * from " + s;
						ResultSet rs =st.executeQuery(query);
						ResultSetMetaData rsmd = rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int cols = rsmd.getColumnCount();
						String[] colName = new String[cols];
						for(int i=0;i<cols;i++)
						{
							colName[i]=rsmd.getColumnName(i+1);
							model.setColumnIdentifiers(colName);
						}
						String userName,due,paid;
						while(rs.next())
						{
							userName = rs.getString(1);
							due = rs.getString(2);
							paid = rs.getString(3);
							String[] row = {userName,due,paid};
							model.addRow(row);
							
						}
						st.close();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
	}
}
