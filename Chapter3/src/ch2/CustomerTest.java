package ch2;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customerLee = new Customer();
		customerLee.setCustomerName("�̼���");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000; //���� �������ִ� ���ʽ�����Ʈ
		System.out.println(customerLee.showCustomerInfo());
			
			
		VIPCustomer customerKim = new VIPCustomer();  //new VIPCustomer()�� ȣ���ϸ� Customer()�����ڰ� ���� ȣ��ȴ�.
		customerKim.setCustomerName("������"); //�θ��� �޼���
		customerKim.setCustomerID(10020);    //�θ��� �޼���
		customerKim.bonusPoint = 10000;      //�θ��� �������
		System.out.println(customerKim.showCustomerInfo());
	}
}
