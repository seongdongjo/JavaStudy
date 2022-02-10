package ch6;

public class GoldCustomer extends Customer{

	double saleRatio;
		
		public GoldCustomer(int customerID, String customerName){
			super(customerID, customerName);
		
			customerGrade = "GOLD"; //부모의 멤버변수니까 showInfo는 오버라이딩 안했음. 
			bonusRatio = 0.02;   	//부모의 멤버변수
			saleRatio = 0.1;
		
		}
		@Override
		public int calcPrice(int price){
			bonusPoint += price * bonusRatio;
			return price - (int)(price * saleRatio);
		}
}
