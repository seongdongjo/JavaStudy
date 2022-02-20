package ch10;

public abstract class Car {
	
	public abstract void drive(); //AI, 직접운전은 drive메서드는 자식이 구현해라
	public abstract void stop(); //마찬가지
	
	//시동은 공통이니까 구현했음
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
			
	public void washCar() {} //구현되긴했다.
	
	final public void run() {
		//시동을걸고 운전하다가 일이생기면 멈추고 시동꺼라 -> 시나리오(이거는 변하면안된다) -> run메서드를 재정의하면안되니까 final로 선언
		startCar(); //일반
		drive(); //추상
		stop(); //추상 
		turnOff(); //일반
		washCar(); //재정의할수있게끔(ai에서만 써도됨), 일반자동차는 재정의안했음
	}
}