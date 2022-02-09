package ch4;

public class CustomerTest {
	public static void main(String[] args) {
			//함수의 이름이 주소값이다.
		 	//메서드는 명령어의 set이고 프로그램이 로드되면 메서드 영역(코드영역)에 명령어 set이 위치
			//해당 메서드가 호출되면 명령어 set이 있는 주소를 찾아 명령어가 실행됨
			//이때 메서드에서 사용하는 변수들은 스택메모리에 위치한다
			//따라서 다른 인스턴스라도 같은 메서드의 코드는 같으므로 같은 메서드가 호출됨
			//인스턴스가 생성되면 변수는 힙메모리에 따로 생성되지만, 메서드 명령어 set은 처음 한번만 로드됨
		
			//가상메소드란
			//상속에서 상위클래스와 하위 클래스에 같은 이름의 메서드가 존재할 때 호출되는 메소드는 인스턴스에 따라 결정된다.
			//선언한 클래스형이 아닌 생성된 인스턴스의 메서드를 호출하는것
			//그떄, 인스턴스의 메서드가 호출되는 기술을 가상메서드라고한다.
		
			//같은 객체의 인스턴스를 여러개 생성한다고 해서 메소드도 여러개 생성되지 않는다.
			//즉, new Customer 를 여러번한다고 해서 a라는 메서드가 여러개 생성되지 않는다.(하나를 공유(메모리주소로))
			//예외적으로 사용하는 지역변수는 stack에 생성되서 잡힘
		
			Customer customerLee = new Customer(10010, "이순신");
			customerLee.bonusPoint = 1000;
			System.out.println(customerLee.showCustomerInfo());
			
			VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
			customerKim.bonusPoint = 10000;
			System.out.println(customerKim.showCustomerInfo());
			
			int priceLee = customerLee.calcPrice(10000); //구입가격대입
			int priceKim = customerKim.calcPrice(10000); //구입가격대입
			
			System.out.println(customerLee.showCustomerInfo() + " 지불금액은 " + priceLee + "원 입니다.");
			System.out.println(customerKim.showCustomerInfo() + " 지불금액은 " + priceKim + "원 입니다.");
			
			//업캐스팅
			Customer customerNo = new VIPCustomer(10030, "나몰라"); 
			customerNo.bonusPoint = 10000;
			int priceNo = customerNo.calcPrice(10000); //오버라이딩한 VIPCustomer를 찾아간다.
			System.out.println(customerNo.showCustomerInfo() + " 지불금액은 " + priceNo  + "원 입니다."); //오버라이딩한 show를 찾아간다
			
			//나몰라님의 등급은 VIP이며, 보너스 포인트는 10500입니다 지불금액은 9000원 입니다.
		}
}
