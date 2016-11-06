package pl.edu.agh.kis;
import java.io.*;
import java.util.*;
/**Klasa zapisuje do pliku 
 * tworzy katalog dla pliku gdy nie istnieje
 * @version 1.1
 * @author Natalia Materek
 * @see ReadFile
 */
public class WriteToFile {
	private String pathToFile;
    private String nameDirectory;
    
    /**
     * @param newPath
     * - sciezka do pliku
     */
    public WriteToFile(String newPath){
    	pathToFile = newPath;
    }
    
    /**Metoda pozwala na modyfikacje skladowej klasy nameDirectory
     * 
     * @param newName
     * - nazwa dla katalogu
     */
    public void setName(String newName){
    	nameDirectory = newName;
    }
    
    /**Funkcja zapisuje do pliku kolejne Stringi z tablicy
     * 
     * @param newTextLine
     * - tablica Stringow do zapisania
     */
    public void writeData(ArrayList<String> newTextLine) {  	
    	File file2 = new File(nameDirectory);
    	if(!file2.exists()){
    		if (file2.mkdir()){
    			System.out.println("Utworzylem katalog");
    		}
    		else{
    			System.out.println("B³¹d w tworzeniu katalogu");
    		}
    	}
    	
		try(FileOutputStream fop = new FileOutputStream(pathToFile)){
			
			System.out.println(pathToFile);
	    	File file = new File(pathToFile);
	    	
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