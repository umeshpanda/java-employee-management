package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
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

public class AddEmployee extends JFrame {

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
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(256, 143, 1, 1);
		contentPane.add(desktopPane);
		
		JLabel l1 = new JLabel("Add Employee");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1.setBounds(123, 10, 160, 29);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Enter id");
		l2.setFont(new Font("Tahoma", Font.BOLD, 15));
		l2.setBounds(58, 70, 110, 29);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Enter Name");
		l3.setFont(new Font("Tahoma", Font.BOLD, 15));
		l3.setBounds(58, 119, 110, 29);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Enter Salary");
		l4.setFont(new Font("Tahoma", Font.BOLD, 15));
		l4.setBounds(58, 168, 110, 29);
		contentPane.add(l4);
		
		id = new JTextField();
		id.setBackground(SystemColor.inactiveCaption);
		id.setBounds(207, 70, 135, 29);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(SystemColor.inactiveCaption);
		name.setBounds(207, 119, 135, 29);
		contentPane.add(name);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBackground(SystemColor.inactiveCaption);
		salary.setBounds(207, 168, 135, 29);
		contentPane.add(salary);
		
		JButton btn1 = new JButton("Add");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inid = Integer.parseInt(id.getText());
				String inname = name.getText();
				int insalary = Integer.parseInt(salary.getText());
				
				Connection con = null;
				PreparedStatement ps = null;
				String dpath = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/employee ? user = root & password = umesh";
				String sql = "insert into employee values(?, ?, ?)";
				int nora = -1;
				
				try {
					
					Class.forName(dpath);
					con = DriverManager.getConnection(url);
					ps = con.prepareStatement(sql);
					ps.setInt(1, inid);
					ps.setString(2, inname);
					ps.setInt(3, insalary);
					
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
						JOptionPane.showMessageDialog(null, "added in database successfully");
					} else {
						JOptionPane.showMessageDialog(null, "not added some error occured");
					}
				}
			}
		});
		btn1.setBackground(SystemColor.textInactiveText);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBounds(133, 220, 102, 33);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMain em = new EmployeeMain();
				em.setVisible(true);;
				dispose();
			}
		});
		btn2.setBackground(SystemColor.inactiveCaption);
		btn2.setBounds(329, 228, 97, 25);
		contentPane.add(btn2);

	}
}
