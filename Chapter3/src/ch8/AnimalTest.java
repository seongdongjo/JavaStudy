package ch8;

import java.util.ArrayList;

//다운캐스팅은 명시적으로 해야한다.
//Customer vc = new VIPCustomer(); 묵시적
//VIPCustomer vCustomer = (VIPCustomer)vc; 명시적

	class Animal{
		
		public void move() {
			System.out.println("동물이 움직입니다.");
		}
		
		public void eating() {
			
		}
	}

	class Human extends Animal{
		public void move() {
			System.out.println("사람이 두발로 걷습니다.");
		}
		
		public void readBooks() {
			System.out.println("사람이 책을 읽습니다.");
		}
	}

	class Tiger extends Animal{
		
		public void move() {
			System.out.println("호랑이가 네 발로 뜁니다.");
		}
		
		public void hunting() {
			System.out.println("호랑이가 사냥을 합니다.");
		}
	}


	class Eagle extends Animal{
		public void move() {
			System.out.println("독수리가 하늘을 날아갑니다.");
		}
		
		public void flying() {
			System.out.println("독수리가 날개를 쭉 펴고 멀리 날아갑니다");
		}
	}
public class AnimalTest {
	public static void main(String[] args) {
		Animal hAnimal = new Human();  
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		/*AnimalTest test = new AnimalTest();
		test.moveAnimal(hAnimal);  //함수에전달(다형성)
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);
		*/
		
		//다운캐스팅
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);
		
		AnimalTest test = new AnimalTest();
		test.testDownCasting(animalList);
		
		
		
	/*	for(Animal animal : animalList) {
			animal.move();
		}
		*/	
	}
	
	//다시 원래 자기타입으로 되돌리고 싶으면 다운캐스팅 쓰고 그게아니면 그냥 다형성을 쓰는게 좋다 (moveAnimal 함수처럼)
	public void testDownCasting(ArrayList<Animal> list) {
			
			for(int i =0; i<list.size(); i++) {
				Animal animal = list.get(i);
			
				if ( animal instanceof Human) { //animal이 Human타입이냐
					Human human = (Human)animal;
					human.readBooks();
				}
				else if( animal instanceof Tiger) {
					Tiger tiger = (Tiger)animal;
					tiger.hunting();
				}
				else if( animal instanceof Eagle) {
					Eagle eagle = (Eagle)animal;
					eagle.flying();
				}
				else {
					System.out.println("error");
				}
			
			}
		}
	
	
	
		public void moveAnimal(Animal animal) {
			animal.move();
			
		}
	}
