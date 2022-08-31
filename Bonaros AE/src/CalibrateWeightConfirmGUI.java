import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;

public class CalibrateWeightConfirmGUI extends JFrame {
	private JButton yes = new JButton();
	private JButton no = new JButton();
	
	private JPanel allPanel = new JPanel(new BorderLayout());
	private JLabel zeroing = new JLabel("Continue calibrate with sample weight ?");
	private JPanel buttonPanel = new JPanel();
	

	private JTextArea messageLabel = new JTextArea("This function allow operator to check the calibration\nobtained by using sample weights and correct automatically\nany change between the displayed value and the correct one.");
	private SerialPort port;
	
	
	
	
	
	public CalibrateWeightConfirmGUI(String arrayList,SerialPort port) {
		
		//SerialPort port3 = SerialPort.getCommPorts()[0];
		//port3.setComPortParameters(9600, 8, 1, 0);
		//port3.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1200, 1200);
		//port3.flushIOBuffers();
		//port3.openPort();
		
		
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
		zeroBox.add(Box.createRigidArea(new Dimension(120,0)));
		zeroBox.add(zeroing);


		
		messageLabel.setFont(new Font("Arial",Font.BOLD,15));	
		messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Image exitImage = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		no.setIcon(new ImageIcon(exitImage));
		no.setFocusPainted(false);
		no.setContentAreaFilled(false);
		no.setOpaque(false);
		no.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//if(port3.isOpen()) {
					//port3.closePort();
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
					
					new ScaleController(port,2,arrayList);
				
		
				
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
