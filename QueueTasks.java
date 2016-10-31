package pl.edu.agh.kis;
import java.util.*;

/**Klasa odpowiadajaca za kolejkowanie zlecen do obliczania silni
 * @see Factory
 * @author Natalia Materek
 * 
 */
public class QueueTasks implements Cache{
	/** Kolejka zlecen */
	ArrayList <Integer>queue = new ArrayList<Integer>();
	
	/** Metoda dodajaca wartosc(zlecenie) do kolejki
	 * 
	 * @param newValue
	 * wartosc do dodania
	 * @return true
	 * jesli dodano wartosc do kolejki
	 */
	public boolean addValue(int newValue){
		if (queue.size() < MAX_SIZE){
			queue.add(newValue);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @return queue.size();
	 * rozmiar kolejki
	 */
	public int getSize(){
		return queue.size();
	}
	
	/**Metoda sortuje i wypisuje kolejke na standardowe wyjscie */
	public void printBufer(){
		sortQueue();
		System.out.println("Job in the queue factorial: ");
		System.out.println(queue);
	}
	
	/**Metoda sortuje kolejke rosnaco w celu uporzadkowania zlecen*/
	void sortQueue(){
		Collections.sort(queue);
	}
	
	/**Metoda usuwa najmniejszy element z kolejki jesli jest pelna*/
	public void clear(){
		if (isFull() == true){
			queue.remove(0);
		}
	}
	
	/**Metoda spr czy w kolejce jest podana wartosc
	 * @param value 
	 * - szukana wartosc
	 * @return true
	 * - jesli element znajduje sie w kolejce
	 */
	public boolean checkValue(int value){
		if(queue.contains(value)){
			return true;
		}	
		return false;
	}
	
	/**Metoda spr czy kolejka jest pelna
	 * @return true
	 * - jesli kolejka jest pelna
	 */
	public boolean isFull(){
		if (getSize() == MAX_SIZE){
			return true;
		}
		return false;
	}
	
	/**Metoda spr czy kolejka jest pusta
	 * @return true
	 * - jesli kolejka jest pusta
	 */
	public boolean isEmpty(){
		if (isEmpty() == true){
			return true;
		}
		return false;
	}

	/**Metoda zwraca najmniejsza wartosc z kolejki
	 * @return
	 * - najmniejsza wartosc w kolejce 
	 */
	public int searchMinKey(){
		sortQueue();
		return at(0);
	}
	
	/** Metoda zwraca wartosc znajdujaca sie pod podanym indeksem
	 * @param index
	 * indeks elementu kolejki
	 * @return 
	 * wartosc pod podanym indeksem
	 */
	public int at(int index){
		return queue.get(index);
	}
}