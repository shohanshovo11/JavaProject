package com.login;
//import com.login.LoginDB;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import javax.swing.UIManager;

import com.Home.HomeAdmin;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login1 {

	public JFrame Login;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	static int homeChoose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 window = new Login1();
					window.Login.setVisible(true);
					if(homeChoose == 1)
					{
						///Admin
					}
					else if(homeChoose == 2 )
					{
						////Stud
						
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Login1() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException, SQLException
	{
		Login = new JFrame();
		Login.getContentPane().setBackground(new Color(51, 51, 102));
		Login.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(122, 456, 231, 45);
		Login.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				String role = null;
				while(bg.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if(jrd.isSelected())
					{
						role = jrd.getToolTipText();
					}
				}
				String un = usernameField.getText();
				String pass = passwordField.getText();
				LoginDB ld = new LoginDB();
				try {
					String login2 = ld.login(un, pass, role);
					if(login2==null)
					{
						System.out.println("Username or Password not found.");
						homeChoose = 0 ;
					}
					if(login2!=null && role=="A")
					{
						System.out.println("Admin Logged in");
						
						Login.dispose();
						
						HomeAdmin homeAdmin = new HomeAdmin(un);
						homeAdmin.frame.setVisible(true);
						
						homeChoose = 1 ;
					}
					if(login2!=null && role=="S")
					{
						System.out.println("Student Logged in");
						homeChoose = 2 ;
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		loginButton.setBounds(0, 0, 231, 45);
		panel_2.add(loginButton);
		loginButton.setBorder(null);
		loginButton.setBackground(new Color(102, 153, 204));
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setBackground(new Color(51,51,102));
		panel_3.setBounds(122, 391, 231, 45);
		Login.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton studentRadio = new JRadioButton("Student");
		studentRadio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					Enumeration<AbstractButton> bg = buttonGroup.getElements();
					String role = null;
					while(bg.hasMoreElements())
					{
						JRadioButton jrd = (JRadioButton) bg.nextElement();
						if(jrd.isSelected())
						{
							role = jrd.getToolTipText();
						}
					}
					String un = usernameField.getText();
					String pass = passwordField.getText();
					LoginDB ld = new LoginDB();
					try {
						@SuppressWarnings("unused")
						String login2 = ld.login(un, pass, role);
						if(login2==null)
						{
							System.out.println("Username or Password not found.");
							homeChoose = 0 ;
						}
						if(login2!=null && role=="A")
						{
							Login.dispose();
							System.out.println("Admin Logged in");
							
							HomeAdmin homeAdmin = new HomeAdmin(un);
							homeAdmin.frame.setVisible(true);
							homeChoose = 1 ;
						}
						if(login2!=null && role=="S")
						{
							System.out.println("Student Logged in");
							homeChoose = 2 ;
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		studentRadio.setToolTipText("S");
		studentRadio.setAlignmentY(Component.TOP_ALIGNMENT);
		studentRadio.setForeground(new Color(0, 255, 255));
		studentRadio.setFont(new Font("Monospaced", Font.PLAIN, 14));
		studentRadio.setBackground(new Color(51, 51, 102));
		buttonGroup.add(studentRadio);
		studentRadio.setBounds(122, 6, 103, 33);
		panel_3.add(studentRadio);
		
		JRadioButton adminRadio = new JRadioButton("Admin");
		adminRadio.setToolTipText("A");
		adminRadio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					Enumeration<AbstractButton> bg = buttonGroup.getElements();
					String role = null;
					while(bg.hasMoreElements())
					{
						JRadioButton jrd = (JRadioButton) bg.nextElement();
						if(jrd.isSelected())
						{
							role = jrd.getToolTipText();
						}
					}
					String un = usernameField.getText();
					String pass = passwordField.getText();
					LoginDB ld = new LoginDB();
					try {
						@SuppressWarnings("unused")
						String login2 = ld.login(un, pass, role);
						if(login2==null)
						{
							System.out.println("Username or Password not found.");
							homeChoose = 0 ;
						}
						if(login2!=null && role=="A")
						{
							System.out.println("Admin Logged in");
							Login.dispose();
//							System.out.println("Admin Logged in");
							
							HomeAdmin homeAdmin = new HomeAdmin(un);
							homeAdmin.frame.setVisible(true);
							homeChoose = 1 ;
						}
						if(login2!=null && role=="S")
						{
							System.out.println("Student Logged in");
							homeChoose = 2 ;
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
//		rdbtnNewRadioButton.setBorder(1);
		adminRadio.setAlignmentY(Component.TOP_ALIGNMENT);
		adminRadio.setForeground(new Color(0, 255, 255));
		adminRadio.setFont(new Font("Monospaced", Font.PLAIN, 14));
		adminRadio.setBackground(new Color(51, 51, 102));
		buttonGroup.add(adminRadio);
		adminRadio.setBounds(6, 6, 103, 33);
		panel_3.add(adminRadio);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(122, 257, 231, 45);
		Login.getContentPane().add(panel);
		panel.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					passwordField.requestFocus();
				}
			}
		});
		usernameField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		usernameField.setBackground(new Color(240,240,240));
//		txtUsername.setBackground(Color.);
		usernameField.setBounds(10, 10, 211, 25);
		panel.add(usernameField);
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String txt = usernameField.getText();
				if(txt.equals("Username"))
				{
					usernameField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(usernameField.getText().equals(""))
				{
					usernameField.setText("Username");
				}
			}
		});
		usernameField.setBorder(null);
		usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);
		usernameField.setAlignmentY(Component.TOP_ALIGNMENT);
		usernameField.setText("Username");
		usernameField.setToolTipText("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(122, 324, 231, 45);
		Login.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		passwordField =  new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					adminRadio.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					usernameField.requestFocus();
				}
			}
		});
		passwordField.setBounds(10, 10, 211, 25);
		panel_1.add(passwordField);
		passwordField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		passwordField.setBackground(new Color(240, 240, 240));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals("Password")) {
					passwordField.setText("");					
					passwordField.setEchoChar('●');
				}
				else {
					passwordField.selectAll();
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals(""))
				{
					passwordField.setText("Password");
					passwordField.setEchoChar((char)0);
				}
			}
		});
		passwordField.setBorder(null);
		passwordField.setEchoChar((char)0);
		passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
		passwordField.setAlignmentY(Component.TOP_ALIGNMENT);
		passwordField.setText("Password");
		
		
		
		
		ImageIcon img = new ImageIcon("E:\\JavaProject\\rsrc\\Logo.png");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(229, 170, Image.SCALE_SMOOTH);
		img = new ImageIcon(new_img);
		
		JLabel iconLabel = new JLabel("" , img , JLabel.CENTER);
		iconLabel.setBounds(66, 38, 327, 196);
		Login.getContentPane().add(iconLabel);
		
		JLabel headerLabel = new JLabel("Fees Management System");
		headerLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));
		headerLabel.setForeground(new Color(255, 204, 0));
		headerLabel.setBounds(38, 10, 428, 45);
		Login.getContentPane().add(headerLabel);
		
		Login.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		Login.setForeground(new Color(51, 102, 102));
		Login.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JavaProject\\rsrc\\loginIcon.png"));
		Login.setTitle("Login");
		Login.setBackground(new Color(51, 102, 204));
		Login.setBounds(100, 100, 490, 634);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screensize = tk.getScreenSize();
		int screenHeight = screensize.height;
		int screenWidth = screensize.width;
		int frameHeight = Login.getHeight();
		int frameWidth = Login.getWidth();
		Login.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
		
		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
