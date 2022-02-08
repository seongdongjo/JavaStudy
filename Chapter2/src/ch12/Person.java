package ch12;

public class Person {
	String name;
	int age;
	
	public Person() {
		//age = 10;
		//name = "test"
		//this���� ���� �ȵȴ�. ��ü�� ��������� ���̱� ������
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
		return this; //�����ڸ� ȣ��
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		person.showPerson(); //no name, 1
		
		System.out.println(person);  //ch12.Person@1175e2db
		
		Person person2 = person.getPerson(); //person2�� person�� �ٶ󺻴�.
		System.out.println(person2); //ch12.Person@1175e2db ����.  this == main�� Person �� ���� Heap������ Person�� ����Ų��
		
	}
}
