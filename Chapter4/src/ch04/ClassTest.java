package ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
						ClassNotFoundException, NoSuchMethodException, SecurityException {
		//기존방식
		Person person = new Person("James");
		System.out.println(person); //James
		
		//동적로딩
		//Class.forName("클래스이름") 메서드로 클래스를 동적으로 로드함(런타임시에)
		
		//Class c = String.class; 클래스 이름으로 직접 Class가져오기
		
		//생성된 인스턴스에서 Class 클래스 가져오기
		//String s = new String();
		//Class c = s.getClass(); 
		
		Class c1 = Class.forName("ch04.Person"); //class를 가져오는 방법 1
		Person person1 = (Person)c1.newInstance(); //반환값이 오브젝트라서
		person1.setName("Lee");
		System.out.println(person1); //Lee 출력(오버라이딩했으니)
		
		//class를 가져오는 방법2
		//아래까지가 실질적으로 Person kim2 = new Person("김유신"); 과 같다.
		//이런거는 local에 Person이라는 클래스가 없을 떄 쓰는것이다.
		Class c2 = person1.getClass(); //getClass를 쓸려면 이미 인스턴스가 있는상태여야한다.
		Person p = (Person)c2.newInstance();
		System.out.println(p); //null출력
		
		Class[] parameterTypes = {String.class};  //person이라는 타입의 클래스가 없는데 
		Constructor cons = c2.getConstructor(parameterTypes); //constructor정보를 가져와서 반환해준다. 
		
		Object[] initargs = {"김유신"};
		Person personLee = (Person)cons.newInstance(initargs);
		System.out.println(personLee); //김유신 출력
		
		//이런게 reflection 프로그래밍인데
		//Class 클래스를 사용하여 클래스의 정보(생성자, 변수, 메서드)등을 알수있고 인스턴스를 생성하고, 메서드를 호출하는 방식의 프로그래밍
		//로컬메모리에 객체없는경우, 원격프로그래밍, 객체의 타입을 알수없는 경우에 사용
		
		
	}
}
