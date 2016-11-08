package com.eledger.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;



public class HomeDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeDialog frame = new HomeDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		Connection connection = null;
	/**
	 * Create the frame.
	 */
	public HomeDialog() {
		connection = MySqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomToEledger = new JLabel("Welcom to E-Ledger");
		lblWelcomToEledger.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWelcomToEledger.setBounds(115, 31, 246, 14);
		contentPane.add(lblWelcomToEledger);
		
		JButton btnV = new JButton("DepositMoney");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 DepositMoney dM = new DepositMoney();
				 dM.setVisible(true);
				
			}
		});
		btnV.setBounds(179, 211, 155, 25);
		contentPane.add(btnV);
		
		JButton btnCreateevent = new JButton("CreateEvent");
		btnCreateevent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEvent cE = new CreateEvent();
				 cE.setVisible(true);
			}
		});
		btnCreateevent.setBounds(267, 103, 171, 25);
		contentPane.add(btnCreateevent);
		
		JButton btnV_1 = new JButton("View Account");
		btnV_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewAccount vA = new ViewAccount();
				 vA.setVisible(true);
				
			}
		});
		btnV_1.setBounds(12, 103, 170, 25);
		contentPane.add(btnV_1);
	}
}
