package com.Home;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.login.LoginDB;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Recovery {

	private JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel nameLabel = new JLabel();
	private JTextField nameField;
	private JTextField phoneNoField;
	private static JDialog d; 

	/**
	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recovery window = new Recovery("Shohan");
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
	public Recovery(String adminName) {
		initialize(adminName);
	}
	
	void frameLocation()
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screensize = tk.getScreenSize();
		int screenHeight = screensize.height;
		int screenWidth = screensize.width;
		int frameHeight = frame.getHeight();
		int frameWidth = frame.getWidth();
		frame.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String adminName) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1280, 720);
		frame.getContentPane().setBackground(new Color(121, 188, 184));
		frame.getContentPane().setLayout(null);
		left.setFont(new Font("Eras Demi ITC", Font.PLAIN, 10));
		left.setBounds(0, 0, 293, 683);
		left.setBackground(new Color(0, 21, 36));
		frame.getContentPane().add(left);
		left.setLayout(null);
		frameLocation();
		left.setFont(new Font("Eras Demi ITC", Font.PLAIN, 10));
		left.setBounds(0, 0, 293, 683);
		left.setBackground(new Color(0, 21, 36));
		left.setLayout(null);
		JLabel adminImage = new JLabel("");
		adminImage.setBounds(63, 158, 178, 217);
		left.add(adminImage);
		adminImage.setInheritsPopupMenu(false);
		adminImage.setIconTextGap(0);
		adminImage.setMinimumSize(new Dimension(187, 187));
		adminImage.setMaximumSize(new Dimension(187, 187));
		adminImage.setIcon(new ImageIcon("E:\\admin.png"));
		adminImage.setAlignmentY(Component.TOP_ALIGNMENT);
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setFont(new Font("Cooper Black", Font.PLAIN, 26));
		nameLabel.setBounds(10, 373, 273, 104);
		nameLabel.setText(adminName);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setVerticalAlignment(SwingConstants.CENTER);
		left.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(583, 163, 584, 39);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME :");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(447, 161, 126, 39);
		frame.getContentPane().add(usernameLabel);
		
		phoneNoField = new JTextField();
		phoneNoField.setBounds(583, 245, 287, 39);
		frame.getContentPane().add(phoneNoField);
		phoneNoField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("PHONE :");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneLabel.setBounds(447, 247, 77, 31);
		frame.getContentPane().add(phoneLabel);
		
		JLabel passLabel = new JLabel("");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passLabel.setBounds(598, 396, 377, 83);
		frame.getContentPane().add(passLabel);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = nameField.getText();
				String phoneNo = phoneNoField.getText();
				String pass = null;
				try {
					pass = LoginDB.getPassword(username, phoneNo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(pass!=null)
				{
					passLabel.setText("YOUR PASSWORD IS : "+pass);
				}
				
			}
		});
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submitButton.setBounds(992, 404, 126, 39);
		frame.getContentPane().add(submitButton);
		
		
		
		
	}
}
