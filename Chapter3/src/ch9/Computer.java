package ch9;

//부모
public abstract class  Computer { //추상클래스는 상속을위한 클래스다.
	
	//메서드선언만했다.(추상메서드)
	//상속받을 애들을 구체적으로 어떻게 구현할지 모르기때문에 display,typing은 자식이 알아서해라
	//컴퓨터는 공통으로쓸 turnOn, turnOff만 구현하고 display(), typing()은 구현하지않았다. 하위클래스로 책임전가
	abstract void display();
	abstract void typing();
	
	//일반메서드
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
