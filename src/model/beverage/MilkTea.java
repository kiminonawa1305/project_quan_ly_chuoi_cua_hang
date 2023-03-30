package model.beverage;

import model.system.Size;

public class MilkTea extends Beverages {
	public MilkTea(String url) {
		this.urlImage = url;
		this.name =  "Trà sửa";
		this.cost = 20000;
	}
	
	public MilkTea(Size size) {
		this.size = size;
		this.name =  "Trà sửa";
		this.cost = 20000;
	}

	public double cost() {
		return this.cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size.toString();
	}
	
	@Override
	public String toString() {
		return this.note();
	}

	@Override
	public Beverage clone() {
		MilkTea re = new MilkTea(this.urlImage);
		re.setName(this.name);
		re.setCost(this.cost);
		return re;
	}
}