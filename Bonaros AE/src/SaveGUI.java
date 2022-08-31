import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SaveGUI extends JFrame {
	
	private JButton okButton = new JButton("ΕΝΤΑΞΕΙ");
	private JFrame powerFrame=  new JFrame("ΑΠΟΘΗΚΕΥΣΗ ΑΛΛΑΓΩΝ");
	private JPanel panel = new JPanel();
	private JLabel message = new JLabel("Επιτυχής αποθήκευση απόβαρου ! ");
	private JDialog dialog = new JDialog(powerFrame,"Αποθήκευση απόβαρου",ModalityType.APPLICATION_MODAL);

	public SaveGUI(JTextField field) {
		
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//�������� ��������
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		//�������� ��������
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		Box labelbox = Box.createVerticalBox();
		
		
		labelbox.setPreferredSize(new Dimension(280,30));
		labelbox.add(message);
		//labelbox.add(Box.createRigidArea(new Dimension(20,20)));
		//labelbox.add(okButton);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				powerFrame.dispose();
				
			}
			
		});
		
		
		
		
		
		panel.add(labelbox);
		panel.add(okButton);
		panel.setPreferredSize(new Dimension(400,100));
		dialog.add(panel);
		powerFrame.pack();
		Image saveLogo = new ImageIcon(this.getClass().getResource("bonaros_logo.jpg")).getImage();
	    dialog.setIconImage(saveLogo);
		dialog.pack();
        dialog.setSize(400,150);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(true);
        dialog.setVisible(true);
		
        

		
	}




}