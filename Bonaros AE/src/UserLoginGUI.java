import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class UserLoginGUI extends JFrame {
	
	private ArrayList<JTextField> arrayList =  new ArrayList<>();
	private JLabel username = new JLabel("Username: ");
	private JLabel password = new JLabel("Password: ");
	private static JTextField userField = new JTextField();
	private static boolean flag = true;
	private static int buttonState=1;
	private static JButton loggedOut = new JButton("LOGOUT");
	public static JTextField getUserField() {
		return userField;
	}


	public static void setUserField(JTextField userField) {
		UserLoginGUI.userField = userField;
	}


	private static JTextField passField = new JTextField();
	private JButton key = new JButton();
	private static JButton save = new JButton("LOGIN");
	
	private JButton close = new JButton();
	private JPanel loginPanel = new JPanel();
	JPanel boxPanel = new JPanel();
	private JFrame loginFrame = new JFrame("LOGIN");
	
	private static JTextArea area1 = new JTextArea();
	
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private static ArrayList<String> users = new ArrayList<>();
	private int count=0;
	
	public static JTextArea getArea() {
		return area1;
	}


	public static void setArea(JTextArea area) {
		UserLoginGUI.area1 = area;
	}


	public UserLoginGUI(JLabel userLoggedIn){

		
		if(!users.isEmpty()) {
			userField.setText(users.get(0));
			passField.setText(users.get(1));
			
		}
		
		
		
		
		//Icon for close button
		Image logo = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		close.setIcon(new ImageIcon(logo));
		
		
		
		username.setFont(new Font("Arial",Font.BOLD,20));
		password.setFont(new Font("Arial",Font.BOLD,20));
		Box box = Box.createVerticalBox();
		Box userBox = Box.createHorizontalBox();
		Box passBox = Box.createHorizontalBox();
		Box downBox = Box.createHorizontalBox();
		Box midBox = Box.createVerticalBox();
		
		midBox.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		midBox.setPreferredSize(new Dimension(800,700));
		
		username.setPreferredSize(new Dimension(150,70));
		userField.setPreferredSize(new Dimension(50,20));
		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		userField.setAlignmentX(Component.CENTER_ALIGNMENT);
		userField.setFont(new Font("Arial",Font.BOLD,30));
		password.setPreferredSize(new Dimension(150,70));
		passField.setPreferredSize(new Dimension(50,20));
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		passField.setAlignmentX(Component.CENTER_ALIGNMENT);
		passField.setFont(new Font("Arial",Font.BOLD,30));
		
		
		
		loggedOut.setEnabled(false);
		loggedOut.setVisible(false);
		loggedOut.setPreferredSize(new Dimension(60,60));
		loggedOut.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		loggedOut.setFont(new Font("Arial",Font.BOLD,15));
		
		if(!users.isEmpty()) {
			loggedOut.setVisible(true);
			loggedOut.setEnabled(true);
		}
		
		userBox.add(username);
		userBox.add(Box.createRigidArea(new Dimension(20,10)));
		userBox.add(userField);
		
		
		passBox.add(password);
		passBox.add(Box.createRigidArea(new Dimension(20,10)));
		passBox.add(passField);
		
		
		box.add(userBox);
		box.add(Box.createRigidArea(new Dimension(10,10)));
		box.add(passBox);
		box.add(Box.createRigidArea(new Dimension(200,0)));
		box.add(loggedOut);
		
		
		
		
		save.setPreferredSize(new Dimension(60,60));
		save.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		save.setFont(new Font("Arial",Font.BOLD,15));
		
		userField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				arrayList.add(userField);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		passField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				arrayList.add(passField);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e7) {
				
				if(save.isEnabled()) {
				new LoginSession(save,loggedOut,userField,passField,users,userLoggedIn);
				
				}
				
				
				
			}
			
	});
		
		loggedOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(loggedOut.isEnabled()) {
					JOptionPane.showMessageDialog(null,"Επιτυχής αποσύνδεση !");
					loggedOut.setEnabled(false);
					loggedOut.setVisible(false);
					save.setVisible(true);
					save.setEnabled(true);
					userField.setEnabled(true);
					passField.setEnabled(true);
					userField.setEditable(true);
					passField.setEditable(true);
					users.removeAll(users);
					
				}
				
				
				
			}
			
			
			
			});
		
		
		
		
		key.setPreferredSize(new Dimension(60,60));
		key.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		Image keyLogo = new ImageIcon(this.getClass().getResource("/keyb_img.png")).getImage();
		key.setIcon(new ImageIcon(keyLogo));
		
		
		key.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(arrayList.size()>0) {
				MyJFrame f = new MyJFrame(arrayList.get(arrayList.size()-1));
				
				
				arrayList.get(arrayList.size()-1).setText(f.getTb1().getText());				
								
				f.pack();
				f.setBounds(500,500,500,500);
				
				}
			}
				
		});
		
		
		close.setPreferredSize(new Dimension(60,60));
		close.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginFrame.dispose();
				
			}
			
		});
		 
		
		downBox.add(key);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(save);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(close);
		
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.setPreferredSize(new Dimension(300,150));
		midBox.add(Box.createRigidArea(new Dimension(290,290)));
		midBox.add(box);
		midBox.add(Box.createRigidArea(new Dimension(200,180)));
		midBox.add(downBox);
		
		loginPanel.add(midBox);			
		loginFrame.setLayout(new BorderLayout());
		loginFrame.add(loginPanel);
		loginFrame.setUndecorated(true);
		loginFrame.pack();
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setBounds(300, 300, 500, 500);
		loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginFrame.setVisible(true);
		
		
    	
	}
	
	
	
	
	
}
	
	



