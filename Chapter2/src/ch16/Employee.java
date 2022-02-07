package ch16;

public class Employee {
	//static변수는 프로그램이 실행되면서 메모리에 로드될때 같이 적재된다. (객체 생성 전)
	public static int serialNum = 1000; //public이라서 외부에서 클래스.serialNum 접근가능했다
	
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
