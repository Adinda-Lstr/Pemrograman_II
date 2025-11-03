package MODUL5.soal1;

public class Rectangle extends Shape {
	private double lenght;
	private double width;
	
	
	public Rectangle(double l, double w) {
		super("Rectangle");
		this.lenght = l;
		this.width = w;
	}
	
	@Override
	protected double area() {
		return lenght * width;
	}
	
	@Override
	public String toString() {
		return super.toString() + " of length " + lenght + " and width " + width;
	}

}
