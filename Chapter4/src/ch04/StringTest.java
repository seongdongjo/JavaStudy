package ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c3 =  Class.forName("java.lang.String");
		
		//c.getConstructors(); 배열로반환된다
		
		Constructor<String>[] cons =  c3.getConstructors();
		for(Constructor con: cons) {
			System.out.println(con); //많은생성자가 있다. 
		}
		
		System.out.println();
		
		Method[] methods = c3.getMethods();
		for(Method  method : methods) {
			System.out.println(method);
		}
	}

}
