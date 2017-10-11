import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Correlation {

	static int NumCorrelatedPairs = 0;
	static int numberOfSamples = 0;
	static int numberOfAttributes = 0;
	
	static ArrayList<ArrayList<Double>> input = new ArrayList<ArrayList<Double>>();
	static ArrayList<ArrayList<Double>> T_input = new ArrayList<ArrayList<Double>>();
	
	static ArrayList<Double> meanValue = new ArrayList<Double>();
	static ArrayList<Double> stdDevValue = new ArrayList<Double>();
	static ArrayList<Integer> output = new ArrayList<Integer>();
	static Map<Double,ArrayList<String>> Correlations_map = new TreeMap<>(Collections.reverseOrder());
	
	static String filename = null;
	static String dirPath = null;
	static Double S_entropy = 0.0;
	
	
	public void mean(ArrayList<ArrayList<Double>> input2 ){
		int r = input2.size();
		int col = input2.get(0).size();
		//System.out.println(r + " " + col);
		for(int i = 0 ;i<r;i++){
			Double sum = 0.0;
			for(int j = 0;j<col;j++){
				sum = sum + input2.get(i).get(j);
			}
			meanValue.add(sum/col);
		}
	}
	
	public void stdDev(ArrayList<ArrayList<Double>> input2 ){
		int r = input2.size();
		int col = input2.get(0).size();
		//System.out.println(r + " " + col);
		for(int i = 0 ;i<r;i++){
			Double sum = 0.0;
			for(int j = 0;j<col;j++){
				sum = sum + Math.pow((input2.get(i).get(j) - meanValue.get(i)),2);
			}
			stdDevValue.add(Math.sqrt(sum/(col-1)));
		}
	}
	
	public  void computeCorrelation(ArrayList<ArrayList<Double>> input2,int k){
		System.out.println("Calculating Correlations");
		int numberOfgenes = input2.size();
		int numberOfSamples = input2.get(0).size();
		mean(input2);
		stdDev(input2);
		System.out.println("Mean for all the genes are : "+ meanValue );
		System.out.println("standard deviation for all the genes are : "+ stdDevValue);
	}
	
}
