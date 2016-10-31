import java.math.*;
import java.util.Scanner;
/** Klasa obliczajaca sum� liczb typu BigInteger
 * @see FactorialBufer
 * @author Natalia Materek
 * @version 1.1
 */
public class Sum {
	/**Oblicza sume
	 * 
	 * @param element1 skladnik 1.
	 * @param element2 skladnik 2.
	 * @throws NumberFormatException
	 * @return result
	 *  - wynik dodawania lub null w przypadku b�edu konwersji
	 */
	BigInteger calculateSum(String element1, String element2){
		try{
			BigInteger element1i = new BigInteger(element1);
			BigInteger element2i = new BigInteger(element2);

			return element1i.add(element2i);
		}
		catch(NumberFormatException e){
			System.out.println("Niepoprawna liczba");
			return null;
		}
	}
	
	/**
	 * Wczytuje dan� dla kt�rych obliczona b�dzie suma
	 * @return a
	 *  - pobrana warto�� od u�ytkownika
	 */
	int readData(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer");
		String myString = scanner.nextLine();
		int a = 0;
		try{
			a = Integer.parseInt(myString);
		}
		catch(NumberFormatException e){
			System.out.println("Niepoprawny format argumentu");
		}
		return a;
	}
	
	/**
	 * Metoda czeka na dwie dane od u�ytkownika 
	 * nast�pnie oblicza z nich sum�
	 */
	void checkData(){
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

		System.out.println("Suma: " + calculateSum(s1,s2));
	}
}