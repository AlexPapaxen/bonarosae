import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GUI  {

	private JPanel northFlowLayoutPanel;
    private JPanel southBorderLayoutPanel;
    private JPanel centerGridBagLayoutPanel;
    private JPanel westBoxLayoutPanel;
    private JPanel eastGridLayoutPanel;
    
    private ArrayList<String> onoma = new ArrayList<String>();
    
    private final JLabel onomaParaggelias = new JLabel();
    private final JLabel copywrite = new JLabel("©2022 Alexandros Papaxenidis");
    private final JLabel autoprintLabel = new JLabel("AUTO PRINT");
    private final JButton tare = new JButton("TARE");
    private final JButton plu = new JButton("PLU");
    private final JButton lot = new JButton("LOT");
    private final JButton logfile = new JButton("LOG FILE");
    private final JButton print = new JButton();
    private final JButton order = new JButton("ORDER");
    private final SwitchButton autoprint = new SwitchButton();
    private final JButton zeroingButton = new JButton();
    private final JButton powerButton = new JButton();
    private final JLabel etiketaBarcode = new JLabel();
    private final JButton swipeLeft = new JButton();
    private final JButton swipeRight = new JButton();
    private final JLabel  onomaetiketas = new JLabel("CARRIER.853903");
    private final JLabel name = new JLabel("ΟΝΟΜΑ ΕΤΙΚΕΤΑΣ : ");
    //private final ArrayList<JLabel> listOfLabels = new ArrayList<>();
    //private final AraayList<JLabel> listOfLabelTickets = new ArrayList<>();
    

    
    private final JButton orderCreation = new JButton("ΠΑΡΑΓΓΕΛΙΑ");
    
    private final JButton scaleSelection = new JButton("ΖΥΓΑΡΙΑ");
    private final JButton productSelection = new JButton("ΠΡΟΪΟΝ");
    private final JButton labelSelection = new JButton("ΖΥΓΙΣΗ");
    private final JButton settingsButton = new JButton("ΡΥΘΜΙΣΕΙΣ");
    
    private GridBagConstraints c = new GridBagConstraints();
    

    public GUI() {
    	
    	//Αρχικοποίηση South Panel
    	southBorderLayoutPanel = new JPanel();
        southBorderLayoutPanel.setBackground(Color.GRAY);
        
        //Boxes για κουμπιά γραμμής
    	Box southBox1 = Box.createVerticalBox();
    	Box southBox2 = Box.createVerticalBox();
    	Box southBox3 = Box.createVerticalBox();
    	Box southBox4 = Box.createVerticalBox();
    	
    	//North Layout Panel αρχικοποίηση
        northFlowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northFlowLayoutPanel.setBackground(Color.LIGHT_GRAY);
                
        northFlowLayoutPanel.add(onomaParaggelias);
        northFlowLayoutPanel.setBorder(BorderFactory.createTitledBorder(""));
        
        //Center Panel αρχικοποίηση
        centerGridBagLayoutPanel = new JPanel(new GridBagLayout());
        centerGridBagLayoutPanel.setBackground(Color.LIGHT_GRAY);
        
        //Box για ετικέτα προϊόντος και αρχικοποίηση West Panel
        Box box = Box.createVerticalBox();        
        westBoxLayoutPanel = new JPanel();
       

        //Δημιουργία box για κουμπιά swipe
        Box swipeBox = Box.createHorizontalBox();
        
        
        //Γραμματοσειρά κουμπιών
        plu.setFont(new Font("Arial", Font.BOLD, 15));
        order.setFont(new Font("Arial", Font.BOLD, 15));
        lot.setFont(new Font("Arial", Font.BOLD, 15));
        tare.setFont(new Font("Arial", Font.BOLD, 15));
        logfile.setFont(new Font("Arial", Font.BOLD, 15));
        autoprint.setFont(new Font("Arial", Font.BOLD, 15));
        autoprintLabel.setFont(new Font("Arial", Font.BOLD, 15));
        settingsButton.setFont(new Font("Arial", Font.BOLD, 15));
        
        //Εικόνα για Κουμπί τερματισμού προγράμματος        
        Image powerImage = new ImageIcon(this.getClass().getResource("/power-off.png")).getImage();
		powerButton.setIcon(new ImageIcon(powerImage));
        powerButton.setPreferredSize(new Dimension(100,100));
        
        //Εικόνα για Κουμπί εκτύπωσης
        Image printImg = new ImageIcon(this.getClass().getResource("/printer.png")).getImage();
		print.setIcon(new ImageIcon(printImg));
        //southBorderLayoutPanel.setPreferredSize(new Dimension(0,120));
               
        //Εικόνα για Κουμπίμηδενισμού ζυγαριάς
        Image zeroingScaleImg = new ImageIcon(this.getClass().getResource("/zeroing.png")).getImage();
		zeroingButton.setIcon(new ImageIcon(zeroingScaleImg));
		zeroingButton.setPreferredSize(new Dimension(100,100));
				
		//Εικόνα για Ετικέτα προϊόντος
		Image etiketa = new ImageIcon(this.getClass().getResource("/image054.png")).getImage();
		etiketaBarcode.setIcon(new ImageIcon(etiketa));
		
		//Εικόνα για Swipe Left κουμπί
		Image swipe_l = new ImageIcon(this.getClass().getResource("/swipe_left.png")).getImage();
		swipeLeft.setIcon(new ImageIcon(swipe_l));
		
		//Εικόνα για Swipe Right κουμπί
		Image swipe_r = new ImageIcon(this.getClass().getResource("/swipe_right.png")).getImage();
		swipeRight.setIcon(new ImageIcon(swipe_r));
		
		//Κουμπιά γραμμής και ετικέτες
		order.setPreferredSize(new Dimension(150,100));
		order.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		order.setAlignmentX(Component.LEFT_ALIGNMENT);
		plu.setPreferredSize(new Dimension(150,100));
		plu.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		lot.setPreferredSize(new Dimension(150,100));
		lot.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		tare.setPreferredSize(new Dimension(150,100));
		tare.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		logfile.setPreferredSize(new Dimension(150,100));
		logfile.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		//AutoPrint Κουμπί
		autoprint.setPreferredSize(new Dimension(0,60));
		autoprint.setMinimumSize(new Dimension(Short.MIN_VALUE,Short.MIN_VALUE));
		autoprint.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));		
		autoprintLabel.setPreferredSize(new Dimension (20,20));
		autoprintLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Print κουμπί
		print.setPreferredSize(new Dimension(150,100));
		print.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		
		
		//Power Button
		powerButton.setPreferredSize(new Dimension(120,80));
		powerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		powerButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		powerButton.setMinimumSize(new Dimension(Short.MIN_VALUE,Short.MIN_VALUE));
		
		
		//Settings button
	     settingsButton.setPreferredSize(new Dimension(150,100));
	     settingsButton.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	     
	     
	     //Swipe Left και Swipe Right κουμπιά για εναλλαγή ετικετών προϊόντος
	     swipeLeft.setPreferredSize(new Dimension(20,10));
	     swipeLeft.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	     
	     swipeRight.setPreferredSize(new Dimension(20,10));
	     swipeRight.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
	     
	     swipeBox.setPreferredSize(new Dimension(20,50));
	     swipeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
	     swipeBox.add(swipeLeft);
	     swipeBox.add(Box.createRigidArea(new Dimension(10,10)));
	     swipeBox.add(swipeRight);
	     
	     
	     //Ονομασία ετικέτας
	     Box labelBox = Box.createHorizontalBox();
	     labelBox.setPreferredSize(new Dimension(40,40));
	     labelBox.setAlignmentX(Component.CENTER_ALIGNMENT);
	     name.setFont(new Font("Arial",Font.BOLD,15));
	     name.setPreferredSize(new Dimension(30,30));
	     name.setAlignmentX(Component.LEFT_ALIGNMENT);
	     onomaetiketas.setFont(new Font("Arial",Font.BOLD,15));
	     //onomaetiketas.setText(fetchLabelName());
		 onomaetiketas.setPreferredSize(new Dimension(30,30));
		 onomaetiketas.setAlignmentX(Component.CENTER_ALIGNMENT);
		 labelBox.add(name);
		 labelBox.add(onomaetiketas);
	     
		//ActionListeners για κουμπιά
		powerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Power_Message_GUI();
				
			}
	
			
		});
		
		 orderCreation.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//new OrderNamingGUI();
									
				}
	        	
	        });
		 
		 lot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new LotGUI();
				
			}
			 
		 });

	    
		
		
		
		//Τοποθέτηση νότιου panel
		southBox1.add(autoprintLabel);
        southBox1.add(autoprint);
        southBox1.add(Box.createRigidArea(new Dimension(66,66)));
        southBox1.add(logfile);
        southBorderLayoutPanel.add(southBox1);
		
		
		//Εισαγωγή κουμπιών στο πρώτο Box του southpanel
		southBox2.add(plu);
        southBox2.add(Box.createRigidArea(new Dimension(50,50)));
        southBox2.add(order);
        southBorderLayoutPanel.add(southBox2);
       
        
      
      //Εισαγωγή κουμπιών στο δεύερο Box του southpanel
        southBox3.add(lot);
        southBox3.add(Box.createRigidArea(new Dimension(50,50)));
        southBox3.add(tare);        
        southBorderLayoutPanel.add(southBox3);   
        
        
        //Εισαγωγή κουμπιών στο τέταρτο Box του southpanel
        southBox4.add(print);
        southBox4.add(Box.createRigidArea(new Dimension(50,50)));
        southBox4.add(settingsButton);        
        southBorderLayoutPanel.add(southBox4);
       
        
      //Δημιουργία Box και τοποθέτηση power button στο south panel
        
        Box sendPowerButtonToCorner = Box.createVerticalBox();        
        sendPowerButtonToCorner.add(Box.createRigidArea(new Dimension(300,168)));
        sendPowerButtonToCorner.add(powerButton);       
        southBorderLayoutPanel.add(sendPowerButtonToCorner);
        
     
        
        
        
        
        southBorderLayoutPanel.setPreferredSize(new Dimension(0,360));
        southBorderLayoutPanel.setBorder(BorderFactory.createTitledBorder(null, "ΚΟΥΜΠΙΑ ΛΕΙΤΟΥΡΓΙΩΝ ΖΥΓΑΡΙΑΣ", TitledBorder.LEFT, TitledBorder.TOP,
        		new Font("times new roman",Font.PLAIN,12), Color.BLUE));

        
        //Κουμπί autoprint
//        autoprint.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(autoprint.isSelected()) {
//					
//				}
//				
//				autoprint.setText("Auto print desabled");
//				
//			}
//        	
//        });
        
        
       //Center Layout
        c.fill = GridBagConstraints.HORIZONTAL;
		
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,630,50,800);  //top padding
		c.gridx = 0;       
		c.gridwidth = 1;   //3 columns wide
		c.gridy = 2; //third row
		
		centerGridBagLayoutPanel.add(zeroingButton, c);
        
		
		/*
		 * //Προσθήκη κουμπιών με αριστερή στοιχηση
		 * orderCreation.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * orderCreation.setPreferredSize(new Dimension(150,100));
		 * orderCreation.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		 * 
		 * scaleSelection.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * scaleSelection.setPreferredSize(new Dimension(100,100));
		 * scaleSelection.setMaximumSize(new
		 * Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		 * 
		 * productSelection.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * productSelection.setPreferredSize(new Dimension(100,100));
		 * productSelection.setMaximumSize(new
		 * Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		 * 
		 * labelSelection.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * labelSelection.setPreferredSize(new Dimension(100,100));
		 * labelSelection.setMaximumSize(new
		 * Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		 */
        
    
        
        
		/*
		 * box.add(orderCreation); box.add(Box.createRigidArea(new Dimension(30,30)));
		 * box.add(scaleSelection); box.add(Box.createRigidArea(new Dimension(30,30)));
		 * box.add(productSelection); box.add(Box.createRigidArea(new
		 * Dimension(30,30))); box.add(labelSelection); box.add(Box.createRigidArea(new
		 * Dimension(30,30)));
		 */
		
		
		etiketaBarcode.setAlignmentX(Component.CENTER_ALIGNMENT);
		etiketaBarcode.setPreferredSize(new Dimension(380,600));
		etiketaBarcode.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(labelBox);
		box.add(etiketaBarcode);
		box.add(swipeBox);
        
       
		westBoxLayoutPanel.setBackground(Color.LIGHT_GRAY);
        westBoxLayoutPanel.add(box);
        westBoxLayoutPanel.setPreferredSize(new Dimension(650,0));
        westBoxLayoutPanel.setBorder(BorderFactory.createTitledBorder(""));
        //copywrite.setVisible(true);
      

        
        
        
        JFrame frame = new JFrame("Bonaros AE");
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("bonaros_big.jpg"));
        frame.setIconImage(logo.getImage());
        
        frame.setLayout(new BorderLayout());      // This is the deafault layout
        frame.add(northFlowLayoutPanel, BorderLayout.PAGE_START);
        frame.add(westBoxLayoutPanel, BorderLayout.LINE_START);
        frame.add(southBorderLayoutPanel, BorderLayout.PAGE_END);
        frame.add(centerGridBagLayoutPanel, BorderLayout.CENTER);
        
        
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException
                    | InstantiationException
                    | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            new GUI();
        });
    }
    
    
	/*
	 * class RoundBtn implements Border { private int r; RoundBtn(int r) { this.r =
	 * r; } public Insets getBorderInsets(Component c) { return new Insets(this.r+1,
	 * this.r+1, this.r+2, this.r); } public boolean isBorderOpaque() { return true;
	 * }
	 * 
	 * @Override public void paintBorder(Component c, Graphics g, int x, int y, int
	 * width, int height) { g.drawRoundRect(x, y, width-1, height-1, r, r);
	 * 
	 * } }
	 */
}
