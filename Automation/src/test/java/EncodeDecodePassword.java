
import java.util.Base64;

public class EncodeDecodePassword {

	public static void main(String[] args) {
		String str = "admin";
		// To get encoded value
	    Base64.getEncoder();
	    //Encoding code
	    byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes());
	    //new String is used  to get encoded bytes in string and append new string value with any msg
	    System.out.println("encoded string: "+new String(encodedBytes));
	    
	    //Decode
	    
	    byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
	    System.out.println("decoded string: "+new String(decodedBytes));
			
		}
}
