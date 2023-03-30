package model.food;

import model.system.Size;

//Phô mai
public class Pizza extends Foods {
	public Pizza(String url) {
		this.urlImage = url;
		name = "Bánh pizza size";
		this.cost = 25000;
	}
	
	public Pizza(Size size) {
		this.size = size;
		name = "Bánh pizza size";
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
		Pizza re = new Pizza(urlImage);
		re.setName(name);
		re.setCost(cost);
		return re;
	}

}