package ch21;

public class BookTest {

	public static void main(String[] args) {
		Book[] library = new Book[5]; //null�� �ʱ�ȭ, new�Ѵٰ� Book���԰� ��������°� �ƴϴ�.
		
		library[0] = new Book("�¹���1", "������"); //��ü�� ���� �־���Ѵ�. 
		library[1] = new Book("�¹���2", "������");
		library[2] = new Book("�¹���3", "������");
		library[3] = new Book("�¹���4", "������");
		library[4] = new Book("�¹���5", "������");
		
		for(Book book : library) {
			System.out.println(book); //ch21.Book@36aa7bc2  ó�� ����ٸ� 5�� ����
			book.showInfo();
		}
		
		
	}

}
