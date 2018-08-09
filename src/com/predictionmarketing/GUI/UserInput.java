/*package com.predictionmarketing.GUI;
import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserInput{
	//should I make these static?
	private static Scanner x = new Scanner(System.in);
	static String input;

	public void PromptInput() {
		
		String input = JOptionPane.showInputDialog(null,"Enter a MatchID", "MatchFinder9000", JOptionPane.PLAIN_MESSAGE);
		//int input1 = Integer.parseInt(input);
	}
	
	public String GetInput(){
		return input;
	}
	public static void SearchInput(){
		String filepath = "data/ratings.csv";
		String searchTerm = input;
		
	}
	public static void readRecord(int searchTerm, String filepath){
		boolean found = false;
		String UserID = "";
		String ItemID = "";
		String Rating = "";
		try
		{
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext() && !found)
			{
				UserID = x.next();
				ItemID = x.next();
				Rating = x.next();
				
				if(ItemID.equals(searchTerm))
				{
					found = true;
				}
			}
			if(found)
			{
				//JOptionPane.showMessageDialog(null, "ID:")
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ProfileID not found. Please Enter a valid ID");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ERROR");
		}
	}
	
}
*/
