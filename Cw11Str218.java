/*Zmodyfikuj tak aby uzyc delegacji*/

class Cw11Str218{
	private String s = "Cleanser";
	
	public void append(String a){
		s+=a;
	}
	
	public void dilute(){
		append("dilute()");
	}
	
	public void apply(){
		append("apply()");
	}
	
	public void scrub(){
		append("scrub()");
	}
	
	public String toString(){
		return s;
	}
	
	public static void main(String[] args) {
		Detergent x = new Detergent();
		//x.dilute();
		//x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("Test klasy bazowej");
		Cw11Str218 y = new Cw11Str218();
		y.dilute();
		y.apply();
		y.scrub();
		System.out.println(y);
		
		Sterylize z = new Sterylize();
		z.scrub();
		z.sterylize();
		System.out.println(z);
	}

}

class Detergent {
	
	private Cw11Str218 controls = new Cw11Str218();
	
	public void scrub(){
		controls.append("Detergent Scrub()");
		controls.scrub();
	}
	public void foam(){
		controls.append("foam()");
	}
	
	public Cw11Str218 getControls(){
		return controls;
	}
	
	public String toString(){
		return controls.toString();
	}
	/*public static void main(String[] args){
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("Test klasy bazowej");
		Cw2Str213.main(args);
	}*/
}

class Sterylize extends Detergent{
	public void scrub(){
		getControls().append("Sterylize scruub()");
	}
	
	public void sterylize(){
		getControls().append("Sterylize");

	}
}