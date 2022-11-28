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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;

import com.Home.HomeAdmin;
import com.login.LoginDB;

import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import javax.swing.JProgressBar;

public class AdminRegistration {
	public JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel lblNewLabel = new JLabel();
	private JTextField usernameField;
	private JPasswordField passwordField;
	private int verifiedsign;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistration window = new AdminRegistration("Shohan");
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
	public AdminRegistration(String adminName) {
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
		///Frame
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(121, 188, 184));
		panel.setBounds(500, 77, 520, 535);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel verified = new JLabel("");
		verified.setBounds(470, 129, 37, 34);
		panel.add(verified);
		
		
		usernameField = new JTextField();
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keytyped = e.getKeyCode();
				if(keytyped == KeyEvent.VK_ENTER)
				{
					LoginDB login = new LoginDB();
					String choosenUname = null;
					choosenUname = usernameField.getText();
//					System.out.println(choosenUname);
					try {
						verifiedsign = login.verifyUsername(choosenUname);
						/// 1 means accepted and 0 means rejected
						if(verifiedsign==0)
						{
							ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\checked.png");
							Image img5 = icon5.getImage();
							Image imgScale5 = img5.getScaledInstance(verified.getWidth(), verified.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
							verified.setIcon(scaledIcon5);
							
						}
						else
						{
							ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\rejected.png");
							Image img5 = icon5.getImage();
							Image imgScale5 = img5.getScaledInstance(verified.getWidth(), verified.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
							verified.setIcon(scaledIcon5);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		usernameField.setText(null);
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoginDB login = new LoginDB();
				String choosenUname = null;
				choosenUname = usernameField.getText();
//				System.out.println(choosenUname);
				try {
					verifiedsign = login.verifyUsername(choosenUname);
					/// 1 means accepted and 0 means rejected
					if(verifiedsign==0)
					{
						ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\checked.png");
						Image img5 = icon5.getImage();
						Image imgScale5 = img5.getScaledInstance(verified.getWidth(), verified.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
						verified.setIcon(scaledIcon5);
						
					}
					else
					{
						ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\rejected.png");
						Image img5 = icon5.getImage();
						Image imgScale5 = img5.getScaledInstance(verified.getWidth(), verified.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
						verified.setIcon(scaledIcon5);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameField.setBounds(59, 119, 401, 55);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(59, 246, 401, 55);
		panel.add(passwordField);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Pressed");
				try {
//					System.out.println(passwordField.getText());
					int x = JOptionPane.showConfirmDialog(frame, "Sure?");
//					System.out.println(x);
					if(x==0 && verifiedsign==1)
					{
						LoginDB.registerLogin(usernameField.getText(),passwordField.getText(),"A");						
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Try Again");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setBounds(59, 372, 401, 55);
		submitButton.setBorder(null);
		submitButton.setFocusable(false);
		panel.add(submitButton);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameLabel.setBounds(59, 77, 104, 42);
		panel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(59, 204, 104, 42);
		panel.add(passwordLabel);
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration r = new Registration(adminName);
				r.frame.setVisible(true);
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
		
		JCheckBox viewBox = new JCheckBox("View");
		viewBox.setFocusable(false);
		viewBox.setBackground(new Color(121, 188, 184));
		viewBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(viewBox.isSelected()==true)
				{
					passwordField.setEchoChar((char)0);
				}
				else
				{
					passwordField.setEchoChar('●');
				}
			}
		});
		viewBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		viewBox.setBounds(461, 251, 110, 42);
		panel.add(viewBox);
		
		
		///
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
