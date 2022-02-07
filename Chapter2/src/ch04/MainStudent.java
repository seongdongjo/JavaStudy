package ch04;

public class MainStudent {
	public static void main(String[] args) {
		Student studentLee = new Student(); //인스턴스라고한다, 같은 패키지내에서는 import 안한다
		Student studentKim = new Student();
		
		//인스턴스들은(studentLee, studentKim) 동적메모리(Heap)에 할당된다.
		//c나 c++에서는 사용한 동적메모리를 프로그래머가 해제시켜야한다.(free, delete)
		//자바에서는 가비지컬렉터가 주기적으로 사용하지 않는 메모리를 수거한다.
		//하나의 클래스로부터 여러개의 인스턴스가 생성되고 각각 다른 메모리 주소를 가지게 된다.
		
		studentLee.studentID = 12345;
		studentLee.setStudentName("Lee");
		studentLee.address = "서울 강남구";
		
		studentLee.showStudentInfo();
		
		System.out.println(studentKim); //ch04.Student@36aa7bc2 -> 객체의 위치를 가리키는(Heap에 있는 인스턴스를 가리킨다) 주소값이다. (물리적 메모리주소가 아니라 JVM이 준 가상 주소)
		//그래서 studentKim. (점.)을 찍음으로써 접근
		System.out.println(studentLee);
		
		//인스턴스 : new 키워드를 사용하여 클래스를 메모리에 생성한 상태
		//참조변수: 메모리에 생성된 인스턴스를 가리키는 변수
		//참조값: 생성된 인스턴스의 메모리 주소값
	}
}
