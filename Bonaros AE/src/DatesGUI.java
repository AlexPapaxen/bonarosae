import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class DatesGUI extends JFrame {
	
	private JDateChooser expireChooser = new JDateChooser();
	private JDateChooser packingChooser = new JDateChooser();
	private JLabel expire = new JLabel();
	private JLabel production = new JLabel();
	private JLabel packing = new JLabel();
	private JTextField productionField = new JTextField();
	private JButton save = new JButton();
	private JButton close  = new JButton();
	private JButton calculateExpireDate = new JButton();
	private JButton keyboard = new JButton();
	private DateTimeFormatter  fm = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
	private ArrayList<JTextField> textFieldClicked = new ArrayList<>();
	private JFormattedTextField expireField = new JFormattedTextField(fm);
	private JFormattedTextField packingField = new JFormattedTextField(fm);
	private GridBagConstraints c = new GridBagConstraints();
	private ArrayList<String> array = new ArrayList<>();
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String dateProduct ="";
	private String expireDate ="";
	private String packingDate ="";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private String daystoexpire="";
	
	public DatesGUI(ArrayList<Integer> id,ArrayList<String> datesList) {
		if(!id.isEmpty()) {
		JFrame allFrame = new JFrame();
		JPanel boxPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();    		
    	}
		
		try {
			
			System.out.println(id.get(0));
    		Connection con =  DriverManager.getConnection(url,uname,pass);
    		Statement statement = con.createStatement();
    		String query = "select* from products where idProducts ="+id.get(id.size()-1)+"";
    		ResultSet result = statement.executeQuery(query);
    		
    		
    		Vector row = new Vector();
    		Vector data = new Vector();
    		while(result.next()) {
    			
    			row = new Vector(20);
    			for(int i=1;i<=20;i++) {
    				System.out.println(result.getString(i));
    				row.add(result.getString(i));
    			}
    			
    		}
		
    			daystoexpire = row.get(4).toString();
    			dateProduct = row.get(5).toString();
    			expireDate = row.get(18).toString();
    			packingDate = row.get(19).toString();
    			
    		
    			
    			productionField.setText(dateProduct);
    			expireField.setText(expireDate);
    			packingField.setText(packingDate);
			
    		
		}catch(SQLException e) {
    		e.printStackTrace();
	
		}
		
		expire.setText("expire ");
		expire.setFont(new Font("Arial",Font.BOLD,25));
		
		packing.setText("packing ");
		packing.setFont(new Font("Arial",Font.BOLD,25));
		
		production.setText("production ");
		production.setFont(new Font("Arial",Font.BOLD,25));
		
		productionField.setPreferredSize(new Dimension(150,30));
		productionField.setEditable(false);
		
		
		
		packingField.setPreferredSize(new Dimension(160,30));
		packingField.setFont(new Font("Arial",Font.PLAIN,18));
		

		
		expireField.setPreferredSize(new Dimension(160,30));
		expireField.setFont(new Font("Arial",Font.PLAIN,18));
		
		
		packingChooser.setPreferredSize(new Dimension(28,35));
		packingChooser.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		packingChooser.setFont(new Font("Arial",Font.PLAIN,18));
		//packingChooser.getJCalendar().setPreferredSize(new Dimension(200,100));
		//packingChooser.getJCalendar().getYearChooser().setPreferredSize(new Dimension(50,20));
		
		expireChooser.setPreferredSize(new Dimension(28,35));
		expireChooser.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		expireChooser.setFont(new Font("Arial",Font.PLAIN,18));
		//expireChooser.getJCalendar().setPreferredSize(new Dimension(200,100));
		//expireChooser.getJCalendar().getYearChooser().setPreferredSize(new Dimension(50,20));
		
		
		Image logo = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		close.setIcon(new ImageIcon(logo));
	    close.setOpaque(false);
	    close.setFocusPainted(false);
	    close.setContentAreaFilled(false);
		
		
	    Image saveLogo = new ImageIcon(this.getClass().getResource("save.png")).getImage();
		save.setIcon(new ImageIcon(saveLogo));
		save.setOpaque(false);
	    save.setFocusPainted(false);
	    save.setContentAreaFilled(false);	
		
	    
	    Image keyb = new ImageIcon(this.getClass().getResource("keyb_img.png")).getImage();
		keyboard.setIcon(new ImageIcon(keyb));
	    keyboard.setOpaque(false);
	    keyboard.setFocusPainted(false);
	    keyboard.setContentAreaFilled(false);
	    
		
	    calculateExpireDate.setFont(new Font("Arial",Font.BOLD,16));
		calculateExpireDate.setText("<html>calculate expiration<br />date</html>");
		calculateExpireDate.setHorizontalAlignment(SwingConstants.CENTER);
		calculateExpireDate.setPreferredSize(new Dimension(50,50));
		
		boxPanel.setBackground(Color.LIGHT_GRAY);
				
		Box expireBox = Box.createHorizontalBox();
		Box productionBox = Box.createHorizontalBox();
		Box packingBox = Box.createHorizontalBox();
		Box allBoxes = Box.createVerticalBox();
		Box buttonBox = Box.createHorizontalBox();
		
		productionBox.add(Box.createRigidArea(new Dimension(350,0)));
		productionBox.add(production);
		productionBox.add(productionField);
		
		packingBox.add(Box.createRigidArea(new Dimension(350,0)));
		packingBox.add(packing);
		packingBox.add(packingField);
		packingBox.add(packingChooser);
		
		expireBox.add(Box.createRigidArea(new Dimension(350,0)));
		expireBox.add(expire);
		expireBox.add(expireField);
		expireBox.add(expireChooser);
		
		
		//expireChooser.setDate(new Date());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//String date = dateFormat.format(expireChooser.getDate());
		
		expireChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if("date".equals(evt.getPropertyName())) {
					Date date = (Date)evt.getNewValue();
					String newDate = dateFormat.format(date);
					expireField.setText(newDate);
				}
				
			}
			
		});
		
		
		expireField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(expireField);
				
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
		
		
		//packingChooser.setDate(new Date());
		DateFormat packingFormat = new SimpleDateFormat("dd/MM/yyyy");
		//String packingdate = dateFormat.format(packingChooser.getDate());
		
		packingChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if("date".equals(evt.getPropertyName())) {
					Date date = (Date)evt.getNewValue();
					String newDate = packingFormat.format(date);
					packingField.setText(newDate);
				}
				
			}
		});
		
		packingField.addMouseListener(new MouseListener() {
		

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(packingField);
				
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
		
		keyboard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					if(textFieldClicked.size()>0) {
					KeyPadDate key = new KeyPadDate(textFieldClicked.get(textFieldClicked.size()-1),array);
					//MyJFrame f = new MyJFrame(textFieldClicked.get(textFieldClicked.size()-1));
					
					
					//textFieldClicked.get(textFieldClicked.size()-1).setText(f.getTb1().getText());
				
					}
			}
			
		});
		
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					PreparedStatement ps = null;
				try {
					
					
					Connection con1 =  DriverManager.getConnection(url,uname,pass);
		    		
					String query1 = "update products set dateproduct =?,expireDate =?,packingDate=?  where idProducts = ?";
					ps = con1.prepareStatement(query1);
					 ps.setString(1, productionField.getText());
			         ps.setString(2, expireField.getText());
			         ps.setString(3, packingField.getText());
			         ps.setInt(4, id.get(id.size()-1));
					ps.executeUpdate();
			         
			         	
					new SuccessSaveGUI();
					//new SaveGUI(packingField);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				datesList.removeAll(datesList);
				datesList.add(productionField.getText());
				datesList.add(expireField.getText());
				datesList.add(packingField.getText());
				
			}
			
		});
		
		
		calculateExpireDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String productionDate = productionField.getText();
				int days = Integer.valueOf(daystoexpire);
	    		Calendar calendar = Calendar.getInstance();
	    		Date date;
				try {
					date = formatter.parse(productionDate);
					calendar.setTime(date);
		    		calendar.add(Calendar.DAY_OF_YEAR, days);
		    		String newDate = dateFormat.format(calendar.getTime());
		    		expireField.setText(newDate);
		    		
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
				
			}
			
		});
		
		calculateExpireDate.setBounds(750, 600, 120, 60);
		allFrame.add(calculateExpireDate);
		
		
		
		buttonBox.add(Box.createRigidArea(new Dimension(10,10)));
		buttonBox.add(keyboard);
		buttonBox.add(Box.createRigidArea(new Dimension(350,10)));
		buttonBox.add(save);
		buttonBox.add(Box.createRigidArea(new Dimension(350,10)));
		buttonBox.add(close);
		
		
		allBoxes.add(Box.createRigidArea(new Dimension(10,350)));
		allBoxes.add(productionBox);
		allBoxes.add(Box.createRigidArea(new Dimension(0,30)));
		allBoxes.add(packingBox);
		allBoxes.add(Box.createRigidArea(new Dimension(0,60)));
		allBoxes.add(expireBox);
		allBoxes.add(Box.createRigidArea(new Dimension(0,30)));
		//allBoxes.add(calculateExpireDate);
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allFrame.dispose();
				
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		buttonPanel.add(buttonBox);
		buttonPanel.setPreferredSize(new Dimension(600,80));
		boxPanel.add(allBoxes);
		
		allFrame.add(boxPanel,BorderLayout.CENTER);
		allFrame.add(buttonPanel,BorderLayout.PAGE_END);
		
		 allFrame.setUndecorated(true);
		 allFrame.pack();
		 allFrame.setLocationRelativeTo(null);
		 //allFrame.setBounds(300, 300, 500, 600);
		 allFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 allFrame.setVisible(true);
		}
		
	}

}
