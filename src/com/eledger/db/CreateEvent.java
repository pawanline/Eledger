package com.eledger.db;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateEvent extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Connection connection = MySqlConnection.dbConnector();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnSubmit;
	private JButton btnDelete;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEvent frame = new CreateEvent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblEventName = new JLabel("EventName");
		lblEventName.setBounds(24, 48, 94, 15);
		contentPane.add(lblEventName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 48, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblParticular = new JLabel("Particular");
		lblParticular.setBounds(24, 75, 94, 15);
		contentPane.add(lblParticular);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 80, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

		JLabel lblAmountDebited = new JLabel("Amt Debtd");
		lblAmountDebited.setBounds(24, 105, 114, 15);
		contentPane.add(lblAmountDebited);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(324, 112, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(24, 135, 114, 15);
		contentPane.add(lblDate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 142, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblBillNo = new JLabel("Bill NO");
		lblBillNo.setBounds(24, 175, 114, 15);
		contentPane.add(lblBillNo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(324, 172, 114, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		

		JLabel lblDebitedBy = new JLabel("DebitedBy");
		lblDebitedBy.setBounds(24, 205, 114, 15);
		contentPane.add(lblDebitedBy);
		
		
		textField_6 = new JTextField();
		textField_6.setBounds(324, 202, 114, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "INSERT INTO Event(eventName,particlular,amountDebited,date,billNo,debitedBy) VALUES(?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_4.getText());
					pst.setString(5, textField_5.getText());
					pst.setString(6, textField_6.getText());
					
					 pst.execute();
					JOptionPane.showMessageDialog(null, "Event Created Succesfully");
					pst.close();
					
				
					
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
				
				
			}
		});
		btnSubmit.setBounds(36, 336, 131, 27);
		contentPane.add(btnSubmit);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "UPDATE Event SET eId='"+textField.getText()+"',eventName='"+textField_1.getText()+"',particlular='"+textField_2.getText()+"',amountDebited='"+textField_3.getText()+"',date='"+textField_4.getText()+"',billNo='"+textField_5.getText()+"',debitedBy='"+textField_6.getText()+"' where eId='"+textField.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					 pst.execute();
					JOptionPane.showMessageDialog(null, "Event  Update  Succesfully");
					pst.close();
					
				
					
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			
			}
		});
		btnUpdate.setBounds(196, 336, 122, 27);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "DELETE FROM Event WHERE  eId='"+textField.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					 pst.execute();
					JOptionPane.showMessageDialog(null, "Event  Deleted  Succesfully");
					pst.close();
					
				
					
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			
			
			}
		});
		btnDelete.setBounds(347, 335, 117, 25);
		contentPane.add(btnDelete);
		
		
		
		
		
	}
}
