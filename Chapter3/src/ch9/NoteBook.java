package ch9;

public abstract class NoteBook extends Computer{ //추상클래스 (구현안한 메서드가 display()가있는데 이거를 구현안하면 abstract를 붙힌다)
	@Override
	public void typing() {
		System.out.println("NoteBook typing");		
	}
}
