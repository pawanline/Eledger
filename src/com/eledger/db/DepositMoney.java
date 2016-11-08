package com.eledger.db;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Color;

public class DepositMoney extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Connection connection = MySqlConnection.dbConnector();

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JLabel lblAmount;
	private JTextField textField_2;
	private JLabel lblDate;
	private JTextField textField_3;
	private JLabel lblTowhom;
	private JTextField textField_4;
	private JButton btnSubmit;
	private JButton btnUpdate;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositMoney frame = new DepositMoney();
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
	public DepositMoney() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setBounds(12, 12, 70, 15);
		contentPane.add(lblRollNo);
		
		textField = new JTextField();
		textField.setBounds(211, 12, 114, 15);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label = new JLabel("Name");
		label.setBounds(12, 41, 70, 15);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 31, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setBounds(12, 75, 70, 15);
		contentPane.add(lblAmount);
		
		textField_2 = new JTextField();
		textField_2.setBounds(211, 60, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(12, 136, 70, 15);
		contentPane.add(lblDate);
		
		textField_3 = new JTextField();
		textField_3.setBounds(211, 134, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblTowhom = new JLabel("ToWhom");
		lblTowhom.setBounds(12, 178, 70, 15);
		contentPane.add(lblTowhom);
		
		textField_4 = new JTextField();
		textField_4.setBounds(211, 176, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "INSERT INTO Student(rollNo,name,amountCredited,date,toWhom) VALUES(?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Money submitted");
					pst.close();
					
				
					
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(12, 289, 117, 25);
		contentPane.add(btnSubmit);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query ="UPDATE Student SET rollNo='"+textField.getText()+"',name='"+textField_1.getText()+"',amountCredited='"+textField_2.getText()+"',date='"+textField_3.getText()+"',toWhom='"+textField_4.getText()+"' where rollNo='"+textField.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					 pst.execute();
					JOptionPane.showMessageDialog(null, "Details   Updated  Succesfully");
					pst.close();
					
				
					
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(161, 289, 117, 25);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "DELETE FROM  Student WHERE  rollNo='"+textField.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					 pst.execute();
					JOptionPane.showMessageDialog(null, "Details Deleted  Succesfully");
					pst.close();
					
				
					
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			
			}
		});
		btnDelete.setBounds(288, 289, 117, 25);
		contentPane.add(btnDelete);
	}
}
