package pl.edu.agh.kis;
import java.io.*;
import java.util.*;

public class WriteToFile {
	private String pathToFile;
     
    public WriteToFile(String newPath){
    	pathToFile = newPath;
    }
     
    public void writeData(ArrayList<String> newTextLine) {
    	try{
    		//FileWriter write = new FileWriter(pathToFile);
    		FileOutputStream write = new FileOutputStream(pathToFile);
    		PrintWriter showText = new PrintWriter(write);
    		
    		for (String s: newTextLine){
    			showText.println(s);
    		}
    		showText.close();
    	}
    	catch(Exception e){
    		System.out.println("Error, cannot write a data");
    	}
    }
		
	
	
}
