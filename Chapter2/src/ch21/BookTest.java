package ch21;

public class BookTest {

	public static void main(String[] args) {
		Book[] library = new Book[5]; //null로 초기화, new한다고 Book개게가 만들어지는게 아니다.
		
		library[0] = new Book("태백산맥1", "조정래"); //객체를 만들어서 넣어야한다. 
		library[1] = new Book("태백산맥2", "조정래");
		library[2] = new Book("태백산맥3", "조정래");
		library[3] = new Book("태백산맥4", "조정래");
		library[4] = new Book("태백산맥5", "조정래");
		
		for(Book book : library) {
			System.out.println(book); //ch21.Book@36aa7bc2  처럼 각기다른 5개 나옴
			book.showInfo();
		}
		
		
	}

}
