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
public class Factory{
	/**Pojemnik do przechowywania ju� wyliczonych warto�ci silni */
	BuferToResult bufer = new BuferToResult();
	QueueTasks queue = new QueueTasks();
	
	
	/** @return MAX_DATA 
	 *  - maksymalny rozmiar pojemnika */ 
	public int getSize(){
		return queue.MAX_SIZE;
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
	
	/**Metoda wczytuje dane do kolejki dla kt�rych chcemy oblicza� silni�
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
	
	void showResult(){
		queue.printBufer();
		System.out.println("Show result petla");
		for (int i = 0; i < queue.getSize(); i++){
			System.out.println("Silnia z: " + queue.at(i) + " to: " + calculateFactory(queue.at(i)));

		}
		bufer.printBufer();
	}
	
	void addLine(String linia) {
		//QueueTasks queue = new QueueTasks();
		String [] liczbyStr = linia.split(" +");
		Integer liczbaDodawnaInt;
		for (int i = 0; i < liczbyStr.length;i++){
			liczbaDodawnaInt = new Integer(liczbyStr[i]);
			System.out.println(liczbaDodawnaInt);
			if (queue.addValue(liczbaDodawnaInt) == true){
				System.out.println("Udalo sie dodac");
			}; // dodaj do kolejki
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
		showResult();
	}
}