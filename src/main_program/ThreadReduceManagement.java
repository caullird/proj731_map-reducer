package main_program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreadReduceManagement implements Runnable {

	private ArrayList<HashMap<String, Integer>> itemsList;
	
	private Reducer reducer;
	
	/* Constructor of the ThreadReduceManagement Class
	 * 
	 * Create ThreadReduceManagement Object 
	 * 
	 */
	
	public ThreadReduceManagement(HashMap<String, Integer> unFirstElement, HashMap<String, Integer> unSecondElement, Reducer unReducer) {
		this.itemsList = new ArrayList<HashMap<String, Integer>>();
		this.reducer = unReducer;
		this.addElements(unFirstElement, unSecondElement);
	}

	@Override
	public void run() {
		
		/* run() function
		 * 
		 * Allows to execute the program for each thread
		 */

		HashMap<String, Integer> count = new HashMap<>();
	
		for(HashMap<String, Integer> maps : this.itemsList) {
			
			for(Map.Entry mapentry : maps.entrySet()) {
		     
		           if(count.containsKey(mapentry.getKey())) {
						count.put((String) mapentry.getKey(), (int) count.get(mapentry.getKey()) +  (int) mapentry.getValue());
					}else {
						count.put((String) mapentry.getKey(), (int) mapentry.getValue());
					}
			}
		}	
		
		this.reducer.addReduceElement(count);
	}
	
	public void addElements(HashMap<String, Integer> unFirstElement, HashMap<String, Integer> unSecondElement) {
	
		/* addElements() function
		 * 
		 * Allows to add element in the list
		 */
		
		this.itemsList.add(unFirstElement);
		this.itemsList.add(unSecondElement);
	}

}
