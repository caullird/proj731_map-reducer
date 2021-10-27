package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReduceFile {
	
	private File file;
	private String content;
	
	
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
	
	public ReduceFile(String link) {
		this.setFile(new File(link));
		this.setContent(this.getContentFile());
	}
	
	public String getContentFile() {
		
		/* getContentFile() function
		 * 
		 * Allows you to retrieve the contents of a file 
		 * 
		 * @Override : getContentFile() in FileInterface
		 * 
		 */

		String result = "";
		Scanner myReader;
		try {
			myReader = new Scanner(this.file);
			while(myReader.hasNextLine()) {
				result += myReader.nextLine();
			}
			myReader.close();
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/* Getters & Setters
	 * 
	 * 
	 * Function allowing the modification and recovery of the elements of the object
	 * 
     * Getters 
     * ----------
     *	- getFile() : is used to retrieve the "file" element 
	 *  - getName() : is used to retrieve the fileName element
	 * 	- getContent() : is used to retried the file content element
	 *  
	 * Setters 
	 * ----------
	 *  - setFile() : is used to modify the file element
	 *  - setContent() : is used to modify the content element
	 * 
	 */
	
	public File getFile() { return file; }

	public void setFile(File file) { this.file = file; }
	
	public String getName() { return this.file.getName(); }
	
	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }
	

}
