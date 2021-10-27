package main_program;

import java.util.List;

public class ThreadGenerator {

	private List<List<String>> maps;
	
	public ThreadGenerator(List<List<String>> maps) {
		this.setMaps(maps);
	}
	
	public ThreadGenerator generateThread() {
		for(List<String> map : this.getMaps()) {
			new Thread(new ThreadManagement(map)).start();
		}
		return null;
	}

	public List<List<String>> getMaps() {
		return maps;
	}

	public void setMaps(List<List<String>> maps) {
		this.maps = maps;
	}

	
}
