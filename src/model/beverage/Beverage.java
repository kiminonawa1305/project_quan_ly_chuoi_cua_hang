package model.beverage;

import model.system.Size;

public interface Beverage {

	public double cost();
	
	public String note();

	@Override
	boolean equals(Object obj);

	Beverage clone();

	@Override
	int hashCode();
}