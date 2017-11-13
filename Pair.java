import java.awt.Point;
import java.util.Comparator;

public class Pair {
	public Point A;
	public Point B;
	public double distance;
	
	public Pair() {
		this.A = null;
		this.B = null;
	}
	
	public Pair(Point A, Point B) {
		this.A = A;
		this.B = B;
		this.distance = A.distance(B);
		
	}
	
	public String toString() {
		return "" + this.A + ", " + this.B + "";
	}
	
}

