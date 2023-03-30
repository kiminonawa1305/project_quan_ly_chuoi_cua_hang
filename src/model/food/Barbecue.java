package model.food;

//Thịt nướng
public class Barbecue extends FoodDecorator {
	public Barbecue(Food food) {
		this.food = food;
		this.name = "Thịt nướng";
		this.cost = 10000;
	}
	
	public Barbecue() {
		this.name = "Thịt nướng";
		this.cost = 10000;
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
		return new Barbecue();
	}

}