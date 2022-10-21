package mainClass;

public class employee {
	private int id;
	private String employeeName;
	private String password;
	private employee(){
		this.id = 0;
		this.employeeName = "";
		this.password = "";
	}
	public employee (String employeeName,  String password) {
		this.id = 0;
		this.employeeName = employeeName;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
