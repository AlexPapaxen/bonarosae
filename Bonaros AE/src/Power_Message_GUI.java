import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Power_Message_GUI extends JFrame {
	
	private JFrame powerFrame=  new JFrame("Επιβεβαίωση τερματισμού");
	private JPanel panel = new JPanel();
	private JButton yesButton = new JButton("ΝΑΙ");
	
	private JButton noButton = new JButton("ΟΧΙ");
	private JLabel message = new JLabel("Θέλετε τερματισμό του προγράμματος; ");
	
	public Power_Message_GUI() {
		
		yesButton.setPreferredSize(new Dimension(100,10));
		yesButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		noButton.setPreferredSize(new Dimension(100,10));
		noButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		//Στοίχηση κουμπιών
		yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		//Στοίχηση ετικέτας
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Box box = Box.createHorizontalBox();
		box.add(yesButton);
		box.add(Box.createRigidArea(new Dimension(20,20)));
		box.add(noButton);
		
		
		Box labelbox = Box.createVerticalBox();
		
		
		labelbox.add(Box.createRigidArea(new Dimension(200,20)));
		labelbox.add(message);
		
		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		
		noButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				powerFrame.dispose();
				
			}
			
		});
		
		panel.add(labelbox);
		panel.add(box);
		panel.setPreferredSize(new Dimension(400,100));
		
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("bonaros.jpg"));
		powerFrame.add(panel);
		powerFrame.setIconImage(logo.getImage());
		powerFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        powerFrame.pack();
        powerFrame.setLocationRelativeTo(null);
        powerFrame.setVisible(true);
        powerFrame.setResizable(false);

		
	}

}
