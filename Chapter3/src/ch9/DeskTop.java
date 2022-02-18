package ch9;

public class DeskTop extends Computer{

	@Override
	void display() {
		System.out.println("DeskTop display");
	}

	@Override
	void typing() {
		System.out.println("DeskTop typing");
	}

	@Override
	public void turnOff() { //재정의도 가능
		System.out.println("Desktop turnoff");
	}
}
