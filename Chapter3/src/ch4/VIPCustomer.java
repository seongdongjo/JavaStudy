package ch4;

public class VIPCustomer extends Customer{
	private int agentID;
	double salesRatio;
	
	/*public VIPCustomer() {
		customerGrade = "VIP";    //오류 발생
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		System.out.println("VIPCustomer() 생성자 호출");
	}
	*/
	
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		//System.out.println("VIPCustomer(int, String) 생성자 호출");
	}
	
	
	//오버라이딩의 조건은 함수명, 매개변수, 타입까지 다 같아야한다.
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}



	public int getAgentID() {
		return agentID;
	}
	
	@Override
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade +  
				"이며, 보너스 포인트는 " + bonusPoint + "입니다(vip)";  //여기쓰인 변수들은 부모의 변수를 쓰고있다.
	}
}
