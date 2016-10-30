import java.util.*;

/**Klasa odpowiadajaca za kolejkowanie zlece� do obliczania silni
 * @see Factory
 * @author Natalia Materek
 * 
 */
public class QueueTasks implements Calculator{
	/** Kolejka zlecen */
	ArrayList <Integer>queue = new ArrayList<Integer>();
	
	/** Metoda dodajaca warto��(zlecenie) do kolejki
	 * 
	 * @param newValue
	 * warto�� do dodania
	 * @return true
	 * je�li dodano warto�� do kolejki
	 */
	boolean addValue(int newValue){
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
		System.out.println("Job in the queue factorial: ");
		System.out.println(queue);
	}
	
	/**Metoda sortuje kolejk� rosnaco w celu uporzadkowania zlece�*/
	void sortQueue(){
		Collections.sort(queue);
	}
	/** @param index
	 * indeks elementu kolejki
	 * @return 
	 * warto�� pod podanym indeksem
	 */
	int at(int index){
		return queue.get(index);
	}
}
