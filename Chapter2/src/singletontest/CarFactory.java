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
		
		//공장안에서 Car를 만들기 때문에
		public Car createCar() { //반환은 Car
			
			Car car = new Car(); 
			return car;
		}
}
