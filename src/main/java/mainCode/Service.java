package mainCode;

public class Service {
	private String serviceId;
	private String title;
	private int price;
	private int employeeId;
	private int time;
	
	
	//constructors
	public Service() {
		
	}
	
	public Service(String id, String title, int price, int employeeId, int time) {
		this.serviceId = id;
		this.title = title;
		this.price = price;
		this.employeeId = employeeId;
		this.time = time;
	}
	
	
	
	//getters and setters
	public String getId() {
		return serviceId;
	}

	public int getPrice() {
		return price;
	}
	
	public int getTime() {
		return time;
	}

	
	
}
