import main_program.Analyze;

public class MapReduceMain {

	public static void main(String[] args){

		/*
		 *  Main function of the program
		 */
		
		// Allows the user to choose the file to be processed
		String freqFile = "big.txt";
		
		
		// Allows the user to choose the maximum number of threads
		int nbThreadMax = 7;
		
		new Analyze(freqFile, nbThreadMax);
	}
}
