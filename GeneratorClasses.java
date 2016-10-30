package pl.edu.agh.kis;
import java.io.*;
import java.util.*;

public class GeneratorClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Generator klas");
		
		ReadFile attempt = new ReadFile();
		attempt.readDataFromFile("klasy.txt");
		
		ReadFile example = new ReadFile();
		example.readDataFromFile("example.txt");
		
		example.changeToRight(attempt);
		
		System.out.println("Tekst zapisany do pliku");
	}

}
