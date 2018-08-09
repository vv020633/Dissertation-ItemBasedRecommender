package com.predictionmarketing.recommender;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.junit.Test;

public class ValidationTest {

	@Test
	public void test() throws IOException, TasteException {
		/*final DataModel dataModel = new FileDataModel(new File("data/ratings.csv"));
		RecommenderIRStatsEvaluator evaluator = 
				new GenericRecommenderIRStatsEvaluator();
		
		RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
			
			public Recommender buildRecommender(DataModel dataModel) throws TasteException {
				ItemSimilarity similarity = new LogLikelihoodSimilarity(dataModel);
				return new GenericItemBasedRecommender(dataModel, similarity);
			}
		};
		IRStatistics stats = evaluator.evaluate(recommenderBuilder, null, dataModel, null, 10, 
				GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD, 1.0);*/
		
		//System.out.println(stats.getPrecision());
		//System.out.println(stats.getRecall());
		System.out.print("Hello World");
	}

}
