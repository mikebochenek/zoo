package zoo.mb.top;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11635 
 * RainyRoad SRM 525 11.29.2011 ir5 Simple Search, Iteration 1 91.62% details
 * topcoder2.pdf
 * 
 * Problem Statement Fox Ciel is going to take a path to meet her friends. The
 * path is tiled with 1x1 square tiles. It is N tiles long and 2 tiles wide. If
 * we imagine that the path is going from the left to the right, we can view it
 * as a rectangle with 2 rows and N columns of tiles. The rows of the path are
 * numbered 0 to 1 from top to bottom, and the columns of the path are numbered
 * 0 to N-1 from left to right. Ciel starts at the tile in row 0, column 0. She
 * has to reach the tile in row 0, column N-1. In each step, Ciel can move to an
 * adjacent tile. Two tiles are adjacent if they share at least one point (a
 * side or a corner). Because it rained yesterday, some tiles are covered by
 * puddles of water. Ciel will not step on these tiles. You are given a String[]
 * road. The j-th character of i-th element is 'W' if a tile at i-th row of jth
 * column is covered by water, and '.' otherwise. Return the String "YES" if she
 * can move to her destination without entering a tile which is filled with
 * water. Otherwise, return "NO".
 */
public class RainyRoad {

	@Test
	public void test0() {
		assertTrue(isReachable(new String[]{".W.." ,"...."}));
	}

	@Test
	public void test1() {
		assertTrue(isReachable(new String[]{".W.." ,"..W."}));
	}
	
	@Test
	public void test2() {
		assertFalse(isReachable(new String[]{".W..W.." ,"...WWW."}));
	}
	
	@Test
	public void test3() {
		assertTrue(isReachable(new String[]{".." ,"WW"}));
	}
	
	@Test
	public void test4() {
		assertFalse(isReachable(new String[]{".WWWW." ,"WWWWWW"}));
	}

	@Test
	public void test5() {
		assertTrue(isReachable(new String[]{".W.W.W." ,"W.W.W.W"}));
	}

	@Test
	public void test6() {
		assertFalse(isReachable(new String[]{".............................................W."
				,".............................................W."}));
	}


	public boolean isReachable(String[] s) {
		for (int i = 0; i < s[0].length(); i++) {
			if (s[0].charAt(i) == 'W' && s[1].charAt(i) == 'W') {
				return false;
			}
		}
		return true;
	}

}
