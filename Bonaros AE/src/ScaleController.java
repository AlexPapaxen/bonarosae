import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class ScaleController {
	
	
	private static int selection;
	private static JLabel net;
	private static String netDataBuffer;
	private static JLabel tareLabel;
	private static ArrayList<String> arrayList = new ArrayList<>();
	private static JLabel grossWeight;
	private ArrayList<String> grossWeightsList = new ArrayList<String>();
	private OutputStream outputstream;
	
	private ArrayList<Boolean> flagList = new ArrayList<>();
	
public void zeroRequest(SerialPort port) {
		
		
		outputstream = port.getOutputStream();
		
		String datatosend = "$01z7B."; 
		
		
		try {
		
		outputstream.write(datatosend.getBytes());
		outputstream.flush();
	}	catch(IOException e){
		JOptionPane.showInputDialog(this,e.getMessage());
	}

}


public void zeroTheScaleRequest(SerialPort port) {
	
	outputstream = port.getOutputStream();
	
	String datatosend = "$01z7B."; 
	
	
	try {
	
	outputstream.write(datatosend.getBytes());
	outputstream.flush();
}	catch(IOException e){
	JOptionPane.showInputDialog(this,e.getMessage());
}

}

   
public void weightRequest(SerialPort port,String arrayList) {
	
	outputstream = port.getOutputStream();
	

	String finalString = "$01s"+arrayList+"70.";
	System.out.println(finalString);
	try {
	
	outputstream.write(finalString.getBytes());
	outputstream.flush();
}	catch(IOException e){
	JOptionPane.showInputDialog(this,e.getMessage());
}

}
public void grossWeightRequest(SerialPort port) {
	
	outputstream = port.getOutputStream();
	
	String datatosend = "$01t75."; 
	
	
	try {
	
	outputstream.write(datatosend.getBytes());
	outputstream.flush();
}	catch(IOException e){
	JOptionPane.showInputDialog(this,e.getMessage());
}

}



    
	private void Serial_EventZeroTareReading(SerialPort activePort) {
		activePort.addDataListener(new SerialPortDataListener() {

			@Override
			public int getListeningEvents() {
				// TODO Auto-generated method stub
				return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
			}

			@Override
			public void serialEvent(SerialPortEvent arg0) {
				
					
					if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
						System.out.println("Data received ! ");
				
							byte[] buffer1 = arg0.getReceivedData();
							char c3 = (char)buffer1[3];
							char c4 = (char)buffer1[4];
							char c5 = (char)buffer1[5];
							char c6 = (char)buffer1[6];
							char c7 = (char)buffer1[7];
							char c8 = (char)buffer1[8];
							String data = "";
							
							for(int i=0;i<buffer1.length;i++) {
								data+=(char)buffer1[i];
								System.out.println(data);
							}
							if(c3=='0' && c4=='0' && c5=='0' && c6=='0' && c7=='0' && c8=='0') {
								JOptionPane.showMessageDialog(null, "Επιτυχής καλιμπράρισμα! ");
							}
							else {
								JOptionPane.showMessageDialog(null, "Αποτυχία καλιμπραρίσματος, δοκιμάστε ξανά.");
							}
						}
					}

		});
		
	
	}
	
	
	
	
	private void Serial_EventZeroScaleReading(SerialPort activePort) {
		activePort.addDataListener(new SerialPortDataListener() {

			@Override
			public int getListeningEvents() {
				// TODO Auto-generated method stub
				return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
			}

			@Override
			public void serialEvent(SerialPortEvent arg0) {
				
					
					if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
						
							
							byte[] buffer1 = arg0.getReceivedData();
							char c3 = (char)buffer1[3];
							char c4 = (char)buffer1[4];
							char c5 = (char)buffer1[5];
							char c6 = (char)buffer1[6];
							char c7 = (char)buffer1[7];
							char c8 = (char)buffer1[8];
							String data = "";
							
							for(int i=0;i<buffer1.length;i++) {
								data+=(char)buffer1[i];
								System.out.println(data);
							}
							
						}
					}

		});
		
	
	}
	
	
	
	private void Serial_EventWeightTareReading(SerialPort activePort,String arrayList) {
		activePort.addDataListener(new SerialPortDataListener() {

			@Override
			public int getListeningEvents() {
				// TODO Auto-generated method stub
				return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
			}

			@Override
			public void serialEvent(SerialPortEvent arg0) {
					
					String buff="";
					
					char[] charArray = arrayList.toCharArray();
					
					if(arg0.getEventType()==SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
						
				
							byte[] buffer1 = arg0.getReceivedData();
							char c3 = (char)buffer1[3];
							char c4 = (char)buffer1[4];
							char c5 = (char)buffer1[5];
							char c6 = (char)buffer1[6];
							char c7 = (char)buffer1[7];
							char c8 = (char)buffer1[8];
									
							
							for(int i=0;i<buffer1.length;i++) {
								buff+=(char)buffer1[i];
								System.out.println(buff + "hi");
							}
							if(c3==charArray[0] && c4==charArray[1] && c5==charArray[2] && c6==charArray[3] && c7==charArray[4] && c8==charArray[5]) {
								JOptionPane.showMessageDialog(null, "Επιτυχής καλιμπράρισμα! ");
							}
							else {
								JOptionPane.showMessageDialog(null, "Αποτυχία καλιμπραρίσματος, δοκιμάστε ξανά.");
							}
						}
					}

		});
		
	
	}
	
	
	
	public ScaleController(SerialPort port,int selection,String arrayList) {
		
			
			SerialPort port1 = SerialPort.getCommPorts()[0];
			port1.setComPortParameters(9600, 8, 1, 0);
			port1.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1200, 1200);
			//port.closePort();
			port1.openPort();
		
		
			if(port1.isOpen() && selection==1) {
				port1.flushIOBuffers();
				//port1.removeDataListener();
			    zeroRequest(port1);
			   //Serial_EventZeroScaleReading(port1);
			    
			}
			else if(port1.isOpen() && selection==2) {
				//port1.removeDataListener();
				port1.flushIOBuffers();
    			weightRequest(port1,arrayList);
    			//Serial_EventWeightTareReading(port1,arrayList);
			}
			
			if(port1.isOpen() && selection==3) {
				//port1.removeDataListener();	
				port1.flushIOBuffers();
				zeroTheScaleRequest(port1);
				//Serial_EventZeroScaleReading(port1);
			}
			
			else {
				
				port.flushIOBuffers();
				grossWeightRequest(port);
				
					
			}
			
			

		
	}



	
}
