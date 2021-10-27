package main_program;

import java.util.HashMap;
import java.util.List;

public class ThreadManagement implements Runnable {

	private List<String> map;
	
	public ThreadManagement(List<String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		
		HashMap<String, Integer> count = new HashMap<>();
		
		for(String word : this.map) {
			if(count.containsKey(word)) {
				count.put(word, count.get(word)+1);
			}else {
				count.put(word,1);
			}
		}
		
		System.out.println(count);
		
	} 
	
}
