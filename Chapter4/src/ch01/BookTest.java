package ch01;

class Book{ //(extends Object)
	
	private String title;
	private String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String toString() {
		return title + "," + author;
	}
}

public class BookTest {

	public static void main(String[] args) {

		Book book = new Book("���̾�", "�츣�� �켼");
		
		System.out.println(book); 
		//������ ch01.Book@36aa7bc2 (jvm�� �� �ν��Ͻ�  ���� �޸� �� = 36aa7bc2)
		
		String str = new String("test"); 
		System.out.println(str.toString()); //String�� toString�� �̹� ������ ���־ ��°���� test�� ���´�.
	}
}
