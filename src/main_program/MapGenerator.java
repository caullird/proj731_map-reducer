package main_program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import config.Logger;
import config.ReduceFile;

public class MapGenerator {

	private String fullText;
	
	private int NbThread;
	
	private Logger logger;

	public MapGenerator(ReduceFile stringBook, int NbThread, Logger unLogger) {
		this.setFullText(stringBook.getContentFile());
		this.setNbThread(NbThread);
		this.logger = unLogger;
	}

	public List<List<String>> GenerateMaps() {
				
				
		List<String> words = Arrays.asList(this.fullText.split(" "));
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
	
	
	public String getFullText() {
		return fullText;
	}

	public void setFullText(String string) {
		this.fullText = string;
	}

	public int getNbThread() {
		return NbThread;
	}

	public void setNbThread(int nbThread) {
		NbThread = nbThread;
	}

}
