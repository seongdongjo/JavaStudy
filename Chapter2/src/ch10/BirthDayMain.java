package ch10;

public class BirthDayMain {
	public static void main(String[] args) {
		BirthDay date = new BirthDay();
		date.setYear(2019);
		
		//private�� ���������� date.month = 100 �̷��� ������ ������� �ٷ� ���԰����ϱ� �����̴�.
		//�׷��� setter�� ���� ������ �ɾ���.
		
		//date.setMonth(13);  month�� 1~12���̰� �ƴѰ��� ó�� xx, BirthDayŬ�������� ó���ߴ�, ��ȿ���� ���� ��¥��� ���.
		date.setDay(30);
	}
}
