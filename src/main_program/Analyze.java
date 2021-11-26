package main_program;

import java.util.List;
import config.ReduceFile;

public class Analyze {
	
	/* Constructor of the File Analyze
	 * 
	 * Manage all the programm
	 * 
	 */

	public Analyze(String freqFile, int nbThreadMax){
		
		// Allows the reading of the file 
		ReduceFile stringBook = new ReduceFile(freqFile, nbThreadMax);
	
		// Allows to calculate the optimal number of threads
		int nbThread = stringBook.getNbThread();
		
		// Allows to generate maps for multi thread management
		List<List<String>> maps = new MapGenerator(stringBook,nbThread).GenerateMaps();
		
		// Creation of treads for the reduce
		new ThreadGenerator(maps,nbThread).generateThread();

	}

}
