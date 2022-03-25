package ch06;

public class ThreeDPrinterTest {
	public static void main(String[] args) {
		Powder powder = new Powder();
		ThreeDPrinter3 printer = new ThreeDPrinter3();
		
		printer.setMaterial(powder); //object로 받는다. printer는
		
		Powder p = (Powder)printer.getMaterial(); //이렇게 오브젝트로 쓰면 다운캐스팅을 해줘야한다. 이게 번거러우니 제네릭타입이 나온것이다.
	}
}
