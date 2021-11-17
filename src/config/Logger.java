package config;

public class Logger {
	private static String info;
	
	private static String warning;
	
	private static String error;
	
	public void addInfo(String unInfo) {
		System.out.println("[INFO] " + unInfo);
		Logger.info += " " + unInfo;
	}
	
	public void addWarning(String unWarning) {
		System.out.println("[WARNING] " + unWarning);
		Logger.warning += " " + unWarning;
	}
	
	public void addError(String unError) {
		System.out.println("[ERROR]" + unError);
		Logger.error += " " + unError;
	}	
	

}
