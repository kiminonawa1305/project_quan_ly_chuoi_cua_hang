package model.beverage;

public class OtherToppingBeverage extends BeverageDecorator {
	public OtherToppingBeverage(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String note() {
		return beverage.note() + " thêm " + name;
	}

	@Override
	public double cost() {
		return cost + beverage.cost();
	}

	@Override
	public String toString() {
		return this.note() + " giá là " + this.cost();
	}

	@Override
	public Beverage clone() {
		return new OtherToppingBeverage(this.name, this.cost);
	}
}
