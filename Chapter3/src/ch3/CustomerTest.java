package ch3;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customerLee = new Customer(); //����Ʈ ������
		customerLee.setCustomerName("�̼���");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000; //���� �������ִ� ���ʽ�����Ʈ
		System.out.println(customerLee.showCustomerInfo());
		
		Customer customerLee2 = new Customer(10030, "ȫ�浿");
		//customerLee.setCustomerName("ȫ�浿");
		//customerLee.setCustomerID(10010);
		customerLee2.bonusPoint = 1000; //���� �������ִ� ���ʽ�����Ʈ
		System.out.println(customerLee2.showCustomerInfo());
			
			
		VIPCustomer customerKim = new VIPCustomer();  //new VIPCustomer()�� ȣ���ϸ� Customer()�����ڰ� ���� ȣ��ȴ�.
		customerKim.setCustomerName("������"); //�θ��� �޼���
		customerKim.setCustomerID(10020);    //�θ��� �޼���
		customerKim.bonusPoint = 10000;      //�θ��� �������
		System.out.println(customerKim.showCustomerInfo());
		
		VIPCustomer customerKim2 = new VIPCustomer(10040, "������"); 
		//customerKim.setCustomerName("������"); //�θ��� �޼���
		//customerKim.setCustomerID(10020);    //�θ��� �޼���
		customerKim2.bonusPoint = 10000;      //�θ��� �������
		System.out.println(customerKim2.showCustomerInfo());
	}
	
	//��ĳ����
	//Customer customerLee = new VIPCustomer();
	//customerLee.  ���� �����ִ°ɺ��� Customer�� �����ִ�.
}
