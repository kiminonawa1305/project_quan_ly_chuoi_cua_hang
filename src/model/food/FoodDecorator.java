package model.food;

import java.util.Objects;

import model.beverage.BeverageDecorator;

public abstract class FoodDecorator implements Food {
	protected Food food;
	protected String name;
	protected double cost;
	
	public abstract double cost();
	
	@Override
	public String toString() {
		return this.note();
	}

	public abstract String getName();

	public Food setFood(Food foodOrder) {
		this.food = foodOrder;
		return this;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Food getFood() {
		return food;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, food, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()){
			return false;
		}
		
		FoodDecorator that = (FoodDecorator) obj;
		return this.name.equals(that.name) && this.cost == that.cost && this.food.equals(that.food);
	}
	
	public abstract Food clone();
}