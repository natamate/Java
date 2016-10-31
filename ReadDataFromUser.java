package pl.edu.agh.kis;

import java.util.Scanner;
/** Klasa wczytuje dane od uzytkownika
 * 
 * @author Natalia Materek
 * @see Sum
 * @see Mul
 */
public class ReadDataFromUser {
	/**
	 * Wczytuje dane dla których obliczony bedzie iloczyn
	 * @return readData
	 *  - pobrana wartosc od uzytkownika
	 */
	int readData(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer");
		String myString = scanner.nextLine();
		int readData = 0;
		try{
			readData = Integer.parseInt(myString);
		}
		catch(NumberFormatException e){
			System.out.println("Niepoprawny format argumentu");
		}
		return readData;
	}
	
	/**
	 * Metoda czeka na dwie dane od uzytkownika 
	 * nastepnie oblicza z nich iloczyn
	 * @return result - tablica String z pobranymi danymi
	 */
	String[] checkData(){
		int counter = 0;
		int [] component = new int [2];
		while (counter < 2){
			component[counter] = readData();
			if (component[counter] != 0){
				counter++;
			}
		}
		String s1 = component[0] + "";
		String s2 = component[1] + "";
		String [] result = {s1, s2};
		return result;
	}

}
