package ch21;

public class ObjectCopyTest {
	public static void main(String[] args) {
		Book[] library = new Book[5]; //null�� �ʱ�ȭ, new�Ѵٰ� Book���԰� ��������°� �ƴϴ�.
		Book[] copyLibrary = new Book[5];
		
		library[0] = new Book("�¹���1", "������"); //��ü�� ���� �־���Ѵ�. 
		library[1] = new Book("�¹���2", "������");
		library[2] = new Book("�¹���3", "������");
		library[3] = new Book("�¹���4", "������");
		library[4] = new Book("�¹���5", "������");
		
		System.arraycopy(library, 0, copyLibrary, 0, 5); //library 0�������� �����ؼ� copyLibrary�� 0����5���� �־��(�ּҰ� ���� �����̴�)
	
		//���� book
		for(Book book : library) {
			System.out.println(book);  //�ּҰ�����.
			book.showInfo();
		}
		
		//������
		for(Book book : copyLibrary) { //�ּҰ�����.
			System.out.println(book); 
			book.showInfo();
		}
		
		//�ּҰ����Ƽ� library0��°�� �مf�µ� copyLibrary�� ���� �ٲ��.
		library[0].setAuthor("�ڿϼ�");
		library[0].setTitle("����");
		
	}
	//�̷��� ���������̴�.
}
