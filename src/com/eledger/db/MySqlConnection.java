package com.eledger.db;
import java.sql.*;

import javax.swing.*;
public class MySqlConnection {
	
	Connection conn = null;
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING = "jdbc:mysql://localhost/ELedger";
	public static Connection dbConnector(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
			//JOptionPane.showMessageDialog(null,"connection is successful");
			return conn;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null,e );
			return null;
		}
		
		
	}
	

}
