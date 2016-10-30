import java.math.BigInteger;
import java.util.*;

public class BuferToResult implements Cache{
	/**Pojemnik do przechowywania ju� wyliczonych warto�ci silni */
	TreeMap<Integer, BigInteger> bufer = new TreeMap<Integer, BigInteger>();

	/**Metoda dodaje do bufora nowa warto�� silni,
	 * @param newValue 
	 *  - wartos� silni
	 * @param newKey 
	 *  - liczba dla kt�rej obliczono silni�
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
	
	/** Wypisuje zawarto�� pojemnika bufor na wyj�cie */
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
	
	/** Szuka warto�ci przypisanej podanemu kluczowi na mapie 
	 * @param key 
	 *  - klucz dla kt�rego szukana jest warto��
	 * @return maxResult 
	 *  - warto�� podanego klucza
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
	 *  - warto�� dla kt�rej liczona b�dzie silnia
	 * @return maxKey 
	 *  - zwraca najwi�kszy klucz na mapie, kt�ry jest mniejszy od parametru 
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
	
	/** Wypisuje zawarto�� pojemnika bufor na wyj�cie */
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
