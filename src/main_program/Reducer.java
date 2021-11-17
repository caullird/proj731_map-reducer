package main_program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Reducer {
	
	private ArrayList<HashMap<String, Integer>> itemsList;
	
	private int nbThread;
	
	private int nbReceived;
	
	private boolean alreadyRestart;
	
	public Reducer(int nbThread) {
		super();
		this.itemsList = new ArrayList<HashMap<String, Integer>>();
		this.nbThread = nbThread;
		this.nbReceived = 0;
		this.alreadyRestart = false;
	}
	
	public void generateTree() throws InterruptedException {
		
		while(this.itemsList.size() > 1 && !this.alreadyRestart) {
			HashMap<String, Integer> FirstElement = this.getAndDeleteFirstElement(this.itemsList.get(0));
			HashMap<String, Integer> SecondElement = this.getAndDeleteFirstElement(this.itemsList.get(0));

			new Thread(new ThreadReduceManagement(FirstElement, SecondElement, this)).start();
			
			synchronized(this) { wait(); }
		}

		this.displayResult(this.itemsList.get(0));
	}
	
	public void displayResult(HashMap<String, Integer> unSortedMap) {
		 
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		 
		unSortedMap.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
		 
		System.out.println("Result   : " + reverseSortedMap);
	}
	
	
	
	public HashMap<String, Integer> getAndDeleteFirstElement(HashMap<String, Integer> hashMap) {
		if(this.itemsList.remove(hashMap)) { return hashMap; }
		return null;
	}

	public void receiveProcessing(HashMap<String, Integer> count) throws InterruptedException {
		
		this.itemsList.add(count);
		this.nbReceived++;
		
		if((this.nbReceived == this.nbThread) && (this.itemsList.size() == this.nbThread)) {
			this.generateTree(); return;
		}else if((this.nbReceived > this.itemsList.size()) && !this.alreadyRestart) {
			this.restart(); return;
		}
	}
	
	public Analyze restart() {
		this.alreadyRestart = true;
		return new Analyze();
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

	public void addReduceElement(HashMap<String, Integer> count) {
		this.itemsList.add(count);
		
		synchronized(this) {
			notify();
		}
	}

	
}
