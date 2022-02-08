package ch23;

import java.util.ArrayList;

import ch21.Book;

public class ArrayListTest {

	public static void main(String[] args) {
		//기존 배열방식은 길이가 고정이라서 배열의 길이가 커지면 배열을 재할당하고 복사해야했다.
		//ArrayList는 동적
		
		ArrayList<Book> library = new ArrayList<Book>(); //book객체를 가리키는 주소가 array형식으로 만들겠다.
				
				library.add(new Book("태백산맥1", "조정래"));
				library.add(new Book("태백산맥2", "조정래"));
				library.add(new Book("태백산맥3", "조정래"));
				library.add(new Book("태백산맥4", "조정래"));
				library.add(new Book("태백산맥5", "조정래"));
				
				for(int i =0; i<library.size(); i++) {
					library.get(i).showInfo();
				}
			}

}
