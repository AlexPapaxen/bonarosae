import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class KeyPad extends JFrame {

String numberString = "";

JTextField jtf = new JTextField();
JButton b1 = new JButton("1");
JButton b2 = new JButton("2");
JButton b3 = new JButton("3");
JButton b4 = new JButton("4");
JButton b5 = new JButton("5");
JButton b6 = new JButton("6");
JButton b7 = new JButton("7");
JButton b8 = new JButton("8");
JButton b9 = new JButton("9");
JButton ba = new JButton(",");
JButton b0 = new JButton("0");
JButton bp = new JButton("C");
JButton ok = new JButton("OK");
JRadioButton percentage = new JRadioButton("Ποσοστιαίο απόβαρο");


public KeyPad(JTextField array,ArrayList<String> arrayList) {
	
	b0.setFont(new Font("Arial",Font.BOLD,18));
	b1.setFont(new Font("Arial",Font.BOLD,18));
	b2.setFont(new Font("Arial",Font.BOLD,18));
	b3.setFont(new Font("Arial",Font.BOLD,18));
	b4.setFont(new Font("Arial",Font.BOLD,18));
	b5.setFont(new Font("Arial",Font.BOLD,18));
	b6.setFont(new Font("Arial",Font.BOLD,18));
	b7.setFont(new Font("Arial",Font.BOLD,18));
	b8.setFont(new Font("Arial",Font.BOLD,18));
	b9.setFont(new Font("Arial",Font.BOLD,18));
	ba.setFont(new Font("Arial",Font.BOLD,18));
	bp.setFont(new Font("Arial",Font.BOLD,18));
	ok.setFont(new Font("Arial",Font.BOLD,18));
	
	
	
	
	
	
	
	
	
	JFrame frame = new JFrame();
    JDialog dialog = new JDialog(this,"Πληκτρολόγιο",ModalityType.APPLICATION_MODAL);

    JPanel panel1 = new JPanel(new GridLayout(4, 3));
    JPanel radioPanel = new JPanel();
    JPanel borderPanel = new JPanel(new BorderLayout());
    panel1.add(b1);
    panel1.add(b2);
    panel1.add(b3);
    panel1.add(b4);
    panel1.add(b5);
    panel1.add(b6);
    panel1.add(b7);
    panel1.add(b8);
    panel1.add(b9);
    panel1.add(ba);
    panel1.add(b0);
    panel1.add(bp);
  
    jtf.setPreferredSize(new Dimension(50,35));
    jtf.setEditable(false);
    jtf.setFont(new Font("Arial",Font.BOLD,15));
    jtf.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    Box hBox = Box.createHorizontalBox();
    hBox.add(percentage);
    hBox.add(ok);
    
    Box box = Box.createVerticalBox();
    box.add(hBox);
    box.add(jtf);
    
    

    
    radioPanel.add(box);
    radioPanel.setPreferredSize(new Dimension(100,70));
    b1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "1");
			}else {
			array.setText(array.getText()+ "1");
			}
			
		}
    	
    });
    
    b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "2");
			}else {
			array.setText(array.getText()+ "2");
			}
			
			
		}
    	
    });
    
    b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "3");
			}else {
			array.setText(array.getText()+ "3");
			}
			
		}
    	
    });
    
    b4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "4");
			}else {
			array.setText(array.getText()+ "4");
			}
		
			
		}
    	
    });
    
    b5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "5");
			}else {
			array.setText(array.getText()+ "5");
			}
			
			
		}
    	
    });
    
    b6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "6");
			}else {
			array.setText(array.getText()+ "6");
			}
			
			
		}
    	
    });
    
    
    b7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "7");
			}else {
			array.setText(array.getText()+ "7");
			}
		
			
		}
    	
    });
    
    
    b8.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "8");
			}else {
			array.setText(array.getText()+ "8");
			}
			
			
		}
    	
    });
    
    
    b9.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "9");
			}else {
			array.setText(array.getText()+ "9");
			}
			
			
		}
    	
    });
    
    b0.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + "0");
			}else {
			array.setText(array.getText()+ "0");
			}
			
			
		}
    	
    });
    
    
    bp.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText("");
			}else {
			array.setText("");
			}
			
			
		}
    	
    });
    
    ba.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(percentage.isSelected()) {
				jtf.setText(jtf.getText() + ",");
			}else {
			array.setText(array.getText()+ ",");
			}	
			
		}
    	
    });
    
    
    ok.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				double per = 0.0;
				double tare=0.0;
				double list = 0.0;
				double inter = 0.0;
				double perI = 0.0;
				DecimalFormat format = new DecimalFormat("#.##");
				
				String right="";
				if(percentage.isSelected() && jtf.getText()!="") {
					per = Double.parseDouble(jtf.getText().replace(",", "."));
					right = arrayList.get(arrayList.size()-1).replace(",", ".");
					System.out.println(right);

					tare = Double.parseDouble(right) * per/100;
					
					right = format.format(tare);
					
					right = right.replace(".", ",");
					System.out.println(right);
					array.setText(right);
				
				}else if(percentage.isSelected() && jtf.getText()==""){
					new NoPerSelectedGUI();
				}
				
			}
    	
    });
    

    
    
    borderPanel.add(radioPanel,BorderLayout.PAGE_START);
    borderPanel.add(panel1,BorderLayout.CENTER);
    
    
    
    
    
    dialog.add(borderPanel);
    dialog.pack();
    dialog.setSize(500,300);
    dialog.setBounds(250,400,500,300);
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.setResizable(false);
    dialog.setVisible(true);

    
    
    
    
    
    

	}

}
    