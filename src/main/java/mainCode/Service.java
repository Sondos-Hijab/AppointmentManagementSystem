package mainCode;

public class Service {
	private int id;
	private String title;
	private int price;
	private int employeeId;
	private int time;
	
	
	//constructors
	public Service() {
		
	}
	
	public Service(int id, String title, int price, int employeeId, int time) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.employeeId = employeeId;
		this.time = time;
	}
	
	//printing service function
	public void print() {
		System.out.println("Service Id = "+this.id+"  Service Title = "+this.title+"  Service Price = "+this.price);
	}
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}
