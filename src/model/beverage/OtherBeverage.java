package model.beverage;

import javax.crypto.spec.OAEPParameterSpec;

import model.system.Size;

public class OtherBeverage extends Beverages {
	public OtherBeverage(String url, String name, double cost) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
	}
	
	public OtherBeverage(Size size) {
		this.size = size;
	}

	@Override
	public double cost() {
		return cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Beverage clone(){
		return new OtherBeverage(this.urlImage, this.name, this.cost);
	}
}
