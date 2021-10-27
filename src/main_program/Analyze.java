package main_program;

import java.util.List;

import config.ReduceFile;

public class Analyze {

	public Analyze(String freqFile, int nbThread) {
		
		ReduceFile stringBook = new ReduceFile(freqFile);
		
		List<List<String>> maps = new MapGenerator(stringBook,nbThread).GenerateMaps();
		
		ThreadGenerator threads = new ThreadGenerator(maps).generateThread();
	
		
		
	}

}
