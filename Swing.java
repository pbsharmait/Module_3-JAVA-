package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Swing implements ActionListener{
	
	JFrame f;
	JLabel id,name,gender,add,cont,reg;
	JTextField t1,t2,t4,t5;
	JRadioButton Male,Female;
	JButton b1,b2,b3,b4,b5;
	
	public Swing() {
		 f=new JFrame("REGISTRATION FORM");
		 f.setVisible(true);
		 f.setSize(330, 500);
		 f.setLayout(null);
		 f.setResizable(false);
		 
		 reg=new JLabel("Registration Form");
		 id=new JLabel("ID");
		 name=new JLabel("Name");
		 gender=new JLabel("Gender");
		 add=new JLabel("Address");
		 cont=new JLabel("Contact");
		 Male=new JRadioButton("Male");
		 Female=new JRadioButton("Female");
		 
		 ButtonGroup gen=new ButtonGroup();
		 gen.add(Male);
		 gen.add(Female);
		 
		 
		 
		 
		 t1=new JTextField(20);
		 t2=new JTextField(20);
		 Male=new JRadioButton("Male");
		 Female=new JRadioButton("Female");
		 t4=new JTextField(20);
		 t5=new JTextField(20);
		 
		 b1=new JButton("Exit");
		 b2=new JButton("Register");
		 b3=new JButton("Delete");
		 b4=new JButton("update");
		 b5=new JButton("Search");
		 
		 
		 f.add(reg);
		 f.add(id);
		 f.add(t1);
		 f.add(name);
		 f.add(t2);
		 f.add(gender);
		 f.add(Male);
		 f.add(Female);
		 f.add(add);
		 f.add(t4);
		 f.add(cont);
		 f.add(t5);
		 f.add(b1);
		 f.add(b2);
		 f.add(b3);
		 f.add(b4);
		 f.add(b5);
		 
		 
		 reg.setBounds    (70, 5, 120, 20);
		 id.setBounds     (50, 50, 100, 20);
		 name.setBounds   (50, 100, 100, 20);
		 gender.setBounds (50, 150, 100, 20);
		 add.setBounds    (50, 200, 100, 20);
		 cont.setBounds   (50, 250, 100, 20);
		 
		 
		 t1.setBounds(130, 50, 130, 20);
		 t2.setBounds(130, 100, 130, 20);
		 Male.setBounds(130, 150, 130, 20);
		 Female.setBounds(190, 150, 130, 20);
		 t4.setBounds(130, 200, 130, 20);
		 t5.setBounds(130, 250, 130, 20);
		 
		 
		 
		 b1.setBounds(50, 300, 100, 20);
		 b2.setBounds(160, 300, 100, 20);
		 b3.setBounds(50, 350, 100, 20);
		 b4.setBounds(160, 350, 100, 20);
		 b5.setBounds(105, 400, 100, 20);
		   
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
	}
	public static void main(String[] args) {
		new Swing();
	}

	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1)
			{
				System.out.println("Exit Button");
			}
			else if(e.getSource()==b2)
			{
				boolean gengp=false;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swingassignments","root","");
					String sql="insert into student(name,gender,address,contact)values(?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,t2.getText());
					
					if(Female.isSelected()) {
						gengp=true;
					}
					if(gengp==true)
					{
						pst.setString(2,"Female");
					}
					else
					{
						pst.setString(2,"Male");
					}
					pst.setString(3,t4.getText());
					pst.setLong(4, Long.parseLong(t5.getText()));
					pst.executeUpdate();
					t2.setText("");
					Male.setText("");
					Female.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(f, "Data Registered Successfully ");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			else if(e.getSource()==b3)
			{
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swingassignments","root","");
					String sql=	"delete from student Where id=?";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(t1.getText()));
					
					
					pst.executeUpdate();
					t1.setText("");
					t2.setText("");
					Male.setText("");
					Female.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(f, "Data Deleted Successfully ");
				} catch (Exception e2) {
                   e2.printStackTrace();
				}
			}
			else if(e.getSource()==b4)
			{
Boolean gengp=false;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swingassignments","root","");
					String sql=	"update student set name=?,gender=?,address=?,contact=? Where id=?";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,t2.getText());
					
					if(Female.isSelected()) {
						gengp=true;
					}
					if(gengp==true)
					{
						pst.setString(2,"Female");
					}
					else
					{
						pst.setString(2,"Male");
					}
					pst.setString(3,t4.getText());
					pst.setLong(4, Long.parseLong(t5.getText()));
					pst.setInt(5, Integer.parseInt(t1.getText()));
					
					pst.executeUpdate();
					t1.setText("");
					t2.setText("");
					Male.setText("");
					Female.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(f, "Data Updated Successfully ");
				} catch (Exception e2) {
                   e2.printStackTrace();
				}
			}
			else if(e.getSource()==b5)
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swingassignments","root","");
					String sql=	"select * from student Where id=?";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(t1.getText()));
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						t2.setText(rs.getString("name"));
						t4.setText(rs.getString("address"));
						t5.setText(rs.getString("contact"));
					}
				} catch (Exception e2) {
					
				}
			}
		
	}

}
