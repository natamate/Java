import java.util.*;

/**Klasa odpowiadajaca za kolejkowanie zleceñ do obliczania silni
 * @see Factory
 * @author Natalia Materek
 * 
 */
public class QueueTasks implements Calculator{
	/** Kolejka zlecen */
	ArrayList <Integer>queue = new ArrayList<Integer>();
	
	/** Metoda dodajaca wartoœæ(zlecenie) do kolejki
	 * 
	 * @param newValue
	 * wartoœæ do dodania
	 * @return true
	 * jeœli dodano wartoœæ do kolejki
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
	
	/**Metoda wypisuje kolejkê na standardowe wyjœcie */
	public void printBufer(){
		System.out.println("Job in the queue factorial: ");
		System.out.println(queue);
	}
	
	/**Metoda sortuje kolejkê rosnaco w celu uporzadkowania zleceñ*/
	void sortQueue(){
		Collections.sort(queue);
	}
	/** @param index
	 * indeks elementu kolejki
	 * @return 
	 * wartoœæ pod podanym indeksem
	 */
	int at(int index){
		return queue.get(index);
	}
}
