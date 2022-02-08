package ch21;

public class ObjectCopyTest2 {
	public static void main(String[] args) {
		Book[] library = new Book[5]; 
		Book[] copyLibrary = new Book[5];
		
		library[0] = new Book("태백산맥1", "조정래");
		library[1] = new Book("태백산맥2", "조정래");
		library[2] = new Book("태백산맥3", "조정래");
		library[3] = new Book("태백산맥4", "조정래");
		library[4] = new Book("태백산맥5", "조정래");
		
		//깊은 복사 방식
		copyLibrary[0] = new Book();
		copyLibrary[1] = new Book();
		copyLibrary[2] = new Book();
		copyLibrary[3] = new Book();
		copyLibrary[4] = new Book();
		
		for(int i =0; i<library.length; i++) {
			copyLibrary[i].setAuthor(library[i].getAuthor());
			copyLibrary[i].setTitle(library[i].getTitle());
		}
		
		
		//주소가같아서 library0번째만 바꿧는데 copyLibrary[0]는 안바뀐다.
		library[0].setAuthor("박완서");
		library[0].setTitle("나목");
		
				//기존 book
				for(Book book : library) {
					System.out.println(book);  //주소가다르다
					book.showInfo();
				}
				
				//복사한
				for(Book book : copyLibrary) { //주소가 다르다
					System.out.println(book); 
					book.showInfo();
				}
	}
}
