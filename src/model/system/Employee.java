package model.system;


public class Employee {
	private String id, name, numberPhone, address, sex;
	private Date birthDate, dateStart;
	private double baseSalary;

	public Employee(String id, String name, Date birthDate, String sex, String address, String numberPhone,
			double baseSalary, Date dateStart) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.sex = sex;
		this.numberPhone = numberPhone;
		this.address = address;
		this.baseSalary = baseSalary;
		this.dateStart = dateStart;
	}

	public boolean equalsID(String id2) {
		return this.id.equalsIgnoreCase(id2);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public String getAddress() {
		return address;
	}

	public String getSex() {
		return sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public double getBaseSalary() {
		return baseSalary;
	}
}