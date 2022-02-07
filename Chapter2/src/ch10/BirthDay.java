package ch10;

public class BirthDay {
	private int day; //같은 클래스내에서만 접근 -> private
	private int month;
	private int year;
	
	private boolean isVaild; //기본값이 false
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month < 1 || month > 13) {
			isVaild = false;
		}
		else {
			isVaild = true;
			this.month = month;
		}
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void showDate() {
		if(isVaild) { //true이면
			System.out.println(year + "년 " + month + "월 " + day + "일 입니다.");
		}
		else {
			System.out.println("유효하지 않은 날짜입니다.");
		}
	}
}
