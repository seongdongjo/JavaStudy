package ch6;

public class GoldCustomer extends Customer{

	double saleRatio;
		
		public GoldCustomer(int customerID, String customerName){
			super(customerID, customerName);
		
			customerGrade = "GOLD"; //�θ��� ��������ϱ� showInfo�� �������̵� ������. 
			bonusRatio = 0.02;   	//�θ��� �������
			saleRatio = 0.1;
		
		}
		@Override
		public int calcPrice(int price){
			bonusPoint += price * bonusRatio;
			return price - (int)(price * saleRatio);
		}
}
