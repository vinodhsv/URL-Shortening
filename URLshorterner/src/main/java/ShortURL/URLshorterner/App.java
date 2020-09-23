package ShortURL.URLshorterner;
import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class App 
{ 
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int    BASE     = ALPHABET.length();

	public static String encode(int num) {
		StringBuilder sb = new StringBuilder();
		while ( num > 0 ) {
        sb.append( ALPHABET.charAt( num % BASE ) );
        num /= BASE;
		}
		return sb.reverse().toString();   
	}

	public static int decode(String str) {
		int num = 0;
		for ( int i = 0; i < str.length(); i++ )
			num = num * BASE + ALPHABET.indexOf(str.charAt(i));
		return num;
	}

	public static void main (String[] args) throws IOException 
	{ 
		int n = 12345; 
		String shorturl = encode(n); 
		System.out.println("Short url : " + shorturl);
		int id = decode(shorturl);
		System.out.println("Unique ID for Short Url : " + id);
	} 
}


