package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class UpdateEmployee extends JFrame implements ActionListener{

	
	JButton add, back;
	JLabel heading, labelname, labelfname, labeldob, labelsalary, labeladdress, lblempid, lblname, lbladhaar;
	JLabel labelphone, labelemail, labeleducation, labeldesignation, labeladhaar, labelemployeeid, lbldob;
	JTextField tfeducation,tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation;
	String empId;
	
	
	UpdateEmployee(String empId){
		
		this.empId = empId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		heading = new JLabel("Update Employee Details");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
		add(heading);
		
		labelname = new JLabel("Name");
		labelname.setBounds(50,150, 150, 30);
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		lblname = new JLabel();
		lblname.setBounds(200, 150, 150, 30);
		add(lblname);
		
		labelfname = new JLabel("Father's Name");
		labelfname.setBounds(400,150, 150, 30);
		labelfname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelfname);
		
		tffname = new JTextField();
		tffname.setBounds(600, 150, 150, 30);
		add(tffname);
		
		labeldob = new JLabel("Date of Birth");
		labeldob.setBounds(50,200, 150, 30);
		labeldob.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldob);
		
		lbldob = new JLabel();
		lbldob.setBounds(200, 200, 150, 30);
		add(lbldob);
		
		labelsalary = new JLabel("Salary");
		labelsalary.setBounds(400,200, 150, 30);
		labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(600, 200, 150, 30);
		add(tfsalary);
		
		labeladdress = new JLabel("Address");
		labeladdress.setBounds(50,250, 150, 30);
		labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250, 150, 30);
		add(tfaddress);
		
		labelphone = new JLabel("Phone No.");
		labelphone.setBounds(400,250, 150, 30);
		labelphone.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250, 150, 30);
		add(tfphone);
		
		labelemail = new JLabel("Email");
		labelemail.setBounds(50,300, 150, 30);
		labelemail.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 300, 150, 30);
		add(tfemail);
		
		labeleducation = new JLabel("Highest Education");
		labeleducation.setBounds(400,300, 150, 30);
		labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeleducation);
		
		tfeducation = new JTextField();
		tfeducation.setBounds(600, 300, 150, 30);
		add(tfeducation);
		
		labeldesignation = new JLabel("Designation");
		labeldesignation.setBounds(50,350, 150, 30);
		labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldesignation);
		
		tfdesignation = new JTextField();
		tfdesignation.setBounds(200, 350, 150, 30);
		add(tfdesignation);
		
		labeladhaar = new JLabel("Adhaar Number");
		labeladhaar.setBounds(400,350, 150, 30);
		labeladhaar.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeladhaar);
		
		lbladhaar = new JLabel();
		lbladhaar.setBounds(600, 350, 150, 30);
		add(lbladhaar);
		
		labelemployeeid = new JLabel("Employee Id");
		labelemployeeid.setBounds(50,400, 150, 30);
		labelemployeeid.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelemployeeid);
		
		lblempid = new JLabel();
		lblempid.setBounds(200,400, 150, 30);
		lblempid.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblempid);
		
		try {
			Conn c = new Conn();
			String query = "select *  from employee where empId = '"+empId+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				tffname.setText(rs.getString("fname"));
				lbldob.setText(rs.getString("dob"));
				tfaddress.setText(rs.getString("address"));
				tfsalary.setText(rs.getString("salary"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				tfeducation.setText(rs.getString("education"));
				lbladhaar.setText(rs.getString("adhaar"));
				lblempid.setText(rs.getString("EmpId"));
				tfdesignation.setText(rs.getString("designation"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		add = new JButton("Update Details");
		add.setBounds(250,550, 150, 40);
		add.addActionListener(this);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add(add);
		
		back = new JButton("Back");
		back.setBounds(450,550, 150, 40);
		back.addActionListener(this);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		add(back);
		
		
		setSize(900,700);
		setLocation(300,50);
		setVisible(true);
		
	}
	public static void main(String[] args) {
	
		new UpdateEmployee("");

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == add) {
			
			String name = tffname.getText();
			String salary = tfsalary.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String education = tfeducation.getText();
			String designation = tfdesignation.getText();
			
			try {
				Conn conn = new Conn();
				String query="update employee set fname = '"+name+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empid = '"+empId+"'";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details updated successfully");
				setVisible(false);
				new Home();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new Home();
		}
		
	}

}
