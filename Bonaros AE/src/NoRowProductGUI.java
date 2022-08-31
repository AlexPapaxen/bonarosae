
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
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

public class NoRowProductGUI {
	
	private JFrame powerFrame=  new JFrame("Καμία επιλογή ");
	private JPanel panel = new JPanel();
	private JButton okButton = new JButton("ΕΝΤΑΞΕΙ");
	private boolean yes = false;

	private JLabel message = new JLabel("Παρακαλώ επιλέξτε τουλάχιστον ένα προϊόν");
	

	public NoRowProductGUI() {
		 JDialog dialog = new JDialog(powerFrame,"Καμία επιλογή",ModalityType.APPLICATION_MODAL);
		okButton.setPreferredSize(new Dimension(10,30));
		okButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//�������� ��������
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
	
		//�������� ��������
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		Box labelbox = Box.createVerticalBox();
		
		
		labelbox.setPreferredSize(new Dimension(350,70));
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

		panel.setPreferredSize(new Dimension(400,100));
		
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("bonaros.jpg"));
		dialog.add(panel);
		powerFrame.pack();
		//powerFrame.setIconImage(logo.getImage());
		dialog.pack();
        dialog.setSize(400,130);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(true);
        dialog.setVisible(true);
        

		
	}






	public boolean isYes() {
		return yes;
	}
	
	

}