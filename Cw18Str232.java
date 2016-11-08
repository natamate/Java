package pl.edu.agh.kis;

class Poppet{
	int i;
	Poppet(){
		i = 1;
		System.out.println("Poppet() " + i);
	}
	
	Poppet(int ii){
		i = ii;
		System.out.println("Poppet(int ii) " + i);
	}
}

class TestFinal{
	final int pole1;
	final static int pole2 = 1; // musze inicjalizowac w miejscu deklaracji
	private final Poppet p;
	{
		pole1 = 22; // mo=usze zainicjalizowaw, albo na poczatku, albo w bloku albo w konstruktorze
	}
	
	TestFinal(){
		p = new Poppet();
		System.out.println("TestFinal() " + p.i);
	}
	
	TestFinal(int ii){
		p = new Poppet(ii);
		System.out.println("TestFinal(ii) " + p.i);
	}
	
	Poppet getPoppet(){
		return p;
	}
	
	void setPoppet(Poppet nowyPoppet){
		//p = nowyPoppet; nie moze byc
	}
}

public class Cw18Str232 {

	public static void main(String[] args) {
		TestFinal test = new TestFinal();
		TestFinal test2 = new TestFinal(22);
		//test.pole1 = 2; nie mozna
		//test.pole2 = 3;
		System.out.println("Poppet i " + test.getPoppet().i);
		test.getPoppet().i = 0;
		System.out.println("Poppet i " + test.getPoppet().i);
		
		Poppet tescik = new Poppet(33);

	}

}
