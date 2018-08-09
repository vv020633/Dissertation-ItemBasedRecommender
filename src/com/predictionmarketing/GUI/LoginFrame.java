package com.predictionmarketing.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField loginfield;
	private String text;
	public static String usr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chas\\workspace\\RecommendationEngine\\RS\\data\\lips.png"));
		setForeground(new Color(255, 51, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 174);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setForeground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(73, 102, 115, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readLogin login = new readLogin();
				usr = loginfield.getText();
				setUserID(usr);
				if(login.read(usr)== true){
					Frame1 main = new Frame1();
					main.frmMatchmaker.setVisible(true);;
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "ProfileID not found. Please Enter a valid ID");
				}	
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		loginfield = new JTextField();
		loginfield.setBounds(73, 68, 115, 23);
		contentPane.add(loginfield);
		loginfield.setColumns(10);
		loginfield.setDocument(new JTextFieldCharLimits(6));
		
		JLabel lblEnterUserId = new JLabel("Enter User ID");
		lblEnterUserId.setBounds(89, 43, 97, 14);
		contentPane.add(lblEnterUserId);
	}
	
public void setUserID(String i){
	usr = i;
}
public String getUserID(){
	return usr;
}
}
