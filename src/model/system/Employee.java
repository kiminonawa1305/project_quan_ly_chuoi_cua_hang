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

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param numberPhone the numberPhone to set
	 */
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * @param baseSalary the baseSalary to set
	 */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
}