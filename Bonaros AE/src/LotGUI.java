import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LotGUI extends JFrame {
	
	private ArrayList<String> arrayList =  new ArrayList<>();
	private JLabel lot = new JLabel("LOT: ");
	private JTextField lotField = new JTextField();
	
	private JButton key = new JButton();
	private JButton save = new JButton("SAVE");
	
	private JButton close = new JButton();
	private JPanel lotguiPanel = new JPanel();
	JPanel boxPanel = new JPanel();
	private JFrame lotguiFrame = new JFrame("LOT");
	
	private static JTextArea area = new JTextArea();
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	
	public static JTextArea getArea() {
		return area;
	}


	public static void setArea(JTextArea area) {
		LotGUI.area = area;
	}


	public LotGUI(ArrayList<Integer> id){
		
		//Icon for close button
		Image logo = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		close.setIcon(new ImageIcon(logo));
		
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();    		
    	}
		
		try {
			
			
    		Connection con1 =  DriverManager.getConnection(url,uname,pass);
    		Statement statement1 = con1.createStatement();
    		String query = "select lot from products where idProducts ="+id.get(id.size()-1)+"";
    		ResultSet result1 = statement1.executeQuery(query);
    		
    		
    		Vector row1 = new Vector();
    		Vector data1 = new Vector();
    		while(result1.next()) {
    			
    			row1 = new Vector(20);
    			for(int i=1;i<2;i++) {
    				System.out.println(result1.getString(i));
    				row1.add(result1.getString(i));
    			}
    			
    		}
    			lotField.setText(row1.get(0).toString());
    	}catch(SQLException e1) {
    		e1.printStackTrace();
    		
		}
		
	
		
		lot.setFont(new Font("Arial",Font.BOLD,15));
		Box box = Box.createHorizontalBox();
		Box downBox = Box.createHorizontalBox();
		Box midBox = Box.createVerticalBox();
		
		midBox.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		midBox.setPreferredSize(new Dimension(800,700));
		
		lot.setPreferredSize(new Dimension(100,100));
		lotField.setPreferredSize(new Dimension(400,20));
		lot.setAlignmentX(Component.CENTER_ALIGNMENT);
		lotField.setAlignmentX(Component.CENTER_ALIGNMENT);
		lotField.setFont(new Font("Arial",Font.BOLD,30));
		
		box.add(lot); 
		box.add(Box.createRigidArea(new Dimension(30,30)));
		box.add(lotField);
		box.add(Box.createRigidArea(new Dimension(70,70)));
		
		save.setPreferredSize(new Dimension(60,60));
		save.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		save.setFont(new Font("Arial",Font.BOLD,15));
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps = null;
				try {
					
					
					Connection con1 =  DriverManager.getConnection(url,uname,pass);
		    		
					String query1 = "update products set lot=? where idProducts = ?";
					ps = con1.prepareStatement(query1);
					ps.setString(1, lotField.getText());
			        ps.setInt(2, id.get(id.size()-1));
					ps.executeUpdate();
			         
			         	
					new SuccessSaveGUI();
					//new SaveGUI(packingField);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
				MyJFrame f = new MyJFrame(lotField);
				lotField.setText(f.getTb1().getText());						
				f.pack();
				f.setBounds(500,500,500,500);
					
			}
				
		});
		
		close.setPreferredSize(new Dimension(60,60));
		close.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lotguiFrame.dispose();
				
			}
			
		});
		 
		downBox.add(key);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(save);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(close);
		
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		midBox.add(Box.createRigidArea(new Dimension(290,290)));
		midBox.add(box);
		midBox.add(Box.createRigidArea(new Dimension(230,230)));
		midBox.add(downBox);
		lotguiPanel.add(midBox);			
		lotguiFrame.setLayout(new BorderLayout());
		lotguiFrame.add(lotguiPanel);
		lotguiFrame.setUndecorated(true);
		lotguiFrame.pack();
		lotguiFrame.setLocationRelativeTo(null);
		lotguiFrame.setBounds(300, 300, 500, 500);
		lotguiFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		lotguiFrame.setVisible(true);

	}

}
