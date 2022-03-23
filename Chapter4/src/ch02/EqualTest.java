package ch02;

public class EqualTest {

	public static void main(String[] args) throws CloneNotSupportedException { //cloneable하지않는데 clone할때 예외발생처리
		Student Lee = new Student(100, "Lee");
		Student Lee2 = Lee;
		Student Shun = new Student(100, "Lee");
		
		System.out.println(Lee == Shun); // 같은 클래스로 만들었지만 false로 나온다. 다른 객체이기때문에
		System.out.println(Lee.equals(Shun)); //재정의 안하면 false로 나온다. equals의 원래 재정의를 안하면 주소값이 같느냐를 보는것이다. 근데 우리는 재정의를 했다
		System.out.println(Lee == Lee2); //true
		
		System.out.println(Lee.hashCode()); //917~  서로 메모리주소가 다르기때문에
		System.out.println(Shun.hashCode()); //199~ 다른값이 나온다.
		//하지만 우리가 hashCode()를 재정의 했기때문에 같은값이나온다(Studentid)
		
		//그렇다고 기존에 가지고있던 hashCode()는 없어지지 않는다.
		//System.out.println(System.identityHashCode(Lee));
		//System.out.println(System.identityHashCode(Shun));
		
		//이와같은 방법으로 Integer, String도 위와같이 equals, hashCode가 오버라이딩이 되어있다.
		//그래서 아래와같이 나온다.
		Integer i1 = new Integer(100); //String str1 = new String("abc");
		Integer i2 = new Integer(100); //String str2 = new String("abc");
		
		System.out.println(i1.equals(i2)); //true
		System.out.println(i1.hashCode()); //100
		System.out.println(i2.hashCode()); //100
		
		System.out.println(System.identityHashCode(i1)); //주소값은 다르다
		System.out.println(System.identityHashCode(i2)); //주소값은 다르다.
		
		Lee.setStudentName("kim");
		Student Lee3 = (Student)Lee.clone(); //클론의 return타입은 object이기때문에 다운캐스팅
		System.out.println(Lee3); //100,kim 으로 나온다. 즉, 복제하면 다가져온다.
		
		System.out.println(System.identityHashCode(Lee)); //복제를 해도 주소값은다르다.
		System.out.println(System.identityHashCode(Lee3)); //값은 다르다.
		
		
		
	}
}
