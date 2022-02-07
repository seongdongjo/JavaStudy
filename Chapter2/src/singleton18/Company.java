package singleton18;

public class Company {
	//싱글톤 패턴: 프로그램에서 인스턴스가 단 한 개만 생성되어야 하는 경우 사용하는 디자인 패턴
	//Timezone같은 시간은 인스턴스를 각각 가질수없다. (동일한시간을 가져야하니까)
	//회사라는 객체는 하나여야만한다.(사원도 또 늘어나니까)
	//이런경우 싱글톤패턴이 필요
	
	private static Company instance = new Company(); //유일한 객체를 한번만 미리만들어놓는다.
	
	//컴파일러가 기본으로 생성하는 Company를 마음대로 new할 수 없도록
	private Company() {}
	
	//외부에서 쓸수있도록 static까지 
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
