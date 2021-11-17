package main_program;

import java.util.HashMap;
import java.util.List;

public class ThreadMapManagement implements Runnable {

	private List<String> map;
	private Reducer reducer;
	private int nbThread;
	
	public ThreadMapManagement(List<String> map, Reducer reducer, int nbThread) {
		this.map = map;
		this.reducer = reducer;
		this.nbThread = nbThread;
	}

	@Override
	public void run() {
		System.out.println("Un thread to map");
		HashMap<String, Integer> count = new HashMap<>();
		
		for(String word : this.map) {
			if(count.containsKey(word)) {
				count.put(word, count.get(word)+1);
			}else {
				count.put(word,1);
			}
		}
		
		try {
			this.reducer.receiveProcessing(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public Reducer getReducer() {
		return reducer;
	}

	public void setReducer(Reducer reducer) {
		this.reducer = reducer;
	}

	public int getNbThread() {
		return nbThread;
	}

	public void setNbThread(int nbThread) {
		this.nbThread = nbThread;
	} 
	
}
