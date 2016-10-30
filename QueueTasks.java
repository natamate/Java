import java.util.*;

/**Klasa odpowiadajaca za kolejkowanie zlece� do obliczania silni
 * @see Factory
 * @author Natalia Materek
 * 
 */
public class QueueTasks implements Cache{
	/** Kolejka zlecen */
	ArrayList <Integer>queue = new ArrayList<Integer>();
	
	/** Metoda dodajaca warto��(zlecenie) do kolejki
	 * 
	 * @param newValue
	 * warto�� do dodania
	 * @return true
	 * je�li dodano warto�� do kolejki
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
	
	/**Metoda wypisuje kolejk� na standardowe wyj�cie */
	public void printBufer(){
		sortQueue();
		System.out.println("Job in the queue factorial: ");
		System.out.println(queue);
	}
	
	/**Metoda sortuje kolejk� rosnaco w celu uporzadkowania zlece�*/
	void sortQueue(){
		Collections.sort(queue);
	}
	
	public void clear(){}
	public boolean checkValue(int value){
		for (int i = 0 ; i < getSize(); i++){
			if (at(i) == value){
				return true;
			}	
		}
		return false;
	}
	
	public boolean isFull(){
		if (getSize() == MAX_SIZE){
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		if (isEmpty() == true){
			return true;
		}
		return false;
	}


	public int searchMinKey(){
		sortQueue();
		return at(0);
	}
	
	/** @param index
	 * indeks elementu kolejki
	 * @return 
	 * warto�� pod podanym indeksem
	 */
	public int at(int index){
		return queue.get(index);
	}
}
