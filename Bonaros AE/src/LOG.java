import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


import com.idautomation.linear.*;
import com.idautomation.linear.encoder.*;






public class LOG extends JFrame{
	
	private JButton export = new JButton();
	private JButton exportAndDelete = new JButton();
	private JButton close = new JButton();
	private JButton deleteRow = new JButton();
	private File targetFile;
	private TableRowSorter sorter = new TableRowSorter();
	private static int selectedColumn = 0;
	private static int counter = 0;
	private int boxNoL = 0;
	private int paletteNoL = 0;
	private int countItemsL = 0;
	private int countBoxesL = 0;
	private int countPalettesL = 0;
	private int countAllPalettesL = 0;
	private int countAllBoxesL =0;
	private double valueBoxLogL = 0.0;
	private double valuePaletteLogL = 0.0;
	private double valueForUseL =0.0;
	private double weightBoxLogL = 0.0;
	private double weightPaletteLogL = 0.0;
	private double sumWeightL = 0.0;
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private static int exportId = 0;
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC";
	private static String pcName = "";
	
	
	
	
	public LOG(File f,Vector column, ArrayList<Integer> intList,ArrayList<Double> doubleList,ArrayList<Integer> logL) {
		pcName = this.getComputerName();
		
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();    		
    	}
		String table = "exports_"+ pcName.toLowerCase().replace("-", "_");
		String query = "select* from " + table;
		
		
		try{
			
			 Connection con = DriverManager.getConnection(url, uname, pass);
			 Statement stm  = con.createStatement();
			 ResultSet result = stm.executeQuery(query);
			  
	    		
	    		while(result.next()) {
	    			
	    			for(int i=1;i<=2;i++) {
	    				if(i==1) {
	    				exportId = Integer.parseInt(result.getString(i)); 
	    				}
	    			}
	    		
	    		}		 
				exportId+=1;	 
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		if(!intList.isEmpty()) {
			intList.removeAll(intList);
		}
		if(!doubleList.isEmpty()) {
			doubleList.removeAll(doubleList);
		}
		
		if(!logL.isEmpty()) {
			logL.removeAll(logL);
		}
		
		JPanel logPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel allPanel = new JPanel(new BorderLayout());	
		JFrame logFrame =  new JFrame();
		
		Box hBox = Box.createVerticalBox();
		hBox.add(export);
		hBox.add(Box.createRigidArea(new Dimension(0,25)));
		hBox.add(exportAndDelete);
		
		export.setFont(new Font("Arial",Font.BOLD,20));
		export.setText("export data");
		export.setPreferredSize(new Dimension(50,50));
		
		exportAndDelete.setFont(new Font("Arial",Font.BOLD,20));
		exportAndDelete.setText("export and delete");
		exportAndDelete.setPreferredSize(new Dimension(50,30));
		
		close.setFont(new Font("Arial",Font.BOLD,20));
		close.setPreferredSize(new Dimension(50,50));
		Image logo = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		close.setIcon(new ImageIcon(logo));
		
		deleteRow.setFont(new Font("Arial",Font.BOLD,20));
		deleteRow.setText("delete row");
		deleteRow.setPreferredSize(new Dimension(50,50));
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(deleteRow);
		buttonBox.add(Box.createRigidArea(new Dimension(250,0)));
		buttonBox.add(hBox);
		buttonBox.add(Box.createRigidArea(new Dimension(300,0)));
		buttonBox.add(close);
		buttonBox.setPreferredSize(new Dimension(1000,150));
		buttonsPanel.setPreferredSize(new Dimension(1000,150));
		
		BufferedReader rowReader;
		
    	Vector<Vector> allLog = new Vector();
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			rowReader = new BufferedReader(isr);
			try {
			
				String currentRowLine = rowReader.readLine();
				
				while(currentRowLine!=null) {
					Vector<String> vLog = new Vector();
					String[] s = currentRowLine.split(",");
					for(String a: s) {
						vLog.add(a);
						
					}
					
					currentRowLine = rowReader.readLine();
					allLog.add(vLog);
					//System.out.println(allLog);
				}
				
				rowReader.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		System.out.println(allLog);
		DefaultTableModel model = new DefaultTableModel(allLog,column){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		    	
		    		return false;
		    }
		};
		JTable logTable = new JTable(model);
		
		 //sorter.setModel(model);
		 //logTable.setModel(model);
		 //logTable.setRowSorter(sorter);
		
		 logTable.setRowHeight(50);
		 logTable.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,25));
		 logTable.setFont(new Font("ARIAL", Font.BOLD, 20));
		 logTable.getTableHeader().setOpaque(false);
		 //logTable.getTableHeader().setPreferredSize(new Dimension(6800,30));
		 
		 
		 
		 //setColumnWidths(logTable,40);
		 
		 logTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		 
		 
		 
		resizeColumnWidth(logTable);
		//logTable.getColumnModel().getColumn(5).setWidth(9000);
		
		
		
		JComboBox<String> jComboBox = new JComboBox<>(column);
     	jComboBox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					selectedColumn = jComboBox.getSelectedIndex();
					
				}
     		
     	});
     	
     	JTextField searchField = new JTextField();
     	searchField.setPreferredSize(new Dimension(60,30));
     	JLabel searchlabel = new JLabel("Αναζήτηση:");
     	searchlabel.setFont(new Font("Arial",Font.BOLD,12));
     	Box searchBox = Box.createHorizontalBox();
     	selectedColumn = jComboBox.getSelectedIndex();
     	searchField.getDocument().addDocumentListener(new DocumentListener() {
     		
     		
             @Override
             public void insertUpdate(DocumentEvent e) {
                search(searchField.getText());
             }
             @Override
             public void removeUpdate(DocumentEvent e) {
                search(searchField.getText());
             }
             @Override
             public void changedUpdate(DocumentEvent e) {
                search(searchField.getText());
             }
             public void search(String str) {
                if (str.length() == 0) {
                   sorter.setRowFilter(null);
                } else {
             	  
                   sorter.setRowFilter(RowFilter.regexFilter(str,selectedColumn));
                }
             }
          });
     	
     	
     	searchBox.add(Box.createRigidArea(new Dimension(0,40)));
     	searchBox.add(searchlabel);
     	searchBox.add(Box.createRigidArea(new Dimension(10,0)));
     	searchBox.add(searchField);
     	searchBox.add(Box.createRigidArea(new Dimension(10,0)));
     	searchBox.add(jComboBox);
     	searchBox.setPreferredSize(new Dimension(60,30));
     	searchBox.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		  
		 
		JScrollPane pane = new JScrollPane(logTable);
		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
    	//Vertical Policy
    	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
    	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
    	pane.setVerticalScrollBarPolicy(vericalPolicy);
    	
    	pane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
    	pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 20));
    	
    	
    	
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				logFrame.dispose();
				
			}
			
		});
		
		
		deleteRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(logTable.getSelectedRows().length==0) {
					NoRowSelected gui = new NoRowSelected();
				}
				else {
					JFrame powerFrame=  new JFrame("Διαγραφή Γραμμής");
					JPanel panel = new JPanel();
					JLabel message = new JLabel("Είστε βέβαιος για την μόνιμη διαγραφή της γραμμής; ");
					
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
							String table = "logs_"+pcName.toLowerCase().replace("-", "_");
							int rowS = logTable.getSelectedRow();
							int id = Integer.parseInt(logTable.getValueAt(rowS, 0).toString());
							try {
								Connection connection = DriverManager.getConnection(url, uname, pass);
								Statement statement = connection.createStatement();
						        
						        String query = "delete from " +table+ " where idlogS=";
						        String last = query+ String.valueOf(id);
						        statement.executeUpdate(last);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					        	
	
							
							counter = 1;
							
							logL.add(0);
							
							int row = logTable.getSelectedRow()-1;
							if(row>0) {
							boxNoL = Integer.valueOf( logTable.getValueAt(row, 2).toString());
							paletteNoL = Integer.valueOf(logTable.getValueAt(row,3).toString());
							countItemsL = Integer.valueOf(logTable.getValueAt(row,22).toString());
							countBoxesL = Integer.valueOf(logTable.getValueAt(row,23).toString());
							countPalettesL = Integer.valueOf(logTable.getValueAt(row,24).toString());
							countAllPalettesL = Integer.valueOf(logTable.getValueAt(row,25).toString());
							countAllBoxesL = Integer.valueOf(logTable.getValueAt(row,26).toString());
							valueBoxLogL = Double.valueOf(logTable.getValueAt(row, 27).toString().replace(",", "."));
							valuePaletteLogL =Double.valueOf(logTable.getValueAt(row, 28).toString().replace(",", "."));
							valueForUseL = Double.valueOf(logTable.getValueAt(row, 29).toString().replace(",", "."));
							weightBoxLogL =Double.valueOf(logTable.getValueAt(row, 15).toString().replace(",", "."));
							weightPaletteLogL = Double.valueOf(logTable.getValueAt(row, 16).toString().replace(",", "."));
							sumWeightL = Double.valueOf(logTable.getValueAt(row, 17).toString().replace(",", "."));
							
							
							}
							else {
								boxNoL = 1;
								paletteNoL = 1;
								countItemsL = 1;
								countBoxesL = 1;
								countPalettesL = 1;
								countAllPalettesL = 1;
								countAllBoxesL = 1;
								valueBoxLogL = 0.0;
								valuePaletteLogL =0.0;
								valueForUseL = 0.0;
								weightBoxLogL = 0.0;
								weightPaletteLogL = 0.0;
								sumWeightL = 0.0;
								
							}
							
							intList.add(boxNoL);
							intList.add(paletteNoL);
							intList.add(countItemsL);
							intList.add(countBoxesL);
							intList.add(countPalettesL);
							intList.add(countAllBoxesL);
							doubleList.add(valueBoxLogL);
							doubleList.add(valuePaletteLogL);
							doubleList.add(valueForUseL);
							
							removeSelectedFromTable(logTable);
							removeRecord(f,row);
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
		
		
		export.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int rand = ThreadLocalRandom.current().nextInt(0,10000);
				String sRand = String.valueOf(rand);
			
				Calendar cal = Calendar.getInstance();
	            SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	            String formatted = format1.format(cal.getTime());
					try {
						JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE");
						
						targetFile = new File(formatted+sRand);
						 excelFileChooser.setDialogTitle("Save As ..");
						 FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
				        excelFileChooser.setFileFilter(fnef);
				        excelFileChooser.setSelectedFile(targetFile);
				        int chooser = excelFileChooser.showSaveDialog(null);
			            //Check if save button has been clicked
			            if (chooser == JFileChooser.APPROVE_OPTION) {
			            	ExcelWrite(logTable,formatted+sRand+".xls");
						
			            }
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		           		
		           }
			
			
		});
		
		
		
		exportAndDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rand = ThreadLocalRandom.current().nextInt(0,10000);
				String sRand = String.valueOf(rand);
			
				Calendar cal = Calendar.getInstance();
	            SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	            String formatted = format1.format(cal.getTime());
					try {
						JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE");
						
						targetFile = new File(formatted+sRand+"exportDeleteData");
						 excelFileChooser.setDialogTitle("Save As ..");
						 FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
				        excelFileChooser.setFileFilter(fnef);
				        excelFileChooser.setSelectedFile(targetFile);
				        int chooser = excelFileChooser.showSaveDialog(null);
			            //Check if save button has been clicked
			            if (chooser == JFileChooser.APPROVE_OPTION) {
			            	
			            	
			            	String table = "logs_"+pcName.toLowerCase().replace("-", "_");
							
							try {
								Connection connection = DriverManager.getConnection(url, uname, pass);
								Statement statement = connection.createStatement();
						        
						        String query = "delete from " +table;
						        
						        statement.executeUpdate(query);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
							for(int i=0;i<logTable.getRowCount();i++) {
								
								String id = logTable.getValueAt(i,0).toString();
								String order = logTable.getValueAt(i,1).toString();
								String boxNo = logTable.getValueAt(i,2).toString();
								String palleteNo = logTable.getValueAt(i,3).toString();
								String itemCode = logTable.getValueAt(i,4).toString();
			    				String description = logTable.getValueAt(i, 5).toString();
			    				String lot = logTable.getValueAt(i, 6).toString();
			    				String tare = logTable.getValueAt(i, 7).toString();
			    				String weight = logTable.getValueAt(i, 8).toString();
			    				String gross = logTable.getValueAt(i, 9).toString();
			    				String productionDate = logTable.getValueAt(i, 10).toString();
			    				String packagingDate = logTable.getValueAt(i, 11).toString();
			    				String exparationDate = logTable.getValueAt(i, 12).toString();
			    				String creationDate = logTable.getValueAt(i, 13).toString();
			    				String paletteFull = logTable.getValueAt(i, 14).toString();
			    				String weightBox = logTable.getValueAt(i, 15).toString();
			    				String weightPalette = logTable.getValueAt(i, 16).toString();
			    				String weightAll = logTable.getValueAt(i, 17).toString();
			    				String barcodeWeight = logTable.getValueAt(i,18).toString();
			    				String barcodeWeightBox = logTable.getValueAt(i,19).toString();
			    				String barcodeWeightPalette = logTable.getValueAt(i,20).toString();
			    				String barcodeWeightAll = logTable.getValueAt(i,21).toString();
			    				String countItems = logTable.getValueAt(i,22).toString();
			    				String countItemsInBox = logTable.getValueAt(i,23).toString();
			    				String countBoxesInPalette = logTable.getValueAt(i,24).toString();
			    				String countAllPalettes = logTable.getValueAt(i,25).toString();
			    				String countAllBoxes = logTable.getValueAt(i,26).toString();
			    				String valueBox = logTable.getValueAt(i,27).toString();
			    				String valuePalette = logTable.getValueAt(i,28).toString();
			    				String valueAll = logTable.getValueAt(i,29).toString();
			    				String user = logTable.getValueAt(i,30).toString();
			    				String pcName = logTable.getValueAt(i,31).toString();
			    				
			    				String table1 = "exports_"+pcName.toLowerCase().replace("-", "_");
			    				
			    				String query = "insert into "+table1+"(exports_id,idLogS,orderS,boxNo,paletteNo,itemCode,description,lot,tare,weight,gross,productionDate,packagingDate,exparationDate,creationDate,paletteFull,weightBox,weightPalette,weightAll,barcodeWeight,barcodeWeightBox,barcodeWeightPalette,barcodeWeightAll,countItems,countItemsInBox,countBoxesInPalette,countAllPalettes,countAllBoxes,valueBox,valuePalette,valueAll,user,pcName) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    				Connection con1 = DriverManager.getConnection(url,uname,pass);
								PreparedStatement preparedStmt = con1.prepareStatement(query);
								
								System.out.println(exportId + " This is the exportId");
								
			    				 preparedStmt.setInt(1, exportId);
			    				 preparedStmt.setString(2,id);	  
			    				 preparedStmt.setString(3,order);
			    				 preparedStmt.setString(4,boxNo);
			    				 preparedStmt.setString(5,palleteNo);
			    				 preparedStmt.setString(6,itemCode);
			    				 preparedStmt.setString(7,description);
			    				 preparedStmt.setString(8,lot);
			    				 preparedStmt.setString(9,tare);
			    				 preparedStmt.setString(10,weight);
			    				 preparedStmt.setString(11,gross);
			    				 preparedStmt.setString(12,productionDate);
			    				 preparedStmt.setString(13,packagingDate);
			    				 preparedStmt.setString(14,exparationDate);
			    				 preparedStmt.setString(15,creationDate);
			    				 preparedStmt.setString(16,paletteFull);
			    				 preparedStmt.setString(17,weightBox);
			    				 preparedStmt.setString(18,weightPalette);
			    				 preparedStmt.setString(19,weightAll);
			    				 preparedStmt.setString(20,barcodeWeight);
			    				 preparedStmt.setString(21,barcodeWeightBox);
			    				 preparedStmt.setString(22,barcodeWeightPalette);
			    				 preparedStmt.setString(23,barcodeWeightAll);
			    				 preparedStmt.setString(24,String.valueOf(countItems));
			    				 preparedStmt.setString(25,String.valueOf(countItemsInBox));
			    				 preparedStmt.setString(26,String.valueOf(countBoxesInPalette));
			    				 preparedStmt.setString(27,String.valueOf(countAllPalettes));
			    				 preparedStmt.setString(28,String.valueOf(countAllBoxes));
			    				 preparedStmt.setString(29,String.valueOf(valueBox));
			    				 preparedStmt.setString(30,String.valueOf(valuePalette));
			    				 preparedStmt.setString(31,String.valueOf(valueAll));
			    				 preparedStmt.setString(32,user);
			    				 preparedStmt.setString(33,pcName);
			    				 preparedStmt.executeUpdate();
			    				exportId+=1;
							}
							
							
							
							}catch(SQLException e1) {
								e1.printStackTrace();
							}
			            	
						ExcelWrite(logTable,formatted+sRand+".xls");
						 DefaultTableModel m = (DefaultTableModel) logTable.getModel();
				           for(int i = logTable.getRowCount() - 1; i >=0; i--) {
				        	   m.removeRow(i);
				           }
				           deleteFile(f);
				           
				           
				            boxNoL = 1;
							paletteNoL = 1;
							countItemsL = 1;
							countBoxesL = 1;
							countPalettesL = 1;
							countAllPalettesL = 1;
							countAllBoxesL = 1;
							valueBoxLogL = 0.0;
							valuePaletteLogL =0.0;
							valueForUseL = 0.0;
							weightBoxLogL = 0.0;
							weightPaletteLogL = 0.0;
							sumWeightL = 0.0;
							
							intList.add(boxNoL);
							intList.add(paletteNoL);
							intList.add(countItemsL);
							intList.add(countBoxesL);
							intList.add(countPalettesL);
							intList.add(countAllBoxesL);
							doubleList.add(valueBoxLogL);
							doubleList.add(valuePaletteLogL);
							doubleList.add(valueForUseL);
							doubleList.add(weightBoxLogL);
							doubleList.add(weightPaletteLogL);
							doubleList.add(sumWeightL);
							
				           logL.add(0);
			            }
			           
			           
			            
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			
		});
		
		
		buttonsPanel.add(buttonBox);
		//allPanel.add(searchBox,BorderLayout.PAGE_START);
		allPanel.add(pane,BorderLayout.CENTER);
		allPanel.add(buttonsPanel,BorderLayout.PAGE_END);
		logFrame.add(allPanel);
		logFrame.setUndecorated(true);
		logFrame.setResizable(false);
		logFrame.pack();
		logFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		logFrame.setLocationRelativeTo(null);
		logFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		logFrame.setResizable(false);
		logFrame.setVisible(true);
		
		
	}
	
	
	
	public String getComputerName() {
									
	    Map<String, String> env = System.getenv();
	    if (env.containsKey("COMPUTERNAME"))
	        return env.get("COMPUTERNAME");
	    else if (env.containsKey("HOSTNAME"))
	        return env.get("HOSTNAME");
	    else
	        return "Unknown Computer";
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
	
	public static void tweakColumns(JTable table){
	    Enumeration<TableColumn> columns = table.getColumnModel().getColumns();

	    int required = 0;
	    while(columns.hasMoreElements()){
	        TableColumn column = columns.nextElement();
	        int width = (int)table.getTableHeader().getDefaultRenderer()
	                    .getTableCellRendererComponent(table, column.getIdentifier()
	                            , false, false, -1, column.getModelIndex()).getPreferredSize().getWidth();
	        required += width;
	    }

	    JViewport viewport = (JViewport)SwingUtilities.getAncestorOfClass(JViewport.class, table);
	    int viewportWidth = viewport.getWidth();
	    table.setAutoResizeMode(required<viewportWidth ? JTable.AUTO_RESIZE_ALL_COLUMNS : JTable.AUTO_RESIZE_OFF);
	}
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 10; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        width = Math.max(width, table.getColumnModel().getColumn(column).getPreferredWidth());
	        if(width > 1500)
	            width=1500;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	public void removeRecord(File currentFile, int position ) {
		
		
		File nFile = new File("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\temp.txt");
		BufferedWriter rowWriter;
		BufferedReader rowReader;
    	
    	int counter = -1;
    	String currentRowLine;
		try {
			FileOutputStream fos = new FileOutputStream(nFile,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			rowWriter = new BufferedWriter(osw);
			
			FileInputStream fis = new FileInputStream(currentFile);
			InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
			rowReader = new BufferedReader(isr);
			
			try {
			
				 rowReader.readLine();
			
				while((currentRowLine = rowReader.readLine())!=null) {
					counter++;
					if(counter!=position) {
						rowWriter.write(currentRowLine);
						rowWriter.newLine();
					}
					
				}
				
				
				rowReader.close();
				rowWriter.close();
				
				currentFile.delete();
				File dump = new File("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\log_file.txt");
				nFile.renameTo(dump);
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
	}
	
	
	public void deleteFile(File currentFile) {
		
		FileWriter fw;
		try {
			fw = new FileWriter(currentFile);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush(); 
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	public void ExcelWrite(JTable table,String file) throws WriteException {
		
 		WritableWorkbook workbook = null;

        try {

        	workbook = Workbook.createWorkbook(new File(file));

            // create an Excel sheet
            WritableSheet excelSheet = workbook.createSheet("JTable Data", 0);
           
            TableModel m = table.getModel();
            for(int i = 0; i < m.getColumnCount(); i++){
 
            Label label1 = new Label(i, 0, m.getColumnName(i));
            excelSheet.addCell(label1);
            }
            
            for(int i=0;i<=table.getRowCount()-1;i++) {
            	for(int j=0;j<=table.getColumnCount()-1;j++) {
            		
            		Label myLabel = new Label(j,i+1,table.getValueAt(i, j).toString());
            		excelSheet.addCell(myLabel);
            		
            	}
            }
            
            workbook.write();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
	        
       }
        
		

 	}
	
	
	


}
