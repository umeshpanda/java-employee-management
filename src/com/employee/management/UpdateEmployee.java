package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class UpdateEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField salary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Update Employee");
		l1.setFont(new Font("SimSun-ExtG", Font.BOLD, 16));
		l1.setBounds(139, 10, 191, 34);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Enter ID");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(71, 59, 96, 25);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("New Name");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(71, 104, 96, 25);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("New Salary");
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(71, 152, 96, 25);
		contentPane.add(l4);
		
		id = new JTextField();
		id.setBackground(SystemColor.inactiveCaptionBorder);
		id.setBounds(172, 54, 115, 30);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(SystemColor.inactiveCaptionBorder);
		name.setBounds(177, 104, 115, 30);
		contentPane.add(name);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBackground(SystemColor.inactiveCaptionBorder);
		salary.setBounds(177, 157, 115, 30);
		contentPane.add(salary);
		
		JButton btn1 = new JButton("Update");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inid = Integer.parseInt(id.getText());
				String inname = name.getText();
				
				Connection con = null;
				PreparedStatement ps = null;
				String dpath = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/employee ? user = root & password = umesh";
				String sql = "update employee set name = ? where id = ?";
				int nora = -1;
				
				try {
					
					Class.forName(dpath);
					con = DriverManager.getConnection(url);
					ps = con.prepareStatement(sql);
					ps.setString(1, inname);
					ps.setInt(2, inid);
					nora = ps.executeUpdate();
					 
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						
						if (con != null) con.close();
						if (ps != null) ps.close();
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					if (nora > 0) {
						JOptionPane.showMessageDialog(null, "Record Updated successfully");
					} else {
						JOptionPane.showMessageDialog(null, " some error occured");
					}
				}
			}
		});
		btn1.setBounds(316, 108, 85, 21);
		contentPane.add(btn1);
		
		JButton btn1_1 = new JButton("Update");
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inid = Integer.parseInt(id.getText());
				int insalary = Integer.parseInt(salary.getText());
				
				Connection con = null;
				PreparedStatement ps = null;
				String dpath = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/employee ? user = root & password = umesh";
				String sql = "update employee set salary = ? where id = ?";
				int nora = -1;
				
				try {
					

					Class.forName(dpath);
					con = DriverManager.getConnection(url);
					ps = con.prepareStatement(sql);
					ps.setInt(1, insalary);
					ps.setInt(2, inid);
					nora = ps.executeUpdate();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						
						if (con != null) con.close();
						if (ps != null) ps.close();
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					if (nora > 0) {
						JOptionPane.showMessageDialog(null, "Record Updated successfully");
					} else {
						JOptionPane.showMessageDialog(null, " some error occured");
					}
					
				}
			}
		});
		btn1_1.setBounds(316, 161, 85, 21);
		contentPane.add(btn1_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMain em = new EmployeeMain();
				em.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(326, 232, 85, 21);
		contentPane.add(btnBack);

	}

}
