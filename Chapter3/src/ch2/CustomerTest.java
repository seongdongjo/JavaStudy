package ch2;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customerLee = new Customer();
		customerLee.setCustomerName("이순신");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000; //원래 가지고있던 보너스포인트
		System.out.println(customerLee.showCustomerInfo());
			
			
		VIPCustomer customerKim = new VIPCustomer();  //new VIPCustomer()를 호출하면 Customer()생성자가 먼저 호출된다.
		customerKim.setCustomerName("김유신"); //부모의 메서드
		customerKim.setCustomerID(10020);    //부모의 메서드
		customerKim.bonusPoint = 10000;      //부모의 멤버변수
		System.out.println(customerKim.showCustomerInfo());
	}
}
