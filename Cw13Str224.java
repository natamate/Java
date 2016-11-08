
class Baza{
	char abs(char x){
		System.out.println("abs char: " + x);
		return 'x';
	}
	
	int abs(int y){
		System.out.println("abs int: " + y);
		return y;
	}
	
	float abs(float z){
		System.out.println("abs float: " + z);
		return z;
	}
}

class Pochodna extends Baza{
	String abs(String a){
		System.out.println("abs string: " + a);
		return a;
	}
}

public class Cw13Str224 {

	public static void main(String[] args) {
		Pochodna p = new Pochodna();
		System.out.println("int: " + p.abs(1));
		System.out.println("char: " + p.abs('a'));
		System.out.println("float: " + p.abs(1.1f));
		System.out.println("string: " + p.abs("ala"));
	}

}
