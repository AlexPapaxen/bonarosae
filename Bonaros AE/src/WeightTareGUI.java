import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class WeightTareGUI extends JFrame  {

	private JButton save = new JButton();
	private JButton close = new JButton();
	private JLabel tare = new JLabel();

	public JLabel getTare() {
		return tare;
	}



	public void setTare(JLabel tare) {
		this.tare = tare;
	}
	

	

	public WeightTareGUI(ArrayList<String> array,JTextField field) {
		
		
		
		JDialog myDialog = new JDialog(this,"Ζύγιση απόβαρου",ModalityType.APPLICATION_MODAL);
		JPanel myPanel = new JPanel();
		JPanel netLabelPanel = new JPanel();
		netLabelPanel.setPreferredSize(new Dimension(50,30));
		netLabelPanel.setBackground(Color.BLACK);
		
		
		
		tare.setFont(new Font("Arial",Font.BOLD,16));
		tare.setOpaque(true);
		tare.setForeground(Color.GREEN);
		tare.setBackground(Color.BLACK);
		tare.setText(array.get(array.size()-1));
		
		netLabelPanel.add(tare);
		
		save.setPreferredSize(new Dimension(60,60));
		save.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		save.setFont(new Font("Arial",Font.BOLD,15));
		Image saveLogo = new ImageIcon(this.getClass().getResource("small_save.png")).getImage();
	    save.setIcon(new ImageIcon(saveLogo));
	    save.setOpaque(false);
	    save.setFocusPainted(false);
	    save.setContentAreaFilled(false);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				field.setText(tare.getText());
				new SaveGUI(field);
			}
			
		});
		
		
		Image closeLogo = new ImageIcon(this.getClass().getResource("small_close.png")).getImage();
	    close.setIcon(new ImageIcon(closeLogo));
		close.setPreferredSize(new Dimension(60,60));
		close.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		close.setOpaque(false);
		close.setFocusPainted(false);
		close.setContentAreaFilled(false);
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myDialog.dispose();
				
			}
			
		});
		
		
		
		
		
		Box buttonsBox = Box.createHorizontalBox();
		buttonsBox.add(save);
		buttonsBox.add(Box.createRigidArea(new Dimension(20,20)));
		buttonsBox.add(close);
		
		Box middle = Box.createVerticalBox();
		middle.add(netLabelPanel);
		middle.add(Box.createRigidArea(new Dimension(40,40)));
		middle.add(buttonsBox);
		
		myPanel.setPreferredSize(new Dimension(400,200));
		
		myPanel.add(middle);
		
		myDialog.add(myPanel);
		myDialog.pack();
		myDialog.setSize(450,200);
		myDialog.setLocationRelativeTo(null);
		myDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		myDialog.setResizable(false);
		myDialog.setVisible(true);
		
		
			
	}

	
}
	
	
	


