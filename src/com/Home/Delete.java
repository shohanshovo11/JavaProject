package com.Home;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.login.LoginDB;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;

public class Delete {

	public JFrame frame;
	public final JPanel left = new JPanel();
	public final JLabel lblNewLabel = new JLabel();
	private JTextField usernameField;
	private int verifiedsign;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete("");
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
	public Delete(String adminName) {
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
		
		JButton backButton = new JButton("BACK");
		backButton.setBounds(94, 512, 110, 50);
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
		left.add(backButton);
		backButton.setFocusable(false);
		backButton.setBorder(null);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JLabel verified = new JLabel("");
		verified.setBounds(1065, 57, 37, 34);
		frame.getContentPane().add(verified);

		usernameField.setBounds(506, 57, 444, 35);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SEARCH USER : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(367, 57, 141, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDB login = new LoginDB();
				String choosenUname = null;
				choosenUname = usernameField.getText();
				System.out.println(choosenUname);
				try {
					verifiedsign = login.verifyUsername(choosenUname);
					System.out.println(verifiedsign);
					if(verifiedsign==1)
					{
						ImageIcon icon5 = new ImageIcon("E:\\JavaProject\\img\\checked.png");
						Image img5 = icon5.getImage();
						Image imgScale5 = img5.getScaledInstance(verified.getWidth(), verified.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
						verified.setIcon(scaledIcon5);
						DeletePopUp dp = new DeletePopUp(choosenUname);
						dp.frame.setVisible(true);
						
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
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchButton.setBounds(960, 57, 95, 36);
		frame.getContentPane().add(searchButton);
		
		JButton class1Delete = new JButton("CLASS 1");
		class1Delete.setBounds(367, 163, 105, 105);
		frame.getContentPane().add(class1Delete);
		
		JButton class2Delete = new JButton("CLASS 2");
		class2Delete.setBounds(529, 163, 105, 105);
		frame.getContentPane().add(class2Delete);
		
		JButton class3Delete = new JButton("CLASS 3");
		class3Delete.setBounds(685, 163, 105, 105);
		frame.getContentPane().add(class3Delete);
		
		JButton class4Delete = new JButton("CLASS 4");
		class4Delete.setBounds(845, 163, 105, 105);
		frame.getContentPane().add(class4Delete);
		
		JButton class5Delete = new JButton("CLASS 5");
		class5Delete.setBounds(994, 163, 108, 105);
		frame.getContentPane().add(class5Delete);
		
		
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
