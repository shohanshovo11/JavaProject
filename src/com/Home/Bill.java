package com.Home;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.login.LoginDB;

public class Bill {

	JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel lblNewLabel = new JLabel();
	JPanel panel;
	JLabel dueLabel;
	JLabel paidLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill("Shovo");
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
	public Bill(String adminName) {
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
		left.setBounds(0, 0, 293, 683);
		left.setFont(new Font("Eras Demi ITC", Font.PLAIN, 10));
		left.setBackground(new Color(0, 21, 36));
		frame.getContentPane().add(left);
		frameLocation();
		left.setFont(new Font("Eras Demi ITC", Font.PLAIN, 10));
		left.setBackground(new Color(0, 21, 36));
		left.setLayout(null);
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
		lblNewLabel.setBounds(10, 373, 273, 104);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 26));
		lblNewLabel.setText(adminName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		left.add(lblNewLabel);
		
		JButton class1Button = new JButton("Class 1");
		class1Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		class1Button.setBounds(325, 26, 136, 61);
		frame.getContentPane().add(class1Button);
		
		JButton class2Button = new JButton("Class 2");
		class2Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class2Button.setBounds(511, 28, 129, 59);
		frame.getContentPane().add(class2Button);
		
		JButton class3Button = new JButton("Class 3");
		class3Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class3Button.setBounds(693, 26, 129, 61);
		frame.getContentPane().add(class3Button);
		
		JButton class4Button = new JButton("Class 4");
		class4Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class4Button.setBounds(873, 26, 129, 61);
		frame.getContentPane().add(class4Button);
		
		JButton btnNewButton_4 = new JButton("Overall");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(599, 379, 168, 61);
		frame.getContentPane().add(btnNewButton_4);
		
		panel = new JPanel();
		panel.setBackground(new Color(121, 188, 184));
		panel.setVisible(false);
		panel.setBounds(623, 158, 284, 141);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		dueLabel = new JLabel("");
		dueLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dueLabel.setBounds(10, 10, 264, 50);
		panel.add(dueLabel);
		
		JLabel paidLabel = new JLabel("");
		paidLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		paidLabel.setBounds(10, 74, 264, 57);
		panel.add(paidLabel);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int due = LoginDB.due("class1")+LoginDB.due("class2")+LoginDB.due("class3")+LoginDB.due("class4");
					int paid = LoginDB.paid("class1")+LoginDB.paid("class2")+LoginDB.paid("class3")+LoginDB.paid("class4");
					panel.setVisible(true);
					dueLabel.setText("Due : " + due);
					paidLabel.setText("Paid : " + paid);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		class4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				try {
					dueLabel.setText("Due : "+LoginDB.due("class4"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					paidLabel.setText("Paid : "+LoginDB.paid("class4"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		class3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				try {
					dueLabel.setText("Due : "+LoginDB.due("class3"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					paidLabel.setText("Paid : "+LoginDB.paid("class3"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		class2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				try {
					dueLabel.setText("Due : "+LoginDB.due("class2"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					paidLabel.setText("Paid : "+LoginDB.paid("class2"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		clearButton.setBounds(1045, 26, 129, 61);
		frame.getContentPane().add(clearButton);
		class1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				try {
					dueLabel.setText("Due : "+LoginDB.due("class1"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					paidLabel.setText("Paid : "+LoginDB.paid("class1"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeAdmin ha = new HomeAdmin(adminName);
				ha.frame.setVisible(true);
				frame.dispose();
			}
		});
		backButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				backButton.setCursor(cur);
			}
		});
		backButton.setBackground(new Color(0, 21, 36));
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBounds(94, 512, 110, 50);
		left.add(backButton);
		backButton.setFocusable(false);
		backButton.setBorder(null);
		
		
	}
}
