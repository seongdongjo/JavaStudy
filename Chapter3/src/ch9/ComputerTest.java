package ch9;

public class ComputerTest {

	public static void main(String[] args) {
		Computer computer = new DeskTop(); //Computer�� �߻�Ŭ����(�ν��Ͻ�ȭ�Ҽ�����new), DeskTop�� �Ϲ�Ŭ����
		computer.display(); //�������̵��� �ν��Ͻ��� �޼��带 ã�ư���(desktop) -> ����޼���
		computer.turnOff();
		
		NoteBook myNote = new MyNoteBook();
	}
}