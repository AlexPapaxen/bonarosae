import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginSession {
	private String uname = "root";
	private String pass = "Jo6c!pi7papaxen";
	private String url = "jdbc:mysql://localhost:3306/users?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private  int error=0;
	
	public LoginSession(JButton login, JButton logOut,JTextField userField, JTextField passField,ArrayList<String> users,JLabel userLoggedIn) {
		
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e2) {
    		e2.printStackTrace();    		
    	}
    	
    	try {
    		PreparedStatement ps;
    		String query = "select UserName,Password from users where UserName=? and Password=?";
    		Connection con =  DriverManager.getConnection(url,uname,pass);
    		ps =con.prepareStatement(query);
    		ps.setString(1, userField.getText());
    		ps.setString(2, passField.getText());
    		
    		ResultSet result = ps.executeQuery();
    		
    		if(result.next()) {
    			JOptionPane.showMessageDialog(null, "Επιτυχής σύνδεση!");
    			users.add(userField.getText());
    			login.setEnabled(false);
				logOut.setEnabled(true);
				logOut.setVisible(true);
				
	    		users.add(passField.getText());
	    		
	    		
	    		userField.setEditable(false);
	    		userField.setEnabled(false);
	    		passField.setEditable(false);
    			passField.setEnabled(false);
    			userLoggedIn.setText(userField.getText());
    			error=1;
    			
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Λανθασμένο όνομα χρήστη ή κωδικός.");
    			login.setEnabled(true);
    			
    		}
    		
    		
    		
    	
    	
    		
    	
	}catch(SQLException e1) {
		e1.printStackTrace();

		}
    	
    			    	
    
}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
		
		
}

