package main_program;

import java.util.List;
import config.ReduceFile;

public class Analyze {
	
	/* Constructor of the File Analyze
	 * 
	 * Manage all the programm
	 * 
	 */

	public Analyze(){
		
		
		// Allows the user to choose the maximum number of threads
		int nbThreadMax = 7;
		
		// Allows the user to choose the file to be processed
		String freqFile = "big.txt";
		
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
