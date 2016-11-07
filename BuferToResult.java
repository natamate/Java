package pl.edu.agh.kis;

import java.math.BigInteger;
import java.util.*;

public class BuferToResult implements Cache{
	/**Pojemnik do przechowywania juz wyliczonych wartosci silni */
	TreeMap<Integer, BigInteger> bufer = new TreeMap<Integer, BigInteger>();


	/**Metoda spr czy mozna dodac do bufora wartosc silni
	 * @return true
	 * - jesli dodanie jest mozliwe
	 */
	public boolean addValue(int newKey){
		if (isEmpty() == true){
			return true;
		}
		//if ((isFull() == false) && (newKey > searchMinKey()) && (checkValue(newKey) == false )){
		if ((isFull() == false) && (checkValue(newKey) == false )){
			return true;
		}
		return false;
	}
	
	/**Metoda dodaje do bufora nowa wartosc silni,
	 * @param newValue 
	 *  - wartosc silni
	 * @param newKey 
	 *  - liczba dla której obliczono silnie
	 */
	public void addValue(BigInteger newValue, int newKey){	
		if (addValue(newKey) == true){
			bufer.put(newKey, newValue);
		}
		else{
			clear();
			if (addValue(newKey) == true){
				bufer.put(newKey, newValue);
			}
		}
	}
	
	/** @return 
	 *  - aktualny rozmiar pojemnika */ 
	public int getSize(){
		return bufer.size();
	}
	
	/** @return minKey 
	 *  - zwraca najmniejszy klucz na mapie */
	public int searchMinKey(){
		int minKey = 0;
		if (bufer.isEmpty() != false){
			minKey = bufer.firstKey();
		}
		return minKey;
	}
	
	/** Szuka wartosci przypisanej podanemu kluczowi na mapie 
	 * @param key 
	 *  - klucz dla którego szukana jest wartosc
	 * @return maxResult 
	 *  - wartosc podanego klucza
	 */
	BigInteger searchMaxValue(int key){
		BigInteger maxResult = new BigInteger("1");
		Set set = bufer.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			Map.Entry memory = (Map.Entry)iterator.next();
			if ((int)memory.getKey() == key){
				maxResult = (BigInteger)memory.getValue();
			}
		}
		return maxResult;
	}
	
	/**@param key 
	 *  - wartosc dla której liczona bedzie silnia
	 * @return maxKey 
	 *  - zwraca najwieêkszy klucz na mapie, który jest mniejszy od parametru 
	 */
	int searchMaxKey(int key){
		int maxKey = 0;
		Set set = bufer.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			Map.Entry memory = (Map.Entry)iterator.next();
			if (((int)memory.getKey() > maxKey)&&((int)memory.getKey() <= key)){
				maxKey = (int)memory.getKey();
			}
		}
		return maxKey;
	}
	
	/**Metoda usuwa pare z kluczem dawno nie uzywanym bufora jesli bufor jest pelny
	 */
	
	public void clear(){
		if (isFull() == true){
			System.out.println(searchMinKey());
			bufer.remove(searchMinKey());
			System.out.println("Hej tu clear() ");
		}
	}
	
	/** Wypisuje zawartosc pojemnika bufor na wyjscie */
	public void printBufer(){
		System.out.println("Bufer: ");
	    System.out.println(bufer);
	    System.out.println("Size: " + getSize());
	}
	
	/**Metoda spr czy bufor jest pusty
	 * @return true
	 * - jesli bufor jest pusty
	 */
	public boolean isEmpty(){
		if (bufer.isEmpty() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**Metoda spr czy bufor jest pelny
	 * @return true
	 * - jesli bufor jest pelny
	 */
	public boolean isFull(){
		if (getSize() >= MAX_SIZE){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**Metoda zwraca wartosc z podaneo indeksu
	 * 
	 * @param index 
	 * - podany indeks
	 * @return 
	 * wartosc z bufora
	 */
	public BigInteger getValue(int index){
		return bufer.get(index);
	}
	
	/**Metoda spr czy bufor zawiera podana wartosc
	 * @param searchKey
	 * - szukany klucz
	 * @return true
	 * - jesli bufor zawiera klucz
	 */
	public boolean checkValue(int searchKey){
		if (bufer.containsKey(searchKey) == true){
			return true;
		}
		return false;
	}
	
	/**Metoda zwraca ktory z kolei jest podany klucz
	 * @param key
	 * - klucz dla ktorego szukane jest polozenie
	 * @return counter
	 * - polozenie klucza
	 */
	public int at(int key){
		int counter = 0;
		Set set = bufer.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			Map.Entry memory = (Map.Entry)iterator.next();
			if ((int)memory.getKey() == key){
				counter++;
			}
		}
		return counter;
	}
}
