package main_program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import config.ReduceFile;

public class Reducer {
	
	private ArrayList<HashMap<String, Integer>> itemsList;
	
	private int nbThread;
	
	private int nbReceived;
	
		
	/* Constructor of Reducer
	 * 
	 * Create Reducer Object 
	 * 
	 */
	
	public Reducer(int nbThread) {
		super();
		this.itemsList = new ArrayList<HashMap<String, Integer>>();
		this.nbThread = nbThread;
		this.nbReceived = 0;
	}
	
	public void receiveProcessing(HashMap<String, Integer> count) throws InterruptedException {
		
		/* receiveProcessing() function
		 * 
		 * Allows the reception and the verification of the good reception
		 * 
		 */
		
		this.itemsList.add(count);
		this.nbReceived++;
		
		if((this.nbReceived == this.nbThread) && (this.itemsList.size() == this.nbThread)) {
			this.generateTree();
		}
	}
	
	public void generateTree() throws InterruptedException {
		
				
		/* generateTree() function
		 * 
		 * Allows to generate the tree for multithread map reduce
		 * 
		 */
		
		while(this.itemsList.size() > 1) {
			HashMap<String, Integer> FirstElement = this.getAndDeleteFirstElement(this.itemsList.get(0));
			HashMap<String, Integer> SecondElement = this.getAndDeleteFirstElement(this.itemsList.get(0));

			new Thread(new ThreadReduceManagement(FirstElement, SecondElement, this)).start();
			
			synchronized(this) { wait(); }
		}

		this.resultProcessing(this.itemsList.get(0));
	}
	
	public void resultProcessing(HashMap<String, Integer> unSortedMap) {
		
	   	/* resultProcessing() function
		 * 
		 * Allows you to sort the list and write it to the result file
		 * 
		 */
		 
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		 
		unSortedMap.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		    .forEachOrdered(element -> reverseSortedMap.put(element.getKey(), element.getValue()));
		
		new ReduceFile().writeResult(reverseSortedMap.toString());
	}
	
	public HashMap<String, Integer> getAndDeleteFirstElement(HashMap<String, Integer> hashMap) {
		
		/* getAndDeleteFirstElement() function
		 * 
		 * Allows you get the first element and delete him
		 * 
		 */
		
		if(this.itemsList.remove(hashMap)) { 
			return hashMap; 
		}
		return null;
	}
	
	public void addReduceElement(HashMap<String, Integer> count) {
				
		/* addReduceElement() function
		 * 
		 * Allows you to retrieve and add an item in the list of maps to be processed
		 * 
		 */
		
		this.itemsList.add(count);
		
		synchronized(this) { notify(); }
	}
	
	/* Getters & Setters
	 * 
	 * 
	 * Function allowing the modification and recovery of the elements of the object
	 * 
    	 * Getters 
    	 * ----------
     	 *  - readHashMaps() : is used to retrieve the Hash Map element
	 *  - getNbThread() : is used to retrieve the number of the thread declared before
	 *  - getNbReceived() : is used to retrieve the number of received element
	 *  
	 * Setters 
	 * ----------
	 *  - setNbThread() : is used to modify the number of thread element 
	 *  - setNbReceived() : is used to modify number of received element
	 * 
	 */

	public ArrayList<HashMap<String, Integer>> readHashMaps() { return this.itemsList; }
	
	public int getNbThread() { return nbThread; }

	public void setNbThread(int nbThread) { this.nbThread = nbThread; }
	
	public int getNbReceived() { return nbReceived; }

	public void setNbReceived(int nbReceived) { this.nbReceived = nbReceived; }
	
}
