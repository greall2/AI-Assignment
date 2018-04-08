package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
	
	public String readFile(String filename){
		String text ="";
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(filename));
			StringBuffer sb = new StringBuffer();
			String line = null;	
			while ((line = bf.readLine()) != null) {
				sb.append(line);				
			}		
			text = sb.toString();
			
			bf.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("Error reading in file");
		}
	
		return text;
	}
	
	public Map<String, Double> readGrams(String filename){
		
		Map<String, Double> fgm;
		 
		fgm = new HashMap<String, Double>();

		BufferedReader bf;
		try {
			
			bf = new BufferedReader(new FileReader(filename));
						String line = null;	
			while ((line = bf.readLine()) != null) {
				String[] grams = line.split(" ");
				fgm.put(grams[0], Double.parseDouble(grams[1]));
			}		

			bf.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("Error reading in file");
		}
		
		return fgm;
	}
}

