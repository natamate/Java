import java.math.BigInteger;
/**Interfejs obs�ugiwany przez klas� Factory dokonujaca oblicze� silni
 * @see Factory
 * @author Natalia Materek
 * @version 1.1
 */
interface Calculator {
	/** MAX_DATA 
	 *  - zmienna sta�a okre�laj�ca maksymalny rozmiar bufora */
	int MAX_SIZE = 5;
	
	//void addValue(BigInteger newValue, int newKey);
	int getSize();
	void printBufer();
	//BigInteger calculateFactory(int n);
}
