package pl.edu.agh.kis;
import java.math.*;
import java.util.Scanner;
/** Klasa obliczajaca sume liczb typu BigInteger
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
	 *  - wynik dodawania lub null w przypadku bledu konwersji
	 */
	BigInteger calculateSum(String[] elements){
		try{
			BigInteger element1i = new BigInteger(elements[0]);
			BigInteger element2i = new BigInteger(elements[1]);

			return element1i.add(element2i);
		}
		catch(NumberFormatException e){
			System.out.println("Niepoprawna liczba");
			return null;
		}
	}
	
	/**Wypisuje wyniki na standardowe wyjscie
	 * 
	 */
	void printResult(){
		ReadDataFromUser read = new ReadDataFromUser();
		System.out.println("Suma = " + calculateSum(read.checkData()));
	}
}
