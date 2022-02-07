package ch10;

public class BirthDay {
	private int day; //���� Ŭ������������ ���� -> private
	private int month;
	private int year;
	
	private boolean isVaild; //�⺻���� false
	
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
		if(isVaild) { //true�̸�
			System.out.println(year + "�� " + month + "�� " + day + "�� �Դϴ�.");
		}
		else {
			System.out.println("��ȿ���� ���� ��¥�Դϴ�.");
		}
	}
}
