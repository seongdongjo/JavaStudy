package ch21;

public class ObjectCopyTest2 {
	public static void main(String[] args) {
		Book[] library = new Book[5]; 
		Book[] copyLibrary = new Book[5];
		
		library[0] = new Book("�¹���1", "������");
		library[1] = new Book("�¹���2", "������");
		library[2] = new Book("�¹���3", "������");
		library[3] = new Book("�¹���4", "������");
		library[4] = new Book("�¹���5", "������");
		
		//���� ���� ���
		copyLibrary[0] = new Book();
		copyLibrary[1] = new Book();
		copyLibrary[2] = new Book();
		copyLibrary[3] = new Book();
		copyLibrary[4] = new Book();
		
		for(int i =0; i<library.length; i++) {
			copyLibrary[i].setAuthor(library[i].getAuthor());
			copyLibrary[i].setTitle(library[i].getTitle());
		}
		
		
		//�ּҰ����Ƽ� library0��°�� �مf�µ� copyLibrary[0]�� �ȹٲ��.
		library[0].setAuthor("�ڿϼ�");
		library[0].setTitle("����");
		
				//���� book
				for(Book book : library) {
					System.out.println(book);  //�ּҰ��ٸ���
					book.showInfo();
				}
				
				//������
				for(Book book : copyLibrary) { //�ּҰ� �ٸ���
					System.out.println(book); 
					book.showInfo();
				}
	}
}
