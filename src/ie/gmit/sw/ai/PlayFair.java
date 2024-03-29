package ie.gmit.sw.ai;

public class PlayFair {
	
	public String decrypt(String cipherText, String key){
		
		String d[] = diagraph(cipherText);
		
		StringBuilder sb = new StringBuilder();
		for (String pair : d) {
			char c1, c2;
			int row1 = (key.indexOf(pair.charAt(0)) / 5);
			int row2 = (key.indexOf(pair.charAt(1)) / 5);
            int col1 = (key.indexOf(pair.charAt(0)) % 5);
            int col2 = (key.indexOf(pair.charAt(1)) % 5);
            
            if (col1 == col2) {
            	c1 = key.charAt((row1 + 4) % 5 * 5 + col1);
            	c2 = key.charAt((row2 + 4) % 5 * 5 + col2);
            } else if (row1 == row2) {
            	c1 = key.charAt(row1 * 5 +(col1 +4) % 5);
            	c2 = key.charAt(row2 * 5 +(col2 +4) % 5);
            } else {
            	c1 = key.charAt(row1 * 5 + col2);
            	c2 = key.charAt(row2 * 5 + col1);
            }
            sb.append(Character.toString(c1) + Character.toString(c2));
		}
		return sb.toString();
		
	}
	
	public String[] diagraph( String s) {
		
		
		String d[] = new String[s.length()/2];
		
		int i = 0;
		for (int j = 0; j < s.length()- 1; j = j + 2) {
			 d[i] = s.substring(j, j + 2);
	         i++;
		}
		return d;
		
	}
	

}
