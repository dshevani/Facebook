package facebookCoding;
/**
 * Write a function to check if polygon is simple based on given list of points
 */
import java.util.*;
public class SimplePolygon {
	public static boolean isSimplePolygon(Point[] polygon) {
		if (polygon == null || polygon.length < 3)
			throw new IllegalArgumentException("invalid input!");
		Set<Double> slopes = new HashSet<Double> ();
		for (int i = 0; i < polygon.length - 1; i++) {
			slopes.clear();
			for (int j = i + 1; j < polygon.length; j++) {
				double slope;
				if (polygon[i].x == polygon[j].x) {
					slope = (double)Integer.MAX_VALUE;
				}
				else if (polygon[i].y == polygon[j].x) {
					slope = 0.0;
				}
				else {
					slope = (double) (polygon[i].y - polygon[j].y) / (double)(polygon[i].x + polygon[j].x);
				}
				if (slopes.contains(slope))
					return false;
				slopes.add(slope);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Point[] polygon = new Point[5];
		polygon[0] = new Point(0, 0);
		polygon[1] = new Point(2, 2);
		polygon[2] = new Point(1, 3);
		polygon[3] = new Point(1, 0);
		polygon[4] = new Point(1, 1);
		System.out.println(isSimplePolygon(polygon));
	}
}
