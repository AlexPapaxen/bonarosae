import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.Vector;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;


import com.idautomation.linear.*;
import com.idautomation.linear.encoder.*;


public class GUI  {
	
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private JPanel northFlowLayoutPanel;
    private JPanel southBorderLayoutPanel;
    private JPanel centerGridBagLayoutPanel;
    private JPanel westBoxLayoutPanel;
    private JPanel eastGridLayoutPanel;
    private OutputStream outputstream;
	private static String netDataBuffer = " ";
	private static String grossDataBuffer = " ";
	private static ArrayList<String> datesList = new ArrayList<>();
	private InputStream input;
	private long bytesToRead;
	private static JLabel userLoggedIn = new JLabel();
	private static ArrayList<String> arrayList = new ArrayList<>();
	private static ArrayList<String> raw = new ArrayList<>();
	private static int select=0;
    private SerialPort port;
    private static int logCounter;
    private static ArrayList<String> grossWeightsList = new ArrayList<String>();
    private static ArrayList<Integer> id = new ArrayList<>();
    private static ArrayList<Integer> selectedRow = new ArrayList<>();
    private final JLabel onomaParaggelias = new JLabel();
    private final JLabel copywrite = new JLabel("�2022 Alexandros Papaxenidis");
    private final JLabel autoprintLabel = new JLabel("AUTO PRINT");
    private final JButton tare = new JButton("TARE");
    private final JButton plu = new JButton("PLU");
    private final JButton lot = new JButton("LOT");
    private final JButton logfile = new JButton("LOG");
    private final JButton print = new JButton();
    private final JButton order = new JButton("ORD");
    private final SwitchButton autoprint = new SwitchButton();
    private final JButton zeroingButton = new JButton();
    private final JButton powerButton = new JButton();
    private final JLabel etiketaBarcode = new JLabel();
    private final JButton swipeLeft = new JButton();
    private final JButton swipeRight = new JButton();
    private final JLabel  onomaetiketas = new JLabel();
    private final JLabel name = new JLabel("ΟΝΟΜΑ ΕΤΙΚΕΤΑΣ : ");
    private static JLabel netWeight = new JLabel("hi");
    private static JLabel net = new JLabel();
    private static final JLabel grossWeight = new JLabel("0,00");
    private static final JLabel tareLabel=  new JLabel("00,00");
    private final JLabel netText = new JLabel("Net (Kg)");
    private final JLabel grossText = new JLabel("Gross (Kg)");
    private final JLabel tareText = new JLabel("Tare (Kg)");
    private final JToggleButton auto = new JToggleButton("DS");
    private final JButton users = new JButton();
    private final JLabel northLabel = new JLabel();
    private final JLabel northIconLabel = new JLabel();
    private String rawString="";
    private final JLabel counter = new JLabel("1");
    private final JLabel pickSize = new JLabel();
    private final JButton swipeSizeLeft = new JButton();
    private final JButton swipeSizeRight = new JButton();
    private final JButton swipeDateLeft = new JButton();
    private final JButton swipeDateRight = new JButton();
    private final JButton closeBox = new JButton("CLOSE");
    private final JButton pluEdit = new JButton("PLU edit");
    private final JButton dates = new JButton();
    private final JLabel pieces = new JLabel("pieces");
    private final JLabel weightPiece = new JLabel("weight");
    private final JLabel valuePiece = new JLabel("value");
    private final JLabel boxesPiece = new JLabel("boxes");
    private final JLabel weight = new JLabel("weight");
    private final JLabel value = new JLabel("value");
    private final JLabel boxes = new JLabel("boxes");
    private final JLabel outofPiece = new JLabel();
    private final JLabel outofBox = new JLabel();
    private static final JLabel piecesLabel = new JLabel();
    private static final JLabel weightPieces = new JLabel("0.00");
    private static final JLabel pricePieces = new JLabel("0.00");
    private static final JLabel boxesLabel = new JLabel();
    private static final JLabel weightBoxes = new JLabel("0.00");
    private static final JLabel priceBoxes = new JLabel("0.00");
    private final JLabel piecesName = new JLabel("pieces per box");
    private final JLabel boxesName = new JLabel("boxes per palett");
    private final JButton add = new JButton();
    private final JButton swipeLeftCounter = new JButton();
    private final JLabel sizeLabel = new JLabel("package");
    private final JLabel copies = new JLabel("copies");
    private final JLabel datesLabel = new JLabel("production");
    private final ArrayList<String> myDates = new ArrayList<>();
    private static int count = 0;
    private static boolean flag = true;
    private static int logId = 0;
    private static String orderName = "";
    private static double netValue = 0.0;
    private static double grossValue = 0.0;
    private static int boxNo = 0;
    private static int paletteNo = 1;
    private static int countItems = 0;
    private static int countBoxes = 0;
    private static int countPalettes = 1;
    private static int countAllBoxes = 1;
    private static int countAllPalettes = 1;
    private static double weightBoxLog = 0.0;
    private static double weightPaletteLog = 0.0;
    private static double weightPieceLog = 0.0;
    private static double sumWeight = 0.0;
    private static double valueLog = 0.0;
    private static double valuePaletteLog = 0.0;
    private static double valueBoxLog = 0.0;
    private static double valueForUse = 0.0;
    private static String palleteFull = "0";
    private static int countPPB = 0;
    private static int countBPP = 0;
    private static int countForppb = 0;
    private static int countForbpp=0;
    private static double init;
    private static double netV;
    private static double sumP = 0.0;
	private static double sumV = 0.0;
	private static char[] charArray;
    private static int full =0;
    private static int countPrint;
    private static Timer timer = new Timer(0, null);
    private final ArrayList<String> sizeArray = new ArrayList<>();
    private final JButton orderCreation = new JButton("����������");
    private ArrayList<Vector> logList = new ArrayList<>();
    private static ArrayList<String> orderListLog = new ArrayList<>();
    private static ArrayList<String> logFile = new ArrayList<>();
    private ArrayList<Integer> logfileList = new ArrayList<>();
    private ArrayList<String> datesLogList = new ArrayList<>();
    private ArrayList<String> nameLog = new ArrayList<>();
    private static final short VENDOR_ID = 0x2d84;
    private static final short PRODUCT_ID =(short) 0xb468;
    private static ArrayList<Boolean> flagList = new ArrayList<>();
    private final JButton settingsButton = new JButton("Settings");
    private static ArrayList<Integer> intList = new ArrayList<>();
    private static ArrayList<Double> doubleList = new ArrayList<>();
    private static ArrayList<Integer> logL = new ArrayList<>();
    private static String actualPCName = "";
    private GridBagConstraints c = new GridBagConstraints();
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
    private GridBagConstraints c11 = new GridBagConstraints();
    private GridBagConstraints c12 = new GridBagConstraints(); 
    private JLabel username = new JLabel("User: ");
    private File f2 = new File("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\log_file.txt");
    private static ArrayList<Integer> selection = new ArrayList<>();
    
    private void zeroRequest(SerialPort port) {
		
		outputstream = port.getOutputStream();
		
		String datatosend = "$01z7b."; 
		
		
		try {
		
		outputstream.write(datatosend.getBytes());
		outputstream.flush();
	}	catch(IOException e){
		JOptionPane.showInputDialog(this,e.getMessage());
	}

}
    
    
    public void grossWeightRequest(SerialPort port) {
		
		outputstream = port.getOutputStream();
		
		String datatosend = "$01t75."; 
		
		
		try {
		
		outputstream.write(datatosend.getBytes());
		outputstream.flush();
	}	catch(IOException e){
		JOptionPane.showInputDialog(this,e.getMessage());
	}

}
    
    public void weightRequest(SerialPort port,String arrayList) {
    	
    	outputstream = port.getOutputStream();
    	
    	
    	try {
    	
    	outputstream.write(arrayList.getBytes());
    	outputstream.flush();
    }	catch(IOException e){
    	JOptionPane.showInputDialog(this,e.getMessage());
    }

    }
    
   
    
	/*
	 * public void Serial_EventBasedReading(SerialPort activePort,
	 * ArrayList<Boolean> flagList) { activePort.addDataListener(new
	 * SerialPortDataListener() {
	 * 
	 * @Override public int getListeningEvents() { // TODO Auto-generated method
	 * stub return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }
	 * 
	 * @Override public void serialEvent(SerialPortEvent arg0) {
	 * 
	 * 
	 * if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED &&
	 * selection.get(0)==0) {
	 * 
	 * 
	 * byte[] buffer1 = arg0.getReceivedData(); double dNet = 0.0; double dTare =
	 * 0.0; String last=""; for(int i =0;i<buffer1.length;i++) {
	 * 
	 * if(i==3 || i==4 || i==5 || i==6 || i==7 || i==8) {
	 * rawString+=(char)buffer1[i]; System.out.println(rawString); } if(i==4 || i==5
	 * || i==6 || i==7) {
	 * 
	 * 
	 * netDataBuffer+=(char)buffer1[i];
	 * 
	 * if(netDataBuffer.length()==2) { netDataBuffer+=",";
	 * 
	 * } if(netDataBuffer.equals("00,00")) { countPrint=1;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * if(tareLabel.getText().equals("00,00")) { net.setText(netDataBuffer); } else
	 * { dTare = Double.parseDouble(tareLabel.getText().replace(",","." )); dNet =
	 * Double.parseDouble(netDataBuffer.replace(",","."))- dTare; last =
	 * String.format("%.3g%n", dNet); net.setText(last.replace(".", ",")); }
	 * 
	 * arrayList.add(netDataBuffer); String gross =
	 * String.format("%.5s%n",netDataBuffer); grossWeight.setText(gross);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * raw.add(rawString); grossWeightsList.add(netDataBuffer); netDataBuffer="";
	 * rawString="";
	 * 
	 * if(!flagList.isEmpty()) { grossWeightRequest(activePort); }
	 * 
	 * 
	 * } if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED &&
	 * selection.get(0)==1) { byte[] buffer2 = arg0.getReceivedData();
	 * System.out.println("selection is" + selection.get(0)); char c3 =
	 * (char)buffer2[3]; char c4 = (char)buffer2[4]; char c5 = (char)buffer2[5];
	 * char c6 = (char)buffer2[6]; char c7 = (char)buffer2[7]; char c8 =
	 * (char)buffer2[8]; String data = "";
	 * 
	 * for(int i=0;i<buffer2.length;i++) { data+=(char)buffer2[i];
	 * System.out.println(data); }
	 * 
	 * }
	 * 
	 * if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED &&
	 * selection.get(0)==2) { //char[] charArray = .toCharArray();
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * });
	 * 
	 * 
	 * }
	 */
    
    
    public class myListener implements SerialPortDataListener{
		
    	

    	@Override
    	public int getListeningEvents() {
    		// TODO Auto-generated method stub
    		return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    	}

    	@Override
    	public void serialEvent(SerialPortEvent arg0) {
    		
    		
    		if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED && selection.get(0)==0) {
    			
			
    			 byte[] buffer1 = arg0.getReceivedData();
    				double dNet = 0.0;
    				double dTare = 0.0;
    				String last="";
    				
    			   for(int i =0;i<buffer1.length;i++) {
    				  
    				   if(i==3 || i==4 || i==5 || i==6 || i==7 || i==8) {
    			    		rawString+=(char)buffer1[i];
    			    		System.out.println(rawString);
    			    	}
    				    if(i==4 || i==5 || i==6 || i==7) {
    				    
    				    	
    				    netDataBuffer+=(char)buffer1[i];
    			    	
    			    	if(netDataBuffer.length()==2) {
    			    		netDataBuffer+=",";
    			    		
    			    	}
    			    	if(netDataBuffer.equals("00,00")) {
    			    		countPrint=1;
    			    		
    			    	}
    			    		

    			    	
    			    	if(tareLabel.getText().equals("00,00")) {
    			    		net.setText(netDataBuffer);
    			    	}
    			    	else {
    			    		dTare = Double.parseDouble(tareLabel.getText().replace(",","." ));
    			    		dNet = Double.parseDouble(netDataBuffer.replace(",","."))- dTare;
    			    		last = String.format("%.3g%n", dNet);
    			    		net.setText(last.replace(".", ","));
    			    	}
    			    	
    			    	arrayList.add(netDataBuffer);
    			    	String gross = String.format("%.5s%n",netDataBuffer);
    			    	grossWeight.setText(gross);
    			    	
    				    }
    				    
    			   }
    			
    			   raw.add(rawString);
    			   charArray = raw.get(raw.size()-1).toCharArray();
    			   grossWeightsList.add(netDataBuffer);
    			   netDataBuffer="";
    			   rawString="";
    			    
    			 	if(!flagList.isEmpty()) {
    			 		grossWeightRequest(port);
    			 	}
    			  
    			
    			}
    		if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED && selection.get(0)==1) {
    			byte[] buffer1 = arg0.getReceivedData();
				char c3 = (char)buffer1[3];
				char c4 = (char)buffer1[4];
				char c5 = (char)buffer1[5];
				char c6 = (char)buffer1[6];
				char c7 = (char)buffer1[7];
				char c8 = (char)buffer1[8];
				String data = "";
				
				for(int i=0;i<buffer1.length;i++) {
					data+=(char)buffer1[i];
					System.out.println(data);
				}
				
				JOptionPane.showMessageDialog(null, "Επιτυχής καλιμπράρισμα! ");
    		}
    		if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED && selection.get(0)==2) {
    			
    			byte[] buffer1 = arg0.getReceivedData();
				char c3 = (char)buffer1[3];
				char c4 = (char)buffer1[4];
				char c5 = (char)buffer1[5];
				char c6 = (char)buffer1[6];
				char c7 = (char)buffer1[7];
				char c8 = (char)buffer1[8];
				String buff="";
				
				for(int i=0;i<buffer1.length;i++) {
					buff+=(char)buffer1[i];
					System.out.println(buff);
				}
				if(c3==charArray[0] && c4==charArray[1] && c5==charArray[2] && c6==charArray[3] && c7==charArray[4] && c8==charArray[5]) {
					JOptionPane.showMessageDialog(null, "Επιτυχής καλιμπράρισμα! ");
				}
				else {
					JOptionPane.showMessageDialog(null, "Αποτυχία καλιμπραρίσματος, δοκιμάστε ξανά.");
				}
    		}
    		
    		}
    	}
    
    
    
    

    public GUI() {
    	
    	intList.add(boxNo);
    	intList.add(paletteNo);
    	intList.add(countItems);
    	intList.add(countBoxes);
    	intList.add(countPalettes);
    	intList.add(countAllPalettes);
    	intList.add(countAllBoxes);
    	
    	doubleList.add(valueBoxLog);
    	doubleList.add(valuePaletteLog);
    	doubleList.add(valueForUse);
    	
    	boolean flag = true;
    	flagList.add(flag);
		int num = 0;
		selection.add(num);
		
    		new Thread(new Runnable() {
    	    public void run() {
    	    	port = SerialPort.getCommPorts()[0];
    	    	port.setComPortParameters(9600, 8, 1, 0);
    	    	port.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1200, 1200);
    	    	port.openPort();
    	    	if(port.isOpen()) {
    	    		port.addDataListener(new myListener());
    	    		grossWeightRequest(port);
    	    		//Serial_EventBasedReading(port,flagList);
    	    	}
    	    	
    	    }
    	}).start();
   	
    	
    	if(datesList.isEmpty()) {
    		datesList.add("No PLU selected");
    		datesList.add("No PLU selected");
    		datesList.add("No PLU selected");
    	}
    	
    	myDates.add("production");
    	myDates.add("expire");
    	myDates.add("packing");
    	
    	
    	BufferedReader reader;
    	BufferedReader rowReader;
    	Vector<String> vLog = new Vector();
    	Vector<Vector> allLog = new Vector();
		try {
			File f = new File("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\idsList.txt");
			reader = new BufferedReader(new FileReader(f));
		
			try {
				String currentLine = reader.readLine();
				id.add(Integer.parseInt(currentLine));
			
				reader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			File f1 = new File("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\selectedRows.txt");
			rowReader = new BufferedReader(new FileReader(f1));
			try {
			
				String currentRowLine = rowReader.readLine();
				
				selectedRow.add(Integer.parseInt(currentRowLine));
				
				rowReader.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(f2);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			rowReader = new BufferedReader(isr);
			
			try {
			
				String currentRowLine = rowReader.readLine();
				
				while(currentRowLine!=null) {
					
						String[] s = currentRowLine.split(",");
						logId = Integer.parseInt(s[0]);
						orderName = s[1];
						boxNo =  Integer.valueOf(s[2]);         
						paletteNo = Integer.valueOf(s[3]);
						logFile.add(s[4]);
						logFile.add(s[5]);
						logFile.add(s[6]);
						logFile.add(s[7]);
						netValue = Double.valueOf(s[8]);
						grossValue = Double.valueOf(s[9]);
						datesLogList.add(s[10]);
						datesLogList.add(s[11]);
						datesLogList.add(s[12]);
						datesLogList.add(s[13]);
						palleteFull = s[14];
						weightBoxLog = Double.valueOf(s[15]);
						weightPaletteLog = Double.valueOf(s[16]);
						sumWeight = Double.valueOf(s[17]);
						logFile.add(s[18]);
						logFile.add(s[19]);
						logFile.add(s[20]);
						logFile.add(s[21]);
						countItems = Integer.parseInt(s[22]);
						countBoxes = Integer.parseInt(s[23]);
						countPalettes = Integer.parseInt(s[24]);
						countAllPalettes = Integer.parseInt(s[25]);
						countAllBoxes = Integer.parseInt(s[26]);
						valueBoxLog = Double.parseDouble(s[27]);
						valuePaletteLog =Double.parseDouble(s[28]);
						valueLog =Double.parseDouble(s[29]);
						valueForUse = Double.parseDouble(s[29]);
						
						currentRowLine = rowReader.readLine();
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
		
		
		
		
    	

		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();    		
    	}
		
		try {
			
			
    		Connection con =  DriverManager.getConnection(url,uname,pass);
    		Statement statement = con.createStatement();
    		String query = "select* from products where idProducts ="+id.get(id.size()-1)+"";
    		ResultSet result = statement.executeQuery(query);
    		
    		
    		Vector row = new Vector();
    		Vector data = new Vector();
    		while(result.next()) {
    			
    			row = new Vector(20);
    			for(int i=1;i<=20;i++) {
    				
    				row.add(result.getString(i));
    			}
    			
    		}
    		
    			outofPiece.setText("(of "+row.get(9).toString()+")");
    			outofBox.setText("(of "+row.get(10).toString()+")");
    		    piecesLabel.setText(String.valueOf(countPPB));
    		    boxesLabel.setText(String.valueOf(countBPP));
    		    pricePieces.setText(row.get(3).toString().replace(",", "."));
    		    priceBoxes.setText(row.get(3).toString().replace(",", "."));
    		    sumP = Double.valueOf( pricePieces.getText().replace(",", "."));
				 sumV = Double.valueOf(priceBoxes.getText().replace(",", "."));
    		    countForppb = Integer.parseInt(row.get(9).toString());
    		    countForbpp = Integer.parseInt(row.get(10).toString());
    		    
    			datesList.removeAll(datesList);
    			if(logFile.isEmpty()) {
    			logFile.add(row.get(0).toString());
    			logFile.add(row.get(2).toString());
    			logFile.add(row.get(6).toString());
    			logFile.add(row.get(8).toString());
    			logFile.add(row.get(10).toString());
    			logFile.add(row.get(1).toString());
    			logFile.add(row.get(3).toString());
    			}
    			
    			datesList.add(row.get(5).toString());
    			datesList.add(row.get(18).toString());
    			datesList.add(row.get(19).toString());
    			dates.setText(datesList.get(0));
    			
    		
		}catch(SQLException e) {
    		e.printStackTrace();
	
		}
		
		try {
			String pcName = this.getComputerName().toLowerCase().replace("-", "_");
			Connection con =  DriverManager.getConnection(url,uname,pass);
    		Statement statement = con.createStatement();
			String log = "select* from logs_"+pcName;
			ResultSet result1 = statement.executeQuery(log);
			ResultSetMetaData rsmt = result1.getMetaData();
    		
    		int c = rsmt.getColumnCount();
    		
    		Vector column = new Vector(c);
    		for(int i=1;i<=c;i++) {
    			column.add(rsmt.getColumnName(i));
    		}
			
			logList.add(column);
		}catch(SQLException e5) {
			e5.printStackTrace();
		}
		
		
		try {
			String pc = this.getComputerName();
			actualPCName = pc;
			Connection con =  DriverManager.getConnection(url,uname,pass);
    		Statement statement = con.createStatement();
			String log = "select* from alllogs_table";
			ResultSet result1 = statement.executeQuery(log);
			ResultSetMetaData rsmt = result1.getMetaData();
    		
    		int c = rsmt.getColumnCount();
    		Vector data = new Vector();	
    		Vector column = new Vector(c);
    		
    		while(result1.next()) {
    		for(int i=1;i<=c;i++) {
    			if(i==1) {
    				logfileList.add(Integer.parseInt(result1.getString(i)));
    			}
    			if(i==2) {
    				nameLog.add(result1.getString(i));
    			}
    			
    		}
    	}
			
    		if(!nameLog.contains(pc)) {
    			this.createLOGTable(statement, con, result1, pc.toLowerCase().replace("-", "_"));
    			this.createEXPORTable(statement, con, result1, pc.toLowerCase().replace("-", "_"));
    			
    			try {
    				
    				String pcn = this.getComputerName();
    				
    				Connection con1 =  DriverManager.getConnection(url,uname,pass);
    				String log1 = "insert into alllogs_table () values (?,?)";
    				PreparedStatement preparedStmt = con1.prepareStatement(log1);
    				int id = logfileList.get(logfileList.size()-1) + 1;
    				
    				  preparedStmt.setInt(1, id);
    				  preparedStmt.setString(2,pcn);
    				  preparedStmt.executeUpdate();
    			}catch(SQLException e5) {
    				e5.printStackTrace();
    			}
    			
    			try {
    				
    				String pcn = this.getComputerName();
    				
    				Connection con1 =  DriverManager.getConnection(url,uname,pass);
    				String log1 = "insert into allexports_table () values (?,?)";
    				PreparedStatement preparedStmt = con1.prepareStatement(log1);
    				int id = logfileList.get(logfileList.size()-1) + 1;
    				
    				  preparedStmt.setInt(1, id);
    				  preparedStmt.setString(2,pcn);
    				  preparedStmt.executeUpdate();
    			}catch(SQLException e5) {
    				e5.printStackTrace();
    			}
    			

    		}
    		
		}catch(SQLException e5) {
			e5.printStackTrace();
		}
		

		
		


    	Image dateLeft = new ImageIcon(this.getClass().getResource("/left_date.png")).getImage();
		swipeDateLeft.setIcon(new ImageIcon(dateLeft));
		
		Image dateRight = new ImageIcon(this.getClass().getResource("/right_date.png")).getImage();
		swipeDateRight.setIcon(new ImageIcon(dateRight));
    	
    	
		Color southColor = new Color(129,140,157,255);
		
		Color labelColor = new Color(199,199,199,255);
		
    	//������������ South Panel
    	southBorderLayoutPanel = new JPanel();
        
        
        //Boxes ��� ������� �������
    	Box southBox1 = Box.createVerticalBox();
    	Box southBox2 = Box.createVerticalBox();
    	Box southBox3 = Box.createVerticalBox();
    	Box southBox4 = Box.createVerticalBox();
    	
    	
    	
    	//North Layout Panel ������������
        northFlowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northFlowLayoutPanel.setBackground(southColor);
        
        Image north = new ImageIcon(this.getClass().getResource("/bonaros_no_back.png")).getImage();
        northLabel.setIcon(new ImageIcon(north));
        northLabel.setLocation(10, 100);
       
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        northIconLabel.setText(dtf.format(now).toString());
        northIconLabel.setFont(new Font("Arial",Font.BOLD,15));
        northIconLabel.setForeground(Color.black);
        northIconLabel.setOpaque(false);
        
        //Boxes for pieces-boxes labels (center layout)
        Box fieldBox1 = Box.createHorizontalBox();
        
        
        fieldBox1.setBackground(Color.white);
        fieldBox1.setOpaque(true);
        fieldBox1.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldBox1.setPreferredSize(new Dimension(100,400));
        Box fieldBox2 = Box.createHorizontalBox();
        fieldBox2.setBackground(Color.white);
        fieldBox2.setOpaque(true);
        fieldBox2.setBorder(BorderFactory.createLineBorder(Color.black));
        fieldBox2.setPreferredSize(new Dimension(100,400));
      
    
        Box h1Box = Box.createVerticalBox();
        
        
       
        piecesName.setFont(new Font("Aral",Font.ITALIC,20));
        
       
        pieces.setPreferredSize(new Dimension(50,20));
        pieces.setFont(new Font("Arial",Font.PLAIN,14));
        
        piecesLabel.setPreferredSize(new Dimension(50,20));
        
        h1Box.add(piecesName);
        h1Box.add(Box.createRigidArea(new Dimension(0,5)));
        h1Box.add(pieces);
        h1Box.add(Box.createRigidArea(new Dimension(0,20)));
        h1Box.add(weightPiece);
        h1Box.add(Box.createRigidArea(new Dimension(0,20)));
        h1Box.add(valuePiece);
        h1Box.add(Box.createRigidArea(new Dimension(0,20)));
        h1Box.setPreferredSize(new Dimension(200,50));        
        
        Box h2Box = Box.createVerticalBox();
        weightPiece.setFont(new Font("Aria",Font.PLAIN,14));
        h2Box.add(Box.createRigidArea(new Dimension(0,25)));
        h2Box.add(piecesLabel);
        h2Box.add(Box.createRigidArea(new Dimension(0,25)));
        h2Box.add(weightPieces);
        h2Box.add(Box.createRigidArea(new Dimension(0,25)));
        h2Box.add(pricePieces);
       // h2Box.add(Box.createRigidArea(new Dimension(0,20)));
        
        //h1Box.setPreferredSize(new Dimension(80,80));
        h2Box.setPreferredSize(new Dimension(80,40));
       // h3Box.setPreferredSize(new Dimension(80,40));
        JLabel temp = new JLabel();
        Box h6Box = Box.createVerticalBox();
        
        outofPiece.setPreferredSize(new Dimension(50,20));
        h6Box.add(outofPiece);
        h6Box.add(Box.createRigidArea(new Dimension(0,58)));
        h6Box.add(temp);
        
        
        
        fieldBox1.add(Box.createRigidArea(new Dimension(10,0)));
        fieldBox1.add(h1Box);
        fieldBox1.add(Box.createRigidArea(new Dimension(80,0)));
        fieldBox1.add(h2Box);
        fieldBox1.add(h6Box);      
        
        Box h4Box = Box.createVerticalBox();
        
        boxes.setFont(new Font("Arial",Font.PLAIN,14));
        
        h4Box.add(boxesName);
        h4Box.add(Box.createRigidArea(new Dimension(0,5)));
        h4Box.add(boxes);
        h4Box.add(Box.createRigidArea(new Dimension(0,20)));
        h4Box.add(weight);
        h4Box.add(Box.createRigidArea(new Dimension(0,20)));
        h4Box.add(value);
      
        
        h4Box.setPreferredSize(new Dimension(160,80));
        
        Box h5Box = Box.createVerticalBox();
        weight.setFont(new Font("Arial",Font.PLAIN,14));
        h5Box.add(Box.createRigidArea(new Dimension(0,25)));
        h5Box.add(boxesLabel);
        h5Box.add(Box.createRigidArea(new Dimension(0,25)));
        h5Box.add(weightBoxes);
        h5Box.add(Box.createRigidArea(new Dimension(0,25)));
        h5Box.add(priceBoxes);
        
        h5Box.setPreferredSize(new Dimension(80,40));
        
        JLabel tempBox = new JLabel();
        Box h3Box = Box.createVerticalBox();
        outofBox.setPreferredSize(new Dimension(50,20));
        h3Box.add(outofBox);
        h3Box.add(Box.createRigidArea(new Dimension(0,58)));
        h3Box.add(tempBox);
        
        boxesName.setFont(new Font("Arial",Font.ITALIC,20));
        fieldBox2.add(Box.createRigidArea(new Dimension(10,0)));
        fieldBox2.add(h4Box);
        fieldBox2.add(Box.createRigidArea(new Dimension(80,0)));
        fieldBox2.add(h5Box);
        fieldBox2.add(h3Box);
        
        Box buttonBox = Box.createVerticalBox();
        closeBox.setPreferredSize(new Dimension(80,100));
        closeBox.setFont(new Font("Arial",Font.PLAIN,18));
        pluEdit.setFont(new Font("Arial",Font.PLAIN,18));
        
        buttonBox.add(closeBox);
        buttonBox.add(Box.createRigidArea(new Dimension(0,30)));
        buttonBox.add(pluEdit);
        buttonBox.setPreferredSize(new Dimension(100,100));
        
        Box hbBox = Box.createHorizontalBox();
        
        dates.setFont(new Font("Arial",Font.PLAIN,15));
        dates.setBorder(new RoundedBorder(4));
        dates.setBackground(Color.WHITE);
       
        swipeDateLeft.setPreferredSize(new Dimension(50,50));
       
        hbBox.add(swipeDateLeft);
        hbBox.add(Box.createRigidArea(new Dimension(10,0)));
        hbBox.add(dates);
        hbBox.add(Box.createRigidArea(new Dimension(10,0)));
        hbBox.add(swipeDateRight);
        
        
        Box hSBox = Box.createHorizontalBox();
        sizeArray.add("piece");
        sizeArray.add("box");
        sizeArray.add("palette");
        Image swipeLeftS = new ImageIcon(this.getClass().getResource("/left_date.png")).getImage();
		swipeSizeLeft.setIcon(new ImageIcon(swipeLeftS));
		
		Image swipeRightR = new ImageIcon(this.getClass().getResource("/right_date.png")).getImage();
		swipeSizeRight.setIcon(new ImageIcon(swipeRightR));
		sizeLabel.setFont(new Font("Arial",Font.PLAIN,12));
		pickSize.setOpaque(false);
		pickSize.setText("piece");
		pickSize.setFont(new Font("Arial",Font.PLAIN,18));
		pickSize.setPreferredSize(new Dimension(50,20));
        hSBox.add(swipeSizeLeft);
        hSBox.add(Box.createRigidArea(new Dimension(20,0)));
        hSBox.add(pickSize);
        hSBox.add(Box.createRigidArea(new Dimension(25,0)));
        hSBox.add(swipeSizeRight);
        
        Image swipeLeftCount = new ImageIcon(this.getClass().getResource("/left_date.png")).getImage();
		swipeLeftCounter.setIcon(new ImageIcon(swipeLeftCount));
		Image addIcon = new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
		add.setIcon(new ImageIcon(addIcon));
		
        Box hCBox = Box.createHorizontalBox();
        copies.setFont(new Font("Arial",Font.PLAIN,12));
        counter.setFont(new Font("Arial",Font.BOLD,20));
        counter.setOpaque(false);
        swipeLeftCounter.setEnabled(false);
        hCBox.add(swipeLeftCounter);
        hCBox.add(Box.createRigidArea(new Dimension(40,0)));
        hCBox.add(counter);
        hCBox.add(Box.createRigidArea(new Dimension(40,0)));
        hCBox.add(add);
        
        
        Box vBBox = Box.createVerticalBox();
        vBBox.add(hbBox);
        vBBox.add(Box.createRigidArea(new Dimension(0,20)));
        vBBox.add(hSBox);
        vBBox.add(Box.createRigidArea(new Dimension(0,20)));
        vBBox.add(hCBox);
        
        Box userBox = Box.createHorizontalBox();
        userBox.add(username);
        userBox.add(Box.createRigidArea(new Dimension(20,10)));
        userBox.add(userLoggedIn);
        
        Box northBox = Box.createHorizontalBox();
        northBox.add(northLabel);
        northBox.add(Box.createRigidArea(new Dimension(500,50)));
       
        
        Box vBox = Box.createVerticalBox();
        vBox.add(northIconLabel);
        vBox.add(Box.createRigidArea(new Dimension(0,10)));
        vBox.add(userBox);
        
        userLoggedIn.setFont(new Font("Arial",Font.BOLD,15));
        userLoggedIn.setForeground(labelColor);
        
        northFlowLayoutPanel.add(northBox);
        northFlowLayoutPanel.add(vBox);
        northFlowLayoutPanel.setBorder(BorderFactory.createTitledBorder(""));
        
        //Center Panel ������������
        centerGridBagLayoutPanel = new JPanel(new GridBagLayout());
        centerGridBagLayoutPanel.setBackground(southColor);
        
        //Box ��� ������� ��������� ��� ������������ West Panel
        Box box = Box.createVerticalBox();        
        westBoxLayoutPanel = new JPanel();
       

        //���������� box ��� ������� swipe
        Box swipeBox = Box.createHorizontalBox();
        
        
        //������������� ��������
        plu.setFont(new Font("Arial", Font.BOLD, 15));
        
        order.setFont(new Font("Arial", Font.BOLD, 15));
        lot.setFont(new Font("Arial", Font.BOLD, 15));
        tare.setFont(new Font("Arial", Font.BOLD, 15));
        logfile.setFont(new Font("Arial", Font.BOLD, 15));
        auto.setFont(new Font("Arial", Font.BOLD, 18));
        autoprintLabel.setFont(new Font("Arial", Font.BOLD, 15));
        settingsButton.setFont(new Font("Arial", Font.BOLD, 15));
        
        //Power Button Icon       
        Image powerImage = new ImageIcon(this.getClass().getResource("/on-off-button.png")).getImage();
		powerButton.setIcon(new ImageIcon(powerImage));
        powerButton.setPreferredSize(new Dimension(80,80));
        
        //Print Button Icon
        Image printImg = new ImageIcon(this.getClass().getResource("/label_printer.png")).getImage();
		print.setIcon(new ImageIcon(printImg));
        
		zeroingButton.setText(">0<");
		zeroingButton.setFont(new Font("Arial",Font.BOLD,30));
		
		
		//Users Button Icon
		Image userImg = new ImageIcon(this.getClass().getResource("user.png")).getImage();
		users.setIcon(new ImageIcon(userImg));
		
		//Panel and label creation for weight measuring
		JPanel tareLabelPanel = new JPanel();
		JPanel netLabelPanel = new JPanel();
		JPanel grossLabelPanel = new JPanel();
		
		tareLabelPanel.setBackground(Color.BLACK);
		netLabelPanel.setBackground(Color.BLACK);
		grossLabelPanel.setBackground(Color.BLACK);
		
		net.setFont(new Font("Arial",Font.BOLD,35));
		net.setOpaque(true);
		net.setForeground(Color.GREEN);
		net.setBackground(Color.BLACK);

		grossWeight.setFont(new Font("Arial",Font.BOLD,35));
		grossWeight.setOpaque(true);
		grossWeight.setForeground(Color.GREEN);
		grossWeight.setBackground(Color.BLACK);

		tareLabel.setFont(new Font("Arial",Font.BOLD,35));
		tareLabel.setOpaque(true);
		tareLabel.setForeground(Color.GREEN);
		tareLabel.setBackground(Color.BLACK);

		netText.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		netText.setPreferredSize(new Dimension(50,10));
		netText.setFont(new Font("Arial",Font.BOLD,15));
		
		grossText.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		grossText.setPreferredSize(new Dimension(50,10));
		grossText.setFont(new Font("Arial",Font.BOLD,15));
		
		tareText.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		tareText.setPreferredSize(new Dimension(50,10));
		tareText.setFont(new Font("Arial",Font.BOLD,15));

		grossLabelPanel.add(grossWeight);
		netLabelPanel.add(net);
		tareLabelPanel.add(tareLabel);

		
		// Swipe Left 
		Image swipe_l = new ImageIcon(this.getClass().getResource("/swipe_left.png")).getImage();
		swipeLeft.setIcon(new ImageIcon(swipe_l));
		
		// Swipe Right 
		Image swipe_r = new ImageIcon(this.getClass().getResource("/swipe_right.png")).getImage();
		swipeRight.setIcon(new ImageIcon(swipe_r));
		
		//Order 
		order.setPreferredSize(new Dimension(80,60));
		order.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		order.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Plu
		plu.setPreferredSize(new Dimension(80,60));
		plu.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//Lot
		lot.setPreferredSize(new Dimension(80,60));
		lot.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		//Tare
		tare.setPreferredSize(new Dimension(80,60));
		tare.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//Log file
		logfile.setPreferredSize(new Dimension(80,60));
		logfile.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//Users
		users.setPreferredSize(new Dimension(80,60));
		users.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		username.setFont(new Font("Arial",Font.BOLD,15));
        username.setForeground(labelColor);
        username.setOpaque(false);
		
		//AutoPrint 
		auto.setPreferredSize(new Dimension(80,60));
		auto.setMinimumSize(new Dimension(Short.MIN_VALUE,Short.MIN_VALUE));
		auto.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		//auto.setBackground(Color.RED);
		auto.setForeground(Color.RED);
		auto.setOpaque(true);
		auto.setBorderPainted(false);
		autoprintLabel.setPreferredSize(new Dimension (80,60));
		autoprintLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Print 
		print.setPreferredSize(new Dimension(80,60));
		print.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		print.setOpaque(false);
		print.setFocusPainted(false);
	    print.setContentAreaFilled(false);
		
		//Power Button
		powerButton.setPreferredSize(new Dimension(150,150));
		powerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		powerButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		powerButton.setMinimumSize(new Dimension(Short.MIN_VALUE,Short.MIN_VALUE));
		powerButton.setOpaque(false);
		powerButton.setFocusPainted(false);
		powerButton.setContentAreaFilled(false);
		
		//Settings button
	     settingsButton.setPreferredSize(new Dimension(100,60));
	     settingsButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	     
	     
	     //Swipe Left - Swipe Right edit
	     //swipeLeft.setPreferredSize(new Dimension(60,20));
	     swipeLeft.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	     swipeLeft.setOpaque(false);
		 swipeLeft.setFocusPainted(false);
		 swipeLeft.setContentAreaFilled(false);
	     
	     
	     //swipeRight.setPreferredSize(new Dimension(60,20));
	     swipeRight.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	     swipeRight.setOpaque(false);
		 swipeRight.setFocusPainted(false);
		 swipeRight.setContentAreaFilled(false);
			
	     swipeBox.setPreferredSize(new Dimension(10,50));
	     swipeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
	     swipeBox.add(swipeLeft);
	     //swipeBox.add(Box.createRigidArea(new Dimension(10,10)));
	     swipeBox.add(swipeRight);
	     
	     
	     //
	     Box labelBox = Box.createHorizontalBox();
	     labelBox.setPreferredSize(new Dimension(350,80));
	     labelBox.setAlignmentX(Component.CENTER_ALIGNMENT);
	     name.setFont(new Font("Arial",Font.BOLD,15));
	     name.setPreferredSize(new Dimension(30,30));
	     name.setAlignmentX(Component.LEFT_ALIGNMENT);
	     onomaetiketas.setFont(new Font("Arial",Font.BOLD,15));
	     
		 onomaetiketas.setPreferredSize(new Dimension(20,20));
		 onomaetiketas.setAlignmentX(Component.CENTER_ALIGNMENT);
		 labelBox.add(name);
		 labelBox.add(Box.createRigidArea(new Dimension(20,20)));
		 labelBox.add(onomaetiketas);
	     
		 
		 datesLabel.setFont(new Font("Arial",Font.PLAIN,13));
		 
		//ActionListeners for all buttons
		powerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedWriter writer;
				BufferedWriter rowWriter;
				if(!id.isEmpty()) {
				try {
					writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\idsList.txt"));
					String stuffToWrite =String.valueOf(id.get(id.size()-1));
					writer.write(stuffToWrite);
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
				if(!selectedRow.isEmpty()) {
					try {
						rowWriter = new BufferedWriter(new FileWriter("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\selectedRows.txt"));
						String stuffToWrite =String.valueOf(selectedRow.get(selectedRow.size()-1));
						rowWriter.write(stuffToWrite);
						rowWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				

				new PowerFrameGUI(port);
				
			}
	
			
		});
		
		 orderCreation.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
									
				}
	        	
	        });
		 
		 lot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LotGUI(id);
				
			}
			 
		 });
		 
		 
		 logfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new LOG(f2,logList.get(0),intList,doubleList,logL);
				
			}
			 
		 });

		 
		 swipeRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scaleImage("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\Images_icons\\test_label.jpg",etiketaBarcode);
				
				
				onomaetiketas.setText("COMP.LIMIT.1234AB");
				
				
			}
			 
		 });
		 
		 swipeLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scaleImage("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\Images_icons\\etiketa_demo.png",etiketaBarcode);
				
				onomaetiketas.setText("CARRIER.853903");
			}
			 
			 
		 });
	    
		
		order.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderNamingGUI(orderListLog);
				
			}
			
		});
		
		tare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TareGUI(tareLabel,arrayList);
				
			}
			
		});
		
		closeBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				String sumS = "";
				String valueS = "";
				String valuepS = "";
				if(pickSize.getText().equals("piece")) {
					new CloseButtonErrMsg();
				}
				
				else if(pickSize.getText().equals("box")) {
					
					if(!logL.isEmpty()) {
						boxNo = intList.get(0);
						paletteNo = intList.get(1);
						countItems = intList.get(2);
						countBoxes = intList.get(3);
						countPalettes = intList.get(4);
						countAllPalettes = intList.get(5);
						countAllBoxes = intList.get(6);
						valueBoxLog = doubleList.get(0);
						valuePaletteLog = doubleList.get(1);
						valueForUse = doubleList.get(2);
					}
					
					
					
					
					boxNo+=1;
					countBoxes=0;
					countPalettes+=1;
					countAllBoxes+=1;
					weightBoxLog = 0.0;
					valueBoxLog = 0.0;
					
					if(pickSize.getText().equals("box")) {
						if(countBPP!=countForbpp) {
						countBPP+=1;
						boxesLabel.setText(String.valueOf(countBPP));
						Double weigh = Double.parseDouble(net.getText().replace(",", "."));
						Double sum = weigh + Double.parseDouble(weightBoxes.getText().replace(",","."));
						
						Double value = Double.valueOf(priceBoxes.getText());
						sumV += value;
						valueS = String.format("%.3g%n", sumV);
						sumS = String.format("%.3g%n", sum);
						weightBoxes.setText(sumS);
						priceBoxes.setText(valueS);
						}else {
							countBPP=0;
							boxesLabel.setText(String.valueOf(countBPP));
							weightBoxes.setText("0.00");
							priceBoxes.setText("0.00");
						}
					}
					
					BufferedReader rowReader;
					System.out.println("HELOOOOOOOO");
					BufferedWriter bw = null;
					
					try { 
							netValue = Double.valueOf(net.getText().replace(",", "."));
							grossValue = Double.valueOf(grossWeight.getText().replace(",", "."));
							weightPieceLog = netValue;
						    weightBoxLog +=weightPieceLog;
							weightPaletteLog+= netValue;
							countItems+=1;
							sumWeight +=weightPieceLog;
							logId+=1;
							if(logFile.isEmpty()) {
							valueLog = Double.valueOf(logFile.get(6));
							valueForUse += Double.valueOf(logFile.get(6));
							}
							countBoxes+=1;
							//df.format(valueLog);
							valueBoxLog +=valueLog;
							valuePaletteLog +=valueLog;
							
							
							try {
			    				
			    				String table = "logs_"+actualPCName.toLowerCase().replace("-", "_");
			    				
			    				Connection con1 =  DriverManager.getConnection(url,uname,pass);
			    				String log1 = "insert into"+table+"(idLogS,orderS,boxNo,paletteNo,itemCode,description,lot,tare,weight,gross,productionDate,packagingDate,exparationDate,creationDate,paletteFull,weightBox,weightPalette,weightAll,barcodeWeight,barcodeBox,barcodePalette,barcodeAll,countItems,countItemsInBox,countBoxesInPalette,countAllPalettes,countAllBoxes,valueBox,valuePalette,valueAll,user,pcName) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    				PreparedStatement preparedStmt = con1.prepareStatement(log1);
			    				
			    				 preparedStmt.setInt(1,logId);	  
			    				 preparedStmt.setString(2,orderName);
			    				 preparedStmt.setString(3,String.valueOf(boxNo));
			    				 preparedStmt.setString(4,String.valueOf(paletteNo));
			    				 preparedStmt.setString(5,logFile.get(0));
			    				 preparedStmt.setString(6,logFile.get(1));
			    				 preparedStmt.setString(7,logFile.get(2));
			    				 preparedStmt.setString(8,logFile.get(3));
			    				 preparedStmt.setString(9,String.valueOf(netValue));
			    				 preparedStmt.setString(10,String.valueOf(grossValue).trim());
			    				 preparedStmt.setString(11,datesList.get(0));
			    				 preparedStmt.setString(12,datesList.get(1));
			    				 preparedStmt.setString(13,datesList.get(2));
			    				 preparedStmt.setString(14,datesList.get(0));
			    				 preparedStmt.setString(15,palleteFull);
			    				 preparedStmt.setString(16,String.valueOf(weightBoxLog));
			    				 preparedStmt.setString(17,String.valueOf(weightPaletteLog));
			    				 preparedStmt.setString(18,String.valueOf(sumWeight));
			    				 preparedStmt.setString(19,logFile.get(5));
			    				 preparedStmt.setString(20,logFile.get(5));
			    				 preparedStmt.setString(21,logFile.get(5));
			    				 preparedStmt.setString(22,logFile.get(5));
			    				 preparedStmt.setString(23,String.valueOf(countItems));
			    				 preparedStmt.setString(24,String.valueOf(countBoxes));
			    				 preparedStmt.setString(25,String.valueOf(countPalettes));
			    				 preparedStmt.setString(26,String.valueOf(countAllPalettes));
			    				 preparedStmt.setString(27,String.valueOf(countBoxes));
			    				 preparedStmt.setString(28,String.valueOf(valueBoxLog));
			    				 preparedStmt.setString(29,String.valueOf(valuePaletteLog));
			    				 preparedStmt.setString(30,String.valueOf(valueForUse));
			    				 preparedStmt.setString(31,userLoggedIn.getText());
			    				 preparedStmt.setString(32,actualPCName);
			    				 preparedStmt.executeUpdate();
			    			}catch(SQLException e5) {
			    				e5.printStackTrace();
			    			}
			    		
							
		
							
						String writetoFile =String.valueOf(logId)+","+orderName+","+String.valueOf(boxNo)+","+String.valueOf(paletteNo)+","+logFile.get(0)+","+logFile.get(1)+","+logFile.get(2)+","+logFile.get(3)+","+String.valueOf(netValue)+","+String.valueOf(grossValue).trim()+","+datesList.get(0)+","+datesList.get(1)+","+datesList.get(2)+","+datesList.get(0)+","+palleteFull+","+String.valueOf(weightBoxLog)+","+String.valueOf(weightPaletteLog)+","+String.valueOf(sumWeight)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+String.valueOf(countItems)+","+String.valueOf(countBoxes)+","+String.valueOf(countPalettes)+","+String.valueOf(countAllPalettes)+","+String.valueOf(countAllBoxes)+","+String.valueOf(valueBoxLog)+","+String.valueOf(valuePaletteLog)+","+String.valueOf(valueForUse)+","+userLoggedIn.getText()+","+getComputerName();
						
						FileOutputStream fw  = new FileOutputStream(f2,true);
						OutputStreamWriter osw = new OutputStreamWriter(fw, StandardCharsets.UTF_8);
						bw = new BufferedWriter(osw);
					    bw.write(writetoFile);
					    bw.newLine();
					    bw.close();
					   
					     } catch (IOException ioe) {
					      		ioe.printStackTrace();
					     }

				}
				else {
					
					
					if(!logL.isEmpty()) {
						boxNo = intList.get(0);
						paletteNo = intList.get(1);
						countItems = intList.get(2);
						countBoxes = intList.get(3);
						countPalettes = intList.get(4);
						countAllPalettes = intList.get(5);
						countAllBoxes = intList.get(6);
						valueBoxLog = doubleList.get(0);
						valuePaletteLog = doubleList.get(1);
						valueForUse = doubleList.get(2);
					}
					

					paletteNo+=1;
					countPalettes=0;
					countAllPalettes+=1;
					valuePaletteLog = 0.0;
					valueBoxLog = 0.0;
					weightPaletteLog = 0.0;
					BufferedReader rowReader;
					System.out.println("HELOOOOOOOO");
					BufferedWriter bw = null;
					
					try { 
						
							netValue = Double.valueOf(net.getText().replace(",", "."));
							grossValue = Double.valueOf(grossWeight.getText().replace(",", "."));
							weightPieceLog = netValue;
						    weightBoxLog +=weightPieceLog;
							weightPaletteLog+= netValue;
							countItems+=1;
							sumWeight +=weightPieceLog;
							logId+=1;
							if(logFile.isEmpty()) {
							valueLog = Double.valueOf(logFile.get(6));
							valueForUse += Double.valueOf(logFile.get(6));
							}
							countBoxes+=1;
							//df.format(valueLog);
							valueBoxLog +=valueLog;
							valuePaletteLog +=valueLog;
							
							
							
							
							try {
			    				
			    				String table = "logs_"+actualPCName.toLowerCase().replace("-", "_");
			    				
			    				Connection con1 =  DriverManager.getConnection(url,uname,pass);
			    				String log1 = "insert into"+table+"(idLogS,orderS,boxNo,paletteNo,,itemCode,description,lot,tare,weight,gross,productionDate,packagingDate,exparationDate,creationDate,paletteFull,weightBox,weightPalette,weightAll,barcodeWeight,barcodeBox,barcodePalette,barcodeAll,countItems,countItemsInBox,countBoxesInPalette,countAllPalettes,countAllBoxes,valueBox,valuePalette,valueAll,user,pcName) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    				PreparedStatement preparedStmt = con1.prepareStatement(log1);
			    				
			    				 preparedStmt.setInt(1,logId);	  
			    				 preparedStmt.setString(2,orderName);
			    				 preparedStmt.setString(3,String.valueOf(boxNo));
			    				 preparedStmt.setString(4,String.valueOf(paletteNo));
			    				 preparedStmt.setString(5,logFile.get(0));
			    				 preparedStmt.setString(6,logFile.get(1));
			    				 preparedStmt.setString(7,logFile.get(2));
			    				 preparedStmt.setString(8,logFile.get(3));
			    				 preparedStmt.setString(9,String.valueOf(netValue));
			    				 preparedStmt.setString(10,String.valueOf(grossValue).trim());
			    				 preparedStmt.setString(11,datesList.get(0));
			    				 preparedStmt.setString(12,datesList.get(1));
			    				 preparedStmt.setString(13,datesList.get(2));
			    				 preparedStmt.setString(14,datesList.get(0));
			    				 preparedStmt.setString(15,palleteFull);
			    				 preparedStmt.setString(16,String.valueOf(weightBoxLog));
			    				 preparedStmt.setString(17,String.valueOf(weightPaletteLog));
			    				 preparedStmt.setString(18,String.valueOf(sumWeight));
			    				 preparedStmt.setString(19,logFile.get(5));
			    				 preparedStmt.setString(20,logFile.get(5));
			    				 preparedStmt.setString(21,logFile.get(5));
			    				 preparedStmt.setString(22,logFile.get(5));
			    				 preparedStmt.setString(23,String.valueOf(countItems));
			    				 preparedStmt.setString(24,String.valueOf(countBoxes));
			    				 preparedStmt.setString(25,String.valueOf(countPalettes));
			    				 preparedStmt.setString(26,String.valueOf(countAllPalettes));
			    				 preparedStmt.setString(27,String.valueOf(countBoxes));
			    				 preparedStmt.setString(28,String.valueOf(valueBoxLog));
			    				 preparedStmt.setString(29,String.valueOf(valuePaletteLog));
			    				 preparedStmt.setString(30,String.valueOf(valueForUse));
			    				 preparedStmt.setString(31,userLoggedIn.getText());
			    				 preparedStmt.setString(32,actualPCName);
			    				 preparedStmt.executeUpdate();
			    				 
			    			}catch(SQLException e5) {
			    				e5.printStackTrace();
			    			}
			    		
							
							
						String writetoFile =String.valueOf(logId)+","+orderName+","+String.valueOf(boxNo)+","+String.valueOf(paletteNo)+","+logFile.get(0)+","+logFile.get(1)+","+logFile.get(2)+","+logFile.get(3)+","+String.valueOf(netValue)+","+String.valueOf(grossValue).trim()+","+datesList.get(0)+","+datesList.get(1)+","+datesList.get(2)+","+datesList.get(0)+","+palleteFull+","+String.valueOf(weightBoxLog)+","+String.valueOf(weightPaletteLog)+","+String.valueOf(sumWeight)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+String.valueOf(countItems)+","+String.valueOf(countBoxes)+","+String.valueOf(countPalettes)+","+String.valueOf(countAllPalettes)+","+String.valueOf(countAllBoxes)+","+String.valueOf(valueBoxLog)+","+String.valueOf(valuePaletteLog)+","+String.valueOf(valueForUse)+","+userLoggedIn.getText()+","+getComputerName();
						
						FileOutputStream fw  = new FileOutputStream(f2,true);
						OutputStreamWriter osw = new OutputStreamWriter(fw, StandardCharsets.UTF_8);
						bw = new BufferedWriter(osw);
					    bw.write(writetoFile);
					    bw.newLine();
					    bw.close();
					   
					     } catch (IOException ioe) {
					      		ioe.printStackTrace();
					     }

				}

				if(String.valueOf(countBoxes).equals(logFile.get(6))) {
					full+=1;
					palleteFull = String.valueOf(full);
				}
				
			}
			
		});
		
		
		auto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Color textColor = new Color(0,100,0);
				timer.setDelay(2000);
				timer.addActionListener(new ActionListener() {
					String sumS = "";
					String valueS = "";
					String valuepS = "";
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(countPrint==1 && !net.getText().equals("00,00")) {
							
							if(!logL.isEmpty()) {
								boxNo = intList.get(0);
								paletteNo = intList.get(1);
								countItems = intList.get(2);
								countBoxes = intList.get(3);
								countPalettes = intList.get(4);
								countAllPalettes = intList.get(5);
								countAllBoxes = intList.get(6);
								valueBoxLog = doubleList.get(0);
								valuePaletteLog = doubleList.get(1);
								valueForUse = doubleList.get(2);
							}
							
							
							if(pickSize.getText().equals("box")) {
								if(countBPP!=countForbpp) {
								countBPP+=1;
								boxesLabel.setText(String.valueOf(countBPP));
								Double weigh = Double.parseDouble(net.getText().replace(",", "."));
								Double sum = weigh + Double.parseDouble(weightBoxes.getText().replace(",", "."));
								
								Double value = Double.valueOf(priceBoxes.getText());
								sumV += value;
								valueS = String.format("%.3g%n", sumV);
								sumS = String.format("%.3g%n", sum);
								weightBoxes.setText(sumS);
								priceBoxes.setText(valueS);
								}else {
									countBPP=0;
									boxesLabel.setText(String.valueOf(countBPP));
									weightBoxes.setText("0.00");
									priceBoxes.setText("0.00");
								}
							}
							else if(pickSize.getText().equals("piece")) {
								if(countPPB!=countForppb) {
									countPPB+=1;
									piecesLabel.setText(String.valueOf(countPPB));
									Double weighPiece = Double.parseDouble(net.getText().replace(",", "."));
									Double sum = weighPiece + Double.valueOf(weightPieces.getText().replace(",", "."));
									sumS = String.format("%.3g%n",sum);
									weightPieces.setText(sumS);
									
									Double valueP = Double.valueOf(pricePieces.getText());
									sumP += valueP;
									valuepS = String.format("%.3g%n", sumP);
									pricePieces.setText(valuepS);
									}else {
										countPPB=0;
										piecesLabel.setText(String.valueOf(countPPB));
										weightPieces.setText("0.00");
										pricePieces.setText("0.00");
										
									}
							}
							else {
								paletteNo+=1;
							}
							try { 
								 
								new PrintAPI("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\newFile.jpeg"); 
								System.out.println("Printing...");
								 String text = counter.getText(); 
								 int c = Integer.parseInt(text); 
								 if(c!=1){ 
									 int total = c-1; text = String.valueOf(total);
									 counter.setText(text);
								 		} 
							 		} catch (IOException e1){ // TODO Auto-generated
							 			e1.printStackTrace(); }
				    		
				    		DecimalFormat df = new DecimalFormat("0.00");
							
							BufferedReader rowReader;
							BufferedWriter bw = null;
							
							try { 
									netValue = Double.valueOf(net.getText().replace(",", "."));
									grossValue = Double.valueOf(grossWeight.getText().replace(",", "."));
									weightPieceLog = netValue;
								    weightBoxLog +=weightPieceLog;
									weightPaletteLog+= netValue;
									countItems+=1;
									sumWeight +=weightPieceLog;
									logId+=1;
									if(logFile.isEmpty()) {
									valueLog = Double.valueOf(logFile.get(6));
									valueForUse += Double.valueOf(logFile.get(6));
									}
									
									countBoxes+=1;
									System.out.println(logFile.get(6).toString() + " The valueLog");
									//df.format(valueLog);
									valueBoxLog +=valueLog;
									valuePaletteLog +=valueLog;
									
									
									try {
					    				
					    				String table = "logs_"+actualPCName.toLowerCase().replace("-", "_");
					    				
					    				Connection con1 =  DriverManager.getConnection(url,uname,pass);
					    				String log1 = "insert into"+table+"(idLogS,orderS,boxNo,paletteNo,,itemCode,description,lot,tare,weight,gross,productionDate,packagingDate,exparationDate,creationDate,paletteFull,weightBox,weightPalette,weightAll,barcodeWeight,barcodeBox,barcodePalette,barcodeAll,countItems,countItemsInBox,countBoxesInPalette,countAllPalettes,countAllBoxes,valueBox,valuePalette,valueAll,user,pcName) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					    				PreparedStatement preparedStmt = con1.prepareStatement(log1);
					    				
					    				 preparedStmt.setInt(1,logId);	  
					    				 preparedStmt.setString(2,orderName);
					    				 preparedStmt.setString(3,String.valueOf(boxNo));
					    				 preparedStmt.setString(4,String.valueOf(paletteNo));
					    				 preparedStmt.setString(5,logFile.get(0));
					    				 preparedStmt.setString(6,logFile.get(1));
					    				 preparedStmt.setString(7,logFile.get(2));
					    				 preparedStmt.setString(8,logFile.get(3));
					    				 preparedStmt.setString(9,String.valueOf(netValue));
					    				 preparedStmt.setString(10,String.valueOf(grossValue).trim());
					    				 preparedStmt.setString(11,datesList.get(0));
					    				 preparedStmt.setString(12,datesList.get(1));
					    				 preparedStmt.setString(13,datesList.get(2));
					    				 preparedStmt.setString(14,datesList.get(0));
					    				 preparedStmt.setString(15,palleteFull);
					    				 preparedStmt.setString(16,String.valueOf(weightBoxLog));
					    				 preparedStmt.setString(17,String.valueOf(weightPaletteLog));
					    				 preparedStmt.setString(18,String.valueOf(sumWeight));
					    				 preparedStmt.setString(19,logFile.get(5));
					    				 preparedStmt.setString(20,logFile.get(5));
					    				 preparedStmt.setString(21,logFile.get(5));
					    				 preparedStmt.setString(22,logFile.get(5));
					    				 preparedStmt.setString(23,String.valueOf(countItems));
					    				 preparedStmt.setString(24,String.valueOf(countBoxes));
					    				 preparedStmt.setString(25,String.valueOf(countPalettes));
					    				 preparedStmt.setString(26,String.valueOf(countAllPalettes));
					    				 preparedStmt.setString(27,String.valueOf(countBoxes));
					    				 preparedStmt.setString(28,String.valueOf(valueBoxLog));
					    				 preparedStmt.setString(29,String.valueOf(valuePaletteLog));
					    				 preparedStmt.setString(30,String.valueOf(valueForUse));
					    				 preparedStmt.setString(31,userLoggedIn.getText());
					    				 preparedStmt.setString(32,actualPCName);
					    				 preparedStmt.executeUpdate();
					    			}catch(SQLException e5) {
					    				e5.printStackTrace();
					    			}
					    		
									
									
									
									
									
									
									
								String writetoFile =String.valueOf(logId)+","+orderName+","+String.valueOf(boxNo)+","+String.valueOf(paletteNo)+","+logFile.get(0)+","+logFile.get(1)+","+logFile.get(2)+","+logFile.get(3)+","+String.valueOf(netValue)+","+String.valueOf(grossValue).trim()+","+datesList.get(0)+","+datesList.get(1)+","+datesList.get(2)+","+datesList.get(0)+","+palleteFull+","+String.valueOf(weightBoxLog)+","+String.valueOf(weightPaletteLog)+","+String.valueOf(sumWeight)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+String.valueOf(countItems)+","+String.valueOf(countBoxes)+","+String.valueOf(countPalettes)+","+String.valueOf(countAllPalettes)+","+String.valueOf(countAllBoxes)+","+String.valueOf(valueBoxLog)+","+String.valueOf(valuePaletteLog)+","+String.valueOf(valueForUse)+","+userLoggedIn.getText()+","+getComputerName();
								
								FileOutputStream fw  = new FileOutputStream(f2,true);
								OutputStreamWriter osw = new OutputStreamWriter(fw, StandardCharsets.UTF_8);
								bw = new BufferedWriter(osw);
							    bw.write(writetoFile);
							    bw.newLine();
							    bw.close();
							   
								} catch (IOException ioe) {
							      		ioe.printStackTrace();
								}
							
							
						}
						countPrint=0;
					}
					
				});
				
				 if(auto.isSelected()) {
					 
			    		auto.setText("EN");
						auto.setForeground(textColor);
						auto.setOpaque(true);
						auto.setBorderPainted(false);
			    		timer.start();

				
			    	}
				

			
				else {
					timer.stop();
					auto.setText("DS");
					auto.setForeground(Color.RED);
					auto.setOpaque(true);
					auto.setBorderPainted(false);
					
				}
			}
			
		});
		
		plu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PLUGUI(id,selectedRow,datesList,logFile);
				
			}
			
		});
		
		users.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserLoginGUI(userLoggedIn);
				
			}
			
		});
		
		zeroingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				new ScaleController(port,1,rawString);
				
				
				
				
				
			}
			
		});
		
		settingsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
								
				new SettingsGUI(port,raw,flagList,selection);
				
				
			}
			
		});
		
		swipeSizeLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = pickSize.getText();
				
				String size="";
				for(int i=0;i<sizeArray.size();i++) {
					if(selected.equals(sizeArray.get(i))) {
						select = i;
					}
				}
				
				if(select==0) {
					size=sizeArray.get(select);
					pickSize.setText(size);
				}else {
					size = sizeArray.get(select-1);
					pickSize.setText(size);
				}
				
				
			}
			
		});
		
		
		swipeSizeRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = pickSize.getText();
				
				String size="";
				for(int i=0;i<sizeArray.size();i++) {
					if(selected.equals(sizeArray.get(i))) {
						select = i;
					}
				}
				
				if(select==sizeArray.size()-1) {
					size=sizeArray.get(select);
					pickSize.setText(size);
				}else {
					size = sizeArray.get(select+1);
					pickSize.setText(size);
				}
				
			}
			
		});
		
		swipeDateLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = datesLabel.getText();
				String size="";
				for(int i=0;i<myDates.size();i++) {
					if(selected.equals(myDates.get(i))) {
						count=i;
					}
				}
				
				if(count==0) {
					size = myDates.get(count);
					datesLabel.setText(size);
					dates.setText(datesList.get(count));
				}else {
					size = myDates.get(count-1);
					datesLabel.setText(size);
					dates.setText(datesList.get(count-1));
				}
				
				
			}
			
		});
		
		
		swipeDateRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = datesLabel.getText();
				String size="";
				for(int i=0;i<myDates.size();i++) {
					if(selected.equals(myDates.get(i))) {
						count=i;
						
					}
				}
				
				if(count==myDates.size()-1) {
					size = myDates.get(count);
					datesLabel.setText(size);
					dates.setText(datesList.get(count));
				}else {
					size = myDates.get(count+1);
					datesLabel.setText(size);
					dates.setText(datesList.get(count+1));
				}
				
				
			}
			
		});
		
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				swipeLeftCounter.setEnabled(true);
				String text = counter.getText();
				
				int c = Integer.parseInt(text);
				int total = c+1;
				text = String.valueOf(total);
				
				counter.setText(text);
				
			}
			
		});
		
		swipeLeftCounter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(counter.getText().equals("1")) {
					swipeLeftCounter.setEnabled(false);
				}else {
					String text = counter.getText();
					int c = Integer.parseInt(text);
					int total = c-1;
					text = String.valueOf(total);
					
					counter.setText(text);
				}
				
				
				
			}
			
		});
		
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)  {
				
				BarCode bc = new BarCode();
				 bc.code = "123456789012";
				 barCodeEncoder bce = new barCodeEncoder(bc, "JPEG", "newfile.jpeg");
				 String sumS=""; 
				 String valueS = "";
				 String valuepS = "";
				 
				 if(pickSize.getText().equals("box")) {
						if(countBPP!=countForbpp) {
						countBPP+=1;
						boxesLabel.setText(String.valueOf(countBPP));
						Double weigh = Double.parseDouble(net.getText().replace(",", "."));
						Double sum = weigh + Double.parseDouble(weightBoxes.getText().replace(",", "."));
						
						Double value = Double.valueOf(priceBoxes.getText().replace(",", "."));
						
						Double valueBoxSum = sumV + value;
						
						valueS = String.format("%.3g%n", valueBoxSum);
						sumS = String.format("%.3g%n", sum);
						weightBoxes.setText(sumS);
						priceBoxes.setText(valueS);
						boxNo+=1;
						}else {
							countBPP=0;
							boxesLabel.setText(String.valueOf(countBPP));
							weightBoxes.setText("0.00");
							priceBoxes.setText("0.00");
						}
					}
					else if(pickSize.getText().equals("piece")) {
						if(countPPB!=countForppb) {
							countPPB+=1;
							piecesLabel.setText(String.valueOf(countPPB));
							Double weighPiece = Double.parseDouble(net.getText().replace(",", "."));
							Double sum = weighPiece + Double.valueOf(weightPieces.getText().replace(",", "."));
							sumS = String.format("%.3g%n",sum);
							weightPieces.setText(sumS);
							
							Double valueP = Double.valueOf(pricePieces.getText().replace(",", "."));
							
							Double valuePieceSum = sumP + valueP;
							
							valuepS = String.format("%.3g%n", valuePieceSum);
							pricePieces.setText(valuepS);
							
							}else {
								countPPB=0;
								piecesLabel.setText(String.valueOf(countPPB));
								weightPieces.setText("0.00");
								pricePieces.setText("0.00");
							}
					}
					else {
						paletteNo+=1;
					}
				// try { 
					 
					 
					// new PrintAPI("C:\\Users\\user\\git\\bonarosaeProgramm\\Bonaros AE\\newFile.jpeg"); 
					 String text = counter.getText(); 
					 int c = Integer.parseInt(text); 
					 if(c!=1){ 
						 int total = c-1; text = String.valueOf(total);
						 counter.setText(text);
					 		} 
				 		//} catch (IOException e1){ // TODO Auto-generated
				 		//e1.printStackTrace(); }
				 
					DecimalFormat df = new DecimalFormat("0.00");
					
					BufferedReader rowReader;
					BufferedWriter bw = null;
					
					try { 
						
						if(!logL.isEmpty()) {
							boxNo = intList.get(0);
							paletteNo = intList.get(1);
							countItems = intList.get(2);
							countBoxes = intList.get(3);
							countPalettes = intList.get(4);
							countAllPalettes = intList.get(5);
							countAllBoxes = intList.get(6);
							valueBoxLog = doubleList.get(0);
							valuePaletteLog = doubleList.get(1);
							valueForUse = doubleList.get(2);
							weightBoxLog = doubleList.get(3);
							weightPaletteLog = doubleList.get(4);
							sumWeight = doubleList.get(5);
						}
						
						
							netValue = Double.valueOf(net.getText().replace(",", "."));
							grossValue = Double.valueOf(grossWeight.getText().replace(",", "."));
							weightPieceLog = netValue;
						    weightBoxLog +=weightPieceLog;
							weightPaletteLog+= netValue;
							countItems+=1;
							sumWeight +=weightPieceLog;
							logId+=1;
							if(logFile.isEmpty()) {
							valueLog = Double.valueOf(logFile.get(6));
							valueForUse += Double.valueOf(logFile.get(6));
							}
							
							countBoxes+=1;
							
							System.out.println(logFile.get(6).toString() + " The valueLog");
							//df.format(valueLog);
							valueBoxLog +=valueLog;
							valuePaletteLog +=valueLog;
							
							
							
							try {
			    				
			    				String table = "logs_"+actualPCName.toLowerCase().replace("-", "_");
			    				
			    				Connection con1 =  DriverManager.getConnection(url,uname,pass);
			    				String log1 = "insert into "+table+"(idLogS,orderS,boxNo,paletteNo,itemCode,description,lot,tare,weight,gross,productionDate,packagingDate,exparationDate,creationDate,paletteFull,weightBox,weightPalette,weightAll,barcodeWeight,barcodeWeightBox,barcodeWeightPalette,barcodeWeightAll,countItems,countItemsInBox,countBoxesInPalette,countAllPalettes,countAllBoxes,valueBox,valuePalette,valueAll,user,pcName) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    				PreparedStatement preparedStmt = con1.prepareStatement(log1);
			    				
			    				 preparedStmt.setInt(1,logId);	  
			    				 preparedStmt.setString(2,orderName);
			    				 preparedStmt.setString(3,String.valueOf(boxNo));
			    				 preparedStmt.setString(4,String.valueOf(paletteNo));
			    				 preparedStmt.setString(5,logFile.get(0));
			    				 preparedStmt.setString(6,logFile.get(1));
			    				 preparedStmt.setString(7,logFile.get(2));
			    				 preparedStmt.setString(8,logFile.get(3));
			    				 preparedStmt.setString(9,String.valueOf(netValue));
			    				 preparedStmt.setString(10,String.valueOf(grossValue).trim());
			    				 preparedStmt.setString(11,datesList.get(0));
			    				 preparedStmt.setString(12,datesList.get(1));
			    				 preparedStmt.setString(13,datesList.get(2));
			    				 preparedStmt.setString(14,datesList.get(0));
			    				 preparedStmt.setString(15,palleteFull);
			    				 preparedStmt.setString(16,String.valueOf(weightBoxLog));
			    				 preparedStmt.setString(17,String.valueOf(weightPaletteLog));
			    				 preparedStmt.setString(18,String.valueOf(sumWeight));
			    				 preparedStmt.setString(19,logFile.get(5));
			    				 preparedStmt.setString(20,logFile.get(5));
			    				 preparedStmt.setString(21,logFile.get(5));
			    				 preparedStmt.setString(22,logFile.get(5));
			    				 preparedStmt.setString(23,String.valueOf(countItems));
			    				 preparedStmt.setString(24,String.valueOf(countBoxes));
			    				 preparedStmt.setString(25,String.valueOf(countPalettes));
			    				 preparedStmt.setString(26,String.valueOf(countAllPalettes));
			    				 preparedStmt.setString(27,String.valueOf(countBoxes));
			    				 preparedStmt.setString(28,String.valueOf(valueBoxLog));
			    				 preparedStmt.setString(29,String.valueOf(valuePaletteLog));
			    				 preparedStmt.setString(30,String.valueOf(valueForUse));
			    				 preparedStmt.setString(31,userLoggedIn.getText());
			    				 preparedStmt.setString(32,actualPCName);
			    				 preparedStmt.executeUpdate();
			    			}catch(SQLException e5) {
			    				e5.printStackTrace();
			    			}
			    		
							
							
							
							
						String writetoFile =String.valueOf(logId)+","+orderName+","+String.valueOf(boxNo)+","+String.valueOf(paletteNo)+","+logFile.get(0)+","+logFile.get(1)+","+logFile.get(2)+","+logFile.get(3)+","+String.valueOf(netValue)+","+String.valueOf(grossValue).trim()+","+datesList.get(0)+","+datesList.get(1)+","+datesList.get(2)+","+datesList.get(0)+","+palleteFull+","+String.valueOf(weightBoxLog)+","+String.valueOf(weightPaletteLog)+","+String.valueOf(sumWeight)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+logFile.get(5)+","+String.valueOf(countItems)+","+String.valueOf(countBoxes)+","+String.valueOf(countPalettes)+","+String.valueOf(countAllPalettes)+","+String.valueOf(countAllBoxes)+","+String.valueOf(valueBoxLog)+","+String.valueOf(valuePaletteLog)+","+String.valueOf(valueForUse)+","+userLoggedIn.getText()+","+getComputerName();
						
						FileOutputStream fw  = new FileOutputStream(f2,true);
						OutputStreamWriter osw = new OutputStreamWriter(fw, StandardCharsets.UTF_8);
						bw = new BufferedWriter(osw);
					    bw.write(writetoFile);
					    bw.newLine();
					    bw.close();
					   
					     } catch (IOException ioe) {
					      		ioe.printStackTrace();
					     }	
				
		}
			
	});
		
		
		dates.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DatesGUI(id,datesList);
				
			}
			
		});
		
		
		pluEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!id.isEmpty() && !selectedRow.isEmpty()) {
					int last = selectedRow.get(selectedRow.size()-1);
					
					
					new EditSelectedPLU(id,last,datesList);
				}
				else {
					JOptionPane.showMessageDialog(null, "Δεν έχετε επιλέξει κάποιο προϊόν από το PLU");
				}
			}
			
		});
		
		//South panel
		Box autoBox = Box.createVerticalBox();
		
		autoBox.add(autoprintLabel);
		autoBox.add(Box.createRigidArea(new Dimension(20,18)));
		autoBox.add(users);
	
		autoBox.setPreferredSize(new Dimension(110,130));
		southBorderLayoutPanel.add(autoBox);
		
        southBox1.add(auto);
        southBox1.add(Box.createRigidArea(new Dimension(20,18)));
        southBox1.add(logfile);
        southBox1.setPreferredSize(new Dimension(100,130));
        southBorderLayoutPanel.add(southBox1);
		
        
		southBox2.add(plu);
        southBox2.add(Box.createRigidArea(new Dimension(20,18)));
        southBox2.add(order);
        southBox2.setPreferredSize(new Dimension(100,130));
        southBorderLayoutPanel.add(southBox2);
       
        southBox3.add(lot);
        southBox3.add(Box.createRigidArea(new Dimension(20,18)));
        southBox3.add(tare);   
        southBox3.setPreferredSize(new Dimension(100,130));
        southBorderLayoutPanel.add(southBox3);   
        
        southBox4.add(print);
        southBox4.add(Box.createRigidArea(new Dimension(20,15)));
        southBox4.add(settingsButton);
        southBox4.setPreferredSize(new Dimension(100,130));
        southBorderLayoutPanel.add(southBox4);
       
        
      //Place Power button to south panel        
        Box sendPowerButtonToCorner = Box.createVerticalBox();        
        sendPowerButtonToCorner.add(Box.createRigidArea(new Dimension(400,60)));
        sendPowerButtonToCorner.add(powerButton);       
        southBorderLayoutPanel.add(sendPowerButtonToCorner);               
        southBorderLayoutPanel.setPreferredSize(new Dimension(0,200));
        southBorderLayoutPanel.setBorder(BorderFactory.createTitledBorder(null, "ΚΟΥΜΠΙΑ ΛΕΙΤΟΥΡΓΙΩΝ", TitledBorder.LEFT, TitledBorder.TOP,
        		new Font("times new roman",Font.BOLD,12), Color.BLACK));

        southBorderLayoutPanel.setBackground(labelColor);
       //Center Layout
        c.fill = GridBagConstraints.HORIZONTAL;
		
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,750,5,800);  //top padding
		c.gridx = 0;       
		c.gridwidth = 1;   //3 columns wide
		c.gridy = 2; //third row
		
		centerGridBagLayoutPanel.add(zeroingButton, c);
		
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.ipady =0;
		c1.weighty = 1.0;
		c1.anchor = GridBagConstraints.WEST;
		c1.insets = new Insets(40,500,210,840);
		c1.gridx=0;
		c1.gridwidth=3;
		c1.gridy=2;
		
		centerGridBagLayoutPanel.add(fieldBox1,c1);
		
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady =0;
		c2.weighty = 1.0;
		c2.anchor = GridBagConstraints.WEST;
		c2.insets = new Insets(100,500,0,840);
		c2.gridx=0;
		c2.gridwidth=3;
		c2.gridy=2;
		
		centerGridBagLayoutPanel.add(fieldBox2,c2);
		
		c3.fill = GridBagConstraints.VERTICAL;
		c3.ipady =0;
		c3.weighty = 1.0;
		c3.anchor = GridBagConstraints.CENTER;
		c3.insets = new Insets(50,560,250,490);
		c3.gridx=0;
		c3.gridwidth=3;
		c3.gridy=2;
				
		centerGridBagLayoutPanel.add(closeBox,c3);
		
		c4.fill = GridBagConstraints.VERTICAL;
		c4.ipady =0;
		c4.weighty = 1.0;
		c4.anchor = GridBagConstraints.CENTER;
		c4.insets = new Insets(210,560,90,490);
		c4.gridx=0;
		c4.gridwidth=3;
		c4.gridy=2;
		
		centerGridBagLayoutPanel.add(pluEdit,c4);
				
		c5.fill = GridBagConstraints.HORIZONTAL;
		c5.ipady =0;
		c5.weighty = 1.0;
		c5.anchor = GridBagConstraints.CENTER;
		c5.insets = new Insets(50,960,190,290);
		c5.gridx=0;
		c5.gridwidth=3;
		c5.gridy=2;
		
		centerGridBagLayoutPanel.add(hbBox,c5);
		
		c6.fill = GridBagConstraints.HORIZONTAL;
		c6.ipady =0;
		c6.weighty = 1.0;
		c6.anchor = GridBagConstraints.CENTER;
		c6.insets = new Insets(100,960,130,260);
		c6.gridx=0;
		c6.gridwidth=3;
		c6.gridy=2;
		
		centerGridBagLayoutPanel.add(hSBox,c6);
		
		c7.fill = GridBagConstraints.HORIZONTAL;
		c7.ipady =0;
		c7.weighty = 1.0;
		c7.anchor = GridBagConstraints.CENTER;
		c7.insets = new Insets(120,1030,95,200);
		c7.gridx=0;
		c7.gridwidth=3;
		c7.gridy=2;
		
		centerGridBagLayoutPanel.add(sizeLabel,c7);
		
		c8.fill = GridBagConstraints.HORIZONTAL;
		c8.ipady =0;
		c8.weighty = 1.0;
		c8.anchor = GridBagConstraints.CENTER;
		c8.insets = new Insets(130,960,40,240);
		c8.gridx=0;
		c8.gridwidth=3;
		c8.gridy=2;
		
		centerGridBagLayoutPanel.add(hCBox,c8);
	
		c9.fill = GridBagConstraints.HORIZONTAL;
		c9.ipady =0;
		c9.weighty = 1.0;
		c9.anchor = GridBagConstraints.CENTER;
		c9.insets = new Insets(150,1035,10,200);
		c9.gridx=0;
		c9.gridwidth=3;
		c9.gridy=2;
		
		centerGridBagLayoutPanel.add(copies,c9);
		
		c10.fill = GridBagConstraints.HORIZONTAL;
		c10.ipady =0;
		c10.weighty = 1.0;
		c10.anchor = GridBagConstraints.CENTER;
		c10.insets = new Insets(90,1030,170,250);
		c10.gridx=0;
		c10.gridwidth=3;
		c10.gridy=2;
		
		centerGridBagLayoutPanel.add(datesLabel,c10);
					
		tareLabelPanel.setPreferredSize(new Dimension(300,35));
		grossLabelPanel.setPreferredSize(new Dimension(300,35));
		netLabelPanel.setPreferredSize(new Dimension(300,35));
 
		Box tareVertical = Box.createVerticalBox();
		Box netVertical = Box.createVerticalBox();
		Box grossVertical = Box.createVerticalBox();
		
		tareVertical.add(Box.createRigidArea(new Dimension(10,30)));
		tareVertical.add(tareLabelPanel);
		tareVertical.add(Box.createRigidArea(new Dimension(200,0)));
		tareVertical.add(tareText);
		
		tareVertical.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		netVertical.add(Box.createRigidArea(new Dimension(10,30)));
		netVertical.add(netLabelPanel);
		netVertical.add(Box.createRigidArea(new Dimension(200,0)));
		netVertical.add(netText);
			
		grossVertical.add(Box.createRigidArea(new Dimension(10,30)));
		grossVertical.add(grossLabelPanel);
		grossVertical.add(Box.createRigidArea(new Dimension(200,0)));
		grossVertical.add(grossText);
		grossLabelPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		grossVertical.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		Box space = Box.createHorizontalBox();

		space.add(tareVertical);
		space.add(Box.createRigidArea(new Dimension(10,40)));
		space.add(netVertical);
		space.add(Box.createRigidArea(new Dimension(10,40)));
		space.add(grossVertical);
		
		space.setAlignmentX(Component.CENTER_ALIGNMENT);
		space.setAlignmentY(Component.CENTER_ALIGNMENT);
		
        centerGridBagLayoutPanel.add(space);

		etiketaBarcode.setAlignmentX(Component.CENTER_ALIGNMENT);
		etiketaBarcode.setPreferredSize(new Dimension(150,230));
		etiketaBarcode.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(labelBox);
		box.add(etiketaBarcode);
		box.add(Box.createRigidArea(new Dimension(60,85)));
		box.add(swipeBox);
               
		westBoxLayoutPanel.setBackground(southColor);
        westBoxLayoutPanel.add(box);
        westBoxLayoutPanel.setPreferredSize(new Dimension(320,0));
        westBoxLayoutPanel.setBorder(BorderFactory.createTitledBorder(""));
        //copywrite.setVisible(true);
      
        JFrame frame = new JFrame("Bonaros AE");
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("bonaros.jpg"));
        frame.setIconImage(logo.getImage());
        frame.setLayout(new BorderLayout());      // This is the deafault layout
        frame.add(northFlowLayoutPanel, BorderLayout.PAGE_START);
        frame.add(westBoxLayoutPanel, BorderLayout.LINE_START);
        frame.add(southBorderLayoutPanel, BorderLayout.PAGE_END);
        frame.add(centerGridBagLayoutPanel, BorderLayout.CENTER);     
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                        //UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException
                    | InstantiationException
                    | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            new GUI();
        });
    }
    
    
	public void scaleImage(String path, JLabel label) {
		ImageIcon icon = new ImageIcon(path);
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		label.setIcon(scaledIcon);
	}
	
	
	public void createLOGTable(Statement stm, Connection con, ResultSet result, String pcName) {
		String table = "logs_"+pcName;
		String query = "create table "+ table+ "(idLogs integer NOT NULL, " +
			      " orderS varchar(45) NOT NULL, " + " boxNo varchar(45) NOT NULL, " +
			      " paletteNo varchar(45) NOT NULL, " + " itemCode varchar(45) NOT NULL, " +
			      " description varchar(45) NOT NULL, " + " lot varchar(45) NOT NULL, " + " tare varchar(45) NOT NULL," +
			      " weight varchar(45) NOT NULL, " + " gross varchar(45) NOT NULL," + " productionDate varchar(45) NOT NULL, " + " packagingDate varchar(45) NOT NULL, " +
			      " exparationDate varchar(45) NOT NULL, " + " creationDate varchar(45) NOT NULL, " +" paletteFull varchar(45) NOT NULL, " + " weightBox varchar(45) NOT NULL, " +
			      " weightPalette varchar(45) NOT NULL, " + " weightAll varchar(45) NOT NULL, " +" barcodeWeight varchar(45) NOT NULL, " + " barcodeWeightBox varchar(45) NOT NULL, " +
			      " barcodeWeightPalette varchar(45) NOT NULL, " + " barcodeWeightAll varchar(45) NOT NULL, " +" countItems varchar(45) NOT NULL, " + " countItemsInBox varchar(45) NOT NULL, " +
			      " countBoxesInPalette varchar(45) NOT NULL, " + " countAllPalettes varchar(45) NOT NULL, " +" countAllBoxes varchar(45) NOT NULL, " + " valueBox varchar(45) NOT NULL, " +
			      " valuePalette varchar(45) NOT NULL, " + " valueAll varchar(45) NOT NULL, " +" user varchar(45) NOT NULL, " + " pcName varchar(45) NOT NULL," +" PRIMARY KEY (idLogs))";
			    
			    try (Statement stmt = con.createStatement()) {
			      stmt.executeUpdate(query);
			    } catch (SQLException e) {
			    	e.printStackTrace();
			    }
		
		
	}
	
	public void createEXPORTable(Statement stm, Connection con, ResultSet result, String pcName) {
		String table = "logs_"+pcName;
		String query = "create table "+ table+ "(exports_id integer NOT NULL, " + " idLogs integer NOT NULL, " +
			      " orderS varchar(45) NOT NULL, " + " boxNo varchar(45) NOT NULL, " +
			      " paletteNo varchar(45) NOT NULL, " + " itemCode varchar(45) NOT NULL, " +
			      " description varchar(45) NOT NULL, " + " lot varchar(45) NOT NULL, " + " tare varchar(45) NOT NULL," +
			      " weight varchar(45) NOT NULL, " + " gross varchar(45) NOT NULL," + " productionDate varchar(45) NOT NULL, " + " packagingDate varchar(45) NOT NULL, " +
			      " exparationDate varchar(45) NOT NULL, " + " creationDate varchar(45) NOT NULL, " +" paletteFull varchar(45) NOT NULL, " + " weightBox varchar(45) NOT NULL, " +
			      " weightPalette varchar(45) NOT NULL, " + " weightAll varchar(45) NOT NULL, " +" barcodeWeight varchar(45) NOT NULL, " + " barcodeWeightBox varchar(45) NOT NULL, " +
			      " barcodeWeightPalette varchar(45) NOT NULL, " + " barcodeWeightAll varchar(45) NOT NULL, " +" countItems varchar(45) NOT NULL, " + " countItemsInBox varchar(45) NOT NULL, " +
			      " countBoxesInPalette varchar(45) NOT NULL, " + " countAllPalettes varchar(45) NOT NULL, " +" countAllBoxes varchar(45) NOT NULL, " + " valueBox varchar(45) NOT NULL, " +
			      " valuePalette varchar(45) NOT NULL, " + " valueAll varchar(45) NOT NULL, " +" user varchar(45) NOT NULL, " + " pcName varchar(45) NOT NULL," +" PRIMARY KEY (exports_id))";
			    
			    try (Statement stmt = con.createStatement()) {
			      stmt.executeUpdate(query);
			    } catch (SQLException e) {
			    	e.printStackTrace();
			    }
		
		
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
	
	
	
}
