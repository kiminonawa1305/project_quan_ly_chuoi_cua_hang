package model.food;

import model.system.Size;

public class OtherToppingFood extends FoodDecorator {
	public OtherToppingFood(String name, double cost, Food food) {
		this.name = name;
		this.cost = cost;
		this.food = food;
	}
	
	public OtherToppingFood(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String note() {
		return food.note() + " thêm " + name;
	}

	@Override
	public double cost() {
		return cost + food.cost();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public Food setFood(Food food) {
		this.food = food;
		return this;
	}
	
	@Override
	public String toString() {
		return this.note() + " giá là " + this.cost();
	}

	@Override
	public Food clone() {
		return new OtherToppingFood(name, cost);
	}
}
