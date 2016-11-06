package pl.edu.agh.kis;
import java.io.*;
import java.util.*;
import java.lang.*;

/**Klasa odczytuje nazwy klas do wygenerowania
 * @version 1.1
 * @author Natalia Materek
 * @see WriteToFile
 */
public class ReadFile {
ArrayList<String> listLine = new ArrayList<String>();
	
	/** Dodaje linie do listy przechowujacej nazwy klasy/ dane do zapisania do pliku
	 * @param newLine
	 * - nazwa klasy/ dane do zapisu
	 */
	void addLine(String newLine) {
		listLine.add(newLine);
	}
	
	void print(){
		System.out.println("Tablica klas do wygenorowania: ");
		for (String s: listLine){
			System.out.println(s + ", ");
		}
	}

	/** Metoda wyodrebnia poszczegolne nazwy klas
	 * @param pathToFile
	 * - sciezka do pliku z nazwami klas
	 * @throws IOException
	 */
	
	void readDataFromFile(String pathToFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(pathToFile));
			String newLine = br.readLine();
			while (newLine != null) {
				addLine(newLine);
				newLine = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Cannot find this file");
		}
	}
	
	/**Metoda do podpunktu a)
	 * Zastepuje x w pliku na nazwe klasy dla ktorej generowany jest wzor
	 * 
	 * @param classes 
	 * - obiekt w ktorym zapisane sa nazwy klas
	 */
	void changeToRight(ReadFile classes){	
		for (int i = 0; i < classes.listLine.size(); i++){
			ReadFile tmp = new ReadFile();
			String name = "";
			for (String s: listLine){
				tmp.listLine.add(s.replace("x", classes.listLine.get(i)));
			}
			name = classes.listLine.get(i) + ".java";
			WriteToFile data = new WriteToFile(name);
			data.writeData(tmp.listLine);
			tmp.listLine.clear();
		}
	}
	
	/**Metoda zamienia . na / w stringu
	 * 
	 * @param index 
	 * - pozycja w tablicy Stringu do modyfikacji
	 * @return fields
	 * - wynik modyfikacji
	 */
	String[] getName(int index){
		String [] fields = listLine.get(index).split("[,\\.]");
		return fields;
	}
	
	/**Metoda do podpunktu b)
	 * Zastepuje x w pliku na nazwe klasy dla ktorej generowany jest wzor
	 * 
	 * @param classes
	 * - obiekt ktory zawiera nazwy paczek
	 */
	void changeToRightWithPackages(ReadFile classes){	
		for (int i = 0; i < classes.listLine.size() - 1 ; i++){
			ReadFile tmp = new ReadFile();		 
			String name = "";
			String path="";
			String [] helpTable = classes.getName(i);
			for (String s: listLine){
				tmp.listLine.add(s.replace("x", helpTable[helpTable.length -1]));
			}
			name = helpTable[helpTable.length -1] + ".java";
			for (int j = 0; j < helpTable.length - 1; j++){
				path = path + helpTable[j] + "/";
			}		
			System.out.println("path: " + path + " Name: " + name);
			WriteToFile data = new WriteToFile(path + name);
			//daj sciezke katalogu zeby utworzyl
			data.setName(path);
			data.writeData(tmp.listLine);
			tmp.listLine.clear();
		}
	}

}