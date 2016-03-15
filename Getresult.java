import java.io.*;
import java.util.*;
import java.lang.*;
public class Getresult {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l = "";
		String s = "";
        Scanner scanner = new Scanner(new File(args[0]));

		//System.out.println("Start");
		while(scanner.hasNextLine()){
			s = scanner.nextLine();
			l=s;
		}
		System.out.println(l);
		
	}
}	
