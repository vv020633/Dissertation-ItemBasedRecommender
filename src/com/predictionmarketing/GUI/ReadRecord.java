package com.predictionmarketing.GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadRecord {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
			boolean found = false;
			String filepath = "data/ratings.csv";
			String UserID = "";
			String ItemID = "";
			String Rating = "";
			
			
				try {
					scan = new Scanner(new File(filepath));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				scan.useDelimiter("[,\n]");
				
				while(scan.hasNext() && !found)
				{
					UserID = scan.next();
					ItemID = scan.next();
					Rating = scan.next();
					
					if(ItemID.equals(1))
					{
						found = true;
						System.out.println(found);
					}
					
					
				}
	}
}
	


