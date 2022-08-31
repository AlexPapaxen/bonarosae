import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;

public class PowerFrameGUI {
	
	private JButton powerOff = new JButton();
	private JButton restart = new JButton();
	private JButton close = new JButton();
	
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagConstraints c1 = new GridBagConstraints();
	private GridBagConstraints c2 = new GridBagConstraints();
	
	
	public PowerFrameGUI(SerialPort port) {
		
		JPanel northPanel = new JPanel(new GridBagLayout());
		JFrame frame = new JFrame();
		Box northBox = Box.createVerticalBox();
		
		Color southColor = new Color(129,140,157,255);
		
		Color labelColor = new Color(199,199,199,255);
		
		Image userImg = new ImageIcon(this.getClass().getResource("cancel.png")).getImage();
		close.setIcon(new ImageIcon(userImg));
		
		Image power = new ImageIcon(this.getClass().getResource("on-off-button.png")).getImage();
		powerOff.setIcon(new ImageIcon(power));
		
		Image restartB = new ImageIcon(this.getClass().getResource("restart.png")).getImage();
		restart.setIcon(new ImageIcon(restartB));
		
		powerOff.setPreferredSize(new Dimension(70,50));
		powerOff.setText("POWER OFF");
		powerOff.setFont(new Font("Arial",Font.BOLD,13));
		
		restart.setPreferredSize(new Dimension(60,50));
		restart.setText("RESTART");
		restart.setFont(new Font("Arial",Font.BOLD,13));
		
		close.setPreferredSize(new Dimension(60,50));
		close.setText("CLOSE");
		close.setFont(new Font("Arial",Font.BOLD,13));
		
		
		northBox.add(restart);
		northBox.add(Box.createRigidArea(new Dimension(0,40)));
		northBox.add(powerOff);
		
		
		powerOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				port.closePort();
				System.exit(0);
				
			}
			
		});
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
			
		});
		
		
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
		
		
		
		c.fill = GridBagConstraints.VERTICAL;
		
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.LINE_START; //bottom of space
		c.insets = new Insets(200,250,50,800);  //top padding
		c.gridx = 0;       
		c.gridwidth = 1;   //3 columns wide
		c.gridy = 2; //third row
		
		northPanel.add(northBox, c);
		
		
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.ipady =0;
		c1.weighty = 1.0;
		c1.anchor = GridBagConstraints.PAGE_END;
		c1.insets = new Insets(540,600,10,600);
		c1.gridx=0;
		c1.gridwidth=3;
		c1.gridy=2;
		
		northPanel.add(close,c1);
		
		
		frame.add(northPanel);
		frame.setUndecorated(true);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setResizable(false);
		
		
		
		
		
		
	}

}
