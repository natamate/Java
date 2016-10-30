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
	BigInteger calculateMul(String element1, String element2){
		try{
			BigInteger element1i = new BigInteger(element1);
			BigInteger element2i = new BigInteger(element2);

			return element1i.multiply(element2i);
		}
		catch(NumberFormatException e){
			System.out.println("Niepoprawna liczba");
			return null;
		}
	}
	
	/**
	 * Wczytuje danê dla których obliczona bêdzie iloczyn
	 * @return a
	 *  - pobrana wartoœæ od u¿ytkownika
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
	 * Metoda czeka na dwie dane od u¿ytkownika 
	 * nastêpnie oblicza z nich iloczyn
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

		System.out.println("Iloczyn: " + calculateMul(s1,s2));
	}
}
