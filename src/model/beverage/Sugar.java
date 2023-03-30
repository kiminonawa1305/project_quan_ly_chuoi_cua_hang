package model.beverage;

public class Sugar extends BeverageDecorator {
	public Sugar(Beverage beverage) {
		this.beverage = beverage;
		this.name = "Đường";
		cost = 1000;
	}
	
	
	public Sugar() {
		this.name = "Đường";
		cost = 1000;
	}

	public double cost() {
		return this.cost + beverage.cost();
	}

	@Override
	public String note() {
		return beverage.note() + " thêm " + name;
	}

	@Override
	public String getName() {
		return name;
	}


	@Override
	public Beverage clone() {
		return new Sugar();
	}
}