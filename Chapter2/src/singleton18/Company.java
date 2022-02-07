package singleton18;

public class Company {
	//�̱��� ����: ���α׷����� �ν��Ͻ��� �� �� ���� �����Ǿ�� �ϴ� ��� ����ϴ� ������ ����
	//Timezone���� �ð��� �ν��Ͻ��� ���� ����������. (�����ѽð��� �������ϴϱ�)
	//ȸ���� ��ü�� �ϳ����߸��Ѵ�.(����� �� �þ�ϱ�)
	//�̷���� �̱��������� �ʿ�
	
	private static Company instance = new Company(); //������ ��ü�� �ѹ��� �̸��������´�.
	
	//�����Ϸ��� �⺻���� �����ϴ� Company�� ������� new�� �� ������
	private Company() {}
	
	//�ܺο��� �����ֵ��� static���� 
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
