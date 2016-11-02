package pl.edu.agh.kis;
import java.io.*;
import java.util.*;
/**Klasa zapisuje do pliku 
 * @version 1.1
 * @author Natalia Materek
 * @see ReadFile
 */
public class WriteToFile {
	private String pathToFile;
     
    public WriteToFile(String newPath){
    	pathToFile = newPath;
    }
    
    public void writeData(ArrayList<String> newTextLine) {
    	
    		System.out.println(pathToFile);
    		String path = "mojafirma";
    		File file2 = new File(path);
    		System.out.println("111");
    		if (file2.mkdirs()){
				System.out.println("Utworzylem katalog");
			}
			else{
				System.out.println("nie ma");
			}
    		
    		
    		/*File file = new File(pathToFile);
    		
    		
    		if (!file.exists()){
    			
				file.createNewFile();			
			}*/
    	
		try(FileOutputStream fop = new FileOutputStream(pathToFile)){
			
		
			//file.mkdir();
			/*System.out.println(pathToFile);
	    	File file = new File(pathToFile);
	    	
	    	file.mkdir();
	    	
			if (!file.exists()){
				file.createNewFile();			
			}*/

			PrintWriter showText = new PrintWriter(fop);
	    		
	    	for (String s: newTextLine){
	    		showText.println(s);
	    	}
	    	showText.close();
	    	fop.flush();
	    	fop.close();
	    		
		}catch(IOException e){
			//e.printStackTrace();
		}

    }	
	
}
