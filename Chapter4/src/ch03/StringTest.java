package ch03;

public class StringTest {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		
		//즉, hashCode값이 같다면 객체는 달라도 문자열이 같은것을 의미한다.
		//반면에 System.identityHashCode()는 오버라이드가 안되며 객체의 고유한 hashCode를 리턴합니다. 객체 자체를 비교하려면 이 메소드를 사용하는 것이 좋습니다.
		System.out.println(str1.hashCode()); //hashcode는 같다. 왜? str1과str2는 다른객체이긴하지만 String클래스에서 자동으로 hashCode오버라이딩된것을 보면 문자열값으로 hashCode를 만들기때문에 값은 같다. 
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1)); //주소값은 다르다
		System.out.println(System.identityHashCode(str2)); //주소값은 다르다.
		System.out.println(str1 == str2);
		
		String str3 = "abc";
		String str4 = "abc";
		
		System.out.println(str3 == str4);
	}
}
