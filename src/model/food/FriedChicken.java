package model.food;

import model.system.Size;

public class FriedChicken extends Foods {
	public FriedChicken(String url) {
		this.urlImage = url;
		name = "Gà rán";
		this.cost = 25000;
	}
	
	public FriedChicken(Size size) {
		this.size = size;
		name = "Gà rán";
		this.cost = 25000;
	}

	public double cost() {
		return this.cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size;
	}

	@Override
	public String toString() {
		return this.note();
	}

	@Override
	public boolean hasSize() {
		return true;
	}

	@Override
	public Food clone() {
		FriedChicken re = new FriedChicken(urlImage);
		re.setName(name);
		re.setCost(cost);
		return re;
	}
}