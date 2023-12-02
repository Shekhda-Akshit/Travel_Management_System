/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

	private JPanel panel,panel2;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login() {
            
	setLayout(null);	
        setSize(900,400);
        setLocation(200,140);
		
        getContentPane().setBackground(Color.WHITE);
        
        panel = new JPanel();
	panel.setBackground(new Color(131,193,233));
        panel.setBounds(0, 0, 400, 400);
        panel.setLayout(null);
	add(panel);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(90, 65, 200, 200);
        panel.add(l6);
	
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(380, 30, 500, 300);
        add(panel2);
        
        JLabel l1 = new JLabel("Username : ");
	l1.setBounds(124, 89, 95, 24);
	panel2.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 124, 95, 24);
	panel2.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel2.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel2.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel2.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel2.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(176, 224, 230));
	b1.setBounds(149, 181, 113, 25);
	panel2.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 181, 113, 25);
	panel2.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(199, 231, 139, 25);
	panel2.add(b3);

	JLabel l5 = new JLabel("Trouble in Login...");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(370, 231, 110, 15);
	panel2.add(l5);
        
        setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    Conn con = new Conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading(textField.getText()).setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login().setVisible(true);
	}

}