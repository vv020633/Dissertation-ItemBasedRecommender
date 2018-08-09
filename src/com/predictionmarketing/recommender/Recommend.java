package com.predictionmarketing.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class Recommend {
	protected float percentage;
	protected static String numberAsString;
	protected static String numberAsString2;
	public  void Recommender(long matchID, JTextArea output) {
		

		try{
			FileDataModel dataModel = new FileDataModel(new File("data/ratings.csv"));
			//Create an ItemSimilarity
			ItemSimilarity itemSimilarity = new LogLikelihoodSimilarity(dataModel);
			//Create an Item Based Recommender
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);
			//Get the recommendations for the Item
			List<RecommendedItem> simItems = recommender.mostSimilarItems(matchID, 10);
			
			for (RecommendedItem recommendations: simItems){
				 numberAsString = Long.toString(recommendations.getItemID());
				percentage = recommendations.getValue()*100;
				 numberAsString2 = Float.toString(percentage);
				output.append(matchID + "\t" + numberAsString + "\t" + numberAsString2  + "%" + "\n" );
				System.out.println(matchID + "\t" + numberAsString + "\t" + numberAsString2  + "%" + "\n" );
				}
			}
			catch (IOException e) {
				System.out.println("There was an error. File Not Found.");
				e.printStackTrace();
			} catch (TasteException e) {
				System.out.println("There was a Taste Exception. User Does Not Exist");
				e.printStackTrace();
			}
		
	
	}
}