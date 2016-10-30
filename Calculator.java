import java.math.BigInteger;
/**Interfejs obs³ugiwany przez klasê Factory dokonujaca obliczeñ silni
 * @see Factory
 * @author Natalia Materek
 * @version 1.1
 */
interface Calculator {
	/** MAX_DATA 
	 *  - zmienna sta³a okreœlaj¹ca maksymalny rozmiar bufora */
	int MAX_SIZE = 5;
	
	//void addValue(BigInteger newValue, int newKey);
	int getSize();
	void printBufer();
	//BigInteger calculateFactory(int n);
}
