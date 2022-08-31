import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.FocusManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class PLUEditGUI extends JFrame {
	
	
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String query = "select* from products";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private String id; 
	private String barcode ;
	private String description;
	private String price;
	private String daysToexpire;
	private String dateProductString;
	private String lot;
	private String serialNumber;
	private String tarePercentage;
	private String smallItemWeight;
	private String piecesperbox;
	private String boxesperpallete;
	private String labelPiece;
	private String labelBox;
	private String labelPallete;
	private String underWeight;
	private String overWeight;
	private String textId;
	private String packingDate;
	private String expireDate;
	
	private static JTextArea area = new JTextArea();

	private JTextField idField = new JTextField(); 
	private JTextField barcodeField=new JTextField() ;
	private JTextField descriptionField =new JTextField();
	private JTextField priceField =new JTextField();
	private JTextField daysToexpireField =new JTextField();
	private JTextField dateProductField =new JTextField();
	private JTextField lotField =new JTextField();
	private JTextField serialNumberField =new JTextField();
	private JTextField tarePercentageField =new JTextField();
	private JTextField smallItemWeightField =new JTextField();
	private JTextField piecesperboxField =new JTextField();
	private JTextField boxesperpalleteField =new JTextField();
	private JTextField labelPieceField =new JTextField();
	private JTextField labelBoxField =new JTextField();
	private JTextField labelPalleteField =new JTextField();
	private JTextField underWeightField =new JTextField();
	private JTextField overWeightField =new JTextField();
	private JTextField textIdField =new JTextField();
	private JTextField packingDateField = new JTextField();
	private JTextField expireDateField = new JTextField();
	
	private JLabel idLabel = new JLabel(); 
	private JLabel barcodeLabel = new JLabel() ;
	private JLabel descriptionLabel = new JLabel();
	private JLabel priceLabel = new JLabel();
	private JLabel daysToexpireLabel = new JLabel();
	private JLabel dateproductLabel = new JLabel();
	private JLabel lotLabel = new JLabel();
	private JLabel serialNumberLabel = new JLabel();
	private JLabel tarePercentageLabel = new JLabel();
	private JLabel smallItemWeightLabel = new JLabel();
	private JLabel piecesperboxLabel = new JLabel();
	private JLabel boxesperpalleteLabel = new JLabel();
	private JLabel labelPieceLabel = new JLabel();
	private JLabel labelBoxLabel = new JLabel();
	private JLabel labelPalleteLabel = new JLabel();
	private JLabel underWeightLabel = new JLabel();
	private JLabel overWeightLabel = new JLabel();
	private JLabel textIdLabel = new JLabel();
	private JLabel packingDateLabel = new JLabel();
	private JLabel expireDateLabel = new JLabel();
	
	private JTextField Text1 =new JTextField();
	private JTextField Text2 =new JTextField();
	private JTextField Text3 =new JTextField();
	private JTextField Text4 =new JTextField();
	private JTextField Text5 =new JTextField();
	private JTextField Text6 =new JTextField();
	private JTextField Text7 =new JTextField();
	private JTextField Text8 =new JTextField();
	private JTextField Text9 =new JTextField();
	private JTextField Text10 =new JTextField();
	private JTextField Text11 =new JTextField();
	private JTextField Text12 =new JTextField();
	private JTextField Text13 =new JTextField();
	private JTextField Text14 =new JTextField();
	private JTextField Text15 =new JTextField();
	private JTextField Text16 =new JTextField();
	private JTextField Text17 =new JTextField();
	private JTextField Text18 =new JTextField(); 
	private JTextField Text19 =new JTextField();
	private JTextField Text20 =new JTextField();
	private JTextField Text21 =new JTextField();
	private JTextField Text22 =new JTextField();
	private JTextField Text23 =new JTextField();
	private JTextField Text24 =new JTextField();
	private JTextField Text25 =new JTextField();
	private JTextField Text26 =new JTextField();
	private JTextField Text27 =new JTextField();
	private JTextField Text28 =new JTextField();
	private JTextField Text29 =new JTextField();
	private JTextField Text30 =new JTextField();
	
	
 
	private JLabel TextLabel1 = new JLabel();
	private JLabel TextLabel2 = new JLabel();
	private JLabel TextLabel3 = new JLabel();
	private JLabel TextLabel4 = new JLabel();
	private JLabel TextLabel5 = new JLabel();
	private JLabel TextLabel6 = new JLabel();
	private JLabel TextLabel7 = new JLabel();
	private JLabel TextLabel8 = new JLabel();
	private JLabel TextLabel9 = new JLabel();
	private JLabel TextLabel10 = new JLabel();
	private JLabel TextLabel11 = new JLabel();
	private JLabel TextLabel12 = new JLabel();
	private JLabel TextLabel13 = new JLabel();
	private JLabel TextLabel14 = new JLabel();
	private JLabel TextLabel15 = new JLabel();
	private JLabel TextLabel16 = new JLabel();
	private JLabel TextLabel17 = new JLabel(); 
	private JLabel TextLabel18 = new JLabel();
	private JLabel TextLabel19 = new JLabel();
	private JLabel TextLabel20 = new JLabel();
	private JLabel TextLabel21 = new JLabel();
	private JLabel TextLabel22 = new JLabel();
	private JLabel TextLabel23 = new JLabel();
	private JLabel TextLabel24 = new JLabel();
	private JLabel TextLabel25 = new JLabel();
	private JLabel TextLabel26 = new JLabel();
	private JLabel TextLabel27 = new JLabel();
	private JLabel TextLabel28 = new JLabel();
	private JLabel TextLabel29 = new JLabel();
	private JLabel TextLabel30 = new JLabel();
	
	private JButton save = new JButton("");
	private JButton close  = new JButton("");
	private JButton keyboard =new JButton();
	private ArrayList<String> array = new ArrayList<>();

	
	public PLUEditGUI(int selected,JTable initTable,ArrayList<String> datesList) {
		
		expireDateField.setEditable(false);
		
		ArrayList<JTextField> textFieldClicked = new ArrayList<>();
		idField.setEditable(false);
		idField.setEnabled(false);
		
		idField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(idField);
				
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
		barcodeField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(barcodeField);
				
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
		descriptionField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(descriptionField);
				
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
		priceField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(priceField);
				
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
		daysToexpireField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(daysToexpireField);
				
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
		
		lotField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(lotField);
				
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
		serialNumberField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(serialNumberField);
				
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
		tarePercentageField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(tarePercentageField);
				
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
		smallItemWeightField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(smallItemWeightField);
				
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
		piecesperboxField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(piecesperboxField);
				
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
		boxesperpalleteField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(boxesperpalleteField);
				
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
		
		underWeightField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(underWeightField);
				
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
		overWeightField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(overWeightField);
				
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
		
		
		packingDateField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(packingDateField);
				
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
		
		
		
		//Text Field  
		
		Text1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text1);
				
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
		Text2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text2);
				
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
		Text3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text4);
				
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
		Text5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text5);
				
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
		Text6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text6);
				
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
		
		Text7.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text7);
				
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
		Text8.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text8);
				
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
		Text9.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text9);
				
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
		Text10.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text10);
				
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
		Text11.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text11);
				
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
		Text12.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text12);
				
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
		
		Text13.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text13);
				
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
		Text14.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text14);
				
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
		
		
		
		Text15.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text15);
				
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
		Text16.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text16);
				
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
		Text17.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text17);
				
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
		Text18.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text18);
				
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
		Text19.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text19);
				
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
		
		Text20.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text20);
				
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
		Text21.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text21);
				
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
		Text22.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text22);
				
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
		Text23.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text23);
				
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
		Text24.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text25);
				
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
		Text26.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text26);
				
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
		
		Text27.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text27);
				
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
		Text28.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text28);
				
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
		
		
		Text29.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text29);
				
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
		Text30.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldClicked.add(Text30);
				
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
	    
	    Image keyLogo = new ImageIcon(this.getClass().getResource("/keyb_img.png")).getImage();
		keyboard.setIcon(new ImageIcon(keyLogo));
		keyboard.setOpaque(false);
	    keyboard.setFocusPainted(false);
	    keyboard.setContentAreaFilled(false);
		
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
    		for(int i=1;i<=c;i++) {
    			column.add(rsmt.getColumnName(i));
    		}
    		Vector data = new Vector();
    		Vector row = new Vector();
    		
    		while(result.next()) {
    			row = new Vector(c);
    			for(int i=1;i<=c;i++) {
    				row.add(result.getString(i));
    				
    			}
    			data.add(row);
    		}
		
    		DefaultTableModel model = new DefaultTableModel(data,column);
    		JTable table = new JTable(model);

		idField.setText(table.getValueAt(selected, 0).toString()); 
		barcodeField.setText(table.getValueAt(selected, 1).toString());
		descriptionField.setText(table.getValueAt(selected, 2).toString());
		priceField.setText(table.getValueAt(selected, 3).toString());
		daysToexpireField.setText(table.getValueAt(selected, 4).toString());
		dateProductField.setText(table.getValueAt(selected, 5).toString());
		lotField.setText(table.getValueAt(selected, 6).toString());
		serialNumberField.setText(table.getValueAt(selected, 7).toString());
		tarePercentageField.setText(table.getValueAt(selected, 8).toString());
		piecesperboxField.setText(table.getValueAt(selected, 9).toString());
		boxesperpalleteField.setText(table.getValueAt(selected, 10).toString());
		labelPieceField.setText(table.getValueAt(selected, 11).toString());
		labelBoxField.setText(table.getValueAt(selected, 12).toString());
		smallItemWeightField.setText(table.getValueAt(selected, 13).toString());
		labelPalleteField.setText(table.getValueAt(selected, 14).toString());
		underWeightField.setText(table.getValueAt(selected, 15).toString());
		overWeightField.setText(table.getValueAt(selected, 16).toString());
		expireDateField.setText(table.getValueAt(selected, 18).toString());
		packingDateField.setText(table.getValueAt(selected, 19).toString());
		
		
		try {
			String query1 = "select* from producttexts where textsID=";
			String query2 = table.getValueAt(selected, 0).toString();
			String finalquery = query1+query2;
    		Connection con1 =  DriverManager.getConnection(url,uname,pass);
    		Statement statement1 = con1.createStatement();
    		ResultSet result1 = statement1.executeQuery(finalquery);
    		ResultSetMetaData rsmt1 = result1.getMetaData();
    		
    		int c1 = rsmt1.getColumnCount();
    		Vector data1 = new Vector();
    		Vector row1 = new Vector();
    		
    		while(result1.next()) {
    			row1 = new Vector(c1);
    			
    				for(int i=1;i<=c1;i++) {
	    				array.add(result1.getString(i));
    			

    			}
    			
    		}
    		
    		if(!array.isEmpty()) {
    			Text1.setText(array.get(1));
        		Text2.setText(array.get(2));
        		Text3.setText(array.get(3));
        		Text4.setText(array.get(4));
        		Text5.setText(array.get(5));
        		Text6.setText(array.get(6));
        		Text7.setText(array.get(7));
        		Text8.setText(array.get(8));
        		Text9.setText(array.get(9));
        		Text10.setText(array.get(10));
        		Text11.setText(array.get(11));
        		Text12.setText(array.get(12));
        		Text13.setText(array.get(13));
        	    Text14.setText(array.get(14));
        		Text15.setText(array.get(15));
        		Text16.setText(array.get(16));
        		Text17.setText(array.get(17));
        		Text18.setText(array.get(18));
        		Text19.setText(array.get(19));
        		Text20.setText(array.get(20));
        		Text21.setText(array.get(21));
        		Text22.setText(array.get(22));
        		Text23.setText(array.get(23));
        		Text24.setText(array.get(24));
        		Text25.setText(array.get(25));
        		Text26.setText(array.get(26));
        		Text27.setText(array.get(27));
        		Text28.setText(array.get(28));
        		Text29.setText(array.get(29));
        		Text30.setText(array.get(30));	
    		}
    		
		}catch(SQLException e1) {
    		e1.printStackTrace();
	
		}
		

		idField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                  e.consume();  // if it's not a number, ignore the event
	             }
	             
	         }
			

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
	      });

		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(save);
		buttonBox.add(Box.createRigidArea(new Dimension(50,10)));
		buttonBox.add(keyboard);
		buttonBox.add(Box.createRigidArea(new Dimension(50,10)));
		buttonBox.add(close);
		save.setPreferredSize(new Dimension(100,60));
		close.setPreferredSize(new Dimension(100,60));
		save.setAlignmentY(Component.CENTER_ALIGNMENT);
		close.setAlignmentY(Component.CENTER_ALIGNMENT);
    		
    		JDateChooser chooser = new JDateChooser();
    		chooser.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
            chooser.setPreferredSize(new Dimension(28,7));
    		//chooser.getJCalendar().setPreferredSize(new Dimension(300,400));
    		
    		JDateChooser packingChooser = new JDateChooser();
    		packingChooser.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
            packingChooser.setPreferredSize(new Dimension(28,7));
    		//packingChooser.getJCalendar().setPreferredSize(new Dimension(300,400));

    		JPanel productEditPanel = new JPanel();
    		JPanel textsPanel = new JPanel();
    		JPanel allPanel = new JPanel(new BorderLayout());
    		
    		JDialog myDialog = new JDialog(this,"Επεξεργασία προϊόντος",ModalityType.APPLICATION_MODAL);
    		myDialog.setPreferredSize(new Dimension(700,700));
    		
    		JScrollPane pane = new  JScrollPane(productEditPanel);
    		int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
        	int vericalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
        	pane.setHorizontalScrollBarPolicy(horizontalPolicy);
        	pane.setVerticalScrollBarPolicy(vericalPolicy);
    		pane.setVisible(true);
    		
    		idLabel.setFont(new Font("Arial",Font.BOLD,13));
    		barcodeLabel.setFont(new Font("Arial",Font.BOLD,13));
    		daysToexpireLabel.setFont(new Font("Arial",Font.BOLD,13));
    		idField.setPreferredSize(new Dimension(40,30));
    		daysToexpireField.setPreferredSize(new Dimension(40,30));
    		barcodeField.setPreferredSize(new Dimension(40,30));
    		
    		Box box1 = Box.createHorizontalBox();
    		idLabel.setText("CODE:");
    		daysToexpireLabel.setText("DAYS TO EXPIRE:");
    		barcodeLabel.setText("BARCODE:");
    		expireDateLabel.setFont(new Font("Arial",Font.BOLD,13));
    		expireDateLabel.setText("EXPIRATION:");
    		expireDateField.setPreferredSize(new Dimension(100,30));
    		box1.add(idLabel);
    		box1.add(idField);
    		box1.add(Box.createRigidArea(new Dimension(40,10)));
    		box1.add(barcodeLabel);
    		box1.add(barcodeField);
    		box1.add(Box.createRigidArea(new Dimension(40,10)));
    		box1.add(daysToexpireLabel);
    		box1.add(daysToexpireField);
    		box1.add(Box.createRigidArea(new Dimension(40,10)));
    		box1.add(Box.createRigidArea(new Dimension(40,10)));
    		box1.add(expireDateLabel);
    		box1.add(expireDateField);
    		
    		
    		//chooser.setDate(new Date());
    		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    		
    		//String date = dateFormat.format(chooser.getDate());
    		//dateProductField.setText(date);
    		
    		Box box2 = Box.createHorizontalBox();
    		descriptionLabel.setFont(new Font("Arial",Font.BOLD,13));
    		descriptionLabel.setText("DESCRIPTION:");
    		dateproductLabel.setFont(new Font("Arial",Font.BOLD,13));
    		dateproductLabel.setText("DATE PRODUCT:");
    		descriptionField.setPreferredSize(new Dimension(170,30));
    		dateProductField.setPreferredSize(new Dimension(100,30));
    		
    		packingDateLabel.setFont(new Font("Arial",Font.BOLD,13));
    		packingDateLabel.setText("PACKING DATE:");
    		packingDateField.setPreferredSize(new Dimension(120,30));
    		
    		box2.add(descriptionLabel);
    		box2.add(descriptionField);
    		box2.add(Box.createRigidArea(new Dimension(60,10)));
    		box2.add(dateproductLabel);
    		box2.add(dateProductField);
    		box2.add(chooser);
    		box2.add(Box.createRigidArea(new Dimension(40,10)));
    		box2.add(packingDateLabel);
    		box2.add(packingDateField);
    		box2.add(packingChooser);
    		
    		chooser.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if("date".equals(evt.getPropertyName())) {
						Date date = (Date)evt.getNewValue();
						String newDate = dateFormat.format(date);
						dateProductField.setText(newDate);
					}
					
				}
    			
    		});
    		
    		packingChooser.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if("date".equals(evt.getPropertyName())) {
						Date date = (Date)evt.getNewValue();
						String newDate = dateFormat.format(date);
						packingDateField.setText(newDate);
					}
					
				}
    			
    		});
    		
    		tarePercentageField.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
		             char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		                  e.consume();  // if it's not a number, ignore the event
		             }
		             
		         }

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
    			
    		});
    		
    		Box box3 = Box.createHorizontalBox();
    		priceLabel.setFont(new Font("Arial",Font.BOLD,13));
    		priceLabel.setText("PRICE:");
    		piecesperboxLabel.setFont(new Font("Arial",Font.BOLD,13));
    		piecesperboxLabel.setText("PIECESPERBOX:");
    		piecesperboxField.setPreferredSize(new Dimension(40,30));
    		priceField.setPreferredSize(new Dimension(40,30));
    		lotLabel.setFont(new Font("Arial",Font.BOLD,13));
    		lotLabel.setText("LOT:");
    		lotField.setPreferredSize(new Dimension(40,20));
    		box3.add(priceLabel);
    		box3.add(priceField);
    		box3.add(Box.createRigidArea(new Dimension(40,10)));
    		box3.add(piecesperboxLabel);
    		box3.add(piecesperboxField);
    		box3.add(Box.createRigidArea(new Dimension(40,10)));
    		box3.add(lotLabel);
    		box3.add(lotField);

    		Box box4 = Box.createHorizontalBox();
    		labelPieceLabel.setFont(new Font("Arial",Font.BOLD,13));
    		labelPieceLabel.setText("LABELPIECE:");
    		labelPieceField.setPreferredSize(new Dimension(30,20));
    		boxesperpalleteLabel.setText("BOXESPERPALLETE:");
    		boxesperpalleteLabel.setFont(new Font("Arial",Font.BOLD,13));
    		boxesperpalleteField.setPreferredSize(new Dimension(40,30));
    		serialNumberLabel.setFont(new Font("Arial",Font.BOLD,13));
    		serialNumberLabel.setText("SERIAL NUMBER:");
    		serialNumberField.setPreferredSize(new Dimension(40,30));	
    		box4.add(labelPieceLabel);
    		box4.add(labelPieceField);
    		box4.add(Box.createRigidArea(new Dimension(40,10)));
    		box4.add(boxesperpalleteLabel);
    		box4.add(boxesperpalleteField);
    		box4.add(Box.createRigidArea(new Dimension(40,10)));
    		box4.add(serialNumberLabel);
    		box4.add(serialNumberField);
    		
    		Box box5 = Box.createHorizontalBox();
    		labelBoxLabel.setFont(new Font("Arial",Font.BOLD,13));
    		labelBoxLabel.setText("LABELBOX:");
    		labelBoxField.setPreferredSize( new Dimension(70,30));
    		tarePercentageLabel.setFont(new Font("Arial",Font.BOLD,13));
    		tarePercentageLabel.setText("PERCENTAGE(%):");
    		tarePercentageField.setPreferredSize(new Dimension(70,30));
    		underWeightLabel.setFont(new Font("Arial",Font.BOLD,13));
    		underWeightLabel.setText("UNDERWEIGHT:");
    		underWeightField.setPreferredSize(new Dimension(70,30));
    		smallItemWeightLabel.setFont(new Font("Arial",Font.BOLD,13));
    		smallItemWeightLabel.setText("SMALLITEMWEIGHT:");
    		smallItemWeightField.setPreferredSize(new Dimension(70,30));
    		
    		box5.add(labelBoxLabel);
    		box5.add(labelBoxField);
    		box5.add(Box.createRigidArea(new Dimension(50,10)));
    		box5.add(underWeightLabel);
    		box5.add(underWeightField);
    		box5.add(Box.createRigidArea(new Dimension(50,10)));
    		box5.add(smallItemWeightLabel);
    		box5.add(smallItemWeightField);
    		box5.add(Box.createRigidArea(new Dimension(50,10)));
    		box5.add(tarePercentageLabel);
    		box5.add(tarePercentageField);
    		
    		Box box6 = Box.createHorizontalBox();
    		labelPalleteLabel.setFont(new Font("Arial",Font.BOLD,13));
    		labelPalleteLabel.setText("LABELPALETTE:");
    		labelPalleteField.setPreferredSize(new Dimension(40,30));
    		overWeightLabel.setFont(new Font("Arial",Font.BOLD,13));
    		overWeightLabel.setText("OVERWEIGHT:");
    		overWeightField.setPreferredSize(new Dimension(40,30));
    		box6.add(labelPalleteLabel);
    		box6.add(labelPalleteField);
    		box6.add(Box.createRigidArea(new Dimension(40,10)));
    		box6.add(overWeightLabel);
    		box6.add(overWeightField);
    		
    		Box vBox = Box.createVerticalBox();
    		
    		vBox.add(box1);
    		vBox.add(Box.createRigidArea(new Dimension(20,10)));
    		vBox.add(box2);
    		vBox.add(Box.createRigidArea(new Dimension(20,10)));
    		vBox.add(box3);
    		vBox.add(Box.createRigidArea(new Dimension(20,10)));
    		vBox.add(box4);
    		vBox.add(Box.createRigidArea(new Dimension(20,10)));
    		vBox.add(box5);
    		vBox.add(Box.createRigidArea(new Dimension(20,10)));
    		vBox.add(box6);
    		
    		productEditPanel.add(vBox);
    		
    		TextLabel1.setText("Text 1:");
    		TextLabel2.setText("Text 2:");
    		TextLabel3.setText("Text 3:");
    		TextLabel4.setText("Text 4:");
    		TextLabel5.setText("Text 5:");
    		TextLabel6.setText("Text 6:");
    		TextLabel7.setText("Text 7:");
    		TextLabel8.setText("Text 8:");
    		TextLabel9.setText("Text 9:");
    		TextLabel10.setText("Text 10:");
    		TextLabel11.setText("Text 11:");
    		TextLabel12.setText("Text 12:");
    		TextLabel13.setText("Text 13:");
    		TextLabel14.setText("Text 14:");
    		TextLabel15.setText("Text 15:");
    		TextLabel16.setText("Text 16:");
    		TextLabel17.setText("Text 17:");
    		TextLabel18.setText("Text 18:");
    		TextLabel19.setText("Text 19:");
    		TextLabel20.setText("Text 20:");
    		TextLabel21.setText("Text 21:");
    		TextLabel22.setText("Text 22:");
    		TextLabel23.setText("Text 23:");
    		TextLabel24.setText("Text 24:");
    		TextLabel25.setText("Text 25:");
    		TextLabel26.setText("Text 26:");
    		TextLabel27.setText("Text 27:");
    		TextLabel28.setText("Text 28:");
    		TextLabel29.setText("Text 29:");
    		TextLabel30.setText("Text 30:");
    		
    		
    		Text1.setPreferredSize(new Dimension(180,27));
    		Text2.setPreferredSize(new Dimension(180,27));
    		Text3.setPreferredSize(new Dimension(180,27));
    		Text4.setPreferredSize(new Dimension(180,27));
    		Text5.setPreferredSize(new Dimension(180,27));
    		Text6.setPreferredSize(new Dimension(180,27));
    		Text7.setPreferredSize(new Dimension(180,27));
    		Text8.setPreferredSize(new Dimension(180,27));
    		Text9.setPreferredSize(new Dimension(180,27));
    		Text10.setPreferredSize(new Dimension(180,27));
    		Text11.setPreferredSize(new Dimension(180,27));
    		Text12.setPreferredSize(new Dimension(180,27));
    		Text13.setPreferredSize(new Dimension(180,27));
    	    Text14.setPreferredSize(new Dimension(180,27));
    		Text15.setPreferredSize(new Dimension(180,27));
    		Text16.setPreferredSize(new Dimension(180,27));
    		Text17.setPreferredSize(new Dimension(180,27));
    		Text18.setPreferredSize(new Dimension(180,27));
    		Text19.setPreferredSize(new Dimension(180,27));
    		Text20.setPreferredSize(new Dimension(180,27));
    		Text21.setPreferredSize(new Dimension(180,27));
    		Text22.setPreferredSize(new Dimension(180,27));
    		Text23.setPreferredSize(new Dimension(180,27));
    		Text24.setPreferredSize(new Dimension(180,27));
    		Text25.setPreferredSize(new Dimension(180,27));
    		Text26.setPreferredSize(new Dimension(180,27));
    		Text27.setPreferredSize(new Dimension(180,27));
    		Text28.setPreferredSize(new Dimension(180,27));
    		Text29.setPreferredSize(new Dimension(180,27));
    		Text30.setPreferredSize(new Dimension(180,27));
    		
    		
    		
    		
    		Box txt1 = Box.createHorizontalBox();
    		Box txt2 = Box.createHorizontalBox();
    		Box txt3 = Box.createHorizontalBox();
    		Box txt4 = Box.createHorizontalBox();
    		Box txt5 = Box.createHorizontalBox();
    		Box txt6 = Box.createHorizontalBox();
    		Box txt7 = Box.createHorizontalBox();
    		Box txt8 = Box.createHorizontalBox();
    		Box txt9 = Box.createHorizontalBox();
    		Box txt10 = Box.createHorizontalBox();
    		Box txt11= Box.createHorizontalBox();
    		Box txt12 = Box.createHorizontalBox();
    		Box txt13 = Box.createHorizontalBox();
    		Box txt14 = Box.createHorizontalBox();
    		Box txt15 = Box.createHorizontalBox();
    		Box txt16 = Box.createHorizontalBox();
    		Box txt17 = Box.createHorizontalBox();
    		Box txt18 = Box.createHorizontalBox();
    		Box txt19 = Box.createHorizontalBox();
    		Box txt20 = Box.createHorizontalBox();
    		Box txt21 = Box.createHorizontalBox();
    		Box txt22 = Box.createHorizontalBox();
    		Box txt23 = Box.createHorizontalBox();
    		Box txt24 = Box.createHorizontalBox();
    		Box txt25 = Box.createHorizontalBox();
    		Box txt26 = Box.createHorizontalBox();
    		Box txt27 = Box.createHorizontalBox();
    		Box txt28 = Box.createHorizontalBox();
    		Box txt29 = Box.createHorizontalBox();
    		Box txt30 = Box.createHorizontalBox();
    		
    		
    		Box lab1 = Box.createVerticalBox();
    		Box lab2 = Box.createVerticalBox();
    		Box lab3 =Box.createVerticalBox();
    		
    		txt1.add(TextLabel1);
    		txt1.add(Text1);
    		
    		txt2.add(TextLabel2);
    		txt2.add(Text2);
    		
    		txt3.add(TextLabel3);
    		txt3.add(Text3);
    		
    		txt4.add(TextLabel4);
    		txt4.add(Text4);
    		
    		txt5.add(TextLabel5);
    		txt5.add(Text5);
    		
    		txt6.add(TextLabel6);
    		txt6.add(Text6);
    		
    		txt7.add(TextLabel7);
    		txt7.add(Text7);
    		
    		txt8.add(TextLabel8);
    		txt8.add(Text8);
    		
    		txt9.add(TextLabel9);
    		txt9.add(Text9);
    		
    		txt10.add(TextLabel10);
    		txt10.add(Text10);
    		
    		txt11.add(TextLabel11);
    		txt11.add(Text11);
    		
    		txt12.add(TextLabel12);
    		txt12.add(Text12);
    		
    		txt13.add(TextLabel13);
    		txt13.add(Text13);
    		
    		txt14.add(TextLabel14);
    		txt14.add(Text14);
    		
    		txt15.add(TextLabel15);
    		txt15.add(Text15);
    		
    		txt16.add(TextLabel16);
    		txt16.add(Text16);
    		
    		txt17.add(TextLabel17);
    		txt17.add(Text17);
    		
    		txt18.add(TextLabel18);
    		txt18.add(Text18);
    		
    		txt19.add(TextLabel19);
    		txt19.add(Text19);
    		
    		txt20.add(TextLabel20);
    		txt20.add(Text20);
    		
    		txt21.add(TextLabel21);
    		txt21.add(Text21);
    		
    		txt22.add(TextLabel22);
    		txt22.add(Text22);
    		
    		txt23.add(TextLabel23);
    		txt23.add(Text23);
    		
    		txt24.add(TextLabel24);
    		txt24.add(Text24);
    		
    		txt25.add(TextLabel25);
    		txt25.add(Text25);
    		
    		txt26.add(TextLabel26);
    		txt26.add(Text26);
    		
    		txt27.add(TextLabel27);
    		txt27.add(Text27);
    		
    		txt28.add(TextLabel28);
    		txt28.add(Text28);
    		
    		txt29.add(TextLabel29);
    		txt29.add(Text29);
    		
    		txt30.add(TextLabel30);
    		txt30.add(Text30);
    		
    		lab1.add(txt1);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt2);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt3);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt4);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt5);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt6);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt7);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt8);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt9);
    		lab1.add(Box.createRigidArea(new Dimension(8,8)));
    		lab1.add(txt10);
    		
    		
    		//lab2.add(Box.createRigidArea(new Dimension(10,10)));
    		lab2.add(txt11);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt12);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt13);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt14);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt15);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt16);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt17);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt18);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt19);
    		lab2.add(Box.createRigidArea(new Dimension(8,8)));
    		lab2.add(txt20);
    		
    		
    		
    		lab3.add(txt21);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt22);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt23);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt24);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt25);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt26);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt27);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt28);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt29);
    		lab3.add(Box.createRigidArea(new Dimension(8,8)));
    		lab3.add(txt30);
 
    		
    		Box hBox = Box.createHorizontalBox();
    		
    	
    		hBox.add(lab1);
    		hBox.add(Box.createRigidArea(new Dimension(30,0)));
    		hBox.add(lab2);
    		hBox.add(Box.createRigidArea(new Dimension(30,0)));
    		hBox.add(lab3);
    		
    		textsPanel.add(hBox);
    		JPanel southPanel = new JPanel();
    		southPanel.add(buttonBox);
    		southPanel.setPreferredSize(new Dimension(200,80));
    		productEditPanel.setBorder(BorderFactory.createTitledBorder("Στοιχεία προϊόντος"));
    		textsPanel.setBorder(BorderFactory.createTitledBorder("Κείμενα προϊόντος"));
    		allPanel.add(productEditPanel,BorderLayout.PAGE_START);
    		allPanel.add(textsPanel,BorderLayout.CENTER);
    		allPanel.add(southPanel,BorderLayout.PAGE_END);
    		
    		
    		save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					
					
		    		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String productionDate = dateProductField.getText();
					int day = Integer.valueOf(daysToexpireField.getText());
		    		Calendar c = Calendar.getInstance();
		    		Date date;
					try {
						date = formatter.parse(productionDate);
						c.setTime(date);
			    		c.add(Calendar.DAY_OF_YEAR, day);
			    		String newC = dateFormat.format(c.getTime());
			    		expireDateField.setText(newC);
			    		
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
		    		
		    		
						 String id = table.getValueAt(selected, 0).toString();
						 String deleteQuery = "delete from producttexts where textsId=";
						 String finaldelete = deleteQuery+id;
						  try {
						  statement.executeUpdate(finaldelete);
						  } catch (SQLException e1) {
							  e1.printStackTrace();
						  }
						
						
						  try {
								int pId = Integer.parseInt(idField.getText().trim());		
		    					
								String query1 = "insert into producttexts(textsId,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28,text29,text30) "
										+ "values("+pId+",'"+Text1.getText()+"','"+Text2.getText()+"','"+Text3.getText()+"','"+Text4.getText()+"','"+Text5.getText()+"',"
										+ "'"+Text6.getText()+"','"+Text7.getText()+"','"+Text8.getText()+"','"+Text9.getText()+"','"+Text10.getText()+"','"+Text11.getText()+"','"+Text12.getText()+"','"+Text13.getText()+"','"+Text14.getText()+"','"+Text15.getText()+"','"+Text16.getText()+"','"+Text17.getText()+"','"+Text18.getText()+"','"+Text19.getText()+"','"+Text20.getText()+"'"
												+ ",'"+Text21.getText()+"','"+Text22.getText()+"','"+Text23.getText()+"','"+Text24.getText()+"','"+Text25.getText()+"','"+Text26.getText()+"','"+Text27.getText()+"','"+Text28.getText()+"','"+Text29.getText()+"','"+Text30.getText()+"')";
								statement.executeUpdate(query1);
								
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
		    				
					id = idField.getText();
					barcode = barcodeField.getText();
					description = descriptionField.getText();
					price = priceField.getText();
					daysToexpire = daysToexpireField.getText();
					dateProductString = dateProductField.getText();
					lot = lotField.getText();
					serialNumber = serialNumberField.getText();
					tarePercentage = tarePercentageField.getText();
					smallItemWeight = smallItemWeightField.getText();
					piecesperbox = piecesperboxField.getText();
					boxesperpallete = boxesperpalleteField.getText();
					labelPiece = labelPieceField.getText();
					labelBox = labelBoxField.getText();
					labelPallete = labelPalleteField.getText();
					underWeight = underWeightField.getText();
					overWeight = overWeightField.getText();
					expireDate = expireDateField.getText();
					System.out.println("This is the production date"+ dateProductString);
					packingDate = packingDateField.getText();
					
						if(!idField.getText().equals("")) {
						initTable.setValueAt(Integer.parseInt(id.trim()), selected, 0);
						}else {
							new OnlyNumberErrorGUI();
						}
						
						initTable.setValueAt(barcode, selected, 1);
						initTable.setValueAt(description, selected, 2);
						PreparedStatement ps = null;	
   				try {
   					
   						int idProduct = Integer.parseInt(initTable.getValueAt(selected, 0).toString());
						int pId = Integer.parseInt(id);	
						int ppb=0;
						int bpp=0;
						if(piecesperbox.equals("")) {
							ppb = 0;
						}else {
							ppb = Integer.parseInt(piecesperbox.trim());
						
						}
						if(boxesperpallete.equals("")) {
							bpp = 0;
						}else {
							bpp = Integer.parseInt(boxesperpallete.trim());
						
						}
						
						String query1 = "update products set idProducts = ?,barcode = ?,description=?,price=?,daystoexpire=?,dateproduct=?,lot=?,serialNumber =?,tarePercentage=?,piecesperbox=?,boxesperpallete=?,labelpiece=?,labelbox=?,smallItemWeight=?,labelpallete=?,underWeight=?,overWeight=?,textsId=?,expireDate=?,packingDate=? where idProducts=?";
						ps = con.prepareStatement(query1);
						 ps.setInt(1,pId);
				         ps.setString(2, barcode);
				         ps.setString(3, description);
				         ps.setString(4, price);
				         ps.setString(5, daysToexpire);
				         ps.setString(6, dateProductString);
				         ps.setString(7, lot);
				         ps.setString(8, serialNumber);
				         ps.setString(9, tarePercentage);
				         ps.setInt(10, ppb);
				         ps.setInt(11, bpp);
				         ps.setString(12, labelPiece);
				         ps.setString(13, labelBox);
				         ps.setString(14, smallItemWeight);
				         ps.setString(15, labelPallete);
				         ps.setString(16, underWeight);
				         ps.setString(17, overWeight);
				         ps.setInt(18, pId);
				         ps.setString(19, expireDate);
				         ps.setString(20, packingDate);
				         ps.setInt(21, pId);
				         ps.executeUpdate();
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
   					
   				 	
   					
   					datesList.removeAll(datesList);
   					datesList.add(dateProductField.getText());
   					datesList.add(expireDateField.getText());
   					datesList.add(packingDateField.getText());
						
						new SuccessSaveGUI();
						
				}
    			
    		});
    		
    		JFrame pluFrame = new JFrame();
    		pluFrame.setFocusable(true);
    		
    		close.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					pluFrame.dispose();
					
				}
    			
    		});
    		
    		keyboard.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(textFieldClicked.size()>0) {
					
					MyJFrame f = new MyJFrame(textFieldClicked.get(textFieldClicked.size()-1));
					
					
					textFieldClicked.get(textFieldClicked.size()-1).setText(f.getTb1().getText());
					}
				}
    			
    		});
    		
    		pluFrame.setUndecorated(true);
    		pluFrame.add(allPanel);
    		pluFrame.pack();
    		
    		pluFrame.setLocationRelativeTo(null);
    		pluFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    		pluFrame.setVisible(true);

    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	
		
    	}
	}



