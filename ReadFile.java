package pl.edu.agh.kis;
import java.io.*;
import java.util.*;

public class ReadFile {
ArrayList<String> listLine = new ArrayList<String>();

	void addLine(String newLine) {
		listLine.add(newLine);
	}
	
	void print(){
		System.out.println("Tablica klas do wygenorowania: ");
		for (String s: listLine){
			System.out.println(s + ", ");
		}
	}

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

}
