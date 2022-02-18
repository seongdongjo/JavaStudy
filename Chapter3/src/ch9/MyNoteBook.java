package ch9;

public class MyNoteBook extends NoteBook{ //추상클래스인 NoteBook을 상속받음(부모가 구현안한 display()를 구현)

	@Override
	void display() {
		System.out.println("MyNoteBook display");		
	}
}
