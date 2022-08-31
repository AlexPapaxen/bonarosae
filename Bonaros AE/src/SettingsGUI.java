import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;

public class SettingsGUI extends JFrame {
	
	
	
	private JButton calibrateZero = new JButton("calibrate zero");
	private JButton calibrateWeight = new JButton("calibrate with weight");
	private JButton exit = new JButton("CLOSE");
	private JPanel exitPanel = new JPanel(new BorderLayout());
	private JPanel calibratePanel = new JPanel();
	
	
	
	
	public SettingsGUI(SerialPort port,ArrayList<String> arrayList,ArrayList<Boolean> flagList, ArrayList<Integer> selection) {
		
		
		boolean flag = true;
		flagList.removeAll(flagList);
		
		JFrame frame = new JFrame();
		//if(port.isOpen()) {
			//port.closePort();
		//}
		
		

		calibrateZero.setPreferredSize(new Dimension(180,70));
		calibrateWeight.setPreferredSize(new Dimension(180,70));
		
		Color southColor = new Color(123,154,190);
		Color labelColor = new Color(15,38,123);
		calibrateZero.setBackground(southColor);
		calibrateWeight.setBackground(southColor);
		calibrateZero.setOpaque(true);
		calibrateZero.setFocusPainted(false);
		calibrateZero.setBorderPainted(false);
		calibrateZero.setFont(new Font("Arila",Font.BOLD,13));
		
		
		
		calibrateWeight.setOpaque(true);
		calibrateWeight.setFocusPainted(false);
		calibrateWeight.setBorderPainted(false);
		calibrateWeight.setFont(new Font("Arial",Font.BOLD,13));
		
		
		Box calibrateBox = Box.createHorizontalBox();
		calibrateBox.add(Box.createRigidArea(new Dimension(560,50)));
		
		Box midBox = Box.createVerticalBox();
		midBox.add(Box.createRigidArea(new Dimension(500,10)));
		exit.setPreferredSize(new Dimension(80,50));
		Image exitImage = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		exit.setIcon(new ImageIcon(exitImage));
		exit.setOpaque(true);
		exit.setFocusPainted(false);
		exit.setBorderPainted(false);
		
		calibratePanel.add(calibrateBox);
		calibratePanel.add(calibrateZero);
		calibratePanel.add(midBox);
		calibratePanel.add(calibrateWeight);
		calibratePanel.setPreferredSize(new Dimension(300,600));
		exitPanel.add(exit);
		exitPanel.setPreferredSize(new Dimension(100,100));
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flagList.add(flag);
				selection.removeAll(selection);
				
				selection.add(0);
				 new ScaleController(port,4,arrayList.get(0));
				
				frame.dispose();	
			}
			
		});
		
		
		calibrateZero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				selection.removeAll(selection);
				selection.add(1);
				new CalibrateZeroGUI(port);
				
			}
			
		});
		
		
		calibrateWeight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selection.removeAll(selection);
				selection.add(2);
				new CalibrateWeightGUI(arrayList,port);
				
			}
			
		});
		
		
		frame.add(calibratePanel,BorderLayout.WEST);
		
		frame.add(exitPanel,BorderLayout.PAGE_END);
		frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
		
		
		
		
		
	}

}
