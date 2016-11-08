package com.eledger.db;


import java.awt.EventQueue;
import javax.swing.JFrame;

import java.sql.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;	


public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
			public static void main(String args[]){																																							
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
				
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
			Connection connection=null;
			private JTextField textField_1;
			private JButton btnNewButton;
			private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=MySqlConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 255));
		frame.setBounds(300, 400, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(42, 88, 108, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(52, 115, 98, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 86, 151, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 113, 151, 19);
		frame.getContentPane().add(passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					try{
						String  query = "select * from Admin where userName=? and password=?";
						PreparedStatement pst=connection.prepareStatement(query);	
						pst.setString(1,textField_1.getText());
						pst.setString(2,passwordField.getText());
						
						ResultSet rs = pst.executeQuery();
						int count=0;
						while(rs.next()){
							count++;
							
						}
						if(count == 1){
							JOptionPane.showMessageDialog(null,"Username and password is correct");
							frame.dispose();
							 HomeDialog hD = new HomeDialog();
							 hD.setVisible(true);
						}else if(count > 1){
							JOptionPane.showMessageDialog(null,"Duplicate Username and password");
						}
						else{
							JOptionPane.showMessageDialog(null,"Username and password is not  correct Try again");
						}
					
						rs.close();
						pst.close();
					}catch(Exception ex){
						
						JOptionPane.showMessageDialog(null,ex);
						
						
					}
					
				
			}
		});
		btnNewButton.setBounds(155, 191, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblEledger = new JLabel("e-Ledger");
		lblEledger.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEledger.setBounds(189, 28, 117, 19);
		frame.getContentPane().add(lblEledger);
		
		
		
		
		
		
	}
}