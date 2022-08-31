import java.awt.Component;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class UserLogOutGUI extends JFrame {
	
	
	private JFrame powerFrame=  new JFrame("");
	private JPanel panel = new JPanel();
	private JButton okButton = new JButton("ΕΝΤΑΞΕΙ");
	private boolean yes = false;

	private JLabel message = new JLabel("Επιτυχής αποσύνδεση!");
	

	public UserLogOutGUI() {
		 JDialog dialog = new JDialog(powerFrame,"Αποσύνδεση χρήστη",ModalityType.APPLICATION_MODAL);
		okButton.setPreferredSize(new Dimension(10,50));
		okButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//�������� ��������
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
	
		//�������� ��������
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		Box labelbox = Box.createVerticalBox();
		
		
		labelbox.setPreferredSize(new Dimension(280,80));
		labelbox.add(message);
		labelbox.add(Box.createRigidArea(new Dimension(10,20)));
		labelbox.add(okButton);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				powerFrame.dispose();
				
			}
			
		});
		
		
		
		panel.add(labelbox);

		panel.setPreferredSize(new Dimension(400,250));
		
		
		dialog.add(panel);
		powerFrame.pack();
		dialog.pack();
        dialog.setSize(300,160);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(true);
        dialog.setVisible(true);
        

		
	}


}
