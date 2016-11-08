package pl.agh.edu.kis;

final class Baza1{
	
}

class Pochodna1 extends Baza1{
	

}
class Baza{
	final void metodaFinalna(){
		System.out.println("Meetoda finalna baza");
	}
	
}

class Pochodna extends Baza{
	@Override
	void metodaFinalna(){
		System.out.println("Meetoda finalna pochodna");
	}
}

class WithFinals{
	@Override
	private final void f(){
		System.out.println("WithFinals.f()");
	}
	
	private void g(){
		System.out.println("WithFinals.g()");
	}
}

class OverridingPrivate extends WithFinals{
	@Override
	private final void f(){
		System.out.println("OverridingPrivate.f()");
	}
	
	private void g(){
		System.out.println("OverridingPrivate.g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate{
	@Override
	public final void f(){
		System.out.println("OverridingPrivate2.f()");
	}
	
	public void g(){
		System.out.println("OverridingPrivate2.g()");
	}
}

public class Cw20Str235 {

	public static void main(String[] args) {
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		
		OverridingPrivate op = op2;
		
		//op.f();
		//op.g();
		
		WithFinals w = op2;
		//w.f();
		//w.g();
	}

}
