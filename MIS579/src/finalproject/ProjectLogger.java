package finalproject;

public class ProjectLogger
{
	//Singleton static instance
	private static ProjectLogger instance = null;
	
	//Change this to change the logging level for the project
	private static final LogLevel CURRENT_LEVEL = LogLevel.TRACE;
	
	//Logging Level Enum
	public enum LogLevel{
		TRACE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);
		
		int level;
		
		private LogLevel(int level){
			this.level = level;
		}
		
		public int getLevel(){
			return level;
		}	
	}
	
	private LogLevel logLevel;
	//private LogFile logfile;

	protected ProjectLogger(){
		this.logLevel = CURRENT_LEVEL;
	}
	
	public static ProjectLogger getInstance(){
		if (instance == null) {
			instance = new ProjectLogger();
		}
		return instance;
	}
	
	public void setLevel(LogLevel level){
		this.logLevel = level;
	}
	
	private void levelTest(LogLevel level, String strLogLine, String strLevel)
	{
		StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
		StackTraceElement stackTraceElement = stackTraces[3];
		String lineNumber = Integer.toString(stackTraceElement.getLineNumber());
		String strClass = stackTraceElement.getClassName();
		if (logLevel.getLevel() <= level.getLevel())
		{
			System.out.println("[" + strLevel + "] - " + strLogLine + " - [" + strClass + " : " + lineNumber + "]");
		}	
	}
	
	public void fatal(Object strLogLine)
	{
		levelTest(LogLevel.FATAL, strLogLine.toString(), "FATAL");
	}
	public void error(Object strLogLine)
	{
		levelTest(LogLevel.ERROR, strLogLine.toString(), "ERROR");
	}
	public void warn(Object strLogLine)
	{
		levelTest(LogLevel.WARN, strLogLine.toString(), "WARN");
	}
	public void info(Object strLogLine)
	{
		levelTest(LogLevel.INFO, strLogLine.toString(), "INFO");
	}
	public void debug(Object strLogLine)
	{
		levelTest(LogLevel.DEBUG, strLogLine.toString(), "DEBUG");
	}
	public void trace(Object strLogLine)
	{
		levelTest(LogLevel.TRACE, strLogLine.toString(), "TRACE");
	}
	
	

}
