package model.food;

import java.util.Objects;

import model.system.Size;

public class Foods implements Food  {
	private String urlImage, name;
	private Size size = Size.MEDIUM;
	private double cost;
	private boolean hasSize = false;

	public Foods(String url, String name, double cost, boolean hasSize) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
		this.hasSize = hasSize;
	}
	
	public Foods(String url, String name, double cost) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
	}
	
	

	public String getUrlImage() {
		return urlImage;
	}

	public String getName() {
		return name;
	}

	@Override
	public double cost() {
		return cost * size.getPercent();
	}

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
		Foods re = new Foods(this.urlImage, this.name, this.cost);
		re.setHasSize(hasSize);
		return re;
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

}
