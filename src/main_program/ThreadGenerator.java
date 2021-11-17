package main_program;

import java.util.List;

public class ThreadGenerator {

	private List<List<String>> maps;
	
	private Reducer reducer;
	
	private int nbThread;
	
	public ThreadGenerator(List<List<String>> maps, int nbThread) {
		this.setMaps(maps);
		this.reducer = new Reducer(nbThread);
		this.setNbThread(nbThread);
	}
	
	public ThreadGenerator generateThread(){
		for(List<String> map : this.getMaps()) {
			new Thread(new ThreadMapManagement(map, this.reducer, this.getNbThread())).start();
		}
		
		return null;
	}

	public List<List<String>> getMaps() {
		return maps;
	}

	public void setMaps(List<List<String>> maps) {
		this.maps = maps;
	}

	public int getNbThread() {
		return nbThread;
	}

	public void setNbThread(int nbThread) {
		this.nbThread = nbThread;
	}

	
}
