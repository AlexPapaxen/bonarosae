import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.fazecast.jSerialComm.SerialPort;

public class TareGUI extends JFrame {
	
	

	private ArrayList<String> arrayList =  new ArrayList<>();
	private JLabel lot = new JLabel("TARE: ");
	private  static JTextField tareField = new JTextField();
	
	private JButton key = new JButton();
	private JButton save = new JButton();
	private JButton weigh = new JButton();
	
	private JButton close = new JButton();
	private JPanel tareGUIpanel = new JPanel();
	JPanel boxPanel = new JPanel();
	private JFrame tareGUIframe = new JFrame("TARE");
	
	private static JTextArea area = new JTextArea();
	private String text="";
	
	
	
	public TareGUI(JLabel label, ArrayList<String> array) {
		
		Image logo = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		close.setIcon(new ImageIcon(logo));
		
		tareField.setEditable(false);
		
		lot.setFont(new Font("Arial",Font.BOLD,15));
		Box box = Box.createHorizontalBox();
		Box downBox = Box.createHorizontalBox();
		Box midBox = Box.createVerticalBox();
		
		midBox.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		midBox.setPreferredSize(new Dimension(800,700));
		
		lot.setPreferredSize(new Dimension(100,100));
		tareField.setPreferredSize(new Dimension(100,20));
		lot.setAlignmentX(Component.CENTER_ALIGNMENT);
		tareField.setAlignmentX(Component.CENTER_ALIGNMENT);
		tareField.setFont(new Font("Arial",Font.BOLD,30));
		
		
		
		save.setPreferredSize(new Dimension(60,60));
		save.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		save.setFont(new Font("Arial",Font.BOLD,15));
		Image saveLogo = new ImageIcon(this.getClass().getResource("save.png")).getImage();
	    save.setIcon(new ImageIcon(saveLogo));
	    save.setOpaque(false);
	    save.setFocusPainted(false);
	    save.setContentAreaFilled(false);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tareField.getText().equals("0")) {
					label.setText("00,00");
				}
				else if(tareField.getText().equals("")) {
					label.setText("00,00");
				} else {
					label.setText(tareField.getText());
				}
				
				
				String last = array.get(array.size()-1).toString();
				if(tareField.getText().equals(last)){
					new TareErrorGUI();
					
				}
				else {
					new SaveGUI(tareField);
				}
				
				
			}
			
		});
		

		key.setPreferredSize(new Dimension(60,60));
		key.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		Image keyLogo = new ImageIcon(this.getClass().getResource("dial.png")).getImage();
	    key.setIcon(new ImageIcon(keyLogo));
	    key.setOpaque(false);
		key.setFocusPainted(false);
		key.setContentAreaFilled(false);
		
		key.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				KeyPad panel = new KeyPad(tareField,array);
				
								
				
					
			}
				
		});
		
		
		weigh.setPreferredSize(new Dimension(100,100));
		weigh.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		Image weighLogo = new ImageIcon(this.getClass().getResource("weight-scale.png")).getImage();
		weigh.setIcon(new ImageIcon(weighLogo));
		weigh.setOpaque(false);
		weigh.setFocusPainted(false);
		weigh.setContentAreaFilled(false);
		
		
		weigh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WeightTareGUI(array,tareField);
				
			}
			
		});
		
		
		
		close.setPreferredSize(new Dimension(60,60));
		close.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		close.setOpaque(false);
		close.setFocusPainted(false);
		close.setContentAreaFilled(false);
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tareGUIframe.dispose();
				
			}
			
		});
		 
		
		box.add(lot); 
		box.add(Box.createRigidArea(new Dimension(10,10)));
		box.add(tareField);
		box.add(Box.createRigidArea(new Dimension(20,20)));
		box.add(key);
		
		
		downBox.setPreferredSize(new Dimension(30,100));
		
		downBox.add(save);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(weigh);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(close);
		
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		midBox.add(Box.createRigidArea(new Dimension(290,290)));
		midBox.add(box);
		midBox.add(Box.createRigidArea(new Dimension(230,230)));
		midBox.add(downBox);
		
		tareGUIpanel.add(midBox);			
		tareGUIframe.setLayout(new BorderLayout());
		tareGUIframe.add(tareGUIpanel);
		tareGUIframe.setUndecorated(true);
		tareGUIframe.pack();
		tareGUIframe.setLocationRelativeTo(null);
		tareGUIframe.setBounds(300, 300, 500, 500);
		tareGUIframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tareGUIframe.setVisible(true);
		
		
		
	}
	

}
