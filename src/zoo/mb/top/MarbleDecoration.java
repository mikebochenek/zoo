package zoo.mb.top;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11287
 * MarbleDecoration SRM 512 07.13.2011 fushar Brute Force, Simple Math, Simple
 * Search, Iteration 1 89.60%
 * 
 * Problem Statement for MarbleDecoration Problem Statement Ash is a marble
 * collector and he likes to create various ornaments using his marbles. One
 * day, Elsh asks him to create a simple decoration for her desk. She wants a
 * sequence of marbles consisting of at most two different colors. To make the
 * sequence look interesting, each pair of adjacent marbles must have different
 * colors. Currently, Ash has R red marbles, G green marbles, and B blue
 * marbles. Elsh wants that the resulting sequence is as long as possible.
 * Return this maximum length.
 * 
 * 45 minutes
 */
public class MarbleDecoration {

	@Test
	public void Test0() {
		assertEquals(0, maxLength(0,0,0));
	}

	@Test
	public void Test1() {
		assertEquals(1, maxLength(3,0,0));
	}

	@Test
	public void Test2() {
		assertEquals(5, maxLength(5,1,2));
	}

	@Test
	public void Test3() {
		assertEquals(14, maxLength(7,7,4));
	}

	@Test
	public void Test4() {
		assertEquals(7, maxLength(2,3,5));
	}

	@Test
	public void Test5() {
		assertEquals(26, maxLength(13,13,13));
	}

	public int maxLength(int R, int G, int B) {
		int[] x = new int[3];
		x[0] = R;
		x[1] = G;
		x[2] = B;
		
		Arrays.sort(x);
		
		int total = x[1] * 2;
		
		if (x[2] > x[1]) total ++;
		
		return total;
	}
}
