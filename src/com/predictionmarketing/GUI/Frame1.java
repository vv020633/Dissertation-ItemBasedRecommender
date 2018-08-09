package com.predictionmarketing.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.predictionmarketing.recommender.Recommend;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame1 {

	public JFrame frmMatchmaker;
	private JTextField Input;
	public static JTextArea SuggestionBox;
	public String TextInput;
	public static long itemID;
	private JLabel lblMatchid;
	private JLabel lblNewLabel;
	private JLabel lblSimilaritydecimal;
	private boolean value;
	private JLabel label;
	public static String ID;
	private static long parseduser;
	private JButton btnViewYourCompetition;
	private JButton usrRecButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmMatchmaker.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmMatchmaker = new JFrame();
		frmMatchmaker.setUndecorated(false);
		frmMatchmaker.setResizable(false);
		frmMatchmaker.setTitle("MatchMaker5000");
		frmMatchmaker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chas\\workspace\\RecommendationEngine\\RS\\data\\lips.png"));
		frmMatchmaker.getContentPane().setForeground(new Color(255, 153, 255));
		frmMatchmaker.getContentPane().setBackground(new Color(204, 51, 102));
		frmMatchmaker.setBackground(new Color(204, 51, 102));
		frmMatchmaker.setBounds(100, 100, 487, 300);
		frmMatchmaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchmaker.getContentPane().setLayout(null);
	
		JButton btnNewButton = new JButton("Find My Matches");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearField clr = new ClearField();
				clr.Clear(SuggestionBox);
				LoginFrame log = new LoginFrame();
				ID = log.getUserID();
				TextInput = Input.getText();
				if(Input.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(frmMatchmaker, "Please Enter an ID in the text field", "Input Required", JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{
				value = readRecord(TextInput);
				}
				
				if (value == false){
					JOptionPane.showMessageDialog(frmMatchmaker,"This User Profile Does Not Exist", "Invalid ID", JOptionPane.PLAIN_MESSAGE);
				}
				 if(TextInput.equals(ID)){
					JOptionPane.showMessageDialog(frmMatchmaker,"100% match! Congratulations you're in love with yourself!", "Enter Another ID", JOptionPane.PLAIN_MESSAGE);
				}
				else if (value == true){
					itemID = Long.parseLong(TextInput);
					Recommend rec = new Recommend();
					rec.Recommender(itemID, SuggestionBox);
				
					}	
			}
		});
		btnNewButton.setForeground(new Color(153, 51, 102));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(34, 97, 130, 23);
		frmMatchmaker.getContentPane().add(btnNewButton);
		
		Input = new JTextField();
		Input.setDocument(new JTextFieldCharLimits(6));
		Input.setForeground(new Color(255, 153, 153));
		Input.setBounds(34, 74, 130, 20);
		frmMatchmaker.getContentPane().add(Input);
		Input.setColumns(10);
		
		JLabel lblEnterMatchId = new JLabel("Enter your match's ID");
		lblEnterMatchId.setBounds(34, 61, 145, 14);
		frmMatchmaker.getContentPane().add(lblEnterMatchId);
		
		lblMatchid = new JLabel("MatchID");
		lblMatchid.setForeground(new Color(255, 102, 255));
		lblMatchid.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMatchid.setBounds(174, 36, 57, 14);
		frmMatchmaker.getContentPane().add(lblMatchid);
		
		lblNewLabel = new JLabel("Recommendations");
		lblNewLabel.setForeground(new Color(255, 102, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(258, 25, 94, 36);
		frmMatchmaker.getContentPane().add(lblNewLabel);
		
		lblSimilaritydecimal = new JLabel("Similarity");
		lblSimilaritydecimal.setForeground(new Color(255, 102, 255));
		lblSimilaritydecimal.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSimilaritydecimal.setBounds(372, 21, 126, 45);
		frmMatchmaker.getContentPane().add(lblSimilaritydecimal);
		
		 SuggestionBox = new JTextArea();
		SuggestionBox.setBounds(174, 72, 273, 159);
		frmMatchmaker.getContentPane().add(SuggestionBox);
		
		label = new JLabel("");
		label.setBounds(206, -56, 487, 300);
		frmMatchmaker.getContentPane().add(label);
		
		usrRecButton = new JButton("View Your Competition");
		usrRecButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UserRecFrame recs = new UserRecFrame();
				LoginFrame log = new LoginFrame();
				ID = log.getUserID();
				parseduser = Long.parseLong(ID);
				recs.setVisible(true);
				frmMatchmaker.dispose();
			}
		});
		usrRecButton.setBounds(226, 237, 186, 23);
		frmMatchmaker.getContentPane().add(usrRecButton);
	}
	public void setParsedUser(long x){
		parseduser = x;
	}
	public long getParsedUser(){
		return parseduser;
	}
	private static boolean readRecord(String TextInput){
		boolean found = false;
		String filepath = "data/ratings.csv";
		Scanner scan = new Scanner(System.in);
		String UserID = "";
		String ItemID = "";
		String Rating = "";
		try
		{
			scan = new Scanner(new File(filepath));
			scan.useDelimiter("[,\n]");
		
			while(scan.hasNext() && !found)
			{
				UserID = scan.next();
				ItemID = scan.next();
				Rating = scan.next();
				
				if(ItemID.equals(TextInput))
				{
					found = true;
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		return found;
	}
}
