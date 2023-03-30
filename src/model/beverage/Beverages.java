package model.beverage;

import java.util.Objects;

import model.system.Size;

public abstract class Beverages implements Beverage {
	protected String urlImage, name;
	protected Size size = Size.MEDIUM;
	protected double cost;

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return this.note() + " giá là " + this.cost();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, name, size, urlImage);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Beverages that = (Beverages) obj;
		return this.name.equals(that.name) && this.size.equals(that.size) && this.cost == that.cost;
	}
	
	public abstract Beverage clone();
}
