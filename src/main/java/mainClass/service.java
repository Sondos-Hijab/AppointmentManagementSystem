package mainClass;

public class service {
	private int id;
	private String serviceName;
	private String employeeId;
	private String price;
	private String time;
	private service(){
		this.serviceName = "";
		this.employeeId = "";
		this.price = "";
		this.time = "";
	}
	public service (String id ,String serviceName,  String employeeId, String price , String time) {
		this.id = Integer.parseInt(id);
		this.serviceName = serviceName;
		this.employeeId = employeeId;
		this.price = price;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
