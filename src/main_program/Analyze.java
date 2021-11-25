package main_program;

import java.util.List;
import config.ReduceFile;

public class Analyze {

	public Analyze(){
		
		int nbThreadMax = 7;
		
		String freqFile = "big.txt";
		
		ReduceFile stringBook = new ReduceFile(freqFile, nbThreadMax);
	
		int nbThread = stringBook.getNbThread();
		
		List<List<String>> maps = new MapGenerator(stringBook,nbThread).GenerateMaps();
		
		new ThreadGenerator(maps,nbThread).generateThread();

	}

}
