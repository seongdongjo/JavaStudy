package ch2;

//���࿡ VIPCustomer Ŭ�������� Customer�θ� ������� if�������� gold,silver �з��ؼ� ������, �� �䱸������ ����� ��� if�� ���� �ʹ� ���ŷӴ�.
//�׷��� VIPCustomer�� ������ �A��.
public class VIPCustomer extends Customer{
	private int agentID;
	double salesRatio; //VIP���� �ִ� ����
	
	public VIPCustomer() {
		//super();
		customerGrade = "VIP";    //���� �߻� -> extends�� �ؾ��Ѵ�(protected��), private�� extends�ص� �ȵ�.
		bonusRatio = 0.05; //�������� 
		salesRatio = 0.1;
	}
	
	public int getAgentID() {
		return agentID;
	}
}
