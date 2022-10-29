package mainClass;

public class Reservations {
	private int id;
	private String serviceName;
	private String employeeId;
	private String userId;
	private String serviceId;
	private String price;
	private String time;
	private String start_time;
	private String end_time;	
	private String day;
	private String month;
	private String year;
	service s;
	public Reservations(){
		this.serviceName = "";
		this.employeeId = "";
		this.userId = "";
		this.serviceId = "";
		this.price = "";
		this.time = "";
		this.start_time = "";
		this.end_time = "";
		this.day = "";
		this.month = "";
		this.year = "";

	}
	public Reservations (String serviceName,  String employeeId, String userId ,String serviceId ,
			String price , String time , String start_time , String end_time ,String day , String month , String year) {
		//this.s = new service(serviceName,employeeId, price ,time );
		this.serviceName = serviceName;
		this.employeeId = employeeId;
		this.userId = userId;
		this.serviceId = serviceId;
		this.price = price;
		this.time = time;
		this.start_time = start_time;
		this.end_time = end_time;
		this.day = day;
		this.month = month;
		this.year = year;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getStartTime() {
		return start_time;
	}
	public void setStartTime(String start_time) {
		this.start_time = start_time;
	}
	public String getEndTime() {
		return end_time;
	}
	public void setEndTime(String end_time) {
		this.end_time = end_time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceId() {
		return serviceId;
	}
	


}
