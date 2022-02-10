package ch4;

public class VIPCustomer extends Customer{
	private int agentID;
	double salesRatio;
	
	/*public VIPCustomer() {
		customerGrade = "VIP";    //���� �߻�
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		System.out.println("VIPCustomer() ������ ȣ��");
	}
	*/
	
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		//System.out.println("VIPCustomer(int, String) ������ ȣ��");
	}
	
	
	//�������̵��� ������ �Լ���, �Ű�����, Ÿ�Ա��� �� ���ƾ��Ѵ�.
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
		return customerName + "���� ����� " + customerGrade +  
				"�̸�, ���ʽ� ����Ʈ�� " + bonusPoint + "�Դϴ�(vip)";  //���⾲�� �������� �θ��� ������ �����ִ�.
	}
}
