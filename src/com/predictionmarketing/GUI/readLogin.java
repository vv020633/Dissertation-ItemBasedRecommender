package com.predictionmarketing.GUI;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class readLogin {

	 boolean read(String TextInput){
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
				
				if(UserID.equals(TextInput))
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
