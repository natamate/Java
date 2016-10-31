package pl.edu.agh.kis;
import java.io.*;
import java.util.*;

public class WriteToFile {
	private String pathToFile;
     
    public WriteToFile(String newPath){
    	pathToFile = newPath;
    }
     
    public void writeData(ArrayList<String> newTextLine) {
    	File file = new File(pathToFile);
		try(FileOutputStream fop = new FileOutputStream(pathToFile)){
			if (file.isDirectory() == true){
				System.out.println(file + " jest katalogiem");
			}
			if (!file.exists()){
				file.createNewFile();
			}
			PrintWriter showText = new PrintWriter(fop);
	    		
	    	for (String s: newTextLine){
	    		showText.println(s);
	    	}
	    	showText.close();
	    	fop.flush();
	    	fop.close();
	    		
		}catch(IOException e){
			e.printStackTrace();
		}
    }	
	
}
