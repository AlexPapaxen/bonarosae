import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.fazecast.jSerialComm.SerialPort;

public class Power_Message_GUI extends JFrame {
	
	private JFrame powerFrame=  new JFrame("Επιβεβαίωση τερματισμού");
	
	private JPanel panel = new JPanel();
	private JButton yesButton = new JButton("ΝΑΙ");
	
	private JButton noButton = new JButton("ΟΧΙ");
	private JLabel message = new JLabel("Τερματισμός λειτουργίας; ");
	
	
	
	public Power_Message_GUI(SerialPort port) {
		String dialogMessage = "Επιβεβαίωση τερματισμού";
		
	  JDialog dialog = new JDialog(this,dialogMessage,ModalityType.APPLICATION_MODAL);
		dialog.setFont(new Font("Arial",Font.PLAIN,15));
	  	yesButton.setFont(new Font("Arial",Font.BOLD,13));
	  	noButton.setFont(new Font("Arial",Font.BOLD,13));
	  	message.setFont(new Font("Source Sans Pro",Font.BOLD,14));
	  	dialog.setFont(new Font("Arial",Font.BOLD,15));
	  	
		yesButton.setPreferredSize(new Dimension(100,40));
		yesButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		noButton.setPreferredSize(new Dimension(100,40));
		noButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		//�������� ��������
		yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		noButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		//�������� ��������
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
				port.closePort();
				System.exit(0);
				
			}
			
		});
		
		
		noButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				
			}
			
		});
		
		panel.add(labelbox);
		panel.add(box);
		panel.setPreferredSize(new Dimension(400,100));
		
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("bonaros.jpg"));
		dialog.add(panel);
		
		dialog.setIconImage(logo.getImage());
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setSize(new Dimension(400,150));
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
        
        
		
	}

}
