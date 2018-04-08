package ie.gmit.sw.ai;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SimulatedAnnealing {
	
	private String alpha = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // not incl j
	
	private String parent;
	private ReadFile rf;
	private Map<String, Double> grams;
	private PlayFair pf;
	private String cipherText;
	private int temp;
	private int trans;
	
	
	public SimulatedAnnealing(String cipherText, int temp, int trans){
		rf = new ReadFile();
		grams = rf.readGrams("./4grams.txt");
		
		pf = new PlayFair(); 
		this.cipherText = cipherText;
		
	}
	
	public void BreakCipher(){
		parent = RandomKey(alpha);
		
		String text = ""; 
		text = pf.decrypt(cipherText, alpha);
		
		double score = Score(text);
		double bestScore= score;
		String bestResult = text;
		String bestKey = parent;
		
		System.out.println("Initial Parent Plain-Text: "+ text);
		System.out.println("Initial Parent Score: "+score);
		
		for(int i = this.temp; i > 0; i--){
			for(int j = this.trans; j> 0; j--){
				//String child = shuffleKey();
			}
		}
		
	}
	
	public String RandomKey(String alpha){
		
		char[] a = alpha.toCharArray();
		int num;
		Random r = ThreadLocalRandom.current();
		
		for(int i = a.length - 1; i > 0; i--){
			
			num = r.nextInt(i+ 1);
			
			//randomly shuffling the key
			if(i != num){
				a[num]^= a[i];
				a[i]^= a[num];
				a[num]^= a[i];
				
			}
			
		}
		return String.valueOf(a);
	}
	
	
	private Double Score(String text){
		
		double score =0;
		
		long gramSum = 457373638373L;
		
		for(int i = 0; i < text.length() - 4; i++){
			//comparing the grams file  to the grams of the text
			Double g = grams.get(text.substring(i, i + 4));
			
			//Log formula
			if(g == null){
				score += Math.log10((double) (1.0 / gramSum));
			}
			else{
				score += Math.log10((double) (g / gramSum));
			}
		}
		
		return score;
	}
	
	//
	public String shuffleKey(){
		int random = (int)Math.floor(Math.random()* 50);
		
		if(random == 1){
			//swap rows
		}
		else if(random == 2){
			//swap cols
		}
		else if(random == 3){
			//flip all rows 
		}
		else if(random == 4){
			//flip all cols
		}
		else if(random == 5){
			//reverse the whole key
		}
		else{
			//swap single letters
		}
		
		return alpha;
		
		
		
	}
	

}
