package model.system;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import model.beverage.Beverage;
import model.beverage.BeverageDecorator;
import model.food.Food;
import model.food.FoodDecorator;
import model.pay.PayOption;

@SuppressWarnings("deprecation")
public class Outlets extends Observable implements Observer {
	private static int countId = 1;
	private final String ID = countId++ + "";
	private String name, address, hotline, pass;
	private List<Employee> employees;
	private Map<LocalDate, List<Bill>> listBill;
	private List<Food> listFood;
	private List<FoodDecorator> listToppingFood;
	private List<BeverageDecorator> listToppingBeverage;
	private List<Beverage> listBeverage;
	private Object[] notify;
	private double thue;

	public Outlets(String name, String address, String hotline, String pass) {
		this.name = name;
		thue = 0.005;
		this.address = address;
		this.hotline = hotline;
		this.pass = pass;

		employees = new ArrayList<>();
		listBill = new TreeMap<>();
		listFood = new ArrayList<>();
		listBeverage = new ArrayList<>();
		listToppingFood = new ArrayList<>();
		listToppingBeverage = new ArrayList<>();
	}

	public String getID() {
		return ID;
	}

	public String getAddress() {
		return address;
	}

	public List<Food> getListFood() {
		return listFood;
	}

	public List<Beverage> getListBeverage() {
		return listBeverage;
	}

	public void setListFood(List<Food> listFood) {
		this.listFood = listFood;
	}

	public void setListBeverage(List<Beverage> listBeverage) {
		this.listBeverage = listBeverage;
	}

	public Map<LocalDate, List<Bill>> getListBill() {
		return listBill;
	}

	public List<FoodDecorator> getListToppingFood() {
		return listToppingFood;
	}

	public void setListToppingFood(List<FoodDecorator> listToppingFood) {
		this.listToppingFood = listToppingFood;
	}

	public List<BeverageDecorator> getListToppingBeverage() {
		return listToppingBeverage;
	}

	public void setListToppingBeverage(List<BeverageDecorator> listToppingBeverage) {
		this.listToppingBeverage = listToppingBeverage;
	}

	public void setListBill(Map<LocalDate, List<Bill>> listBill) {
		this.listBill = listBill;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * 
	 * @param payOption
	 */
	public boolean pay(PayOption payOption, Bill bill) {
		if (payOption.getPay(bill, thue)) {
			LocalDate now = LocalDate.now();
			if (listBill.containsKey(now)) {
				listBill.get(now).add(bill);
			} else {
				List<Bill> list = new ArrayList<>();
				list.add(bill);
				listBill.put(now, list);
			}
			return true;
		}
		return false;
	}

	public double getCountBIllByToday() {
		int count = 0;
		for (LocalDate date : listBill.keySet()) {
			if (date.equals(LocalDate.now())) {
				count++;
			}
		}

		return count;
	}

	public double getCountBIllByWeekOfMonth(int weekOfMonth, int month, int year) {
		int count = 0;
		for (LocalDate date : listBill.keySet()) {
			// Tính date thuộc tuần thứ mấy;
			int week = (date.getDayOfMonth() - 1) / 7 + 1;
			;
			if (week == weekOfMonth && date.getMonthValue() == month && date.getYear() == year) {
				count++;
			}
		}

		return count;
	}

	public double getCountBIllByMonth(int month, int year) {
		int count = 0;
		for (LocalDate date : listBill.keySet()) {
			if (date.getMonthValue() == month && date.getYear() == year) {
				count++;
			}
		}

		return count;
	}

	public double getCountBIllByYear(int year) {
		int count = 0;
		for (LocalDate date : listBill.keySet()) {
			if (date.getYear() == year) {
				count++;
			}
		}

		return count;
	}

//	public void getTotalTurnover(Object[] src) {
//		if (((String) src[0]).equals("Thu nhap")) {
//			double re = 0;
//			notify = new Object[5];
//			System.arraycopy(src, 0, notify, 0, 3);
//			if (((String) src[1]).equals("nam")) {
//				re = this.getTotalTurnoverByYear(Integer.parseInt((String) src[2]));
//			} else {
//				re = this.getTotalTurnoverByMonth(Integer.parseInt(((String) src[2]).split("/")[0]),
//						Integer.parseInt(((String) src[2]).split("/")[1]));
//			}
//			notify[3] = id;
//			notify[4] = re;
//			this.setChanged();
//			this.notifyObservers(notify);
//		}
//	}

	public double getTotalTurnoverByToday() {
		double re = 0;
		for (LocalDate date : listBill.keySet()) {
			if (date.equals(LocalDate.now())) {
				for (Bill bill : listBill.get(date)) {
					re += bill.getPay(thue);
				}
			}
		}

		return re;
	}

	public double getTotalTurnoverByWeekOfMonth(int weekOfMonth, int month, int year) {
		double re = 0;
		for (LocalDate date : listBill.keySet()) {
			// Tính date thuộc tuần thứ mấy;
			int week = (date.getDayOfMonth() - 1) / 7 + 1;
			if (week == weekOfMonth && date.getMonthValue() == month && date.getYear() == year) {
				for (Bill bill : listBill.get(date)) {
					re += bill.getPay(thue);
				}
			}
		}

		return re;
	}

	public double getTotalTurnoverByMonth(int month, int year) {
		double re = 0;
		for (LocalDate date : listBill.keySet()) {
			if (date.getMonthValue() == month && date.getYear() == year) {
				for (Bill bill : listBill.get(date)) {
					re += bill.getPay(thue);
				}
			}
		}

		return re;
	}

	public double getTotalTurnoverByYear(int year) {
		double re = 0;
		for (LocalDate date : listBill.keySet()) {
			if (date.getYear() == year) {
				for (Bill bill : listBill.get(date)) {
					re += bill.getPay(thue);
				}
			}
		}

		return re;
	}

	public void getTotalTurnover(Object[] src) {
		if (((String) src[0]).equals("Thu nhap")) {
			double re = 0;
			notify = new Object[5];
			System.arraycopy(src, 0, notify, 0, 3);
			if (((String) src[1]).equals("nam")) {
				re = this.getTotalTurnoverByYear(Integer.parseInt((String) src[2]));
			} else {
				re = this.getTotalTurnoverByMonth(Integer.parseInt(((String) src[2]).split("/")[0]),
						Integer.parseInt(((String) src[2]).split("/")[1]));
			}
			notify[3] = ID;
			notify[4] = re;
			this.setChanged();
			this.notifyObservers(notify);
		}
	}

	public void addFood(Object[] src) {
		if (((String) src[0]).equals("Cap nhat mon an")) {
			this.listFood = (List<Food>) src[1];
		}
	}

	public void addBeverage(Object[] src) {
		if (((String) src[0]).equals("Cap nhat do uong")) {
			this.listBeverage = (List<Beverage>) src[1];
		}
	}

	public void addToppingBeverage(Object[] src) {
		if (((String) src[0]).equals("Cap nhat topping do uong")) {
			this.listToppingBeverage = (List<BeverageDecorator>) src[1];
		}
	}

	public void addToppingFood(Object[] src) {
		if (((String) src[0]).equals("Cap nhat topping do an")) {
			this.listToppingFood = (List<FoodDecorator>) src[1];
		}
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public boolean removeEmployee(String id) {
		for (Employee employee : employees) {
			if (employee.equalsID(id)) {
				employees.remove(employee);
				return true;
			}
		}

		return false;
	}

	@Override
	public void update(Observable o, Object arg) {
		Object[] src = (Object[]) arg;

		getTotalTurnover(src);
		addFood(src);
		addBeverage(src);
		addToppingBeverage(src);
		addToppingFood(src);
	}
}