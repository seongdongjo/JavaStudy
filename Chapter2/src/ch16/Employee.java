package ch16;

public class Employee {
	//static������ ���α׷��� ����Ǹ鼭 �޸𸮿� �ε�ɶ� ���� ����ȴ�. (��ü ���� ��)
	public static int serialNum = 1000; //public�̶� �ܺο��� Ŭ����.serialNum ���ٰ����ߴ�
	
		private int employeeId;
		private String employeeName;
		private String department;
			
		public Employee()
		{
			serialNum++;
			employeeId = serialNum;
		}
		
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
}
