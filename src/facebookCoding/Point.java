package facebookCoding;

public class Point {
	double x;
	double y;
	
	public Point() {
		this.x = 0.0;
		this.y = 0.0;
	}
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point p) {
		return (this.x == p.x && this.y == p.y);
		
	}
	
	public double distanceFrom(Point p) {
		return Math.sqrt(Math.pow(p.y - this.y, 2) + Math.pow(p.x - this.x, 2));
	}
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
