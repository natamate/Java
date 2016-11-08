
class Insect{
	private int i = 9;
	protected int j;
	
	Insect(){
		System.out.println("i: " + i + " j: " + j);
		j = 39;
	}
	
	private static String x1 = "Insect x1 zainicjalizowana";
	
	int initPrint(String s){
		System.out.println(s);
		return 47;
	}
}

class Beetle extends Insect{
	protected int k = 98;
	
	public Beetle(){
		System.out.println("k: " + k + " j: " + j);
	}
	
	public static String x2 = "Beetle x2 zainicjalizowana";
	
}

class Zuk extends Beetle{
	private int l = 99;
	
	public Zuk(){
		System.out.println("l: " + l + " k: " + k + " j: " + j);
	}
	
	public static String x3 = "Beetle x3 zainicjalizowana";
}

public class Cw23Str239 {

	public static void main(String[] args) {
		//Beetle b = new Beetle();
		
		System.out.println(Beetle.x2);
		
		Zuk z = new Zuk();
	}

}
