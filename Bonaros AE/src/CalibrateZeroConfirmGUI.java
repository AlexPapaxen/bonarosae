import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class CalibrateZeroConfirmGUI extends JFrame {
	
	private JButton yes = new JButton();
	private JButton no = new JButton();
	private JPanel message = new JPanel();
	private JPanel allPanel = new JPanel(new BorderLayout());
	private JLabel zeroing = new JLabel("Zeroing");
	private JPanel buttonPanel = new JPanel();
	private OutputStream outputstream;
	private static int selection;
	private static JLabel net;
	private static String netDataBuffer;
	private static JLabel tareLabel;
	private static ArrayList<String> arrayList = new ArrayList<>();
	private static JLabel grossWeight;
	private ArrayList<String> grossWeightsList = new ArrayList<String>();
	private SerialPort myPort;
	private InputStream inputstream;
	
	private JTextArea messageLabel = new JTextArea("The zero values are stored to the EEPROM"
			+ " memory,please\nnote that the writing number allowed is limited (about 100000).\n"
			+ "If it is necessary to reset the weight quite often, it is recommended to perform it\n"
			+ "by PC or PLC program, keeping in mind the weight deviation respect to the zero instrument");

	
	public CalibrateZeroConfirmGUI(SerialPort port) {
		
		//SerialPort port1 = SerialPort.getCommPorts()[0];
		//port1.setComPortParameters(9600, 8, 1, 0);
		//port1.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1200, 1200);
		//port1.flushIOBuffers();
		//port1.openPort();
		
		
		JScrollPane scrollPane = new JScrollPane(messageLabel);
		messageLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
		//scrollPane.setBounds(10,60,300,500);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		messageLabel.setEditable(false);
		JDialog dialog = new JDialog(this,"Calibrate Zero",ModalityType.APPLICATION_MODAL);
		
		
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.setPreferredSize(new Dimension(10,10));
		
		Box zeroBox = Box.createHorizontalBox();
		
		
		zeroing.setOpaque(false);
		zeroing.setFont(new Font("Arial",Font.BOLD,20));
		zeroBox.add(Box.createRigidArea(new Dimension(250,0)));
		zeroBox.add(zeroing);


		
		messageLabel.setFont(new Font("Arial",Font.BOLD,12));	
		
		
		Image exitImage = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		no.setIcon(new ImageIcon(exitImage));
		no.setFocusPainted(false);
		no.setContentAreaFilled(false);
		no.setOpaque(false);
		no.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//if(port1.isOpen()) {
				//port1.closePort();
				//}
				dialog.dispose();
				
			}
			
		});
		
		Image yesImage = new ImageIcon(this.getClass().getResource("check.png")).getImage();
		yes.setIcon(new ImageIcon(yesImage));
		yes.setFocusPainted(false);
	    yes.setContentAreaFilled(false);
	    yes.setOpaque(false);
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					//if(port1.isOpen()) {
						new ScaleController(port,1,netDataBuffer);
			
					//}
					//else {
						//System.out.println("Port is closed ! ");
				//	}
				
				
				}
				
			
			
		});
		
		buttonPanel.add(yes);
		buttonPanel.add(buttonBox);
		buttonPanel.add(no);
		allPanel.add(zeroBox,BorderLayout.PAGE_START);
		allPanel.add(scrollPane,BorderLayout.CENTER);
		allPanel.add(buttonPanel,BorderLayout.PAGE_END);
		
		dialog.add(allPanel);
		
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setSize(new Dimension(600,300));
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
        
		
	}
	
	
	
	
	
	

}
