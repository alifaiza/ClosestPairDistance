
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ClosestPairTest {
	
	@Test
	public void test() {
		
		List<Point> a = ClosestPair.randomPointListGenerator(5);
		List<Point> b = ClosestPair.randomPointListGenerator(10);
		List<Point> c = ClosestPair.randomPointListGenerator(15);
		List<Point> d = ClosestPair.randomPointListGenerator(20);
		List<Point> e = ClosestPair.randomPointListGenerator(100);
		
		Pair A1 = ClosestPair.findClosestPair(a);
		Pair A2 = ClosestPair.bruteForce(a);
		Pair B1 = ClosestPair.findClosestPair(b);
		Pair B2 = ClosestPair.bruteForce(b);
		Pair C1 = ClosestPair.findClosestPair(c);
		Pair C2 = ClosestPair.bruteForce(c);
		Pair D1 = ClosestPair.findClosestPair(d);
		Pair D2 = ClosestPair.bruteForce(d);
		Pair E1 = ClosestPair.findClosestPair(e);
		Pair E2 = ClosestPair.bruteForce(e);
		System.out.println(A1.toString());
		System.out.println(A2.toString());
		System.out.println(B1.toString());
		System.out.println(B2.toString());
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		System.out.println(D1.toString());
		System.out.println(D2.toString());
		System.out.println(E1.toString());
		System.out.println(E2.toString());
		
		assertTrue(Math.floor(A1.distance) == Math.floor(A2.distance));
		assertTrue(Math.floor(B1.distance) == Math.floor(B2.distance));
		assertTrue(Math.floor(C1.distance) == Math.floor(C2.distance));
		assertTrue(Math.floor(D1.distance) == Math.floor(D2.distance));
		assertTrue(Math.floor(E1.distance) == Math.floor(E2.distance));


		

		
		/*lst = new SkipList();
		lst.insert("4", "four");
		SkipList.print(lst);
		System.out.println("\n");
		lst.insert("5","five");
		SkipList.print(lst);
		System.out.println("\n");
		lst.insert("6", "six");
		SkipList.print(lst);
		System.out.println("\n");
		lst.insert("Nice", "car");
		SkipList.print(lst);
		System.out.println("\n");
		lst.insert("Assignment", "6");
		SkipList.print(lst);
		System.out.println("\n");
		
		assertEquals(lst.get("4"), "four");		
		assertEquals(lst.get("5"), "five");
		assertEquals(lst.get("6"), "six");*/

	}	

}
