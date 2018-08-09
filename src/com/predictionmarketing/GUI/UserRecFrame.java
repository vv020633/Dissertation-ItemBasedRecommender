package com.predictionmarketing.GUI;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.mahout.cf.taste.common.TasteException;
import com.predictionmarketing.recommender.UsrRecommend;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class UserRecFrame extends JFrame {

	public static JTextArea userSimBox;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRecFrame frame = new UserRecFrame();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public UserRecFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chas\\workspace\\RecommendationEngine\\RS\\data\\lips.png"));
		setBackground(new Color(255, 51, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setForeground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 userSimBox = new JTextArea();
		userSimBox.setBounds(56, 49, 319, 189);
		contentPane.add(userSimBox);
		
		JLabel lblNewLabel = new JLabel("Profile ID");
		lblNewLabel.setBounds(132, 34, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Similarity");
		lblNewLabel_1.setBounds(229, 34, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setForeground(new Color(153, 0, 102));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame1 fr = new Frame1();
				ClearField clr = new ClearField();
				clr.Clear(userSimBox);
				 long parse = fr.getParsedUser();
				UsrRecommend usrrec = new UsrRecommend();
				try {
					usrrec.Recommender(parse, userSimBox);
				} catch (TasteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(151, 238, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(153, 0, 102));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame1 back = new Frame1();
				back.frmMatchmaker.setVisible(true);
				UserRecFrame.this.dispose();
			}
		});
		btnNewButton_1.setBounds(0, 0, 73, 23);
		contentPane.add(btnNewButton_1);
	}
}
