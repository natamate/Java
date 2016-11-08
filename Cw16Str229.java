
class Amphibian{
	void swim(){
		System.out.println("Amphibian.swim()");
	}
	
	void stop(){
		System.out.println("Amphibian.stop()");
	}
	
	void forward(){
		System.out.println("Amphibian.forward()");
	}
}

class Frog extends Amphibian{
	void jump(){
		System.out.println("Frog.jump()");
	}
	
	void swim(){
		System.out.println("Frog.swim()");
	}
	
	void stop(){
		System.out.println("Frog.stop()");
	}
	
	void forward(){
		System.out.println("Frog.forward()");
	}
}

public class Cw16Str229 {
	public static void main(String[] args) {
		Frog f = new Frog();
		f.swim();
		f.forward();
		f.stop();
		f.jump(); 
		Amphibian a = f;
		a.swim();
		a.forward();
		a.stop();
		//a.jump(); undeffined
	}

}
