package ch3;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customerLee = new Customer(); //디폴트 생성자
		customerLee.setCustomerName("이순신");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000; //원래 가지고있던 보너스포인트
		System.out.println(customerLee.showCustomerInfo());
		
		Customer customerLee2 = new Customer(10030, "홍길동");
		//customerLee.setCustomerName("홍길동");
		//customerLee.setCustomerID(10010);
		customerLee2.bonusPoint = 1000; //원래 가지고있던 보너스포인트
		System.out.println(customerLee2.showCustomerInfo());
			
			
		VIPCustomer customerKim = new VIPCustomer();  //new VIPCustomer()를 호출하면 Customer()생성자가 먼저 호출된다.
		customerKim.setCustomerName("김유신"); //부모의 메서드
		customerKim.setCustomerID(10020);    //부모의 메서드
		customerKim.bonusPoint = 10000;      //부모의 멤버변수
		System.out.println(customerKim.showCustomerInfo());
		
		VIPCustomer customerKim2 = new VIPCustomer(10040, "강지은"); 
		//customerKim.setCustomerName("김유신"); //부모의 메서드
		//customerKim.setCustomerID(10020);    //부모의 메서드
		customerKim2.bonusPoint = 10000;      //부모의 멤버변수
		System.out.println(customerKim2.showCustomerInfo());
	}
	
	//업캐스팅
	//Customer customerLee = new VIPCustomer();
	//customerLee.  으로 쓸수있는걸보면 Customer만 쓸수있다.
}
