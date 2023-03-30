package model.system;

public enum Size {
	SMALL(0.9), 
	MEDIUM(1), 
	LARGE(1.25);

	private double percent;
	
	Size(double percent) {
		this.percent = percent;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
}
