package main_program;

import java.util.List;

public class ThreadGenerator {

	private List<List<String>> maps;
	
	private Reducer reducer;
	
	private int nbThread;
	
        /* Constructor of the ThreadGenerator Class
	 * 
	 * Create ThreadGenerator Object 
	 * 
	 */
	
	public ThreadGenerator(List<List<String>> maps, int nbThread) {
		this.setMaps(maps);
		this.reducer = new Reducer(nbThread);
		this.setNbThread(nbThread);
	}
	
	public ThreadGenerator generateThread(){
		
		/* generateThread() function
		 * 
		 * Allows the generation of threads according to the different information
		 * 
		 */
		
		
		for(List<String> map : this.getMaps()) {
			new Thread(new ThreadMapManagement(map, this.reducer, this.getNbThread())).start();
		}
		
		return null;
	}
	
		
	/* Getters & Setters
	 * 
	 * 
	 * Function allowing the modification and recovery of the elements of the object
	 * 
    	 * Getters 
    	 * ----------
     	 *  - getMaps() : is used to retrieve all the maps
	 *  - getNbThread() : is used to retrieve the number of threads
	 *  
	 * Setters 
	 * ----------
	 *  - setMaps() : is used to modify the maps
	 *  - setNbThread() : is used to modify the number if threads
	 * 
	 */

	public List<List<String>> getMaps() { return maps; }

	public void setMaps(List<List<String>> maps) { this.maps = maps; }

	public int getNbThread() { return nbThread; }

	public void setNbThread(int nbThread) { this.nbThread = nbThread; }
	
}
