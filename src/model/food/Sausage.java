package model.food;

//Xúc xích
public class Sausage extends FoodDecorator {
	public Sausage(Food food) {
		this.food = food;
		this.name = "Xúc xích";
		this.cost = 5000;
	}

	public Sausage() {
		this.name = "Xúc xích";
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
		return new Sausage();
	}
}