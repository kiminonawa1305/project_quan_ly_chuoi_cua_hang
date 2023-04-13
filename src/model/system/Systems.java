package model.system;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import model.beverage.*;
import model.food.*;

@SuppressWarnings("deprecation")
public class Systems extends Observable implements Observer {
	private List<Beverage> listBeverage;
	private List<Food> listFood;
	private List<FoodDecorator> listToppingFood;
	private List<BeverageDecorator> listToppingBeverage;
	private Map<String, Double> listTurnover;
	private Object[] notify;

	public Systems(List<Beverage> listBeverage, List<Food> listFood) {
		super();
		this.listBeverage = listBeverage;
		this.listFood = listFood;
		listTurnover = new HashMap<>();
	}

	public Systems() {
		super();
		this.listBeverage = new ArrayList<>();
		this.listFood = new ArrayList<>();
		listTurnover = new HashMap<>();
		this.listToppingBeverage = new ArrayList<>();
		this.listToppingFood = new ArrayList<>();
	}

	public List<Beverage> getListBeverage() {
		return this.listBeverage;
	}

	public List<Food> getListFood() {
		return listFood;
	}
	
	public List<FoodDecorator> getListToppingFood() {
		return listToppingFood;
	}

	public List<BeverageDecorator> getListToppingBeverage() {
		return listToppingBeverage;
	}

<<<<<<< HEAD
	
//	public String getTurnoverOfOutlets(String id, int month, int year) {
//		this.getTotalTurnoverByMonth(month, year);
//
//		return "Thu nhap " + id + " " + listTurnover.get("Thu nhap " + id);
//	}
//	
//	public String getTurnoverByOutlets(String id, int year) {
//		this.getTotalTurnoverByYear(year);
//
//		return "Thu nhap " + id + " " + listTurnover.get("Thu nhap " + id);
//	}
	
	public void getTotalTurnoverByWeek(int week, int month, int year) {
		notify = new Object[5];
		notify[0] = "Thu nhap";
		notify[1] = "tuan";
		notify[2] = week;
		notify[3] = month;
		notify[5] = year;
=======
	/**
	 * 
	 * @param id
	 */
	public String getTurnoverOfOutlets(String id, int month, int year) {
		this.getTotalTurnoverByMonth(month, year);
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95

		this.setChanged();
		this.notifyObservers(notify);
	}
	
	public void getTotalTurnoverByMonth(int month, int year) {
		notify = new Object[4];
		notify[0] = "Thu nhap";
		notify[1] = "thang";
		notify[2] = month;
		notify[3] = year;

		this.setChanged();
		this.notifyObservers(notify);
	}

<<<<<<< HEAD
	public void getTotalTurnoverByQuarter(int quarter, int year) {
		notify = new Object[4];
		notify[0] = "Thu nhap";
		notify[1] = "quy";
		notify[2] = quarter;
		notify[3] = year;
=======
	public void getTotalTurnoverByMonth(int month, int year) {
		notify = new Object[1];
		notify[0] = "Thu nhap";
		notify[1] = "thang";
		notify[2] = month + "/" + year;
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95

		this.setChanged();
		this.notifyObservers(notify);
	}
	
<<<<<<< HEAD
	public void getTotalTurnoverByYear(int year) {
		notify = new Object[3];
=======
	public String getTurnoverOfOutlets(String id, int year) {
		this.getTotalTurnoverByYear(year);

		return "Thu nhap " + id + " " + listTurnover.get("Thu nhap " + id);
	}

	public void getTotalTurnoverByYear(int year) {
		notify = new Object[1];
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
		notify[0] = "Thu nhap";
		notify[1] = "nam";
		notify[2] = year;

		this.setChanged();
		this.notifyObservers(notify);
	}

	public void addTurnover(Object[] src) {
		if (((String) src[0]).equals("Thu nhap")) {
			this.listTurnover.put(src[0] + " " + src[1], (Double) src[2]);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Object[] src = (Object[]) arg;

		addTurnover(src);
	}

	public void addFood(Food food) {
		this.listFood.add(food);
		notify = new Object[2];
		notify[0] = "Cap nhat mon an";
		notify[1] = this.listFood;

		this.setChanged();
		this.notifyObservers(notify);
	}

	public void addBeverage(Beverage beverage) {
		this.listBeverage.add(beverage);
		notify = new Object[2];
		notify[0] = "Cap nhat do uong";
		notify[1] = this.listBeverage;

		this.setChanged();
		this.notifyObservers(notify);
	}
	
	public void addToppingBeverage(BeverageDecorator BeverageDecorator) {
		this.listToppingBeverage.add(BeverageDecorator);
		notify = new Object[2];
		notify[0] = "Cap nhat topping do uong";
		notify[1] = this.listBeverage;

		this.setChanged();
		this.notifyObservers(notify);
	}
	
	public void addToppingFood(FoodDecorator FoodDecorator) {
		this.listToppingFood.add(FoodDecorator);
		notify = new Object[2];
		notify[0] = "Cap nhat topping do an";
		notify[1] = this.listBeverage;

		this.setChanged();
		this.notifyObservers(notify);
	}

	public void deleteOutlets(Outlets outlets) {
		this.deleteObserver(outlets);
		outlets.deleteObserver(this);
		outlets.setListBeverage(new ArrayList<>());
		outlets.setListFood(new ArrayList<>());
		outlets.setListBill(new TreeMap<>());
		outlets.setListToppingBeverage(new ArrayList<>());
		outlets.setListToppingFood(new ArrayList<>());
	}

	public void addOutlets(Outlets outlets) {
		this.addObserver(outlets);
		outlets.addObserver(this);
		outlets.setListBeverage(listBeverage);
		outlets.setListFood(listFood);
		outlets.setListToppingBeverage(listToppingBeverage);
		outlets.setListToppingFood(listToppingFood);
	}
}