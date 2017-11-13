import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClosestPair {

	static Comparator<Point> xComparator = new Comparator<Point>() {
		@Override
		public int compare(Point a, Point b) {
			return (int) (a.getX() - b.getX());
		}
	}; 

	static Comparator<Point> yComparator = new Comparator<Point>() {
		@Override
		public int compare(Point a, Point b) {
			return (int) (a.getY() - b.getY());
		}
	};

	public static Comparator<Pair> distanceComparator = new Comparator<Pair>() {
		@Override
		public int compare(Pair A, Pair B) {
			return (int) (A.distance - B.distance);
		}
	};

	static Pair bruteForce(List<Point> set)  {

		if(set.size() < 2)  {
			return null;
		}

		else if(set.size() == 2) {
			Pair closestPair = new Pair(set.get(0), set.get(1)); 
			return closestPair;
		}
		else {

			Pair closestPair = new Pair(set.get(0), set.get(1)); 
			for(int i = 0; i < set.size(); i++) {
				for(int j = i+1; j < set.size(); j++) {
					Pair Y = new Pair(set.get(i), set.get(j));
					if(Y.distance < closestPair.distance) {
						closestPair = Y;
					}
				}
			}

			return closestPair;
		}
	}




	public static Pair findClosestPair(List<Point> set)  {

		if (set == null) {
			return null;
		}

		List<Point> setSortedByX = new ArrayList<Point>(set);
		setSortedByX.sort(xComparator);

		List<Point> setSortedByY = new ArrayList<Point>(set);
		setSortedByY.sort(yComparator);

		return findClosestPair(setSortedByX, setSortedByY);
	}

	private static Pair findClosestPair(List<Point> setSortedByX, List<Point> setSortedByY) {

		int size = setSortedByX.size();

		if(size <= 3) {
			return bruteForce(setSortedByX);
		}
		else {
			List<Point> leftSetSortedByX = setSortedByX.subList(0, size/2);
			List<Point> leftSetSortedByY = new ArrayList<Point>(leftSetSortedByX);
			leftSetSortedByY.sort(yComparator);
			Pair closestLeftPair = findClosestPair(leftSetSortedByX, leftSetSortedByY);

			List<Point> rightSetSortedByX = setSortedByX.subList(size/2, size);
			List<Point> rightSetSortedByY = new ArrayList<Point>(rightSetSortedByX);
			rightSetSortedByY.sort(yComparator);
			Pair closestRightPair = findClosestPair(rightSetSortedByX, rightSetSortedByY);

			Pair closestPair;
			if(closestLeftPair.distance < closestRightPair.distance)  {
				closestPair = closestLeftPair;
			}
			else  {closestPair = closestRightPair;}

			List<Point> withinStrip = new ArrayList<Point>();
			double delta = closestPair.distance;
			double verticalAxis = rightSetSortedByX.get(0).getX();
			for(Point point : setSortedByY)  {
				if(Math.abs(point.getX() - verticalAxis) < delta) {
					withinStrip.add(point);
				}
			}
			
			for(int i = 0; i < withinStrip.size(); i++)  {
				Point A = withinStrip.get(i);
				for(int j = i + 1; j < Math.min(withinStrip.size()-1, i+7); j++) {
					Point B = withinStrip.get(j);
					double curDistance = A.distance(B);
					if (curDistance < delta) {
						closestPair = new Pair(A,B);
						delta = curDistance;
					}
				}
			}
			

			return closestPair;
		}


		//return null;
	}




	public static void main(String[] args) {
		Point a = new Point(1,2);
		Point b = new Point(2,2);
		Point c = new Point(3,4);
		Point d = new Point(4,5);
		Point e = new Point(6,7);
		Point f = new Point(5,6);
		Point g = new Point(7,8);

		ArrayList<Point> n = new ArrayList<Point>();
		n.add(a);
		n.add(b);
		n.add(c);
		n.add(d);
		n.add(e);
		n.add(f);
		n.add(g);
		System.out.println(n.toString());

		System.out.println(findClosestPair(n).toString());


	}


}
