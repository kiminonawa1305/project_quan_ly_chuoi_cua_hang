package model.food;

import model.system.Size;

public class OtherFood extends Foods {
	private boolean hasSize = false;

	public OtherFood(String url, String name, double cost, boolean hasSize) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
		this.hasSize = hasSize;
	}
	
	public OtherFood(String url, String name, double cost) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
	}

	@Override
	public double cost() {
		return cost * size.getPercent();
	}

	@Override
	public boolean hasSize() {
		return hasSize;
	}

	public String note() {
		return name + " size " + size;
	}

	public Size getSize() {
		if(hasSize) {
			return size;
		}else {
			return null;
		}
	}

	public void setSize(Size size) {
		if(hasSize) {
			this.size = size;
		}
	}
	
	public void setHasSize(boolean hasSize) {
		this.hasSize = hasSize;
	}

	@Override
	public Food clone() {
		OtherFood re = new OtherFood(this.urlImage, this.name, this.cost);
		re.setHasSize(hasSize);
		return re;
	}
}
