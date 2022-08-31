import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;

public class CalibrateZeroGUI extends JFrame {
	
	
	
	private JButton calibrate =  new JButton("Calibrate zero");
	private JPanel allPanel = new JPanel();
	private JLabel message = new JLabel("For the calibration you have to"
			+ " make sure that the system is unloaded.");
	private JLabel please = new JLabel("Please press calibrate when you are ready");
	private JButton close = new JButton();
	private JPanel exitPanel = new JPanel();
	
	
	
	public CalibrateZeroGUI(SerialPort port) {
		JFrame frame = new JFrame();
		Color southColor = new Color(123,154,190);
		calibrate.setBackground(southColor);
		calibrate.setOpaque(true);
		calibrate.setFocusPainted(false);
		calibrate.setBorderPainted(false);
		
		
		message.setOpaque(false);
		please.setOpaque(false);
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		please.setAlignmentX(Component.CENTER_ALIGNMENT);
		message.setFont(new Font("Arial",Font.BOLD,15));
		please.setFont(new Font("Arial",Font.BOLD,15));
		Box messageBox = Box.createVerticalBox();
		messageBox.add(Box.createRigidArea(new Dimension(100,300)));
		messageBox.add(message);
		messageBox.add(Box.createRigidArea(new Dimension(20,20)));
		messageBox.add(please);
		messageBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		allPanel.add(messageBox);
		allPanel.setBackground(Color.LIGHT_GRAY);
		
		
		calibrate.setPreferredSize(new Dimension(120,60));
		calibrate.setFont(new Font("Arial",Font.BOLD,12));
		
		
		close.setPreferredSize(new Dimension(100,60));
		Image exitImage = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		close.setIcon(new ImageIcon(exitImage));
		close.setOpaque(true);
		close.setFocusPainted(false);
		close.setBorderPainted(false);
		
		Box exitBox = Box.createHorizontalBox();
		exitBox.setPreferredSize(new Dimension(10,20));
		
		
		exitPanel.add(calibrate);
		exitPanel.add(exitBox);
		exitPanel.add(close);
		exitPanel.setPreferredSize(new Dimension(100,100));
		
		//calibrate.setAlignmentX(Component.CENTER_ALIGNMENT);
		//close.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		calibrate.setAlignmentY(Component.CENTER_ALIGNMENT);
		close.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}
			
		});
		
		
		calibrate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CalibrateZeroConfirmGUI(port);
				
			}
			
		});
		
		
		frame.add(allPanel,BorderLayout.CENTER);
		
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
