import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PLUGUI extends JFrame {
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String query = "select* from products";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private static int prod;
	
	public PLUGUI(ArrayList<Integer> id,ArrayList<Integer> selectedRow,ArrayList<String> datesList,ArrayList<String> logFile) {
		Color southColor = new Color(129,140,157,255);
		JPanel allPanel = new JPanel(new BorderLayout());
		JPanel arrowPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JFrame allFrame = new JFrame("Προϊόντα");
	    
	    JButton details = new JButton();
	    details.setPreferredSize(new Dimension(60,60));
		details.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	    Image keyLogo = new ImageIcon(this.getClass().getResource("search.png")).getImage();
	    details.setIcon(new ImageIcon(keyLogo));
	    details.setOpaque(false);
	    details.setFocusPainted(false);
	    details.setContentAreaFilled(false);
	    
	    JButton close = new JButton();
	    close.setPreferredSize(new Dimension(60,60));
	    Image logo = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		close.setIcon(new ImageIcon(logo));
	    close.setOpaque(false);
	    close.setFocusPainted(false);
	    close.setContentAreaFilled(false);
	    
	    
	    JButton select = new JButton();
	    select.setFont(new Font("Arial",Font.BOLD,20));
	    Image selectlogo = new ImageIcon(this.getClass().getResource("select.png")).getImage();
	    select.setIcon(new ImageIcon(selectlogo));
	    select.setOpaque(false);
	    select.setFocusPainted(false);
	    select.setContentAreaFilled(false);
	    
	    JButton upArrow = new JButton();
	    upArrow.setPreferredSize(new Dimension(45,45));
	    Image uplogo = new ImageIcon(this.getClass().getResource("up-arrow.png")).getImage();
	    upArrow.setIcon(new ImageIcon(uplogo));
	    upArrow.setOpaque(false);
	    upArrow.setFocusPainted(false);
	    upArrow.setContentAreaFilled(false);
	    
	    JButton downArrow = new JButton();
	    downArrow.setPreferredSize(new Dimension(45,45));
	    Image downlogo = new ImageIcon(this.getClass().getResource("arrow-down.png")).getImage();
	    downArrow.setIcon(new ImageIcon(downlogo));
	    downArrow.setOpaque(false);
	    downArrow.setFocusPainted(false);
	    downArrow.setContentAreaFilled(false);
	    
	    JButton gotoTop = new JButton();
	    gotoTop.setPreferredSize(new Dimension(45,45));
	    Image gotoTopLogo = new ImageIcon(this.getClass().getResource("gotoTop.png")).getImage();
	    gotoTop.setIcon(new ImageIcon(gotoTopLogo));
	    gotoTop.setOpaque(false);
	    gotoTop.setFocusPainted(false);
	    gotoTop.setContentAreaFilled(false);
	    
	    
	    
	    JButton gotoBottom = new JButton();
	    gotoBottom.setPreferredSize(new Dimension(45,45));
	    Image gotoBottomLogo = new ImageIcon(this.getClass().getResource("gotoBottom.png")).getImage();
	    gotoBottom.setIcon(new ImageIcon(gotoBottomLogo));
	    gotoBottom.setOpaque(false);
	    gotoBottom.setFocusPainted(false);
	    gotoBottom.setContentAreaFilled(false);
	    
	    
	    Box uparrowBox = Box.createVerticalBox();
	    uparrowBox.add(gotoTop);
	    uparrowBox.add(Box.createRigidArea(new Dimension(10,10)));
	    uparrowBox.add(upArrow);
	    
	    
	    Box buttonsBox = Box.createHorizontalBox();
	   
	    buttonsBox.add(details);
		buttonsBox.add(Box.createRigidArea(new Dimension(250,150)));
		buttonsBox.add(select);
		buttonsBox.add(Box.createRigidArea(new Dimension(250,150)));
		buttonsBox.add(close);
		buttonsPanel.add(buttonsBox);
		buttonsPanel.setPreferredSize(new Dimension(500,140));
		
		
		Box downarrowBox = Box.createVerticalBox();
		downarrowBox.add(downArrow);
		downarrowBox.add(Box.createRigidArea(new Dimension(10,10)));
		downarrowBox.add(gotoBottom);
		
		
		Box arrowBox = Box.createVerticalBox();
		arrowBox.add(Box.createRigidArea(new Dimension(60,200)));
		arrowBox.add(uparrowBox);
		arrowBox.add(Box.createRigidArea(new Dimension(10,10)));
		arrowBox.add(downarrowBox);
		
		arrowBox.setPreferredSize(new Dimension(100,500));
		arrowPanel.add(arrowBox);
		
		
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();    		
    	}
    	
    	try {
    		Connection con =  DriverManager.getConnection(url,uname,pass);
    		Statement statement = con.createStatement();
    		ResultSet result = statement.executeQuery(query);
    		ResultSetMetaData rsmt = result.getMetaData();
    		
    		int c = rsmt.getColumnCount();
    		Vector column = new Vector(c);
    		for(int i=1;i<=3;i++) {
    			column.add(rsmt.getColumnName(i));
    		}
    		Vector data = new Vector();
    		Vector row = new Vector();
    		
    		while(result.next()) {
    			row = new Vector(3);
    			for(int i=1;i<=3;i++) {
    				row.add(result.getString(i));
    				
    			}
    			System.out.println(row);
    			data.add(row);
    		}
		
    		DefaultTableModel model = new DefaultTableModel(data,column) {

    		    @Override
    		    public boolean isCellEditable(int row, int column) {
    		    	
    		    		return false;
    		    }
    		};
    		Color initial = new Color(32,136,203);
    		Color fore = new Color(255,255,255);
    		
    		  JTable table = new JTable(model);
    		
    		 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    		 table.setRowHeight(50);
    		 table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
    		 table.getTableHeader().setOpaque(false);
    		 table.getTableHeader().setBackground(southColor);
    		 table.getTableHeader().setForeground(southColor);
    		 table.setPreferredSize(new Dimension(1000,1000));
    		JScrollPane pane = new JScrollPane(table);
    		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
        	//Vertical Policy
        	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
        	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
        	pane.setVerticalScrollBarPolicy(vericalPolicy);
        	pane.setPreferredSize(new Dimension(600,1000));
    		 
        	
        	
        	
        	
        	       	
        	close.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				allFrame.dispose();
    				
    			}
    			
    		});
        	
        	
        	downArrow.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					int select = table.getSelectedRow(); 
					if(select<table.getRowCount()-1) {
					//model.moveRow(select, select, select+1);
					table.getSelectionModel().setSelectionInterval(select+1, select+1);
					
					}
					
				}
        	});
        	
        	
        	upArrow.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int select = table.getSelectedRow();
				
					if(select>0) {
					//model.moveRow(select,select, select-1);
					table.getSelectionModel().setSelectionInterval(select-1, select-1);
					}
					
				}
        		
        	});
        	
        	gotoTop.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					table.changeSelection(0, 0,false,false);
				
				}
        		
        	});
        	
        	
        	gotoBottom.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int select = table.getRowCount()-1;
		
					table.changeSelection(select, 0,false,false);
	
			}
        		
        	});
        	
        	
        	details.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int selected = table.getSelectedRow();
					if(selected!=-1) {
						new PLUEditGUI(selected,table,datesList);
					}
					
					
				}
        		
        	});
        	
        	select.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					String s = table.getValueAt(row, 0).toString();
					prod = Integer.parseInt(s);
					id.add(prod);
					selectedRow.add(row);
					try {
		    			
		    			
		        		Connection con1 =  DriverManager.getConnection(url,uname,pass);
		        		Statement statement1 = con1.createStatement();
		        		String query = "select* from products where idProducts ="+prod+"";
		        		ResultSet result1 = statement1.executeQuery(query);
		        		
		        		
		        		Vector row1 = new Vector();
		        		Vector data1 = new Vector();
		        		while(result1.next()) {
		        			
		        			row1 = new Vector(20);
		        			for(int i=1;i<=20;i++) {
		        				System.out.println(result1.getString(i));
		        				row1.add(result1.getString(i));
		        			}
		        			
		        		}	logFile.removeAll(logFile);
		        			logFile.add(row1.get(0).toString());
		        			logFile.add(row1.get(2).toString());
		        			logFile.add(row1.get(6).toString());
		        			logFile.add(row1.get(8).toString());
		        			logFile.add(row1.get(10).toString());
		        			logFile.add(row1.get(1).toString());
		        			logFile.add(row1.get(3).toString());
		        			datesList.removeAll(datesList);
		        			datesList.add(row1.get(5).toString());
		        			datesList.add(row1.get(18).toString());
		        			datesList.add(row1.get(19).toString());
		        			System.out.println(datesList.toString());
		        			
		        			
		        	}catch(SQLException e1) {
		        		e1.printStackTrace();
		        		
		    		}
					
					
					
					
					allFrame.dispose();
				}
        		
        	});
        	
        	
        	
    		 allPanel.add(pane,BorderLayout.CENTER);
    		 allPanel.add(buttonsPanel,BorderLayout.PAGE_END);
    		 allPanel.add(arrowPanel,BorderLayout.LINE_END);
    		 allFrame.add(allPanel);
    		 allFrame.setUndecorated(true);
    		 allFrame.pack();
    		 allFrame.setLocationRelativeTo(null);
    		 //allFrame.setBounds(300, 300, 500, 600);
    		 allFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    		 allFrame.setVisible(true);
		
		
	
    	}catch(SQLException e) {
    		e.printStackTrace();
	
		}
		
	
	
	

	}
}
