package com.predictionmarketing.recommender;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class UsrRecommend {
	
protected static String numberAsString;
protected static String numberAsString2;
private double percentage;
public  void Recommender(long x, JTextArea output) throws TasteException, IOException {
	
	long startTime = System.currentTimeMillis();
			FileDataModel dataModel = new FileDataModel(new File("data/ratings.csv"));
			//Create an UsermSimilarity
			UserSimilarity userSimilarity= new LogLikelihoodSimilarity(dataModel);
			//Interface for computing a neighborhood of similar users
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, userSimilarity, dataModel);
	            long[] myneighborhood = neighborhood.getUserNeighborhood(x);
	        //Loop through neighbors and get the similarity to the main user
	            for(long neighbors:myneighborhood){
	            	   double compare =  userSimilarity.userSimilarity(x,neighbors);
	            	   percentage= compare*100;
	            	numberAsString = Long.toString(neighbors);
	            	numberAsString2 = Double.toString(percentage);
	            	output.append("\t" + numberAsString);
	            	output.append("\t" + numberAsString2 + "%" + "\n");
	            }
	            long endTime = System.currentTimeMillis();
	            System.out.println("That took " + (endTime - startTime) + " milliseconds");
				}

			}
			






