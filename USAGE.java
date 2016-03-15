import semantics.Compare;
import java.io.*;
import java.util.*;
import java.lang.*;
public class USAGE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
String a = readfile(args[0]);
String b = readfile(args[1]);
//System.out.println(a+"\n"+b);
Compare c = new Compare(a,b);
//System.out.println("Similarity between the sentences\n-"+a+"\n-"+b+"\n is: " + c.getResult());
System.out.println(+c.getResult());
}

	public static String readfile(String filepath){
		String fileasstring=null;
		//System.out.println("Enter filepath");
		//String filepath ;
		//filepath = "/home/gaurav/workspace_eclipse/TextSimplifier/test1.txt";
		//filepath = in.nextLine();
		try{
            Scanner scanner = new Scanner(new File(filepath));
            StringBuilder sb = new StringBuilder();

            while(scanner.hasNextLine()){
          	//System.out.println("in Inputdoc.loadfile");
          	String x;
          	sb.append(x = scanner.nextLine());
          	//System.out.println(x);
              if(scanner.hasNextLine()){
                sb.append("\n");
              }
            }

            fileasstring = sb.toString();
        }
        catch(IOException e){ 
      	  //System.out.println("filepath : "+filepath);
          //System.out.println(" InputDocument File IOException");
        }
		//System.out.println(fileasstring);
		return fileasstring;
	}
	

}
