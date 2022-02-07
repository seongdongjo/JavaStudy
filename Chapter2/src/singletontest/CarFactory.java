package singletontest;

public class CarFactory {
	private static CarFactory instance = new CarFactory();
		
		private CarFactory() {}
		
		public static CarFactory getInstance() {
			if(instance == null) {
				instance = new CarFactory();
			}
			return instance;
		}
		
		//����ȿ��� Car�� ����� ������
		public Car createCar() { //��ȯ�� Car
			
			Car car = new Car(); 
			return car;
		}
}
