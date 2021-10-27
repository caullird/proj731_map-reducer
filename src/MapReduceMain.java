import main_program.Analyze;

public class MapReduceMain {

	public static void main(String[] args) {

		/* Main function of the program
		 * 
		 * Add the frequency file and the binary translation, in the data files -> "data/initial_data"
		 * 
		 */
		
		String freqFile = "src/data/bible.txt";
		
		int nbThread = 3;
		
		
		new Analyze(freqFile, nbThread);
	}

}
