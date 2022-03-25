package ch06;

public class ThreeDPrinter3 {
	private Object material; //우리는 제네릭을 쓰지않으면 이렇게 Object를 써야한다.(변수타입을 다 받기위해서)
		
	public Object getMaterial() {
		return material;
	}

	public void setMaterial(Object material) {
		this.material = material;
	}

}
