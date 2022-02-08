package ch21;

public class ObjectCopyTest {
	public static void main(String[] args) {
		Book[] library = new Book[5]; //null로 초기화, new한다고 Book개게가 만들어지는게 아니다.
		Book[] copyLibrary = new Book[5];
		
		library[0] = new Book("태백산맥1", "조정래"); //객체를 만들어서 넣어야한다. 
		library[1] = new Book("태백산맥2", "조정래");
		library[2] = new Book("태백산맥3", "조정래");
		library[3] = new Book("태백산맥4", "조정래");
		library[4] = new Book("태백산맥5", "조정래");
		
		System.arraycopy(library, 0, copyLibrary, 0, 5); //library 0번쨰부터 복사해서 copyLibrary의 0에서5까지 넣어라(주소가 같은 상태이다)
	
		//기존 book
		for(Book book : library) {
			System.out.println(book);  //주소가같다.
			book.showInfo();
		}
		
		//복사한
		for(Book book : copyLibrary) { //주소가같다.
			System.out.println(book); 
			book.showInfo();
		}
		
		//주소가같아서 library0번째만 바꿧는데 copyLibrary도 같이 바뀐다.
		library[0].setAuthor("박완서");
		library[0].setTitle("나목");
		
	}
	//이런게 얕은복사이다.
}
