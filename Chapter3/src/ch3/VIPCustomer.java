package ch3;

//���࿡ VIPCustomer Ŭ�������� Customer�θ� ������� if�������� gold,silver �з��ؼ� ������, �� �䱸������ ����� ��� if�� ���� �ʹ� ���ŷӴ�.
//�׷��� VIPCustomer�� ������ �A��.
public class VIPCustomer extends Customer{
	private int agentID;
	double salesRatio; //VIP���� �ִ� ����
	
	public VIPCustomer() {
		//super();
		customerGrade = "VIP"; 
		bonusRatio = 0.05;
		salesRatio = 0.1;
	}
	
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "VIP"; //����� super()���� ���ǵ� customerGrade��   
		bonusRatio = 0.05; //���������� �����
		salesRatio = 0.1;
		//���� ���ʽ�����Ʈ, ������ ���Ǿ���
	}
	
	public int getAgentID() {
		return agentID;
	}
}
