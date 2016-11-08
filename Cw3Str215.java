package Cw3Str215;

class A{
	A(){
		System.out.println("A");
	}
}

class B{
	B(){
		System.out.println("B");
	}
}

class C extends A{
	private B b = new B();
}

class Art{
	Art(){
		System.out.println("Konstruktor Klasa bazowa ");
	}
}

class Drawing extends Art{
	Drawing(){
		System.out.println("Konstruktor klasy pochodnej ");
	}
}

public class Cw3Str215 {


	public static void main(String[] args) {
		Drawing test = new Drawing(); 
		//konstruktor klasy bazowe zostanie wywolany
		
		Drawing d1 = new Drawing();
		Drawing d2 = new Drawing();
		Drawing d3 = new Drawing();
		System.out.println("Tablica obiektow Art");
		Art [] testArray = {d1, d2, d3};
			
		System.out.println("A B C");
		C c = new C();
	}

}
