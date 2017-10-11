import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	/**
	 * @param args
	 */
	
	static int numberOfSamples = 0;
	static int numberOfAttributes = 0;
	static int numCorrelatedPairs= 0;
	
	static ArrayList<ArrayList<Double>> input = new ArrayList<ArrayList<Double>>();
	static ArrayList<ArrayList<Double>> inputTranspose = new ArrayList<ArrayList<Double>>();
	static ArrayList<Integer> output = new ArrayList<Integer>();
	
	static String filename = null;
	static String dirPath = null;
	
	public static void readInput(String filename){
		String line = null;
		String[] temp = null;
		FileReader fileReader;
		BufferedReader br;
		try {
			File file = new File(filename);
			file.createNewFile();
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			while((line = br.readLine()) !=null){
				ArrayList<Double> tempArray = new ArrayList<Double>();
				temp = line.split(",");
				for(int i = 0 ;i<(temp.length-1);i++){
					Double tempValue = Double.parseDouble(temp[i]);
					tempArray.add(tempValue);
				}
				input.add(tempArray);
				if(temp[temp.length-1].equalsIgnoreCase("positive")){
					output.add(1);
				}
				else{
					output.add(0);
				}
			}
//			System.out.println(output);
			numberOfSamples = input.size();
			numberOfAttributes = input.get(0).size();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<ArrayList<Double>> transpose(ArrayList<ArrayList<Double>> input2) {
		int r = input2.size();
		int c = input2.get(r-1).size();
		//System.out.println(r + " " +c);
		ArrayList<ArrayList<Double>> t = new ArrayList<ArrayList<Double>>();
		  for(int i = 0; i < c; ++i) {
			 ArrayList<Double> temp = new ArrayList<Double>();;
			 for(int j = 0; j < r; ++j) {
				 ArrayList<Double> temp2 = input2.get(j);
			     Double addValue = temp2.get(i);
		    	 temp.add(addValue);
		     }
		     t.add(temp);
		  }
		return t;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 1. Read input file
		File file = new File(args[0]);
		file.createNewFile();
		dirPath = file.getAbsoluteFile().getParentFile().getAbsolutePath();
		readInput(args[0]);
		inputTranspose = transpose(input);
		
		// 2. Compute correlation between pair of genes
			numCorrelatedPairs = 500;

			//create correlation object
			Correlation obj = new Correlation();
			
			// call for compute correlation method 
			obj.computeCorrelation(inputTranspose,numCorrelatedPairs);
			//obj.writeCorrelation();
				
	}

}
