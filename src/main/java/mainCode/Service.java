package mainCode;

public class Service {
	public String number;
	public String name;
	public String hour;
	public String day;
	public String month;
	public String year;
	
public Service() {
		
	}
public Service (String number , String name, String hour , String day, String month , String year) {
	this.number = number;
	this.name = name;
	this.hour = hour;
	this.day = day;
	this.month = month;
	this.year = year;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getHour() {
	return hour;
}
public void setHour(String hour) {
	this.hour = hour;
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
}
