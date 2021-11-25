package config;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class ReduceFile {
	
	private File file;
	
	private String link;
	
	private String content;
	
	private String result;
	
	private int nbThreadMax;
	
	private String path;
	
	/* Constructor of the File Class
	 * 
	 * Create File Object 
	 * 
	 * Override constructor: Possibility to make an object without any
	 * element (allows the creation of a file) or directly with a 
	 * file as a parameter.
	 * 
	 */
	
	public ReduceFile() {}
	
	public ReduceFile(String link, int nbThreadMax) {
		this.setFile(new File(link));
		this.link = link;
		this.setContent(this.getContentFile());
		this.nbThreadMax = nbThreadMax;
		this.setPath();
	}
	
	public String getContentFile() {
		
		/* getContentFile() function
		 * 
		 * Allows you to retrieve the contents of a file 
		 * 
		 * 
		 */

		byte[] content = null;
		try {
			content = Files.readAllBytes(Paths.get("src/data/" + this.link));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.result = new String(content);
		
		return new String(content);
		
	}

	
	public int getNbThread() {
		
		/* getNbThread() function
		 * 
		 * Allows you to retrieve the number of thread
		 * 
		 * 
		 */
		
		int NbThread = (int) Math.ceil(Math.log(this.getNbWord()));
		
		if(NbThread <= 0) { return 1; }
		
		if(NbThread >= this.getNbThreadMax() ) { return this.getNbThreadMax(); }
		
		return NbThread;
	}
	
	
	public int getNbWord() {
		
		/* getNbWord() function
		 * 
		 * Allows you to retrieve the number of word
		 * 
		 * 
		 */
		
		int NbWords =  new StringTokenizer(this.result," ").countTokens();  
		
		if(NbWords <= 0) {
			System.out.println("Pas de mots dans le document");
		}else {
	        	return NbWords; 
		}
		
		return 0;
		 
	}
	
	public void writeResult(String result) {
		
	         /* writeResult() function
		 * 
		 * Allows you to write result in a file
		 * 
		 */
		
		this.setPath();
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.path + "\\src\\data\\result.txt"), "utf-8"))) { 
			writer.write(result);
			this.openResult();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public void openResult() {
		
		/* openResult() function
		 * 
		 * Allows you to open the file with the result
		 * 
		 */
		
		File file = new File(this.path + "\\src\\data\\result.txt"); 
		
		Desktop desktop = Desktop.getDesktop();  
		if(file.exists()) {        
			try {
				desktop.open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}             
		}  
	}
	
	/* Getters & Setters
	 * 
	 * 
	 * Function allowing the modification and recovery of the elements of the object
	 * 
    	 * Getters 
    	 * ----------
     	 *  - getFile() : is used to retrieve the "file" element 
	 *  - getName() : is used to retrieve the fileName element
	 *  - getContent() : is used to retried the file content element
	 *  - getNbThreadMax() : is used to retried the default value
	 *  - getPath() : is used to retried the path of the project
	 *  
	 * Setters 
	 * ----------
	 *  - setFile() : is used to modify the "file" element 
	 *  - setName() : is used to modify the fileName element
	 *  - setContent() : is used to modify the file content element
	 *  - setNbThreadMax() : is used to modify the default value
	 *  - setPath() : is used to modify the path of the project
	 * 
	 */
	
	public File getFile() { return file; }

	public void setFile(File file) { this.file = file; }
	
	public String getName() { return this.file.getName(); }
	
	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	public int getNbThreadMax() { return nbThreadMax; }

	public void setNbThreadMax(int nbThreadMax) { this.nbThreadMax = nbThreadMax; }

	public String getPath() { return path; }

	public void setPath() {

		try {
			this.path = new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
