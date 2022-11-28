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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class Record {
	JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel lblNewLabel = new JLabel();

//	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record window = new Record("ss");
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
	public Record(String adminName) {
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
		left.setLayout(null);
		frameLocation();
		left.setFont(new Font("Eras Demi ITC", Font.PLAIN, 10));
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
		
		JButton class1Button = new JButton("Class 1");
		class1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintRecord printRecord = new PrintRecord("class1");
				printRecord.frame.setVisible(true);
				
			}
		});
		class1Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class1Button.setBounds(344, 64, 109, 50);
		frame.getContentPane().add(class1Button);
		
		JButton class2Button = new JButton("Class 2");
		class2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintRecord printRecord = new PrintRecord("class2");
				printRecord.frame.setVisible(true);
			}
		});
		class2Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class2Button.setBounds(500, 64, 107, 49);
		frame.getContentPane().add(class2Button);
		
		JButton class3Button = new JButton("Class 3");
		class3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintRecord printRecord = new PrintRecord("class3");
				printRecord.frame.setVisible(true);
			}
		});
		class3Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class3Button.setBounds(652, 63, 111, 47);
		frame.getContentPane().add(class3Button);
		
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
		
		JButton class4Button = new JButton("Class 4");
		class4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintRecord printRecord = new PrintRecord("class4");
				printRecord.frame.setVisible(true);
			}
		});
		class4Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		class4Button.setBounds(798, 64, 118, 46);
		frame.getContentPane().add(class4Button);
		
		
	}
}
