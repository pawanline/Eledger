package com.eledger.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

public class ViewAccount extends JFrame {

	
	Connection connection = MySqlConnection.dbConnector();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccount frame = new ViewAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame\.
	 */
	public ViewAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubmittedFund = new JButton("Submitted Fund");
		btnSubmittedFund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "Select * from Student";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception Except){
					
				}
				
			}
		});
		btnSubmittedFund.setBounds(0, 42, 153, 25);
		contentPane.add(btnSubmittedFund);
		
		JButton btnViewEvents = new JButton("View Events");
		btnViewEvents.setBounds(0, 108, 153, 25);
		contentPane.add(btnViewEvents);
		btnViewEvents.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				String query = "Select * from Event";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception Except){
				
			}
			
		}
		});
	
		
		JButton btnAva = new JButton("Total Submission");
		btnAva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "SELECT SUM(amountCredited) AS totalCredited from Student";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		
				rs.next();
				float balance=rs.getFloat("totalCredited");
					
				
		
				
				JOptionPane.showMessageDialog(null, "Total Submission is "+balance);
				
				
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
				
			}
		});
		btnAva.setBounds(0, 175, 166, 25);
		contentPane.add(btnAva);
		
		JButton btnNewButton = new JButton("Tot Expenditure");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "SELECT SUM(amountDebited) AS expenditure from Event";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		
				rs.next();
				float totalExpenditure=rs.getFloat("expenditure");
			
				
				
				JOptionPane.showMessageDialog(null, "Total Expenditure is "+totalExpenditure);
				
				
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(0, 238, 153, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 12, 823, 468);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
