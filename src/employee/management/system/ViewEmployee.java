package employee.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
//import net.proteanit.sql.*;

public class ViewEmployee extends JFrame implements ActionListener{
	
	DefaultTableModel dt, dt2;
	JTable table;
	
	Choice  comployeeId;
	JButton search, print, update, back;
	
	ViewEmployee(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel searchlbl = new JLabel("Search by Employee Id");
		searchlbl.setBounds(20, 20, 150, 20);
		add(searchlbl);
		
		comployeeId = new Choice();
		comployeeId.setBounds(180, 20, 150, 20);
		add(comployeeId);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from employee");
			
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			dt = new DefaultTableModel();
			table = new JTable(dt);
			dt.addColumn("name");
			dt.addColumn("fname");
			dt.addColumn("dob");
			dt.addColumn("salary");
			dt.addColumn("address");
			dt.addColumn("phone");
			dt.addColumn("email");
			dt.addColumn("education");
			dt.addColumn("designation");
			dt.addColumn("adhaar");
			dt.addColumn("empId");
			
			while(rs.next()) {
				comployeeId.add(rs.getString("empId"));
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};	
				dt.addRow(row);
			}
			table.setModel(dt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from employee");
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 600);
		add(jsp);
		
		search = new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(220, 70, 80, 20);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(320, 70, 80, 20);
		back.addActionListener(this);
		add(back);
		
		setSize(900, 700);
		setLocation(300, 100);
		setVisible(true);
		
	}
	public static void main(String args[]) {
		
		new ViewEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == search) {
			String query = "select * from employee where empId = '"+comployeeId.getSelectedItem()+"'";
			dt.setRowCount(0);
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				
				dt2 = new DefaultTableModel();
				
				table = new JTable(dt2);
				dt2.addColumn("name");
				dt2.addColumn("fname");
				dt2.addColumn("dob");
				dt2.addColumn("salary");
				dt2.addColumn("address");
				dt2.addColumn("phone");
				dt2.addColumn("email");
				dt2.addColumn("education");
				dt2.addColumn("designation");
				dt2.addColumn("adhaar");
				dt2.addColumn("empId");
				
				if(rs.next()) {
					comployeeId.add(rs.getString("empId"));
					String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
					
					dt.addRow(row);
				}
				table.setModel(dt2);
								
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == print) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == update) {
			setVisible(false);
			new UpdateEmployee(comployeeId.getSelectedItem());
		}else {
			 setVisible(false);
			 new Home();
		}
		
	}
}
