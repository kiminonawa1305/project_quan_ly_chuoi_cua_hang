package model.system;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

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

	/**
	 * 
	 * @param id
	 */
	public String getTurnoverOfOutlets(String id) {
		this.getTotalTurnover();

		return "Thu nhap " + id + " " + listTurnover.get("Thu nhap " + id);
	}

	public void getTotalTurnover() {
		notify = new Object[1];
		notify[0] = "Thu nhap";

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
		outlets.setListBill(new ArrayList<>());
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