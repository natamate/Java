package pl.edu.agh.kis;

import java.math.*;
import java.util.*;
/**Klasa tworzaca menu wyboru dla prostego kalkulatora, 
 * okreœlajaca rodzaj dzia³añ (silnia, suma, iloczyn)
 * 
 * @author Natalia Materek
 * @see Factory
 * @see Sum
 * @see Mul
 */
public class FactoryBufer {

	public static void main(String[] args){
		/**@throws  new RuntimeException 
		 *  - jesli nie podano argumentów */

		if (args.length < 1){
			throw new RuntimeException("Nie podales argumentów");
		}
		
		String arg = args[0].toLowerCase();
		//System.out.println(" " + args[0]);

		if (arg.equals("silnia")){
			Factory exampleFactory = new Factory();
			exampleFactory.readFromFile("silnia.txt");
			//exampleFactory.readData();
		}
		
		if (arg.equals("suma")){
			Sum suma = new Sum();
			suma.printResult();
		}
		
		if (arg.equals("iloczyn")){
			Mul iloczyn = new Mul();
			iloczyn.printResult();
		}
		
	}
}