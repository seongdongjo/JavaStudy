package ch4;

public class CustomerTest {
	public static void main(String[] args) {
			//�Լ��� �̸��� �ּҰ��̴�.
		 	//�޼���� ��ɾ��� set�̰� ���α׷��� �ε�Ǹ� �޼��� ����(�ڵ念��)�� ��ɾ� set�� ��ġ
			//�ش� �޼��尡 ȣ��Ǹ� ��ɾ� set�� �ִ� �ּҸ� ã�� ��ɾ �����
			//�̶� �޼��忡�� ����ϴ� �������� ���ø޸𸮿� ��ġ�Ѵ�
			//���� �ٸ� �ν��Ͻ��� ���� �޼����� �ڵ�� �����Ƿ� ���� �޼��尡 ȣ���
			//�ν��Ͻ��� �����Ǹ� ������ ���޸𸮿� ���� ����������, �޼��� ��ɾ� set�� ó�� �ѹ��� �ε��
		
			//����޼ҵ��
			//��ӿ��� ����Ŭ������ ���� Ŭ������ ���� �̸��� �޼��尡 ������ �� ȣ��Ǵ� �޼ҵ�� �ν��Ͻ��� ���� �����ȴ�.
			//������ Ŭ�������� �ƴ� ������ �ν��Ͻ��� �޼��带 ȣ���ϴ°�
			//�׋�, �ν��Ͻ��� �޼��尡 ȣ��Ǵ� ����� ����޼������Ѵ�.
		
			//���� ��ü�� �ν��Ͻ��� ������ �����Ѵٰ� �ؼ� �޼ҵ嵵 ������ �������� �ʴ´�.
			//��, new Customer �� �������Ѵٰ� �ؼ� a��� �޼��尡 ������ �������� �ʴ´�.(�ϳ��� ����(�޸��ּҷ�))
			//���������� ����ϴ� ���������� stack�� �����Ǽ� ����
		
			Customer customerLee = new Customer(10010, "�̼���");
			customerLee.bonusPoint = 1000;
			System.out.println(customerLee.showCustomerInfo());
			
			VIPCustomer customerKim = new VIPCustomer(10020, "������");
			customerKim.bonusPoint = 10000;
			System.out.println(customerKim.showCustomerInfo());
			
			int priceLee = customerLee.calcPrice(10000); //���԰��ݴ���
			int priceKim = customerKim.calcPrice(10000); //���԰��ݴ���
			
			System.out.println(customerLee.showCustomerInfo() + " ���ұݾ��� " + priceLee + "�� �Դϴ�.");
			System.out.println(customerKim.showCustomerInfo() + " ���ұݾ��� " + priceKim + "�� �Դϴ�.");
			
			//��ĳ����
			Customer customerNo = new VIPCustomer(10030, "������"); 
			customerNo.bonusPoint = 10000;
			int priceNo = customerNo.calcPrice(10000); //�������̵��� VIPCustomer�� ã�ư���.
			System.out.println(customerNo.showCustomerInfo() + " ���ұݾ��� " + priceNo  + "�� �Դϴ�."); //�������̵��� show�� ã�ư���
			
			//��������� ����� VIP�̸�, ���ʽ� ����Ʈ�� 10500�Դϴ� ���ұݾ��� 9000�� �Դϴ�.
		}
}
