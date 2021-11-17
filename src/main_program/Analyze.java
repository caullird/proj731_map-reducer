package main_program;

import java.util.List;

import config.Logger;
import config.ReduceFile;

public class Analyze {

	public Analyze(){
		
		String freqFile = "src/data/bible.txt";
		
		Logger logger = new Logger();
		
		ReduceFile stringBook = new ReduceFile(freqFile, logger);
		
		int nbThread = stringBook.getNbThread();
		
		List<List<String>> maps = new MapGenerator(stringBook,nbThread, logger).GenerateMaps();
		
		new ThreadGenerator(maps,nbThread).generateThread();

	}

}
