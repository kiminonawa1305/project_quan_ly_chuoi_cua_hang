package model.beverage;

public class Lemon extends BeverageDecorator {

	public Lemon(Beverage beverage) {
		this.beverage = beverage;
		this.name = "Chanh";
		this.cost = 2500;
	}
	
	public Lemon() {
		this.name = "Chanh";
		this.cost = 2500;
	}

	public double cost() {
		return this.cost + beverage.cost();
	}

	@Override
	public String note() {
		return beverage.note() + " thêm " + name;
	}

	@Override
	public Beverage clone() {
		return new Lemon();
	}
}