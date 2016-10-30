import java.math.BigInteger;
import java.util.*;

public class BuferToResult implements Cache{
	/**Pojemnik do przechowywania ju¿ wyliczonych wartoœci silni */
	TreeMap<Integer, BigInteger> bufer = new TreeMap<Integer, BigInteger>();

	/**Metoda dodaje do bufora nowa wartoœæ silni,
	 * @param newValue 
	 *  - wartosæ silni
	 * @param newKey 
	 *  - liczba dla której obliczono silniê
	 */
	public boolean addValue(int newKey){
		if (isEmpty() == true){
			return true;
		}
		if ((getSize() <= MAX_SIZE) && (newKey > searchMinKey()) && (checkValue(newKey) == false )){
			return true;
		}
		return false;
	}
	
	public void addValue(BigInteger newValue, int newKey){	
		if (addValue(newKey) == true){
			bufer.put(newKey, newValue);
		}
		else{
			bufer.remove(searchMinKey());
			bufer.put(newKey, newValue);
		}
	}
	/** @return MAX_DATA 
	 *  - maksymalny rozmiar pojemnika */ 
	public int getSize(){
		return bufer.size();
	}
	
	/** Wypisuje zawartoœæ pojemnika bufor na wyjœcie */
	public void printBufer(){
		System.out.println("{key = value}");
	    System.out.println(bufer);
	    System.out.println("Size: " + bufer.size());
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
	
	/** Szuka wartoœci przypisanej podanemu kluczowi na mapie 
	 * @param key 
	 *  - klucz dla którego szukana jest wartoœæ
	 * @return maxResult 
	 *  - wartoœæ podanego klucza
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
	 *  - wartoœæ dla której liczona bêdzie silnia
	 * @return maxKey 
	 *  - zwraca najwiêkszy klucz na mapie, który jest mniejszy od parametru 
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
	
	public void clear(){
		if (getSize() == bufer.size()){
			bufer.remove(searchMinKey());
		}
	}
	
	/** Wypisuje zawartoœæ pojemnika bufor na wyjœcie */
	public void print(){
		System.out.println("Bufer: ");
	    System.out.println(bufer);
	    System.out.println("Size: " + getSize());
	}
	
	
	public boolean isEmpty(){
		if (bufer.isEmpty() == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isFull(){
		if (getSize() == MAX_SIZE){
			return true;
		}
		else{
			return false;
		}
	}
	
	public BigInteger getValue(int index){
		return bufer.get(index);
	}
	
	public boolean checkValue(int value){
		if (bufer.containsKey(value) == true){
			return true;
		}
		return false;
	}
	
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
