package model.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

import model.beverage.*;
import model.food.*;
import model.pay.PayOption;

@SuppressWarnings("deprecation")
public class Outlets extends Observable implements Observer {
	private static int countId = 1;
	private String id = countId++ + "";
	private String name, address, hotline, pass;
	private Employee manager;
	private List<Employee> employees;
	private List<Bill> listBill;
	private List<Food> listFood;
	private List<FoodDecorator> listToppingFood;
	private List<BeverageDecorator> listToppingBeverage;
	private List<Beverage> listBeverage;
	private Object[] notify;

	public Outlets(String name, String address, String hotline, String pass) {
		this.name = name;
		this.address = address;
		this.hotline = hotline;
		this.pass = pass;

		employees = new ArrayList<>();
		listBill = new ArrayList<>();
		listFood = new ArrayList<>();
		listBeverage = new ArrayList<>();
		listToppingFood = new ArrayList<>();
		listToppingBeverage = new ArrayList<>();
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

	public List<Bill> getListBill() {
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

	public void setListBill(List<Bill> listBill) {
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
	public static boolean pay(PayOption payOption, Bill bill,double thue, double moneyReceived) {
		return payOption.getPay(bill, thue, moneyReceived);
	}

	/**
	 * 
	 * @param listFood
	 */
	public void order(HashMap<Food, Integer> listFood, HashMap<Beverage, Integer> listbeverage) {
		listBill.add(new Bill(listbeverage, listFood));
	}

	public void getTotalTurnover(Object[] src) {
		double re = 0;
		for (Bill bill : listBill) {
			re += bill.getTotalBill();
		}

		if (((String) src[0]).equals("Thu nhap")) {
			notify = new Object[3];
			notify[0] = "Thu nhap";
			notify[1] = id;
			notify[2] = re;

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