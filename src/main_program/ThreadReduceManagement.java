package main_program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreadReduceManagement implements Runnable {

	private HashMap<String, Integer> firstElement;
	
	private HashMap<String, Integer> secondElement;
	
	private ArrayList<HashMap<String, Integer>> itemsList;
	
	private Reducer reducer;
	
	public ThreadReduceManagement(HashMap<String, Integer> unFirstElement, HashMap<String, Integer> unSecondElement, Reducer unReducer) {
		this.itemsList = new ArrayList<HashMap<String, Integer>>();
		this.reducer = unReducer;
		this.addElements(unFirstElement, unSecondElement);
	}

	@Override
	public void run() {

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
		this.itemsList.add(unFirstElement);
		this.itemsList.add(unSecondElement);
	}

}
