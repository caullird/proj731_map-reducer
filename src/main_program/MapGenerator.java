package main_program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import config.ReduceFile;

public class MapGenerator {

	private String fullText;
	private int NbThread;
	
	
	public MapGenerator(ReduceFile stringBook, int NbThread) {
		this.setFullText(stringBook.getContentFile());
		this.setNbThread(NbThread);
	}

	public List<List<String>> GenerateMaps() {
		List<String> words = Arrays.asList(this.fullText.split(" "));
		List<List<String>> lists = new ArrayList<List<String>>();
		
		// TODO : modulo
		int modulo = words.size() % this.NbThread;
		
		
		int nbMotsThread = words.size() / this.NbThread;
		int nbMotsTreaty = 0;
		
		for(int i = 0; i < this.getNbThread(); i++) {
			lists.add(words.subList(nbMotsTreaty,nbMotsThread + nbMotsTreaty));
			nbMotsTreaty += nbMotsThread;
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
