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

public class SuccessSaveGUI {
	private JButton okButton = new JButton("ΕΝΤΑΞΕΙ");
	private JFrame powerFrame=  new JFrame("ΑΠΟΘΗΚΕΥΣΗ ΑΛΛΑΓΩΝ");
	private JPanel panel = new JPanel();
	private JLabel message = new JLabel("ΟΙ ΑΛΛΑΓΕΣ ΣΑΣ ΑΠΟΘΗΚΕΥΤΗΚΑΝ ΕΠΙΤΥΧΩΣ ! ");
	private JDialog dialog = new JDialog(powerFrame,"Διαγραφή χρήστη",ModalityType.APPLICATION_MODAL);

	public SuccessSaveGUI() {
		
		okButton.setPreferredSize(new Dimension(10,30));
		okButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//�������� ��������
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		//�������� ��������
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		Box labelbox = Box.createVerticalBox();
		
		
		labelbox.setPreferredSize(new Dimension(280,70));
		labelbox.add(message);
		labelbox.add(Box.createRigidArea(new Dimension(20,20)));
		labelbox.add(okButton);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				powerFrame.dispose();
				
			}
			
		});
		
		
		
		panel.add(labelbox);

		panel.setPreferredSize(new Dimension(400,100));
		dialog.add(panel);
		powerFrame.pack();
		
		dialog.pack();
        dialog.setSize(400,130);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(true);
        dialog.setVisible(true);
		
        

		
	}

}
