package ch3;

//만약에 VIPCustomer 클래스없이 Customer로만 만들려면 if문돌려서 gold,silver 분류해서 할인율, 또 요구조건이 생기면 계속 if문 쓰면 너무 번거롭다.
//그래서 VIPCustomer로 별도로 뺸다.
public class VIPCustomer extends Customer{
	private int agentID;
	double salesRatio; //VIP에만 있는 변수
	
	public VIPCustomer() {
		//super();
		customerGrade = "VIP"; 
		bonusRatio = 0.05;
		salesRatio = 0.1;
	}
	
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "VIP"; //덮어쓰기 super()에서 정의된 customerGrade를   
		bonusRatio = 0.05; //마찬가지로 덮어쓰기
		salesRatio = 0.1;
		//아직 보너스포인트, 가격은 정의안함
	}
	
	public int getAgentID() {
		return agentID;
	}
}
