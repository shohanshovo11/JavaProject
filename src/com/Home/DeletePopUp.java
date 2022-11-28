package com.Home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.login.LoginDB;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeletePopUp {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePopUp window = new DeletePopUp(" ");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeletePopUp(String name) {
		initialize(name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel deleteLabel = new JLabel("DELETE THIS USER?");
		deleteLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteLabel.setBounds(120, 52, 177, 34);
		frame.getContentPane().add(deleteLabel);
		
		JButton yesButton = new JButton("YES");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginDB.deleteUser(name);
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		yesButton.setBounds(117, 117, 85, 39);
		frame.getContentPane().add(yesButton);
		
		JButton noButton = new JButton("NO");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		noButton.setBounds(212, 117, 85, 39);
		frame.getContentPane().add(noButton);
	}

}
