import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LotGUI extends JFrame {
	
	
	private JLabel lot = new JLabel("LOT: ");
	private JTextField lotField = new JTextField();
	
	private JButton key = new JButton();
	private JButton save = new JButton("SAVE");
	
	private JButton close = new JButton();
	private JPanel lotguiPanel = new JPanel();
	JPanel boxPanel = new JPanel();
	private JFrame lotguiFrame = new JFrame("LOT");
	
	private static JTextArea area = new JTextArea();
	
	
	public LotGUI(){
		//Icon for close button
		Image logo = new ImageIcon(this.getClass().getResource("/close_lot.png")).getImage();
		close.setIcon(new ImageIcon(logo));
		
		lot.setFont(new Font("Arial",Font.BOLD,15));
		Box box = Box.createHorizontalBox();
		Box downBox = Box.createHorizontalBox();
		Box midBox = Box.createVerticalBox();
		
		midBox.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		midBox.setPreferredSize(new Dimension(800,770));
		
		lot.setPreferredSize(new Dimension(100,100));
		lotField.setPreferredSize(new Dimension(400,20));
		lot.setAlignmentX(Component.CENTER_ALIGNMENT);
		lotField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		box.add(lot);
		box.add(Box.createRigidArea(new Dimension(30,30)));
		box.add(lotField);
		box.add(Box.createRigidArea(new Dimension(70,70)));
		
		
		save.setPreferredSize(new Dimension(100,100));
		save.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		save.setFont(new Font("Arial",Font.BOLD,15));
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Κώδικας για αποθήκευση ονόματος LOT
				//
				//
				//
				
			}
			
		});
		
		
		
		
		key.setPreferredSize(new Dimension(100,100));
		key.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		Image keyLogo = new ImageIcon(this.getClass().getResource("/keyb_img.png")).getImage();
		key.setIcon(new ImageIcon(keyLogo));
		
		
		key.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				MyJFrame f = new MyJFrame(area);
				f.setLocationRelativeTo(null);
				String n = f.getArrayList().toString();
				n = n.substring(0,n.lastIndexOf(n));
				lotField.setText(n);
				System.out.println("The text is: " +f.getTb1().getText());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//f.setPreferredSize(new Dimension(500,500));
				f.setBounds(100, 100, 500, 500);
				f.pack();
				f.setVisible(true);
				
				
			}
			
		});
		
		
		close.setPreferredSize(new Dimension(100,100));
		close.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lotguiFrame.dispose();
				
			}
			
		});
		 
		
		downBox.add(key);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(save);
		downBox.add(Box.createRigidArea(new Dimension(100,100)));
		downBox.add(close);
		
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		midBox.add(Box.createRigidArea(new Dimension(250,250)));
		midBox.add(box);
		midBox.add(Box.createRigidArea(new Dimension(350,350)));
		midBox.add(downBox);
		
		lotguiPanel.add(midBox);
		
		
		lotguiFrame.setLayout(new BorderLayout());
		lotguiFrame.add(lotguiPanel);
		lotguiFrame.setUndecorated(true);
		lotguiFrame.pack();
		lotguiFrame.setLocationRelativeTo(null);
		lotguiFrame.setBounds(300, 300, 500, 500);
		lotguiFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		lotguiFrame.setVisible(true);
		
		
		
	
	}

}
