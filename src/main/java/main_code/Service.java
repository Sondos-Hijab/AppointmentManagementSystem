package main_code;

public class Service {
	private String serviceId;
	private String serviceName;
	private String employeeId;
	private int price;
	private int time;
	public Service(){
		this.serviceName = "";
		this.employeeId = "";
		this.price = 0;
		this.time = 0;
	}
	public Service (String serviceId ,String serviceName,  String employeeId, int price , int time) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.employeeId = employeeId;
		this.price = price;
		this.time = time;
	}

	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

}
