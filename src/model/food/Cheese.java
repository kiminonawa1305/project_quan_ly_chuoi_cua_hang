package model.food;

public class Cheese extends FoodDecorator {
	public Cheese(Food food) {
		this.food = food;
		this.name = "Phô mai";
		this.cost = 5000;
	}

	public Cheese() {
		this.name = "Phô mai";
		this.cost = 5000;
	}

	public double cost() {
		return this.cost + food.cost();
	}

	@Override
	public String note() {
		return food.note() + " thêm " + name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Food clone() {
		return new Cheese();
	}
}