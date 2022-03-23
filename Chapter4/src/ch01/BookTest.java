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

		Book book = new Book("데미안", "헤르만 헤세");
		
		System.out.println(book); 
		//원래는 ch01.Book@36aa7bc2 (jvm이 준 인스턴스  가상 메모리 값 = 36aa7bc2)
		
		String str = new String("test"); 
		System.out.println(str.toString()); //String의 toString은 이미 재정의 되있어서 출력결과가 test로 나온다.
	}
}
