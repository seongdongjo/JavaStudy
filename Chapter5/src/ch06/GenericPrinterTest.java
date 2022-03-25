package ch06;

public class GenericPrinterTest {

	public static void main(String[] args) {

		//Powder powder = new Powder();
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>(); //GenericPrinter���� <T>�� �˾Ƽ� powder�� �ٲ��.
		//GenericPrinter<Powder> powderPrinter = new GenericPrinter<>(); <powder>���������ϴ�. 
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter);
		Powder p = powderPrinter.getMaterial(); //�ٿ�ĳ���þ��ص� �ȴ�.
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter);
		
	}

}
