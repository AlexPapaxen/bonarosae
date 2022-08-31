import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;


public class OrderNamingGUI extends JFrame {
	
	private JFrame orderFrame = new JFrame();
	private JPanel orderPanel = new JPanel(new GridBagLayout());
	private JLabel orderLabel = new JLabel();
	private JTextField ordername = new JTextField();
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private GridBagConstraints keyboard = new GridBagConstraints();
	private GridBagConstraints textfield = new GridBagConstraints();
	private GridBagConstraints labelfield = new GridBagConstraints();
	private GridBagConstraints closeButton = new GridBagConstraints();
	private GridBagConstraints c1 = new GridBagConstraints();
	private GridBagConstraints c2 = new GridBagConstraints();
	private GridBagConstraints c3 = new GridBagConstraints();
	private GridBagConstraints c4 = new GridBagConstraints();
	private GridBagConstraints c5 = new GridBagConstraints();
	private GridBagConstraints c6 = new GridBagConstraints();
	private GridBagConstraints c7 = new GridBagConstraints();
	private GridBagConstraints c8 = new GridBagConstraints();
	private GridBagConstraints c9 = new GridBagConstraints();
	private GridBagConstraints c10 = new GridBagConstraints();
	private Map<String,Boolean> map = new HashMap<>();
	private ArrayList<JTable> selectedTable = new ArrayList<>();
	private static JScrollPane pane= new JScrollPane();
	private static int selection = 0;
	private JButton keyboardButton = new JButton();
	private JButton close =  new JButton();
	private JButton save = new JButton();
	private JButton addOrder = new JButton();
	private JButton delete  = new JButton();
	private JButton execute = new JButton();
	private JLabel orderName = new JLabel("ORDER:");
	private JTextField orderField = new JTextField();
	private ArrayList<String> myStr = new ArrayList<>();
	private TableRowSorter sorter = new TableRowSorter();
	private ArrayList<JTextField> myList = new ArrayList<>();
	private ArrayList<String> saveList = new ArrayList<>();
	private JLabel pickingOrderLabel = new JLabel("Saved Orders");
	private JButton newOrder = new JButton("ΝΕΑ ΠΑΡΑΓΓΕΛΙΑ");
	private JButton deleteOrder = new JButton("ΔΙΑΓΡΑΦΗ ΠΑΡΑΓΓΕΛΙΑΣ");
	private String[] productNameList = null;
	private String[] ppbList = null;
	private String[] bppList = null;
	private ArrayList<String> orderSQLname = new ArrayList<>();
	private ArrayList<Vector> vList=  new ArrayList<>();
	private JComboBox<String> productBox = new JComboBox<>();
	private static int selectedColumn =0;
	private TableColumn tablecol = null;
	//private ArrayList<Boolean> bollList = new ArrayList<>();
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private int id = 0;
    private static int firstTime=0;
    private ArrayList<Integer> idList = new ArrayList<>();
    private static int selectedId =0;
	public OrderNamingGUI(ArrayList<String> order) {
		
		
		Color southColor = new Color(56,105,138,255);
		myStr.add("");
		
		Box orderNameBox = Box.createVerticalBox();
		
		
		
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();    		
    	}
		
		
		
		
		try {
			
			
    		Connection con =  DriverManager.getConnection(url,uname,pass);
    		Statement statement = con.createStatement();
    		String query = "select* from orders";
    		ResultSet result = statement.executeQuery(query);
    		ResultSetMetaData rsmt = result.getMetaData();
    		
    		
    		ArrayList<Integer> ids = new ArrayList<>(); 
    		ArrayList<String> productNames = new ArrayList<>();
    		
    		int c = rsmt.getColumnCount();
    		
    		Vector column = new Vector(c);
    		for(int i=2;i<=c-1;i++) {
    			column.add(rsmt.getColumnName(i));
    		}
    		Vector row = new Vector();
    		Vector data = new Vector();
    		
    		while(result.next()) {
    			idList.add(Integer.parseInt(result.getString(1)));
    			data = new Vector();
    			for(int i=2;i<=c;i++) {
    				
    				
    				String s = result.getString(i);
    				saveList.add(s);
    				
    				if(i==5) {
    					orderSQLname.add(result.getString(i));
    					map.put(result.getString(i), false);
    				 }
    				
    				
    			}
    			
    			productNameList = saveList.get(0).split("[.]");
    			ppbList = saveList.get(1).split("[.]");
    			bppList = saveList.get(2).split("[.]");
    			
    			
    			
    			for(int i=0;i<=productNameList.length-1;i++) {
    				row = new Vector(c);
    				String s1 =productNameList[i];
    				
    				String s2 = ppbList[i];
    				
    				String s3 = bppList[i];
    				
    				row.add(s1);
    				row.add(s2);
    				row.add(s3);
    				data.add(row);
    				
    				
    				
    				
    			}
    			
    			
    			vList.add(data);
    			saveList.removeAll(saveList);
    			
    		}
    		
    		
    		try {
    			String qn = "select description from products";
    			ResultSet resultn = statement.executeQuery(qn);
    			
    			while(resultn.next()) {
    				
    				productBox.addItem(resultn.getString(1));
    				
    				
    			}
    			
    			
    		} catch(SQLException e5) {
    			e5.printStackTrace();
    		}
    		
    		
    		
    		
    		
    		
    		if(!orderSQLname.isEmpty()) {
    			orderField.setText(orderSQLname.get(0));
    		}
    		
    		DefaultTableModel model = new DefaultTableModel(vList.get(0),column);
    		
    		JTable table = new JTable(model);
    		TableColumn column1 = table.getColumnModel().getColumn(0);
    		column1.setCellEditor(new DefaultCellEditor(productBox));
    		selectedTable.add(table);
    		 //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    		 table.setRowHeight(50);
    		 table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
    		 table.setFont(new Font("ARIAL", Font.BOLD, 20));
    		 table.setPreferredSize(new Dimension(872,1000));
    		pane = new JScrollPane(table);
    		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
        	//Vertical Policy
        	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        	
        	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
        	pane.setVerticalScrollBarPolicy(vericalPolicy);
        	pane.setPreferredSize(new Dimension(850,1000));
    		 
        	sorter.setModel(model);
        	table.setRowSorter(sorter);
        	selectedId = idList.get(0);

    		
    		String[] choices1 = new String [orderSQLname.size()];
    		for(int i=0;i<orderSQLname.size();i++) {
    			choices1[i] = orderSQLname.get(i);
    		}
    		
    		JComboBox<String> jComboBox1 = new JComboBox<>(choices1);
    		
    		pickingOrderLabel.setFont(new Font("Arial",Font.BOLD,13));
    		pickingOrderLabel.setPreferredSize(new Dimension(60,40));
    		
    		deleteOrder.setFont(new Font("Arial",Font.PLAIN,13));
    		deleteOrder.setPreferredSize(new Dimension(50,50));
    		
    		orderNameBox.add(pickingOrderLabel);
    		orderNameBox.add(Box.createRigidArea(new Dimension(0,5)));
    		orderNameBox.add(jComboBox1);
    		
    		
    		jComboBox1.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				selectedColumn = jComboBox1.getSelectedIndex();
    				
    				
    				String[] column1 = {"productNames","piecesperbox","boxesperpalette"};
    				
    					
	    	    		model.setDataVector(vList.get(selectedColumn), column);
	    	    		orderField.setText(orderSQLname.get(selectedColumn));
	    	    		
	    	    		JTable table1 = new JTable(model);
	    	    		TableColumn column3 = table1.getColumnModel().getColumn(0);
	    	    		column3.setCellEditor(new DefaultCellEditor(productBox));
	    	    		selectedTable.add(table1);
	    	    		if(selectedColumn ==0) {
	    	    			selectedId = idList.get(0);
	    	    		}else {
	    	    			selectedId = idList.get(selectedColumn);
	    	    			System.out.println(selectedId +" Selected ID");
	    	    		}
	    	    		
	    	    		
	    	    		table1.setRowHeight(50);
	    	    		table1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
	    	    		table1.setFont(new Font("ARIAL", Font.BOLD, 20));
	    	    		table1.setPreferredSize(new Dimension(872,1000));
	    	    		
	    	    		pane.getViewport().add(table1);
	    	    		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
	    	        	//Vertical Policy
	    	        	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
	    	        	
	    	        	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
	    	        	pane.setVerticalScrollBarPolicy(vericalPolicy);
	    	        	pane.setPreferredSize(new Dimension(850,1000));
    				
    				
    			}
    			
    		});
    		
    		
		
    	newOrder.setFont(new Font("Arial",Font.PLAIN,12));
    	newOrder.setPreferredSize(new Dimension(30,30));
    	
		orderName.setFont(new Font("Arial",Font.BOLD,15));
		
		orderField.setPreferredSize(new Dimension(150,30));
		orderField.setFont(new Font("Arial",Font.BOLD,20));
		
		addOrder.setText("ΠΡΟΣΘΗΚΗ");
		addOrder.setFont(new Font("Arial",Font.PLAIN,12));
		addOrder.setPreferredSize(new Dimension(30,30));
		Image addImg = new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
		addOrder.setIcon(new ImageIcon(addImg));
		
		delete.setText("ΔΙΑΓΡΑΦΗ");
		delete.setFont(new Font("Arial",Font.PLAIN,12));
		Image deleteImg = new ImageIcon(this.getClass().getResource("/minus.png")).getImage();
		delete.setIcon(new ImageIcon(deleteImg));
		
		execute.setText("ΕΚΤΕΛΕΣΗ");
		execute.setFont(new Font("Arial",Font.PLAIN,12));
		execute.setPreferredSize(new Dimension(30,30));
		Image execImg = new ImageIcon(this.getClass().getResource("/execute.png")).getImage();
		execute.setIcon(new ImageIcon(execImg));
		
		
		close.setPreferredSize(new Dimension(50,50));
		Image closeImg = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		close.setIcon(new ImageIcon(closeImg));
		
		save.setPreferredSize(new Dimension(50,50));
		Image saveImg = new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		save.setIcon(new ImageIcon(saveImg));
		
		
		keyboardButton.setPreferredSize(new Dimension(50,50));
		keyboardButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		Image keyboardImg = new ImageIcon(this.getClass().getResource("/keyb_img.png")).getImage();
		keyboardButton.setIcon(new ImageIcon(keyboardImg));
		
		orderLabel.setText("ΔΗΜΙΟΥΡΓΙΑ ΠΑΡΑΓΓΕΛΙΑΣ");
		orderLabel.setFont(new Font("Arial",Font.PLAIN,20));
	
		keyboard.fill = GridBagConstraints.HORIZONTAL;
		
		keyboard.ipady = 45;       //reset to default
		keyboard.weighty = 1.0;   //request any extra vertical space
		keyboard.anchor = GridBagConstraints.LAST_LINE_START; //bottom of space
		keyboard.insets = new Insets(10,30,10,800);  //top padding
		keyboard.gridx = 0;       
		keyboard.gridwidth = 2;   //3 columns wide
		keyboard.gridy = 2; //third row
		orderPanel.add(keyboardButton, keyboard);
		
		
		labelfield.fill = GridBagConstraints.HORIZONTAL;
		labelfield.anchor = GridBagConstraints.PAGE_START;
		labelfield.weightx = 0.5;
		labelfield.gridx = 1;
		labelfield.gridy = 0;
		labelfield.insets = new Insets(80,380,120,100);
		orderPanel.add(orderLabel,labelfield);
		
		
		closeButton.fill = GridBagConstraints.HORIZONTAL;
		closeButton.anchor = GridBagConstraints.PAGE_END;
		closeButton.ipady = 45;
		closeButton.weighty = 1.0;
		closeButton.gridx = 0;
		closeButton.gridy = 2;
		closeButton.gridwidth = 2;
		closeButton.insets = new Insets(10,800,10,30);
		orderPanel.add(close,closeButton);
		
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.anchor = GridBagConstraints.CENTER;
		c1.ipady = 20;
		c1.weighty = 1.0;
		c1.gridx = 0;
		c1.gridy = 2;
		c1.gridwidth = 2;
		c1.insets = new Insets(5,30,500,800);
		orderPanel.add(addOrder,c1);
		
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.CENTER;
		c2.ipady = 180;
		c2.weighty = 1.0;
		c2.gridx = 0;
		c2.gridy = 2;
		c2.gridwidth = 3;
		c2.insets = new Insets(100,65,100,65);
		orderPanel.add(pane,c2);
		
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.anchor = GridBagConstraints.CENTER;
		c3.ipady = 20;
		c3.weighty = 1.0;
		c3.gridx = 0;
		c3.gridy = 2;
		c3.gridwidth = 2;
		c3.insets = new Insets(5,260,500,560);
		orderPanel.add(delete,c3);
		
		c5.fill = GridBagConstraints.HORIZONTAL;
		c5.anchor = GridBagConstraints.CENTER;
		c5.ipady = 20;
		c5.weighty = 1.0;
		c5.gridx = 0;
		c5.gridy = 2;
		c5.gridwidth = 2;
		c5.insets = new Insets(5,500,500,320);
		orderPanel.add(execute,c5);
		
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.anchor = GridBagConstraints.PAGE_END;
		c4.ipady = 45;
		c4.weighty = 1.0;
		c4.gridx = 0;
		c4.gridy = 2;
		c4.gridwidth = 2;
		c4.insets = new Insets(300,400,10,400);
		orderPanel.add(save,c4);
		
		c6.fill = GridBagConstraints.HORIZONTAL;
		c6.anchor = GridBagConstraints.CENTER;
		c6.ipady = 45;
		c6.weighty = 1.0;
		c6.gridx = 0;
		c6.gridy = 2;
		c6.gridwidth = 2;
		c6.insets = new Insets(10,70,270,800);
		orderPanel.add(orderName,c6);
		
		c7.fill = GridBagConstraints.HORIZONTAL;
		c7.anchor = GridBagConstraints.CENTER;
		c7.ipady = 45;
		c7.weighty = 1.0;
		c7.gridx = 0;
		c7.gridy = 2;
		c7.gridwidth = 2;
		c7.insets = new Insets(120,140,380,600);
		orderPanel.add(orderField,c7);
		
		
		c8.fill = GridBagConstraints.HORIZONTAL;
		c8.anchor = GridBagConstraints.CENTER;
		c8.ipady = 45;
		c8.weighty = 1.0;
		c8.gridx = 0;
		c8.gridy = 2;
		c8.gridwidth = 2;
		c8.insets = new Insets(0,810,460,60);
		orderPanel.add(orderNameBox,c8);
		
		c9.fill = GridBagConstraints.HORIZONTAL;
		c9.anchor = GridBagConstraints.CENTER;
		c9.ipady = 45;
		c9.weighty = 1.0;
		c9.gridx = 0;
		c9.gridy = 2;
		c9.gridwidth = 2;
		c9.insets = new Insets(90,500,380,390);
		orderPanel.add(newOrder,c9);
		
		c10.fill = GridBagConstraints.HORIZONTAL;
		c10.anchor = GridBagConstraints.CENTER;
		c10.ipady = 45;
		c10.weighty = 1.0;
		c10.gridx = 0;
		c10.gridy = 2;
		c10.gridwidth = 2;
		c10.insets = new Insets(90,700,380,120);
		orderPanel.add(deleteOrder,c10);
		
		orderField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				myList.add(orderField);
				
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
		
		keyboardButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row =  selectedTable.get(selectedTable.size()-1).getSelectedRow();
				
				int column = selectedTable.get(selectedTable.size()-1).getSelectedColumn();
				
				if(myList.isEmpty()) {
				OrderKeyboard keyb = new OrderKeyboard(myStr);
				
				selectedTable.get(selectedColumn).setValueAt(myStr.get(0), row, column);
				keyb.pack();
				keyb.setBounds(500,500,500,500);
				}
				else {
					MyJFrame f = new MyJFrame(myList.get(myList.size()-1));
					orderField.setText(f.getTb1().getText());
					myList.removeAll(myList);
				}
				
			}
			
		});
		
		newOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Vector v = new Vector();
				Vector d = new Vector();
				v.add("");
				v.add("");
				v.add("");
				d.add(v);
				orderField.setText("");
	    		model.setDataVector(d, column);
	    		
	    		
	    		JTable table1 = new JTable(model);
	    		selectedTable.add(table1);
	    		selectedId = -1;
	    		TableColumn column = table1.getColumnModel().getColumn(0);
	    		column.setCellEditor(new DefaultCellEditor(productBox));
	    		table1.setRowHeight(50);
	    		table1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
	    		table1.setFont(new Font("ARIAL", Font.BOLD, 20));
	    		table1.setPreferredSize(new Dimension(872,1000));
	    		
	    		pane.getViewport().add(table1);
	    		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
	        	//Vertical Policy
	        	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
	        	
	        	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
	        	pane.setVerticalScrollBarPolicy(vericalPolicy);
	        	pane.setPreferredSize(new Dimension(850,1000));
				
			}
			
		});
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				orderFrame.dispose();
				
			}
			
		});
		
		addOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(vList.get(selectedColumn).isEmpty()) {
					
					model.addRow(new Object[] {"","","",""});
					
				}
				else {
					
					model.addRow(new Object[] {"","","",""});
					
				}
			}
			
			});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!selectedTable.isEmpty() && selectedTable.get(selectedTable.size()-1).getSelectedRows().length==0 ) {
					NoRowProductGUI gui = new NoRowProductGUI();
					
					
				}
				
				else {
					
					JFrame powerFrame=  new JFrame("Διαγραφή Προϊόντος");
					JPanel panel = new JPanel();
					JLabel message = new JLabel("Είστε βέβαιος για την μόνιμη διαγραφή του προϊόντος; ");
					
					JButton yesButton = new JButton("ΝΑΙ");
					JButton noButton = new JButton("OXI");
					yesButton.setPreferredSize(new Dimension(100,50));
					yesButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
					noButton.setPreferredSize(new Dimension(100,50));
					noButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
					//�������� ��������
					yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
					noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
					
					
					//�������� ��������
					message.setAlignmentX(Component.CENTER_ALIGNMENT);
					
					Box box = Box.createHorizontalBox();
					box.add(yesButton);
					box.add(Box.createRigidArea(new Dimension(20,20)));
					box.add(noButton);
					
					
					Box labelbox = Box.createVerticalBox();
					
					message.setFont(new Font("Arial",Font.BOLD,12));
					labelbox.add(Box.createRigidArea(new Dimension(200,20)));
					labelbox.add(message);
					labelbox.add(Box.createRigidArea(new Dimension(0,20)));
					yesButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							removeSelectedFromTable(selectedTable.get(selectedTable.size()-1));
							powerFrame.dispose();
							
						}
						
						
					});
					
					
					noButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							powerFrame.dispose();
							
						}
						
					});
					
					
					panel.add(labelbox);
					panel.add(box);
					panel.setPreferredSize(new Dimension(400,150));
					
					
					powerFrame.add(panel);
					powerFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			        powerFrame.pack();
			        powerFrame.setLocationRelativeTo(null);
			        powerFrame.setVisible(true);
			        powerFrame.setResizable(false);
				}
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String products="";
				String ppb ="";
				String bpp="";
				
				
				System.out.println("Selected ID :" + selectedId);
				//System.out.println("OrderName :" + );
				
				int rand = ThreadLocalRandom.current().nextInt(3,1000);
				
				for(int i=0;i<selectedTable.get(selectedTable.size()-1).getRowCount(); i++) {
					
					if(i!=selectedTable.get(selectedTable.size()-1).getRowCount()-1) {
					products += selectedTable.get(selectedTable.size()-1).getValueAt(i, 0).toString() + ".";
					ppb += selectedTable.get(selectedTable.size()-1).getValueAt(i, 1).toString()+ ".";
					bpp += selectedTable.get(selectedTable.size()-1).getValueAt(i, 2).toString() + ".";
						}
					
					else {
						products += selectedTable.get(selectedTable.size()-1).getValueAt(i, 0).toString();
						ppb += selectedTable.get(selectedTable.size()-1).getValueAt(i, 1).toString();
						bpp += selectedTable.get(selectedTable.size()-1).getValueAt(i, 2).toString();
					}
					
					
					
				}
				
				
				
				if(orderField.getText().equals("")) {
					new NoOrderNameTyped();
				}
				else if(idList.contains(selectedId)) {
					
					try {
						
						String q2 = "update orders set productNames = ?, piecesperbox = ?, boxesperpalette =?,orderName =? where idOrder =?";
						PreparedStatement ps1 = con.prepareStatement(q2);
						ps1.setString(1, products);
						ps1.setString(2, ppb);
						ps1.setString(3, bpp);
						ps1.setString(4, orderField.getText());
						ps1.setInt(5,selectedId);
						ps1.executeUpdate();
						new SuccessSaveGUI();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					Vector<String> myR = new Vector();
					Vector myD = new Vector();
					myR.add(products);
					myR.add(ppb);
					myR.add(bpp);
					myR.add(orderField.getText());
					myD.add(myR);
					String q3 = "insert into orders(idOrder,productNames,piecesperbox,boxesperpalette,orderName)"
							+ "values("+rand+",'"+products+"','"+ppb+"','"+bpp+"','"+orderField.getText()+"')";
					try {
						statement.executeUpdate(q3);
						jComboBox1.addItem(orderField.getText());
						vList.add(myD);
						orderSQLname.add(orderField.getText());
						idList.add(rand);
						new SuccessSaveGUI();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		
		execute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				order.removeAll(order);
				order.add(orderField.getText());
				
			}
			
		});
		
		
		deleteOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(orderSQLname.contains(orderField.getText())){
				JFrame powerFrame=  new JFrame("Διαγραφή Παραγγελίας");
				JPanel panel = new JPanel();
				JLabel message = new JLabel("Είστε βέβαιος για την μόνιμη διαγραφή της παραγγελίας; ");
				
				JButton yesButton = new JButton("ΝΑΙ");
				JButton noButton = new JButton("OXI");
				yesButton.setPreferredSize(new Dimension(100,50));
				yesButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
				noButton.setPreferredSize(new Dimension(100,50));
				noButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
				//�������� ��������
				yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				
				//�������� ��������
				message.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				Box box = Box.createHorizontalBox();
				box.add(yesButton);
				box.add(Box.createRigidArea(new Dimension(20,20)));
				box.add(noButton);
				
				
				Box labelbox = Box.createVerticalBox();
				
				message.setFont(new Font("Arial",Font.BOLD,12));
				labelbox.add(Box.createRigidArea(new Dimension(200,20)));
				labelbox.add(message);
				labelbox.add(Box.createRigidArea(new Dimension(0,20)));
				yesButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						
						try {
							String query1 = "delete from orders where orderName =?";
							PreparedStatement ps = con.prepareStatement(query1);
							ps.setString(1, orderField.getText());
							ps.executeUpdate();
							
							
							Vector v = new Vector();
							orderField.setText("");
							jComboBox1.removeItem(orderField.getText());
							vList.remove(selectedColumn);
							idList.remove(selectedColumn);
							orderSQLname.remove(selectedColumn);
				    		model.setDataVector(v, column);
				    		
				    		
				    		JTable table1 = new JTable(model);
				    		selectedTable.add(table1);
				    		
				    		table1.setRowHeight(50);
				    		table1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
				    		table1.setFont(new Font("ARIAL", Font.BOLD, 20));
				    		table1.setPreferredSize(new Dimension(872,1000));
				    		
				    		pane.getViewport().add(table1);
				    		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
				        	//Vertical Policy
				        	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
				        	
				        	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
				        	pane.setVerticalScrollBarPolicy(vericalPolicy);
				        	pane.setPreferredSize(new Dimension(850,1000));
							
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						jComboBox1.removeItemAt(selectedColumn);
						powerFrame.dispose();
						
					}
					
					
				});
				
				
				noButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						powerFrame.dispose();
						
					}
					
				});
				
				
				panel.add(labelbox);
				panel.add(box);
				panel.setPreferredSize(new Dimension(400,150));
				
				
				powerFrame.add(panel);
				
				powerFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		        powerFrame.pack();
		        powerFrame.setLocationRelativeTo(null);
		        powerFrame.setVisible(true);
		        powerFrame.setResizable(false);
			 }
			}
			
		});
		
		orderFrame.setUndecorated(true);
		orderFrame.add(orderPanel,BorderLayout.CENTER);
		orderFrame.setResizable(false);
		orderFrame.pack();
		orderFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		orderFrame.setLocationRelativeTo(null);
		orderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		orderFrame.setResizable(false);
		orderFrame.setVisible(true);
		
		
		}catch(SQLException e) {
    		e.printStackTrace();
	
		}
		
		
		
	}
	

	
	public void removeSelectedFromTable(JTable table) {

	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    int indexes[] = table.getSelectedRows(); 
	    int res = 0;
	    for(int i = 0; i < indexes.length; i++) {
	        res += (i>0)?(indexes[i]-indexes[i-1]-1):0;
	        int index = table.convertRowIndexToModel(indexes[0]+res);
	        model.removeRow(index);
	    }
	
	}
	class ColumnColorRenderer extends DefaultTableCellRenderer {
		   Color backgroundColor, foregroundColor;
		   public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
		      super();
		      this.backgroundColor = backgroundColor;
		      this.foregroundColor = foregroundColor;
		   }
		   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   boolean hasFocus, int row, int column) {
		      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		      cell.setBackground(backgroundColor);
		      cell.setForeground(foregroundColor);
		      return cell;
		   }
		}
}
