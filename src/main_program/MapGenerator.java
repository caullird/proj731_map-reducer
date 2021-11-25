package main_program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import config.ReduceFile;


public class MapGenerator {

	private String fullText;
	
	private int NbThread;
	
	/* Constructor of the MapGenerator
	 * 
	 * Create MapGenerator Object 
	 * 
	 */
	

	public MapGenerator(ReduceFile stringBook, int NbThread) {
		this.setFullText(stringBook.getContentFile());
		this.setNbThread(NbThread);
	}

	public List<List<String>> GenerateMaps() {
		
		/* GenerateMaps() function
		 * 
		 * Allows you to generate the maps
		 * 
		 */		
				
		List<String> words = Arrays.asList(this.fullText.split("\\P{L}+"));
		List<List<String>> lists = new ArrayList<List<String>>();
		
		
		int nbMotsThread = words.size() / this.NbThread;
		int nbMotsTreaty = 0;
		
		for(int i = 0; i < this.getNbThread(); i++) {

			lists.add(words.subList(nbMotsTreaty,nbMotsThread + nbMotsTreaty));
			nbMotsTreaty += nbMotsThread;
			
			if(words.size() - (nbMotsTreaty) < nbMotsThread) {

				List<String> lastIteration = lists.get(lists.size() - 1); 
				int lastIterationNb = lists.size() - 1; 
				
				List<String> missWords = words.subList(nbMotsTreaty,nbMotsTreaty + words.size() - nbMotsTreaty);
				
				List<String> newList = new ArrayList<String>();
				newList.addAll(lastIteration);
				newList.addAll(missWords);
				
				lists.set(lastIterationNb, newList);
			}
		}
		return lists;
	}
	
	/* Getters & Setters
	 * 
	 * 
	 * Function allowing the modification and recovery of the elements of the object
	 * 
    	 * Getters 
    	 * ----------
     	 *  - getFullText() : is used to retrieve the full text element 
	 *  - getNbThread() : is used to retrieve the number of threads
	 *  
	 * Setters 
	 * ----------
	 *  - setFullText() : is used to modify the full text element 
	 *  - setNbThread() : is used to modify the number of threads
	 * 
	 */
	
	
	public String getFullText() { return fullText; }

	public void setFullText(String string) { this.fullText = string; }

	public int getNbThread() { return NbThread; }

	public void setNbThread(int nbThread) { NbThread = nbThread;
					      }

}
