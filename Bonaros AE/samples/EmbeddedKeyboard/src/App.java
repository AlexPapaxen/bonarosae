import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mindfusion.keyboard.KeyboardMode;
import com.mindfusion.keyboard.Theme;
import com.mindfusion.keyboard.VirtualKeyboard;


public class App
{
	static public void main(String[] args)
	{
		JFrame mainFrame = new JFrame("MindFusion Virtual Keyboard sample: Embedded Keyboard");
		mainFrame.getContentPane().setLayout(new BorderLayout());

		// set up the keyboard instance
		VirtualKeyboard vkb = new VirtualKeyboard();
		vkb.setFocusable(false);
		vkb.setPreferredSize(new Dimension(870, 300));
		mainFrame.getContentPane().add(vkb, BorderLayout.SOUTH);

		// text entry field
		JTextArea text = new JTextArea();
		mainFrame.getContentPane().add(text, BorderLayout.CENTER);

		// check box showing layouts
		JCheckBox extendedLayout = new JCheckBox("Extended layout");
		extendedLayout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				vkb.setMode(
					extendedLayout.isSelected() ?
						KeyboardMode.Extended : KeyboardMode.Default);
		      }
		});
		
		// combo box showing themes
		JLabel themesLabel = new JLabel("   Theme: ");
		JComboBox themes = new JComboBox(Theme.values());
		themes.addActionListener (new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        vkb.setTheme((Theme)themes.getSelectedItem());
		    }
		});

		JPanel controls = new JPanel();
		controls.setLayout(new BoxLayout(controls, BoxLayout.X_AXIS));
		controls.add(extendedLayout);
		controls.add(themesLabel);
		controls.add(themes);

		mainFrame.getContentPane().add(controls, BorderLayout.NORTH);
		
		mainFrame.setSize(870, 450);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text.requestFocus();
	}
}