package ch6;

import java.util.ArrayList;
//��������, ��Ӱ� ���Ҿ� �������� ��ü���� ���α׷����� ���� ū Ư¡ �� �ϳ��̴�.
class Animal{
	
	public void move() {
		System.out.println("������ �����Դϴ�.");
	}
	
	public void eating() {
		
	}
}

class Human extends Animal{
	@Override
	public void move() {
		System.out.println("����� �ι߷� �Ƚ��ϴ�.");
	}
	
	public void readBooks() {
		System.out.println("����� å�� �н��ϴ�.");
	}
}

class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("ȣ���̰� �� �߷� �ݴϴ�.");
	}
	
	public void hunting() {
		System.out.println("ȣ���̰� ����� �մϴ�.");
	}
}


class Eagle extends Animal{
	@Override
	public void move() {
		System.out.println("�������� �ϴ��� ���ư��ϴ�.");
	}
	
	public void flying() {
		System.out.println("�������� ������ �� ��� �ָ� ���ư��ϴ�");
	}
}

public class AnimalTest {
	public static void main(String[] args) {

		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		//��¹�� 1
		AnimalTest test = new AnimalTest();
		test.moveAnimal(hAnimal);
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);
		
		
		//��¹��2
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);
		
		for(Animal animal : animalList) {
			animal.move();
		}
	}	
	//main�ۿ��� �Լ������ؾ��Ѵ�.
	public void moveAnimal(Animal animal) {
		animal.move(); //�̷��� �������̴�. ���� move��� �޼��������� ��°���� �ٸ���.
		
	}
	
}
