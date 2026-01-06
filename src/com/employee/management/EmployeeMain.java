package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EmployeeMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMain frame = new EmployeeMain();
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
	public EmployeeMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Employee Management System");
		l1.setForeground(new Color(0, 0, 0));
		l1.setBackground(new Color(240, 240, 240));
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l1.setBounds(86, 10, 267, 39);
		contentPane.add(l1);
		
		JButton btn1 = new JButton("Fetch Employee");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 FetchEmployee fe = new FetchEmployee();
			        fe.setVisible(true);   
			        dispose();            
			}
		});
		btn1.setBackground(new Color(192, 192, 192));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn1.setBounds(42, 81, 136, 44);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Add Employee");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee ae = new AddEmployee();
				ae.setVisible(true);
				dispose();
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.setBounds(42, 151, 136, 44);
		contentPane.add(btn2);
		
		JButton btn4 = new JButton("Delete Employee");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee de = new DeleteEmployee();
				de.setVisible(true);
				dispose();
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(260, 151, 136, 44);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("Update Employee");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployee ue = new UpdateEmployee();
				ue.setVisible(true);
				dispose();
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(260, 81, 136, 44);
		contentPane.add(btn5);

	}
}
