package finalproject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectLogger extends Logger{
	
	public static final Logger logger = Logger.getLogger("runlog");
	
	protected ProjectLogger(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}
	
	static {
		logger.setLevel(Level.ALL);
	}
	
	
	
	public static void INFO (String logString){
		logger.log(Level.INFO, logString);
	}
	public static void DEBUG (String logString){
		logger.log(Level.FINER, logString);
	}
	public static void TRACE (String logString){
		logger.log(Level.FINEST, logString);
	}
	public static void ERROR (String logString){
		logger.log(Level.SEVERE, logString);
	}
}

