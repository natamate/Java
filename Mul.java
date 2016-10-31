package pl.edu.agh.kis;
import java.math.BigInteger;
import java.util.Scanner;
/** Klasa obliczajaca iloczyn liczb typu BigInteger
 * 
 * @author Natalia Materek
 * @see FactorialBufer
 */
public class Mul {
	/**Oblicza iloczyn
	 * 
	 * @param element1 czynnik 1.
	 * @param element2 czynnik 2.
	 * @throws NumberFormatException
	 * @return result
	 *  - wynik dodawania lub null w przypadku b³edu konwersji
	 */
	BigInteger calculateMul(String[] elements){
		try{
			BigInteger element1i = new BigInteger(elements[0]);
			BigInteger element2i = new BigInteger(elements[1]);

			return element1i.multiply(element2i);
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
		System.out.println("Iloczyn = " + calculateMul(read.checkData()));
	}
}