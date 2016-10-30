import java.math.*;
import java.util.*;
import java.io.*;
/**Klasa obliczajaca silni� umo�liwiajaca kolejkowanie 'zlece�' obliczeniowych 
 * oraz ponowne u�ycie wcze�niej wyliczonych warto�ci silni;
 * @see Calculator
 * @see QueueTasks
 * @author Natalia Materek
 * @version 1.1
 */
public class Factory implements Calculator{
	/**Pojemnik do przechowywania ju� wyliczonych warto�ci silni */
	private TreeMap<Integer, BigInteger> bufer = new TreeMap<Integer, BigInteger>();
	
	/**Metoda dodaje do bufora nowa warto�� silni,
	 * @param newValue 
	 *  - wartos� silni
	 * @param newKey 
	 *  - liczba dla kt�rej obliczono silni�
	 */
	public void addValue(BigInteger newValue, int newKey){	
		if (bufer.size() <= MAX_SIZE){
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
		return MAX_SIZE;
	}
	
	/** Wypisuje zawarto�� pojemnika bufor na wyj�cie */
	public void printBufer(){
		System.out.println("{key = value}");
	    System.out.println(bufer);
	    System.out.println("Size: " + bufer.size());
	}
	
	/** @return minKey 
	 *  - zwraca najmniejszy klucz na mapie */
	int searchMinKey(){
		int minKey = 0;
		if (bufer.isEmpty() != false){
			minKey = bufer.firstKey();
		}
		return minKey;
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
	
	/** Metoda generuje silni� u�ywajac ju� obliczonych warto�ci
	 *  @param n 
	 *   - liczba dla kt�rej obliczona b�dzie silnia
	 *  @return result 
	 *   - wynik dzia�a�
	 */
	
	public BigInteger calculateFactory(int n){
		BigInteger result = new BigInteger("1");
		if (n <= 1){
			return result;
		}
		else if (searchMaxKey(n) != 0){
			BigInteger maxAvailableValue = new BigInteger(""+searchMaxValue(searchMaxKey(n)));
			result = maxAvailableValue;

			int i = searchMaxKey(n);
			while(i < n){
				BigInteger tmp = new BigInteger(""+(++i));
				result = result.multiply(tmp);
			}
		}
		else{
			for (int i = 2; i <= n; i++){
				BigInteger tmp = new BigInteger(""+i);
				result = result.multiply(tmp);
			}	
		}
		addValue(result, n);
		return result;
	}
	
	/**Metoda wczytuje dane do kolejki dla kt�rych chcemy oblicza� silni�
	 * @throws NumberFormatException 
	 *  - jesli podano niepoprawny format danych
	 */
	void readData(){
		boolean end = false;
		QueueTasks queue = new QueueTasks();
		while (end != true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter an integer");
			String myString = scanner.nextLine();
	
			try{
				int a = Integer.parseInt(myString);
				if (queue.addValue(a) == false){
					System.out.println("The queue is full");
					end = true;
				}
			}
			
			catch(NumberFormatException e){
				System.out.println("Niepoprawny format argumentu");
				end = true;
			}
		}
		queue.sortQueue();
		queue.printBufer();
		for (int i = 0; i < queue.getSize(); i++){
			System.out.println("Silnia z: " + queue.at(i) + " to: " + calculateFactory(queue.at(i)));

		}
		printBufer();
	}
	
	void addLine(String linia) {
		QueueTasks queue = new QueueTasks();
		String [] liczbyStr = linia.split(" +");
		Integer liczbaDodawnaInt;
		for (int i = 0; i < liczbyStr.length;i++){
			liczbaDodawnaInt = new Integer(liczbyStr[i]);
			System.out.println(liczbaDodawnaInt);
			queue.addValue(liczbaDodawnaInt); // dodaj do kolejki
		}
	}
	
	 void readFromFile(){
		 try{ 
			 FileReader fileReader = new FileReader("C:\\Java\\jdk1.8.0_91\\JavaPodstawy\\FactorialBuffer\\src\\plik.txt");
			 BufferedReader br = new BufferedReader(fileReader);
			 String word = br.readLine(); 
			 while (word != null){ 
				 System.out.println(word); 
				 addLine(word);
				 word = br.readLine();
			} 
		
		br.close(); 
		}catch(Exception e){ 
			System.out.println("Niepowodzenie"); 
		} 
	}
}