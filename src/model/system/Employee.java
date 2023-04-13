package model.system;


public class Employee {
	private String id, name, numberPhone, address;
	private Date birthDate, dateStart;
	private Sex sex;
	private int baseSalary;

	public Employee(String id, String name, Date birthDate, Sex sex, String address, String numberPhone,
			int baseSalary, Date dateStart) {
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
	
	public Employee() {
		
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

	public Sex getSex() {
		return sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	
}