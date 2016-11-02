package pl.edu.agh.kis;
import java.io.*;
import java.util.*;

/**Klasa generuje szablon klasy pobierajac
 * jej nazwe z pliku
 * 
 * @version 1.1
 * @author Natalia Materek
 * @see ReadFile
 * @see WriteToFile
 * @see 
 */

public class GeneratorClasses {

	/**
	 * @param args 
	 * zaleznie od args program generuje plik z metoda main lub bez
	 */
	public static void main(String[] args) {
		
		System.out.println("Generator klas");
		
		/*ReadFile attempt = new ReadFile();
		attempt.readDataFromFile("klasy.txt");*/
		
		String nameFile;
		if ((args.length == 0) || (args[0].equals("main"))){
			nameFile = "example.txt";
		}
		else{
			nameFile = "exampleWithoutMain.txt";
		}
		ReadFile example = new ReadFile();
		example.readDataFromFile(nameFile);
		//example.changeToRight(attempt);
		
		System.out.println("Tekst zapisany do pliku");
		
		ReadFile attempt2 = new ReadFile();
		attempt2.readDataFromFile("klasyb.txt");
		
		attempt2.print();
		example.changeToRightWithPackages(attempt2);
	}

}
