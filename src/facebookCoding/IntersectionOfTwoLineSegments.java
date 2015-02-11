package facebookCoding;
/**
 * Write a function to tell if two line segments intersect or not
 * @author shirleyyoung
 *http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 *http://shirleyisnotageek.blogspot.com/2015/02/determine-if-two-line-segments-intersect.html
 */
public class IntersectionOfTwoLineSegments {
	/**
	 * check if two line segments pq and rs intersect with each other
	 * @param p
	 * @param q
	 * @param r
	 * @param s
	 * @return
	 */
	public static boolean hasIntersection(Point p, Point q, Point r, Point s) {
		if (p == null || q == null || r == null || s == null)
			throw new NullPointerException("Null points!");
		if (p.equals(q) || r.equals(s))
			throw new IllegalArgumentException("Not a line!");
		int ori1 = orientation(p, q, r);
		int ori2 = orientation(p, q, s);
		int ori3 = orientation(r, s, p);
		int ori4 = orientation(r, s, q);
		if (ori1 != ori2 && ori3 != ori4)
			return true;
		if (ori1 == 0 && isOnSegment(p, q, r))
			return true;
		if (ori2 == 0 && isOnSegment(p, q, s))
			return true;
		if (ori3 == 0 && isOnSegment(r, s, p))
			return true;
		if (ori4 == 0 && isOnSegment(r, s, q))
			return true;
		return false;
	}
	/**
	 * check if point r is on line segment pq
	 * @param p
	 * @param q
	 * @param r
	 */
	private static boolean isOnSegment(Point p, Point q, Point r) {
		return r.x <= Math.max(p.x, q.x) && r.x >= Math.min(p.x, q.x) 
				&& r.y <= Math.max(p.y, q.y) && r.y >= Math.min(p.y, q.y);
	}
	/**
	 * return the orientation of the triplet
	 * 0: parallel
	 * 1: clockwise
	 * 2: counterclockwise
	 * cross product
	 * http://en.wikipedia.org/wiki/Cross_product
	 * pq & pr
	 * @param p
	 * @param q
	 * @param r
	 * @return
	 */
	private static int orientation(Point p, Point q, Point r) {
		double orientation = (p.x - q.x) * (p.y - r.y) - (p.y - q.y) * (p.x - r.x);
		if (orientation == 0)
			return 0;
		return orientation > 0 ? 1 : 2;
	}

	public static void main(String[] args) {
		System.out.println(hasIntersection(new Point(1, 4), new Point(2, 3), new Point(0, 2), new Point(3, 1)));
		System.out.println(hasIntersection(new Point(0, 0), new Point(1, 1), new Point(2, 1), new Point(3, 1)));
		System.out.println(hasIntersection(new Point(-1, 4), new Point(-2, 3), new Point(2, 1), new Point(0, 0)));
		System.out.println(hasIntersection(new Point(1, 2), new Point(8, 9), new Point(3, 1), new Point(4, 6)));
		System.out.println(hasIntersection(new Point(0, 0), new Point(0, 5), new Point(0, 2), new Point(0, -1)));

	}

}
