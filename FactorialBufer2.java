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
public class FactorialBufer2 {

	public static void main(String[] args){
		/**@throws  new RuntimeException 
		 *  - jeœli nie podano argumentów */
		if (args.length < 1){
			throw new RuntimeException("Nie poda³eœ argumentów");
		}
		
		String arg = args[0].toLowerCase();
		System.out.println(" " + args[0]);

		if (arg.equals("silnia")){
			Factory exampleFactory = new Factory();
			//exampleFactory.readData();
			exampleFactory.readFromFile();
		}
		
		if (arg.equals("suma")){
			Sum suma = new Sum();
			suma.checkData();
		}
		
		if (arg.equals("iloczyn")){
			Mul iloczyn = new Mul();
			iloczyn.checkData();
		}
		
	}
}