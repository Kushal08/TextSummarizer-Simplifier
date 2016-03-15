//package wordclass
import java.io.*;
import java.util.*;
import java.lang.*;

public class WordClass {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws IOException, NullPointerException{
		// TODO Auto-generated method stub
		//System.out.println(readfile());
		String final1=" ",temp1=" ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			temp1=br.readLine();
			if(temp1==null){
				break;
			}else{
			final1 = final1+temp1;
			//System.out.println(final1);
			}
		}
		//System.out.println(final1);
		//final1 = in.nextLine();
	
		Simplifier(final1);
		
		
		//return builder.toString();
		
		//System.out.println(builder.toString());
		String term = new String();
		// wm word -over -- gives all type of word
		
		//System.out.println("Enter term you want to check");
		//term = in.next();
		//Systeem.out.println(term);
		//System.out.println(isadj(term));
	    String all_type = new String("/usr/local/WordNet-3.0/bin/wn " +term + " -over");
	    String syn = new String("/usr/local/WordNet-3.0/bin/wn " +term + " -syns");
	    Runtime runtime = Runtime.getRuntime();
	    int type =-1;
	    
	    try{
	    	//System.out.println("1");
	    	//System.out.println("4");
	        Process p = runtime.exec(all_type);
	        //p.wait(100);
	        //System.out.println("2");
	        BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        //System.out.println("inside while loop");
	        String wordline;
	        String verb = "The verb";
			String adj = "The adj";
			String noun = "The noun";
	          
	        while ((wordline = output.readLine()) != null) {
			  if ( wordline.contains(verb) ) {
	        	  //System.out.println("YES VERB\n");
	        	   type = 0;	             
			  }
			  else if(wordline.contains(noun) ){
	        	  //System.out.println("YES noun\n");
	        	  type = 1;
	          }
			  else if(wordline.contains(adj) ){
	        	  //System.out.println("YES adj\n");
	        	  type=2;
	          }
	          
	        }
	      } 
	      catch (Exception e) {
	    	  //System.out.println("Error in getSynonym NOT FOUND");
	      }

	    switch (type) {
  	  	
  	  	case 0:
			syn = syn+"v";
			getsynonym(syn);
			break;
		case 1 :
			syn = syn+"n";
			getsynonym(syn);
			break;
		case 2:
			syn = syn+"a";
			getsynonym(syn);
			break;
		default:
			//System.out.println("Not in wordnet");
			break;
		}
	    
	  
	}
	
	
	public static boolean isverb(String term){
		boolean verb = false;
		// wm word -over -- gives all type of word
	    String all_type = new String("/usr/local/WordNet-3.0/bin/wn " +term + " -over");
	    Runtime runtime = Runtime.getRuntime();
	    
	    try{
	        Process p = runtime.exec(all_type);
	        BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        //System.out.println("inside while loop");
	        String wordline;
	        String for_verb = "The verb";
			  
	        while ((wordline = output.readLine()) != null) {
			  if ( wordline.contains(for_verb) ) {
	        	  verb =  true;	             
			  }
	        }
		} catch(Exception e){
	    	  //System.out.println("Error in isverb NOT FOUND");
		}
	    return verb;
	}
	
	public static boolean isadj(String term){
		boolean adj = false;
		// wm word -over -- gives all type of word
	    String all_type = new String("/usr/local/WordNet-3.0/bin/wn " +term + " -over");
	    Runtime runtime = Runtime.getRuntime();
	    
	    try{
	        Process p = runtime.exec(all_type);
	        BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        //System.out.println("inside while loop");
	        String wordline;
	        String for_adj = "The adj";
			  
	        while ((wordline = output.readLine()) != null) {
			  if ( wordline.contains(for_adj) ) {
	        	  adj =  true;	             
			  }
	        }
		} catch(Exception e){
	    	  //System.out.println("Error in isverb NOT FOUND");
		}
	    return adj;
	}
	
	public static ArrayList<String> getsynonym(String syn_command){
		 Process p2;
//		 System.out.println(syn_command);
		 ArrayList<String> synonymList = new ArrayList<>();
			try {
				Runtime runtime1 = Runtime.getRuntime();
				p2 = runtime1.exec(syn_command);
		  	  	BufferedReader output_synv = new BufferedReader(new InputStreamReader(p2.getInputStream())); 
		  	  	String synonyms;
		  	  	String[] mylist = null;
		  	  	while ((synonyms = output_synv.readLine()) != null) {
		          
		  	  		if ( synonyms.contains("Sense") ) {
		             synonyms = output_synv.readLine();
		             //System.out.println(synonyms);
		             mylist = synonyms.split(", ");
		             
		             for(String word : mylist) {
		            	 if(!synonymList.contains(word)){
		            		 synonymList.add(word); 
		            	 }
		            }
		             
		          }
		        }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("\nnumber of synonyms: ");// + synonymList.length);
            //for (int z = 0; z < synonymList.size(); z++) {
            //   System.out.println(synonymList.get(z));
            //}
	  	  	return synonymList;
	}
	
	public static TreeMap<String,Integer> readIndexFile() throws IOException{
		FileInputStream fis = new FileInputStream("TreeMap");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			TreeMap<String,Integer > list1 = new TreeMap<String,Integer >();

			try {
				list1=(TreeMap<String,Integer>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			ois.close();
			
			//System.out.println("The leght is :" + list1.size());



		return list1;
		}

	public static String[] Simplifier(String string) throws IOException, NullPointerException{
		
		String original = string;
		ArrayList<String> synonym;
		TreeMap<String, Integer>  dictionary= readIndexFile();
	    String[] words = string.split(" ");
	    for(int i=0;i<=words.length-1;i++){
	    	//System.out.println(words[i]);
	    	int val=0;
	    	if(dictionary.containsKey(words[i]) && ((dictionary.get(words[i]))<500)){
	    		//System.out.println(dictionary.get(words[i]));
	    		if( isverb(words[i])){
	    			String syn_command = new String("/usr/local/WordNet-3.0/bin/wn " +words[i] + " -synsv");
	    			synonym = getsynonym(syn_command);
	    			String toreplace = words[i];
	    			
	    			for(String x : synonym){
	    				if(dictionary.containsKey(x)){
	    					if(dictionary.get(toreplace) <= dictionary.get(x)  ){
		    					toreplace = x;
		    	    			//System.out.println("THIS IS TO REPLACE THE WORD :" +toreplace + "  Freq :"+dictionary.get(toreplace));

		    				}	
	    				}	
	    			}
	    			words[i]=toreplace;
	    			
	    		} else if(isadj(words[i])){
	    			String syn_command = new String("/usr/local/WordNet-3.0/bin/wn " 
	    								+words[i] + " -synsa");
	    			synonym = getsynonym(syn_command);
	    			String toreplace = words[i];
	    			
	    			for(String x : synonym){
	    				if(dictionary.containsKey(x)){
	    					if(dictionary.get(toreplace) <= dictionary.get(x)  ){
		    					toreplace = x;
		    	    			//System.out.println("THIS IS TO REPLACE THE WORD :"
		    	    				//	+toreplace + "  Freq :"+dictionary.get(toreplace));
		    				}	
	    				}	
	    			}
	    			words[i]=toreplace;
	    		}
                    
                }  else{
                	//System.out.println("Word not in tree map");
                }
	    	}
	    StringBuilder builder = new StringBuilder();
		for(String s : words) {
			builder.append(" "+s);
		}		
		String sd=builder.toString();
	    System.out.println(sd);	
	    //for(String temp : words){
	    	//System.out.print(temp+" ");
	    	
	    //}
	    return words;
	    
	}

	public static String readfile(){
		String fileasstring=null;
		//System.out.println("Enter filepath");
		String filepath ;
		filepath = "/home/gaurav/workspace_eclipse/TextSimplifier/test1.txt";
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
		System.out.println(fileasstring);
		return fileasstring;
	}
	
	

}
