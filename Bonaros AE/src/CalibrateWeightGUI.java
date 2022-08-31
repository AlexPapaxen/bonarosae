import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;

public class CalibrateWeightGUI extends JFrame {
	
	private JButton editWeight = new JButton();
	private JButton close = new JButton();
	private JLabel message1 = new JLabel("This function allow the operator to check the calibration obtained by using sample weights");
	private JLabel message4 = new JLabel("and correct automatically any change between the displayed value and the correct one.");
	private JLabel message2 = new JLabel("Load onto the weighing system a sample weight, which must be at least 50% of the Full Scale.");
	private JLabel message3 = new JLabel("When you are ready press finish");
	private JButton calibrateWeight = new JButton("CALIBRATE");
	private JTextField weightField = new JTextField();
	private JPanel myPanel = new JPanel(new BorderLayout());
	private JPanel editPanel = new JPanel();
	private JFrame myFrame = new JFrame();
	private JPanel buttonPanel = new JPanel();
	private static String start ="";
	public CalibrateWeightGUI(ArrayList<String> arrayList,SerialPort port) {
		
		
		
		
		JFrame myFrame = new JFrame();
		
		Color southColor = new Color(123,154,190);
		Image exitImage = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		
		close.setIcon(new ImageIcon(exitImage));
		close.setOpaque(true);
		close.setFocusPainted(false);
		close.setBorderPainted(false);
		
		
		calibrateWeight.setBackground(southColor);   
	    calibrateWeight.setOpaque(true);
	    calibrateWeight.setFocusPainted(false);
	    calibrateWeight.setBorderPainted(false);
	    calibrateWeight.setPreferredSize(new Dimension(120,60));
		calibrateWeight.setFont(new Font("Arial",Font.BOLD,11));
	    
	    Image keyLogo = new ImageIcon(this.getClass().getResource("dial.png")).getImage();
	    editWeight.setIcon(new ImageIcon(keyLogo));
		editWeight.setBackground(southColor);
	    editWeight.setOpaque(false);
	    editWeight.setFocusPainted(false);
	    editWeight.setBorderPainted(false);
	    
	    
	    
	    
	    
		weightField.setPreferredSize(new Dimension(200,50));
		weightField.setEditable(false);
		weightField.setFont(new Font("Arial",Font.BOLD,15));
		weightField.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Box messageBox = Box.createVerticalBox();
		messageBox.add(Box.createRigidArea(new Dimension(0,250)));
		message1.setAlignmentX(Component.CENTER_ALIGNMENT);
		message1.setFont(new Font("Arial",Font.BOLD,15));
		messageBox.add(message1);
		message4.setFont(new Font("Arial",Font.BOLD,15));
		message4.setAlignmentX(Component.CENTER_ALIGNMENT);
		messageBox.add(message4);
		messageBox.add(Box.createRigidArea(new Dimension(0,10)));
		message2.setAlignmentX(Component.CENTER_ALIGNMENT);
		message2.setFont(new Font("Arial",Font.BOLD,15));
		messageBox.add(message2);
		messageBox.add(Box.createRigidArea(new Dimension(0,10)));
		message3.setFont(new Font("Arial",Font.BOLD,15));
		message3.setAlignmentX(Component.CENTER_ALIGNMENT);
		messageBox.add(message3);
		
		messageBox.setPreferredSize(new Dimension(200,400));
		
		Box editBox = Box.createHorizontalBox();
		editBox.add(Box.createRigidArea(new Dimension(600,0)));
		
		myPanel.add(messageBox);
		editPanel.add(editBox);
		editPanel.add(weightField);
		editPanel.add(editWeight);
		myPanel.setBackground(Color.LIGHT_GRAY);
		Box midBox =Box.createHorizontalBox();
		midBox.add(Box.createRigidArea(new Dimension(10,20)));
		
		buttonPanel.add(calibrateWeight);
		buttonPanel.add(midBox);
		buttonPanel.add(close);
		buttonPanel.setPreferredSize(new Dimension(100,100));
		int count =0;
		int j=0;
		String weight = arrayList.get(arrayList.size()-1).toString();
		String myWeight ="";
		char[] weightCar = weight.toCharArray();
		
		if(weight.equals("000000")) {
			weight = "0";
			weightField.setText(weight);
		}
		
		else {
			
			
			for(int i=0;i<3;i++) {
				char c = weightCar[i];
				System.out.println(c);
				if(c!='0' && count==0) {
					
					myWeight +=c;
					count+=1;
				}
				
			}
			if(myWeight.length()==0) {
				myWeight+="0";
			}
			String end = weight.substring(3);
			String finalString = myWeight +"," + end;
			weightField.setText(finalString);
		}
		
		
		
		
		editWeight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				KeyPadCalibrate pad =new KeyPadCalibrate(weightField,arrayList);
				
			}
			
		});
		
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				myFrame.dispose();
				
				
			}
			
		});
		
		calibrateWeight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String back="";
				String front="";
				String lastFront="";
				String lastBack ="";
				String frontFinal="";
				String backFinal="";
				String[] myStr = weightField.getText().split(",");
				if(myStr.length>2) {
				front = myStr[0];
				back = myStr[1];
				}
				
				int firstCount = front.length();
				int secondCount = back.length();	
				
				for(int i=0;i<3-firstCount;i++) {
					lastFront+="0";
					
				}
				
				frontFinal+=lastFront+front;
				
				for(int i=0;i<3-secondCount;i++) {
					lastBack+="0";
					
				}
				
				backFinal+=back+lastBack;
				
				
				String all = frontFinal + backFinal;
				
				
				new CalibrateWeightConfirmGUI(all,port);
				
			}
			
		});
		
		
		
		
		myPanel.setPreferredSize(new Dimension(1000,600));
		editPanel.setBackground(Color.LIGHT_GRAY);
		myFrame.add(myPanel,BorderLayout.PAGE_START);
		myFrame.add(editPanel,BorderLayout.CENTER);
		myFrame.add(buttonPanel,BorderLayout.PAGE_END);
		myFrame.setUndecorated(true);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setResizable(false);
		
		
		
		
		
	}

}
