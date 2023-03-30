package model.food;

import java.util.Objects;

import model.beverage.Beverages;
import model.system.Size;

public abstract class Foods implements Food {
	protected String urlImage, name;
	protected Size size = Size.MEDIUM;
	protected double cost;


	public abstract boolean hasSize();

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
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		Foods that = (Foods) obj;
		return this.name.equals(that.name) && this.size.equals(that.size) && this.cost == that.cost;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cost, name, size, urlImage);
	}

	@Override
	public String toString() {
		return this.note();
	}
	
	public abstract Food clone();
}
