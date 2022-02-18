package ch9;

public class ComputerTest {

	public static void main(String[] args) {
		Computer computer = new DeskTop(); //Computer는 추상클래스(인스턴스화할수없다new), DeskTop은 일반클래스
		computer.display(); //오버라이딩된 인스턴스의 메서드를 찾아간다(desktop) -> 가상메서드
		computer.turnOff();
		
		NoteBook myNote = new MyNoteBook();
	}
}