package model.beverage;

import java.util.Objects;

public abstract class BeverageDecorator implements Beverage {
	protected Beverage beverage;
	protected double cost;
	protected String name;

	public abstract double cost();

	@Override
	public String toString() {
		return this.note();
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public Beverage setBeverage(Beverage beverage) {
		this.beverage = beverage;
		return this;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beverage, cost, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()){
			return false;
		}
		
		BeverageDecorator that = (BeverageDecorator) obj;
		return this.name.equals(that.name) && this.cost == that.cost && this.beverage.equals(that.beverage);
	}

	@Override
	public abstract Beverage clone();
}