package main_program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reducer {
	
	private ArrayList<HashMap<String, Integer>> itemsList;
	
	private int nbThread;
	
	private int nbArrived;
	
	public Reducer(int nbThread) {
		super();
		this.itemsList = new ArrayList<HashMap<String, Integer>>();
		this.nbThread = nbThread;
		this.nbArrived = 0;
	}

	public void receiveProcessing(HashMap<String, Integer> count) {
		this.itemsList.add(count);
		System.out.println("Un nouveau thread est arrivée");
		this.nbArrived++;
		if(this.nbArrived == this.nbThread) {
			this.reducer();
		}
	}
	
	public void reducer() {
		
		HashMap<String, Integer> count = new HashMap<>();
		
		for(HashMap<String, Integer> map : this.itemsList) {
			
			//for(String word : map) {
				//if(count.containsKey(word)) {
					//count.put(word, count.get(word)+1);
				//}else {
					//count.put(word,1);
				//}
			//}
			System.out.println(map.keySet());
			System.out.println(map.values());
		}
	}
	
	public ArrayList<HashMap<String, Integer>> readHashMaps() {
		return this.itemsList;
	}

	public int getNbThread() {
		return nbThread;
	}

	public void setNbThread(int nbThread) {
		this.nbThread = nbThread;
	}

	public int getNbArrived() {
		return nbArrived;
	}

	public void setNbArrived(int nbArrived) {
		this.nbArrived = nbArrived;
	}

	
}
