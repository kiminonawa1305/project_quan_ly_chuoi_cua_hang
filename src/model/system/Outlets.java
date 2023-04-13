package model.system;

<<<<<<< HEAD
import java.awt.Dimension;
import java.time.LocalDate;
=======
import java.time.LocalDate;
import java.time.temporal.WeekFields;
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import model.beverage.Beverage;
import model.beverage.BeverageDecorator;
import model.food.Food;
import model.food.FoodDecorator;
<<<<<<< HEAD
import model.object.Bill;
import model.object.MapSortByValue;
=======
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
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
	private List<Beverage> listBeverage;
	private List<BeverageDecorator> listToppingBeverage;
	private Map<LocalDate, Map<Food, Integer>> topFood;
	private Map<LocalDate, Map<Beverage, Integer>> topBeverage;
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
		topFood = new HashMap<>();
		topBeverage = new HashMap<>();
	}

	public String getID() {
		return ID;
	}

	public String getAddress() {
		return address;
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

	public Map<LocalDate, Map<Food, Integer>> getTopFood() {
		return topFood;
	}

	public Map<LocalDate, Map<Beverage, Integer>> getTopBeverage() {
		return topBeverage;
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
<<<<<<< HEAD
				Map<Beverage, Integer> topBeverageNow = topBeverage.get(now);
				Map<Beverage, Integer> listBeverageOfBill = bill.getListBeverage();
				a: for (Entry<Beverage, Integer> beverage : listBeverageOfBill.entrySet()) {
					if (topBeverageNow.containsKey(beverage.getKey())) {
						topBeverageNow.put(beverage.getKey(),
								topBeverageNow.get(beverage.getKey()) + beverage.getValue());
					} else {
						topBeverageNow.put(beverage.getKey(), beverage.getValue());
					}
				}
				topBeverage.put(now, MapSortByValue.sortByValue(topBeverageNow));

				Map<Food, Integer> listFoodNow = topFood.get(now);
				Map<Food, Integer> listFoodOfBill = bill.getListFood();
				b: for (Entry<Food, Integer> food : listFoodOfBill.entrySet()) {
					if (listFoodNow.containsKey(food.getKey())) {
						listFoodNow.put(food.getKey(), listFoodNow.get(food.getKey()) + food.getValue());
					} else {
						listFoodNow.put(food.getKey(), food.getValue());
					}
				}
				topFood.put(now, MapSortByValue.sortByValue(listFoodNow));
=======
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
			} else {
				List<Bill> list = new ArrayList<>();
				list.add(bill);
				listBill.put(now, list);
<<<<<<< HEAD

				Map<Beverage, Integer> topBeverageNow = new HashMap<Beverage, Integer>();
				Map<Beverage, Integer> listBeverageOfBill = bill.getListBeverage();
				a: for (Entry<Beverage, Integer> beverage : listBeverageOfBill.entrySet()) {
					if (topBeverageNow.containsKey(beverage.getKey())) {
						topBeverageNow.put(beverage.getKey(),
								topBeverageNow.get(beverage.getKey()) + beverage.getValue());
					} else {
						topBeverageNow.put(beverage.getKey(), beverage.getValue());
					}
				}
				topBeverage.put(now, MapSortByValue.sortByValue(topBeverageNow));

				Map<Food, Integer> listFoodNow = new HashMap<Food, Integer>();
				Map<Food, Integer> listFoodOfBill = bill.getListFood();
				b: for (Entry<Food, Integer> food : listFoodOfBill.entrySet()) {
					if (listFoodNow.containsKey(food.getKey())) {
						listFoodNow.put(food.getKey(), listFoodNow.get(food.getKey()) + food.getValue());
					} else {
						listFoodNow.put(food.getKey(), food.getValue());
					}
				}
				topFood.put(now, MapSortByValue.sortByValue(listFoodNow));
			}

			// In top
			for (Entry<LocalDate, Map<Beverage, Integer>> beverage : topBeverage.entrySet()) {
				System.out.println("-Ngay : " + beverage.getKey());
				for (Entry<Beverage, Integer> be : beverage.getValue().entrySet()) {
					System.out.println("\t+" + be.getKey() + " tổng số lương: " + be.getValue());
				}
			}

			for (Entry<LocalDate, Map<Food, Integer>> food : topFood.entrySet()) {
				System.out.println("-Ngay : " + food.getKey());
				for (Entry<Food, Integer> fo : food.getValue().entrySet()) {
					System.out.println("\t+" + fo.getKey() + " tổng số lương: " + fo.getValue());
				}
=======
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
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

<<<<<<< HEAD
	public double getTotalTurnoverByQuarter(int quarter, int year) {
		double re = 0;
		for (LocalDate date : listBill.keySet()) {
			if (3 * (quarter - 1) < date.getMonthValue() && date.getMonthValue() <= 3 * quarter
					&& date.getYear() == year) {
				for (Bill bill : listBill.get(date)) {
					re += bill.getPay(thue);
				}
			}
		}

		return re;
	}

=======
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
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
<<<<<<< HEAD
			switch (((String) src[1])) {
			case "tuan": {
				break;
			}
			case "thang": {
				re = this.getTotalTurnoverByMonth(Integer.parseInt(((String) src[2]).split("/")[0]),
						Integer.parseInt(((String) src[2]).split("/")[1]));
				break;
			}
			case "quy": {
				break;
			}
			case "nam": {
				re = this.getTotalTurnoverByYear(Integer.parseInt((String) src[2]));
				break;
			}
			}

=======
			if (((String) src[1]).equals("nam")) {
				re = this.getTotalTurnoverByYear(Integer.parseInt((String) src[2]));
			} else {
				re = this.getTotalTurnoverByMonth(Integer.parseInt(((String) src[2]).split("/")[0]),
						Integer.parseInt(((String) src[2]).split("/")[1]));
			}
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
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

	public List<Food> getTopFoodToday() {
		List<Food> result = new ArrayList<>();
		LocalDate now = LocalDate.now();

		if(topFood.get(now) != null) {
			for (Food food : topFood.get(now).keySet()) {
				if (result.size() >= 3) {
					return result;
				}

				result.add(food);
			}
		}

		return result;
	}

	public List<Beverage> getTopBeverageToday() {
		List<Beverage> result = new ArrayList<>();
		LocalDate now = LocalDate.now();

		if(topBeverage.get(now) != null) {
			for (Beverage beverage : topBeverage.get(now).keySet()) {
			if (result.size() >= 3) {
				return result;
			}

			result.add(beverage);
		}
		}
		

		return result;
	}

	public List<Food> getTopFoodByWeekOfMonth(int weekOfMonth, int month, int year) {
		List<Food> result = new ArrayList<>();

		Map<Food, Integer> listTop = new HashMap<>();
		for (LocalDate date : topFood.keySet()) {
			int week = (date.getDayOfMonth() - 1) / 7 + 1;
			if (week == weekOfMonth && date.getMonthValue() == month && date.getYear() == year) {
				for (Food food : topFood.get(date).keySet()) {
					if (listTop.containsKey(food)) {
						listTop.put(food, topFood.get(date).get(food) + listTop.get(food));
					} else {
						listTop.put(food, topFood.get(date).get(food));
					}
				}
			}
		}

		for (Food food : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(food);
		}

		return result;
	}

	public List<Beverage> getTopBeverageByWeekOfMonth(int weekOfMonth, int month, int year) {
		List<Beverage> result = new ArrayList<>();

		Map<Beverage, Integer> listTop = new HashMap<>();
		for (LocalDate date : topBeverage.keySet()) {
			int week = (date.getDayOfMonth() - 1) / 7 + 1;
			if (week == weekOfMonth && date.getMonthValue() == month && date.getYear() == year) {
				for (Beverage beverage : topBeverage.get(date).keySet()) {
					if (listTop.containsKey(beverage)) {
						listTop.put(beverage, topBeverage.get(date).get(beverage) + listTop.get(beverage));
					} else {
						listTop.put(beverage, topBeverage.get(date).get(beverage));
					}
				}
			}
		}

		for (Beverage beverage : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(beverage);
		}

		return result;
	}
	
	public List<Food> getTopFoodByMonth(int month, int year) {
		List<Food> result = new ArrayList<>();

		Map<Food, Integer> listTop = new HashMap<>();
		for (LocalDate date : topFood.keySet()) {
			if (date.getMonthValue() == month && date.getYear() == year) {
				for (Food food : topFood.get(date).keySet()) {
					if (listTop.containsKey(food)) {
						listTop.put(food, topFood.get(date).get(food) + listTop.get(food));
					} else {
						listTop.put(food, topFood.get(date).get(food));
					}
				}
			}
		}

		for (Food food : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(food);
		}

		return result;
	}

	public List<Beverage> getTopBeverageByMonth(int month, int year) {
		List<Beverage> result = new ArrayList<>();

		Map<Beverage, Integer> listTop = new HashMap<>();
		for (LocalDate date : topBeverage.keySet()) {
			if (date.getMonthValue() == month && date.getYear() == year) {
				for (Beverage beverage : topBeverage.get(date).keySet()) {
					if (listTop.containsKey(beverage)) {
						listTop.put(beverage, topBeverage.get(date).get(beverage) + listTop.get(beverage));
					} else {
						listTop.put(beverage, topBeverage.get(date).get(beverage));
					}
				}
			}
		}

		for (Beverage beverage : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(beverage);
		}

		return result;
	}
	
	public List<Food> getTopFoodByQuarter(int quarter, int year) {
		List<Food> result = new ArrayList<>();

		Map<Food, Integer> listTop = new HashMap<>();
		for (LocalDate date : topFood.keySet()) {
			if ((quarter - 1)*3 < date.getMonthValue() && date.getMonthValue() <= quarter*3 && date.getYear() == year) {
				for (Food food : topFood.get(date).keySet()) {
					if (listTop.containsKey(food)) {
						listTop.put(food, topFood.get(date).get(food) + listTop.get(food));
					} else {
						listTop.put(food, topFood.get(date).get(food));
					}
				}
			}
		}

		for (Food food : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(food);
		}

		return result;
	}

	public List<Beverage> getTopBeverageByQuarter(int quarter, int year) {
		List<Beverage> result = new ArrayList<>();

		Map<Beverage, Integer> listTop = new HashMap<>();
		for (LocalDate date : topBeverage.keySet()) {
			if ((quarter - 1)*3 < date.getMonthValue() && date.getMonthValue() <= quarter*3 && date.getYear() == year) {
				for (Beverage beverage : topBeverage.get(date).keySet()) {
					if (listTop.containsKey(beverage)) {
						listTop.put(beverage, topBeverage.get(date).get(beverage) + listTop.get(beverage));
					} else {
						listTop.put(beverage, topBeverage.get(date).get(beverage));
					}
				}
			}
		}

		for (Beverage beverage : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(beverage);
		}

		return result;
	}
	
	public List<Food> getTopFoodByYear(int year) {
		List<Food> result = new ArrayList<>();

		Map<Food, Integer> listTop = new HashMap<>();
		for (LocalDate date : topFood.keySet()) {
			if (date.getYear() == year) {
				for (Food food : topFood.get(date).keySet()) {
					if (listTop.containsKey(food)) {
						listTop.put(food, topFood.get(date).get(food) + listTop.get(food));
					} else {
						listTop.put(food, topFood.get(date).get(food));
					}
				}
			}
		}

		for (Food food : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(food);
		}

		return result;
	}

	public List<Beverage> getTopBeverageByYear(int year) {
		List<Beverage> result = new ArrayList<>();

		Map<Beverage, Integer> listTop = new HashMap<>();
		for (LocalDate date : topBeverage.keySet()) {
			if (date.getYear() == year) {
				for (Beverage beverage : topBeverage.get(date).keySet()) {
					if (listTop.containsKey(beverage)) {
						listTop.put(beverage, topBeverage.get(date).get(beverage) + listTop.get(beverage));
					} else {
						listTop.put(beverage, topBeverage.get(date).get(beverage));
					}
				}
			}
		}

		for (Beverage beverage : listTop.keySet()) {
			if (result.size() >= 3) {
				return result;
			}
			
			result.add(beverage);
		}

		return result;
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