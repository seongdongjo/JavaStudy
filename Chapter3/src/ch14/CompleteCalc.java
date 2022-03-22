package ch14;

public class CompleteCalc extends Calculator{ //Calc interface의 private myMethod, mystaticMethod는 재정의,구현할수없다.
	//즉, private메서드는 재정의할수없다.
	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if( num2 == 0 )
			return ERROR;
		else 
			return num1 / num2;
	}
	
	public void showInfo() { //내 함수
		System.out.println("모두 구현하였습니다.");
	}

	@Override
	public void description() { //Calc interface에 있는 default메서드이다.
		System.out.println("CompleteCalc에서 재정의한 default 메서드");
		//super.description(); 부모에있는걸쓰는게아니라 재정의하겠다. 위에서
	}
}
