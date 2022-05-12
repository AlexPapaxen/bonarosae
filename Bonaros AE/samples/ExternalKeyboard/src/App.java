import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.mindfusion.keyboard.VirtualKeyboard;


public class App
{
	static public void main(String[] args)
	{
		VirtualKeyboard vkb = new VirtualKeyboard();
		vkb.setStandalone(true);

		JFrame mainFrame = new JFrame("MindFusion Virtual Keyboard sample: External Keyboard");
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.getContentPane().add(vkb, BorderLayout.CENTER);

		mainFrame.setSize(870, 310);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}