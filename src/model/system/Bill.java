package model.system;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import model.beverage.*;
import model.food.*;

public class Bill {
	private static int countID = 1;
	private String id = countID++ + "";
	private HashMap<Beverage, Integer> listBeverage;
	private HashMap<Food, Integer> listFood;
	private double totalBill;

	public Bill(HashMap<Beverage, Integer> listBeverage, HashMap<Food, Integer> listFood) {
		super();
		this.id = id;
		this.listBeverage = listBeverage;
		this.listFood = listFood;
		totalBill = this.getTotalBill();
	}

	public Bill() {
		listBeverage = new HashMap<>();
		listFood = new HashMap<>();
		totalBill = this.getTotalBill();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<Beverage, Integer> getListBeverage() {
		return listBeverage;
	}

	public void setListBeverage(HashMap<Beverage, Integer> listBeverage) {
		this.listBeverage = listBeverage;
	}

	public HashMap<Food, Integer> getListFood() {
		return listFood;
	}

	public void setListFood(HashMap<Food, Integer> listFood) {
		this.listFood = listFood;
	}

	public double getTotalBill() {
		totalBill = 0;
		for(Entry<Food, Integer> entryFood : listFood.entrySet()) {
			totalBill += entryFood.getKey().cost() * entryFood.getValue();
		}
		
		for(Entry<Beverage, Integer> entryBeverage : listBeverage.entrySet()) {
			totalBill += entryBeverage.getKey().cost() * entryBeverage.getValue();
		}
		
		this.totalBill = totalBill;
		return totalBill;
	}
	
	public void addFood(Food food, int amount) {
		if(this.listFood.containsKey(food)) {
			this.listFood.put(food, this.listFood.get(food) + amount);
		}else {
			this.listFood.put(food, amount);
		}
	}
	
	public void addBeverage(Beverage beverage, int amount) {
		if(this.listBeverage.containsKey(beverage)) {
			this.listBeverage.put(beverage, this.listBeverage.get(beverage) + amount);
		}else {
			this.listBeverage.put(beverage, amount);
		}
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Bill [id=" + id + ", listBeverage="
				+ (listBeverage != null ? toString(listBeverage.entrySet(), maxLen) : null) + "\nlistFood="
				+ (listFood != null ? toString(listFood.entrySet(), maxLen) : null) + "\ntotalBill=" + getTotalBill() + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
	public int countSP() {
		return this.listBeverage.size() + this.listFood.size();
	}
	
	public double getPay(double thue) {
		return this.getTotalBill() + this.getTotalBill()*thue;
	}
}