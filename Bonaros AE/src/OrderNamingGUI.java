import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class OrderNamingGUI extends JFrame {
	
	private JFrame orderFrame = new JFrame();
	private JPanel orderPanel = new JPanel(new GridBagLayout());
	private JLabel orderLabel = new JLabel();
	private JTextField ordername = new JTextField();

	private GridBagConstraints keyboard = new GridBagConstraints();
	private GridBagConstraints textfield = new GridBagConstraints();
	private GridBagConstraints labelfield = new GridBagConstraints();
	private JButton keyboardButton = new JButton();
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
	public OrderNamingGUI() {
		
		
		
		keyboardButton.setPreferredSize(new Dimension(70,100));
		keyboardButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		//keyboardButton.setBorder(new EmptyBorder(5, 15, 5, 15));
		//Προσθήκη εικόνας πληκτρολογίου
		Image keyboardImg = new ImageIcon(this.getClass().getResource("/keyboard.png")).getImage();
		keyboardButton.setIcon(new ImageIcon(keyboardImg));
		
		//Προσθήκη κουμπιού ενεργοποίησης πληκτρολογίου
		keyboard.fill = GridBagConstraints.HORIZONTAL;
		
		keyboard.ipady = 45;       //reset to default
		keyboard.weighty = 1.0;   //request any extra vertical space
		keyboard.anchor = GridBagConstraints.LAST_LINE_START; //bottom of space
		keyboard.insets = new Insets(10,30,10,800);  //top padding
		keyboard.gridx = 0;       
		keyboard.gridwidth = 2;   //3 columns wide
		keyboard.gridy = 2; //third row
		
		orderPanel.add(keyboardButton, keyboard);
		
		//Πορσθήκη πεδίου ονοματοδοσίας παραγγελίας
		
		textfield.fill = GridBagConstraints.HORIZONTAL;
		textfield.weightx = 0.0;
		textfield.gridwidth = 2;
		textfield.anchor = GridBagConstraints.PAGE_START;
		textfield.insets = new Insets(50,250,250,250);
	
		textfield.gridx = 0;
		textfield.gridy = 1;
		
		ordername.isEditable();
	
		orderPanel.add(ordername, textfield);
		
		//Προσθήκη ετικέτας
		
		labelfield.fill = GridBagConstraints.HORIZONTAL;
		labelfield.anchor = GridBagConstraints.PAGE_START;
		labelfield.weightx = 0.5;
		labelfield.gridx = 1;
		labelfield.gridy = 0;
		orderLabel.setText("ORDER");
		labelfield.insets = new Insets(100,460,100,100);
		orderPanel.add(orderLabel,labelfield);
		
		//Προσθήκη στοιχείων στο Frame
		orderFrame.add(orderPanel,BorderLayout.CENTER);
		orderFrame.setResizable(false);
		
		orderFrame.pack();
		orderFrame.setBounds(510,300, 1000, 700);
		orderFrame.setVisible(true);
		orderFrame.setTitle("Παραγγελία");
		orderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		orderFrame.setResizable(false);
		keyboardButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
		       new KeyboardGUI();
				
				
			}
			
			
			
		});
		
		
		
	}
	
	

}
