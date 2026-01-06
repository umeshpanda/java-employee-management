package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FetchEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FetchEmployee frame = new FetchEmployee();
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
	public FetchEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Fetch Employee");
		l1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		l1.setBounds(151, 10, 147, 27);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Enter The Id");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(49, 47, 130, 33);
		contentPane.add(l2);
		
		textField = new JTextField();
		textField.setBounds(199, 47, 167, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btn = new JButton("Fetch");
		btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int id = Integer.parseInt(textField.getText());

		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String dpath = "com.mysql.cj.jdbc.Driver";
		        String url = "jdbc:mysql://localhost:3306/employee?user=root&password=umesh";
		        String sql = "select * from employee where id = ?";

		        try {
		            Class.forName(dpath);
		            con = DriverManager.getConnection(url);
		            ps = con.prepareStatement(sql);
		            ps.setInt(1, id);
		            rs = ps.executeQuery();
		       
					if (rs.next()) {
		                textArea.setText(
		                    "ID : " + rs.getInt("id") +
		                    "\nName : " + rs.getString("name") +
		                    "\nSalary : " + rs.getInt("salary")
		                );
		            } else {
		                textArea.setText("Employee not found");
		            }
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        } finally {
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		                if (con != null) con.close();
		            } catch (Exception e2) {
		                e2.printStackTrace();
		            }
		        }
		    }  // Closes actionPerformed
		});  // Closes addActionListener call and anonymous class
		btn.setBackground(SystemColor.inactiveCaption);
		btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn.setBounds(135, 90, 111, 33);
		contentPane.add(btn);

		
		textArea = new JTextArea();
		textArea.setBounds(49, 133, 293, 106);
		contentPane.add(textArea);
		
		JButton btn1 = new JButton("Back");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMain em = new EmployeeMain();
				em.setVisible(true);
				dispose();
			}
		});
		btn1.setBounds(351, 242, 85, 21);
		contentPane.add(btn1);

	}
}
