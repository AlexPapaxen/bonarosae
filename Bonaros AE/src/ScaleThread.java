import com.fazecast.jSerialComm.SerialPort;

public class ScaleThread extends Thread {
	private GUI g = new GUI();
	
	public void run() {
		SerialPort port = SerialPort.getCommPorts()[0];
		port.setComPortParameters(9600, 8, 1, 0);
		port.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1200, 1200);
		port.openPort();
		if(port.isOpen()) {
		port.flushIOBuffers();
		g.grossWeightRequest(port);
		//g.Serial_EventBasedReading(port);
		
		}
	}
}
