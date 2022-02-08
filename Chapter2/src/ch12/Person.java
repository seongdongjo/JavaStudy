package ch12;

public class Person {
	String name;
	int age;
	
	public Person() {
		//age = 10;
		//name = "test"
		//this위에 쓰면 안된다. 객체가 만들어지기 전이기 때문에
		this("no name", 1);
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void showPerson() {
		System.out.println(name + ", " + age);
	}
	public Person getPerson() {
		return this; //생성자를 호출
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		person.showPerson(); //no name, 1
		
		System.out.println(person);  //ch12.Person@1175e2db
		
		Person person2 = person.getPerson(); //person2도 person을 바라본다.
		System.out.println(person2); //ch12.Person@1175e2db 같다.  this == main의 Person 이 같은 Heap공간의 Person을 가리킨다
		
	}
}
