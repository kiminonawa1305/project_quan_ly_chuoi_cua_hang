package model.beverage;

public class Milk extends BeverageDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
		this.cost = 2000;
		this.name = "Sữa";
	}
	
	public Milk() {
		this.cost = 2000;
		this.name = "Sữa";
	}

	public double cost() {
		return cost + beverage.cost();
	}

	@Override
	public String note() {
		return beverage.note() + " thêm " + name;
	}

	@Override
	public Beverage clone() {
		return new Milk();
	}
}