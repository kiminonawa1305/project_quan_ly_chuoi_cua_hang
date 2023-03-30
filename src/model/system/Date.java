package model.system;

public class Date {
	private int day, month, year;
	
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(String date) {
		day = Integer.parseInt(date.split("/")[0]);
		month = Integer.parseInt(date.split("/")[1]);
		year = Integer.parseInt(date.split("/")[2]);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	
}
