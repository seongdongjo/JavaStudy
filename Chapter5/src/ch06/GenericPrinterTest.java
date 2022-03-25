package ch06;

public class GenericPrinterTest {

	public static void main(String[] args) {

		//Powder powder = new Powder();
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>(); //GenericPrinter에서 <T>가 알아서 powder로 바뀐다.
		//GenericPrinter<Powder> powderPrinter = new GenericPrinter<>(); <powder>생략가능하다. 
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter);
		Powder p = powderPrinter.getMaterial(); //다운캐스팅안해도 된다.
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter);
		
	}

}
