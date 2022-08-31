import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class KeyPadDate extends JFrame {

String numberString = "";
private static int counter = 0;
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
JButton ba = new JButton("OK");
JButton b0 = new JButton("0");
JButton bp = new JButton("C");
JButton ok = new JButton("OK");
JRadioButton percentage = new JRadioButton("Ποσοστιαίο απόβαρο");
private boolean shouldCheckUpdate = true;

public void stop(){
    shouldCheckUpdate = false;
}

public KeyPadDate(JTextField array,ArrayList<String> arrayList) {
	
	
	
	b1.setFont(new Font("Arial",Font.PLAIN,18));
	b2.setFont(new Font("Arial",Font.PLAIN,18));
	b3.setFont(new Font("Arial",Font.PLAIN,18));
	b4.setFont(new Font("Arial",Font.PLAIN,18));
	b5.setFont(new Font("Arial",Font.PLAIN,18));
	b6.setFont(new Font("Arial",Font.PLAIN,18));
	b7.setFont(new Font("Arial",Font.PLAIN,18));
	b8.setFont(new Font("Arial",Font.PLAIN,18));
	b9.setFont(new Font("Arial",Font.PLAIN,18));
	ba.setFont(new Font("Arial",Font.PLAIN,18));
	bp.setFont(new Font("Arial",Font.PLAIN,18));
	b0.setFont(new Font("Arial",Font.PLAIN,18));
	
	
	
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
  
    jtf.setPreferredSize(new Dimension(50,20));
    jtf.setEditable(false);
    
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
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "1");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
		}
    	
    });
    
    b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "2");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "3");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    b4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "4");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    b5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "5");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    b6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "6");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    
    b7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "7");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    
    b8.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "8");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    
    b9.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "9");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    b0.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(array.getText().length()<10) {
			array.setText(array.getText()+ "0");
			counter++;
			if(counter==2 || counter ==4) {
				array.setText(array.getText() + "/");
			}
			}
			
		}
    	
    });
    
    
    bp.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			array.setText("");
			counter=0;
			
			
		}
    	
    });
    
    ba.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			counter=0;
			dialog.dispose();
			
			
		}
    	
    });
    
    //borderPanel.add(radioPanel,BorderLayout.PAGE_START);
    borderPanel.add(panel1,BorderLayout.CENTER);
    
    
    
    
    
    dialog.add(borderPanel);
    dialog.pack();
    dialog.setSize(500,300);
    dialog.setBounds(30,380,500,300);
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.setResizable(false);
    dialog.setVisible(true);

    
    
    
    
    
    

	}




}
    