package com.Home;

import java.awt.Dimension;

import com.Registration.Registration;
import com.login.Login1;
import com.Home.Bill;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

public class HomeAdmin {

	public JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel lblNewLabel = new JLabel();
	public final JPanel registerPanel = new JPanel();
	public final JPanel billPanel = new JPanel();
	public final JLabel billIcon = new JLabel("");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin window = new HomeAdmin(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public HomeAdmin(String adminName) {
		initialize(adminName);
	}
	private void initialize(String adminName) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(121, 188, 184));
		frame.getContentPane().setLayout(null);
		left.setFont(new Font("Eras Demi ITC", Font.PLAIN, 10));
		left.setBounds(0, 0, 293, 683);
		left.setBackground(new Color(0, 21, 36));
		frame.getContentPane().add(left);
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
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					Login1 login = new Login1();
					login.Login.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		signOutButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				signOutButton.setCursor(cur);
			}
		});
		signOutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signOutButton.setBorder(null);
		signOutButton.setFocusable(false);
		signOutButton.setBackground(new Color(0, 21, 36));
		signOutButton.setForeground(new Color(255, 255, 255));
		signOutButton.setBounds(95, 516, 108, 44);
		left.add(signOutButton);
		registerPanel.setBackground(new Color(42, 94, 142));
		registerPanel.setBounds(315, 158, 270, 195);
		
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(null);
		
		
		JLabel registerIcon = new JLabel("");
		registerIcon.setBounds(75, 10, 114, 114);
		registerPanel.add(registerIcon);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("E:\\JavaProject\\img\\register.png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(registerIcon.getWidth(), registerIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		registerIcon.setIcon(scaledIcon);
		
		JButton registerButton = new JButton("REG STUDENT");
		registerButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				registerButton.setCursor(cur);
			}
		});
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration regstd = new Registration(adminName);
				frame.dispose();
				regstd.frame.setVisible(true);
				
			}
		});
		registerButton.setFocusPainted(false);
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.setBackground(new Color(0, 153, 153));
		registerButton.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		registerButton.setBounds(-4, 147, 276, 51);
		registerPanel.add(registerButton);
		billPanel.setLayout(null);
		billPanel.setBackground(new Color(42, 94, 142));
		billPanel.setBounds(645, 158, 270, 195);
		
		frame.getContentPane().add(billPanel);
		billIcon.setBounds(75, 10, 114, 114);
		billPanel.add(billIcon);
		ImageIcon icon2 = new ImageIcon("E:\\JavaProject\\img\\status.png");
		Image img2 = icon2.getImage();
		Image imgScale2 = img2.getScaledInstance(billIcon.getWidth(), billIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
		billIcon.setIcon(scaledIcon2);
		
		JButton billButton = new JButton("BILL STATUS");
		billButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bill bill = new Bill(adminName);
				frame.dispose();
				bill.frame.setVisible(true);
			}
		});
		billButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				billButton.setCursor(cur);
			}
		});
		billButton.setForeground(new Color(0, 0, 0));
		billButton.setBackground(new Color(0, 153, 153));
		billButton.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		billButton.setFocusPainted(false);
		billButton.setBounds(0, 144, 276, 51);
		billPanel.add(billButton);
		
		JPanel recordPanel = new JPanel();
		recordPanel.setLayout(null);
		recordPanel.setBackground(new Color(42, 94, 142));
		recordPanel.setBounds(973, 158, 270, 195);
		frame.getContentPane().add(recordPanel);
		
		JLabel recordIcon = new JLabel("");
		recordIcon.setBounds(82, 10, 114, 114);
		ImageIcon icon3 = new ImageIcon("E:\\JavaProject\\img\\record.png");
		Image img3 = icon3.getImage();
		Image imgScale3 = img3.getScaledInstance(recordIcon.getWidth(), recordIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
		recordIcon.setIcon(scaledIcon3);
		
		recordPanel.add(recordIcon);
		
		JButton recordButton = new JButton("RECORDS");
		recordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record record = new Record(adminName);
				record.frame.setVisible(true);
				frame.dispose();
			}
		});
		recordButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				recordButton.setCursor(cur);
			}
		});
		recordButton.setForeground(new Color(0, 0, 0));
		recordButton.setBackground(new Color(0, 153, 153));
		recordButton.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		recordButton.setFocusPainted(false);
		recordButton.setBounds(0, 144, 276, 51);
		recordPanel.add(recordButton);
		
		JPanel feePanel = new JPanel();
		feePanel.setLayout(null);
		feePanel.setBackground(new Color(42, 94, 142));
		feePanel.setBounds(315, 420, 270, 195);
		frame.getContentPane().add(feePanel);
		
		JLabel feeIcon = new JLabel("");
		feeIcon.setBounds(75, 10, 114, 114);
		
		ImageIcon icon4 = new ImageIcon("E:\\JavaProject\\img\\charge.png");
		Image img4 = icon4.getImage();
		Image imgScale4 = img4.getScaledInstance(feeIcon.getWidth(), feeIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
		feeIcon.setIcon(scaledIcon4);
		feePanel.add(feeIcon);
		
		JButton feeButton = new JButton("FEE GENERATOR");
		feeButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				feeButton.setCursor(cur);
			}
		});
		feeButton.setForeground(new Color(0, 0, 0));
		feeButton.setBackground(new Color(0, 153, 153));
		feeButton.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		feeButton.setFocusPainted(false);
		feeButton.setBounds(0, 144, 276, 51);
		feePanel.add(feeButton);
		
		JPanel recoveryPanel = new JPanel();
		recoveryPanel.setLayout(null);
		recoveryPanel.setBackground(new Color(42, 94, 142));
		recoveryPanel.setBounds(646, 420, 270, 195);
		frame.getContentPane().add(recoveryPanel);
		
		JLabel recoveryIcon = new JLabel("");
		recoveryIcon.setBounds(74, 10, 114, 114);
		recoveryPanel.add(recoveryIcon);
		
		JButton recoveryButton = new JButton("RECOVERY");
		recoveryButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				recoveryButton.setCursor(cur);
			}
		});
		recoveryButton.setForeground(new Color(0, 0, 0));
		recoveryButton.setBackground(new Color(0, 153, 153));
		recoveryButton.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		recoveryButton.setFocusPainted(false);
		recoveryButton.setBounds(0, 144, 276, 51);
		recoveryPanel.add(recoveryButton);
		
		ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\recovery.png");
		Image img5 = icon5.getImage();
		Image imgScale5 = img5.getScaledInstance(recoveryIcon.getWidth(), recoveryIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
		recoveryIcon.setIcon(scaledIcon5);
		
		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(null);
		deletePanel.setBackground(new Color(42, 94, 142));
		deletePanel.setBounds(973, 420, 270, 195);
		frame.getContentPane().add(deletePanel);
		
		JLabel deleteIcon = new JLabel("");
		deleteIcon.setBounds(78, 10, 114, 114);
		deletePanel.add(deleteIcon);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete dl = new Delete(adminName);
				dl.frame.setVisible(true);
				frame.dispose();
			}
		});
		deleteButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				deleteButton.setCursor(cur);
			}
		});
		deleteButton.setForeground(new Color(0, 0, 0));
		deleteButton.setBackground(new Color(0, 153, 153));
		deleteButton.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		deleteButton.setFocusPainted(false);
		deleteButton.setBounds(0, 144, 276, 51);
		deletePanel.add(deleteButton);
		
		ImageIcon icon6 = new ImageIcon("E:\\JavaProject\\img\\delete.png");
		Image img6 = icon6.getImage();
		Image imgScale6 = img6.getScaledInstance(deleteIcon.getWidth(), deleteIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
		deleteIcon.setIcon(scaledIcon6);
		
		JLabel mistHeading = new JLabel("MILITARY INSTITUTE OF SCIENCE AND TECHNOLOGY (MIST)");
		mistHeading.setForeground(new Color(0, 0, 0));
		mistHeading.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 42));
		mistHeading.setBounds(315, 46, 933, 58);
		frame.getContentPane().add(mistHeading);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screensize = tk.getScreenSize();
		int screenHeight = screensize.height;
		int screenWidth = screensize.width;
		int frameHeight = frame.getHeight();
		int frameWidth = frame.getWidth();
		frame.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
	}
}
