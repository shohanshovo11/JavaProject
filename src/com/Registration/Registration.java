package com.Registration;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.Home.HomeAdmin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration {

	public JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel lblNewLabel = new JLabel();


	/**
	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration("Shohan");
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
	public Registration(String adminName) {
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
		///frame
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
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 373, 273, 104);
		lblNewLabel.setText(adminName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		left.add(lblNewLabel);
		
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
		
		JButton feeButton = new JButton("FEE GENERATOR");
		feeButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				feeButton.setCursor(cur);
			}
		});

		///Admin Reg button
		JPanel recoveryPanel = new JPanel();
		recoveryPanel.setLayout(null);
		recoveryPanel.setBackground(new Color(42, 94, 142));
		recoveryPanel.setBounds(571, 383, 377, 195);
		frame.getContentPane().add(recoveryPanel);
		
		JLabel recoveryIcon = new JLabel("");
		recoveryIcon.setBounds(142, 10, 114, 114);
		recoveryPanel.add(recoveryIcon);
		
		JButton recoveryButton = new JButton("ADMIN REGISTRATION");
		recoveryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminRegistration adminRegistration=new AdminRegistration(adminName);
				adminRegistration.frame.setVisible(true);
			}
		});
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
		recoveryButton.setBounds(0, 144, 377, 51);
		recoveryPanel.add(recoveryButton);
		
		ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\recovery.png");
		Image img5 = icon5.getImage();
		Image imgScale5 = img5.getScaledInstance(recoveryIcon.getWidth(), recoveryIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
		recoveryIcon.setIcon(scaledIcon5);
		
		///Student registration
		JPanel recoveryPanel1 = new JPanel();
		recoveryPanel1.setLayout(null);
		recoveryPanel1.setBackground(new Color(42, 94, 142));
		recoveryPanel1.setBounds(571, 110, 377, 195);
		frame.getContentPane().add(recoveryPanel1);
		
		JLabel recoveryIcon1 = new JLabel("");
		recoveryIcon1.setBounds(142, 10, 114, 114);
		recoveryPanel1.add(recoveryIcon1);
		
		JButton recoveryButton1 = new JButton("STUDENT REGISTRATION");
		recoveryButton1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur = new Cursor(Cursor.HAND_CURSOR);
				recoveryButton1.setCursor(cur);
			}
		});
		recoveryButton1.setForeground(new Color(0, 0, 0));
		recoveryButton1.setBackground(new Color(0, 153, 153));
		recoveryButton1.setFont(new Font("Kalpurush", Font.PLAIN, 30));
		recoveryButton1.setFocusPainted(false);
		recoveryButton1.setBounds(0, 144, 377, 51);
		recoveryPanel1.add(recoveryButton1);
		
		ImageIcon icon6 = new ImageIcon("E:\\JavaProject\\img\\recovery.png");
		Image img6 = icon6.getImage();
		Image imgScale6 = img6.getScaledInstance(recoveryIcon1.getWidth(), recoveryIcon1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
		recoveryIcon1.setIcon(scaledIcon6);
		
		
		
	}

}
