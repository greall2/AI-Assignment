package ie.gmit.sw.ai;

import java.util.Scanner;

public class CipherBreaker {

	//Runner Class
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter filePath:" );
		String file = sc.nextLine();
		
		ReadFile rf =new ReadFile();
		
		String s = rf.readFile(file);
		
		System.out.println("Enter Temperature");
		int temp = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Transition");
		int trans = sc.nextInt();
		sc.nextLine();

		SimulatedAnnealing sm = new SimulatedAnnealing(s, temp, trans);
		
		sm.BreakCipher();
		
		sc.close();
	
	}

}
