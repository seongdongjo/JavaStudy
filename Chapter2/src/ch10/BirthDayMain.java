package ch10;

public class BirthDayMain {
	public static void main(String[] args) {
		BirthDay date = new BirthDay();
		date.setYear(2019);
		
		//private를 쓰는이유는 date.month = 100 이렇게 범위를 벗어난값을 바로 대입가능하기 때문이다.
		//그래서 setter를 통해 제약을 걸었다.
		
		//date.setMonth(13);  month가 1~12사이가 아닌것은 처리 xx, BirthDay클래스에서 처리했다, 유효하지 않은 날짜라고 뜬다.
		date.setDay(30);
	}
}
