import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import com.mindfusion.keyboard.Key;
import com.mindfusion.keyboard.VirtualKeyEvent;
import com.mindfusion.keyboard.VirtualKeyboard;
import com.mindfusion.keyboard.VirtualKeyboardListener;
import  com.mindfusion.keyboard.RegularKey; 
public class KeyboardGUI {
	

	private final ArrayList<String> table = new ArrayList<String>();
	private String fetchMeText = "";
	public KeyboardGUI() {
		

		
		
		JFrame mainFrame = new JFrame();
		mainFrame.getContentPane().setLayout(new BorderLayout());
		VirtualKeyboard vkb = new VirtualKeyboard();
	    vkb.setFocusable(false);
	    vkb.setPreferredSize(new Dimension(870, 300));
	    vkb.setStandalone(false);
	    
	    mainFrame.getContentPane().add(vkb, BorderLayout.SOUTH);

	    JTextArea text = new JTextArea();
	    mainFrame.getContentPane().add(text, BorderLayout.CENTER);

	    mainFrame.setSize(600, 400);
	    mainFrame.setVisible(true);
	    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    text.requestFocus();
	    vkb.addVirtualKeyboardListener(new VirtualKeyboardListener() {

			@Override
			public void keyPressed(VirtualKeyEvent arg0) {
				Key key = arg0.getKey();
				
				String aText = text.getText();
				
				
				if(key.equals(Key.ENTER)) {
					System.out.println("Enter pressed ! ");
					
						fetchMeText = aText;
						table.add(fetchMeText);
						
						
					
					}
				}
			
	    	
	    });
	    
		
	}
	
	
		
	   
	
		
	
   

	
}