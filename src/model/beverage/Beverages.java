package model.beverage;

import java.util.Objects;

import model.system.Size;

public class Beverages implements Beverage {
	private String urlImage, name;
	private Size size = Size.MEDIUM;
	private double cost;
	
	public Beverages(String url, String name, double cost) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
	}
	
	public Beverages(Size size) {
		this.size = size;
	}

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
		return this.note();
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
	

	@Override
	public double cost() {
		return cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size;
	}

	@Override
	public Beverage clone(){
		return new Beverages(this.urlImage, this.name, this.cost);
	}
}
