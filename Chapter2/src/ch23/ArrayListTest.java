package ch23;

import java.util.ArrayList;

import ch21.Book;

public class ArrayListTest {

	public static void main(String[] args) {
		//���� �迭����� ���̰� �����̶� �迭�� ���̰� Ŀ���� �迭�� ���Ҵ��ϰ� �����ؾ��ߴ�.
		//ArrayList�� ����
		
		ArrayList<Book> library = new ArrayList<Book>(); //book��ü�� ����Ű�� �ּҰ� array�������� ����ڴ�.
				
				library.add(new Book("�¹���1", "������"));
				library.add(new Book("�¹���2", "������"));
				library.add(new Book("�¹���3", "������"));
				library.add(new Book("�¹���4", "������"));
				library.add(new Book("�¹���5", "������"));
				
				for(int i =0; i<library.size(); i++) {
					library.get(i).showInfo();
				}
			}

}
