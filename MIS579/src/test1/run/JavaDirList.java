package test1.run;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class JavaDirList {
	private static ResourceBundle bundle = ResourceBundle.getBundle("testinfo");
	public static void main(String[] args) {
		long strtTime = System.currentTimeMillis();
		System.out.println("Starting :");
		
		listFiles("C:/");
		System.out.println("Complete.");
		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed Time : " + (endTime - strtTime) / 1000);
	}
	
	
	public static void listFiles(String sourceDir) {
		listFilesRecursive(sourceDir, 1);
	}
	
	public static void listFilesRecursive(String sourceDir, int level) {
		System.out.println(getPad(level) + "******DIR******");
		File dir = new File(sourceDir);
		File[] childFiles = dir.listFiles();
		if (childFiles == null) {
		    // Either dir does not exist or is not a directory
			System.out.println("No Files Found");
		} 
		else {
		    for (int i=0; i<childFiles.length; i++) {
		        // Get filename of file or directory
		    	try {
		    		System.out.print(getPad(level) + childFiles[i].getName());
		    		if (childFiles[i].isDirectory()) {
		    			System.out.println("\t [DIR]");
		    			listFilesRecursive(childFiles[i].getPath(), level + 1);
		    		}
		    		else {
		    			System.out.println("\t [FILE]");
		    		}
		    	}
		    	catch (Exception e) {
					e.printStackTrace();
				}
		    }    
	    }
	}
	private static String getPad(int level) {
		String strReturn = "";
		for (int i = 0; i < level; i++) {
			strReturn += "\t";
		}
		return strReturn;
	}
}

