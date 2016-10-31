package pl.edu.agh.kis;
import java.math.*;
import java.util.*;
import java.io.*;

/**Klasa obliczajaca silnie umozliwiajaca kolejkowanie 'zlecen' obliczeniowych 
 * oraz ponowne uzycie wczesniej wyliczonych wartosci silni;
 * @see Calculator
 * @see QueueTasks
 * @author Natalia Materek
 * @version 1.1
 */
public class Factory{
	/**Pojemnik do przechowywania juz wyliczonych wartosci silni */
	BuferToResult bufer = new BuferToResult();
	QueueTasks queue = new QueueTasks();
	
	
	/** @return MAX_DATA 
	 *  - maksymalny rozmiar pojemnika */ 
	public int getSize(){
		return queue.MAX_SIZE;
	}
	
	/** Metoda generuje silnie uzywajac juz obliczonych wartosci
	 *  @param n 
	 *   - liczba dla której obliczona bedzie silnia
	 *  @return result 
	 *   - wynik dzialan
	 */
	
	public BigInteger calculateFactory(int n){
		BigInteger result = new BigInteger("1");
		if (n <= 1){
			return result;
		}
		else if (bufer.searchMaxKey(n) != 0){
			BigInteger maxAvailableValue = new BigInteger(""+ bufer.searchMaxValue(bufer.searchMaxKey(n)));
			result = maxAvailableValue;

			int i = bufer.searchMaxKey(n);
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
		bufer.addValue(result, n);
		return result;
	}
	
	/**Metoda wczytuje dane do kolejki dla których chcemy obliczac silnie
	 * @throws NumberFormatException 
	 *  - jesli podano niepoprawny format danych
	 */
	void readData(){
		boolean end = false;
		//QueueTasks queue = new QueueTasks();
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
		showResult();
	}
	
	/**Metoda drukuje obliczone silnie na standardowe wyjscie
	 */
	void showResult(){
		queue.printBufer();
		System.out.println("Show result petla");
		for (int i = 0; i < queue.getSize(); i++){
			System.out.println("Silnia z: " + queue.at(i) + " to: " + calculateFactory(queue.at(i)));

		}
		bufer.printBufer();
	}
	
	/**Metoda dodaje dane do kolejki
	 * 
	 * @param line 
	 * - String z ktorego wyciagniete beda liczby
	 */
	void addLine(String line) {
		String [] numbers = line.split(" +");
		Integer valueToAdd;
		for (int i = 0; i < numbers.length;i++){
			valueToAdd = new Integer(numbers[i]);
			if (queue.addValue(valueToAdd) == true){
				System.out.println();
			}; 
		}
	}
	/**Metoda otwiera i czyta dane z aplik 
	 * 
	 * @param path sciezka do pliku z ktorego odczytane beda dane
	 * @throws Exception
	 * - przy bledzie zwiazanym z plikiem
	 */
	 void readFromFile(String path){
		 try{ 
			 FileReader fileReader = new FileReader(path);
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
		showResult();
	}
}
