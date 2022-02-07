package singleton18;

import java.util.Calendar;

public class CompanyTest {
	public static void main(String[] args) {
		Company company1 = Company.getInstance(); //static이라 클래스로 접근
		Company company2 = Company.getInstance();
		
		System.out.println(company1); //값이 같다.
		System.out.println(company2);
		
		Calendar calendar = Calendar.getInstance(); //이것도 마찬가지
		
	}
}
