import java.math.BigInteger;

public interface Cache {
	int MAX_SIZE = 15;
	
	boolean addValue(int newValue);
	void clear();
	boolean checkValue(int value);
	void printBufer();
	boolean isFull();
	boolean isEmpty();
	int getSize();
	int at(int index);
	int searchMinKey();
}
