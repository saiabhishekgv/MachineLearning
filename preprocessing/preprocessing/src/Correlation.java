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
	
	// mean for all genes. 
	// for each gene : get the sum of samples in that gene and divide it with number of samples in that gene.
	// append this gene value into arraylist(so that we can use it later with O(1) time complexity
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
	
	// Standard Deviation for all genes. 
	// for each gene : get the sum of ( value of each sample-mean) in that gene and divide it with number of samples in that gene.
	// perform square root of the value to get standard deviation of that gene.
	// append this gene value into arraylist(so that we can use it later with O(1) time complexity
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
		// Get the mean values of all genes.
		mean(input2);
		// Get the standard deviation values of all genes.
		stdDev(input2);
		// Print the Mean and standard Deviation values 
		System.out.println("Mean for all the genes are : "+ meanValue );
		System.out.println("standard deviation for all the genes are : "+ stdDevValue);
	}
	
}
