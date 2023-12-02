package travel.management.system;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DeleteCustomer extends JFrame implements ActionListener{
	
	JButton back;
        String username;
	public DeleteCustomer(String username) {
		this.username = username;
                setBounds(200, 80, 900, 550);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
                Image i3 = i1.getImage().getScaledInstance(400, 380,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,40,450,420);
                add(l1);
		
		JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(60, 11, 295, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                JLabel l4 = new JLabel();
		l4.setBounds(272, 70, 150, 20);
		contentPane.add(l4);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                JLabel l5 = new JLabel();
		l5.setBounds(272, 110, 150, 20);
		contentPane.add(l5);
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                JLabel l6 = new JLabel();
		l6.setBounds(272, 150, 150, 20);
		contentPane.add(l6);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		JLabel l7 = new JLabel();
		l7.setBounds(272, 190, 150, 20);
		contentPane.add(l7);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                JLabel l8 = new JLabel();
		l8.setBounds(272, 230, 150, 20);
		contentPane.add(l8);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                JLabel l9 = new JLabel();
		l9.setBounds(272, 270, 150, 20);
		contentPane.add(l9);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                JLabel l10 = new JLabel();
		l10.setBounds(272, 310, 150, 20);
		contentPane.add(l10);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                JLabel l11 = new JLabel();
		l11.setBounds(272, 350, 150, 20);
		contentPane.add(l11);
                
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l12 = new JLabel();
		l12.setBounds(272, 390, 150, 20);
		contentPane.add(l12);
                
                back = new JButton("Delete");
                back.setBounds(100, 430, 120, 30);
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                contentPane.add(back);

                try{
                        Conn conn = new Conn();
                        String query = "select * from customer where username = '"+username+"'";
                        ResultSet rs = conn.s.executeQuery(query);
                        while(rs.next()){
                            l4.setText(rs.getString("username"));
                            l5.setText(rs.getString("id_type"));
                            l6.setText(rs.getString("number"));
                            l7.setText(rs.getString("name"));
                            l8.setText(rs.getString("gender"));
                            l9.setText(rs.getString("country"));
                            l10.setText(rs.getString("address"));
                            l11.setText(rs.getString("phone"));
                            l12.setText(rs.getString("email"));
                        }
	    			
	    		}catch(SQLException e1){}
                setVisible(true);
        }
       
            
            public void actionPerformed(ActionEvent ae) {
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate("delete from account where username = '"+username+"'");
                    c.s.executeUpdate("delete from customer where username = '"+username+"'");
                    c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
                    c.s.executeUpdate("delete from bookHotel where username = '"+username+"'");
                    
                    JOptionPane.showMessageDialog(null,"Data Deleted Sucessfuly" );
                    System.exit(0);
                }catch(Exception e){
                    e.printStackTrace();}
            }
        
public static void main(String[] args) {
    new DeleteCustomer("");
}
}
