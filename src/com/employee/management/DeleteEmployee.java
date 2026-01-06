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

public class DeleteEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Delete Employee");
		l1.setFont(new Font("Stencil", Font.BOLD, 16));
		l1.setBounds(125, 10, 185, 32);
		contentPane.add(l1);
		
		JLabel lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(79, 80, 107, 32);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBackground(SystemColor.scrollbar);
		id.setBounds(211, 80, 145, 32);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btn = new JButton("Delete");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inid = Integer.parseInt(id.getText());
				
				Connection con = null;
				PreparedStatement ps = null;
				String dpath = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/employee ? user = user & password = password";
				String sql = "delete from employee where id = ?";
				int nora = -1;
				
				try {
					
					Class.forName(dpath);
					con = DriverManager.getConnection(url);
					ps = con.prepareStatement(sql);
					ps.setInt(1, inid);
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
						JOptionPane.showMessageDialog(null, "Record deleted successfully");
					} else {
						JOptionPane.showMessageDialog(null, " some error occured");
					}
				}
			}
		});
		btn.setBackground(SystemColor.windowText);
		btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn.setBounds(141, 146, 107, 32);
		contentPane.add(btn);
		
		JButton btn1 = new JButton("Back");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMain em = new EmployeeMain();
				em.setVisible(true);
				dispose();
			}
		});
		btn1.setBackground(SystemColor.controlDkShadow);
		btn1.setBounds(305, 213, 97, 32);
		contentPane.add(btn1);

	}

}
