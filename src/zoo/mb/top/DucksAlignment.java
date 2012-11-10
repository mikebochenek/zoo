package zoo.mb.top;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11667
 * DucksAlignment SRM 526 12.06.2011 fushar Brute Force, Greedy 1 81.21% 2
 * 55.24% details
 * 
 * Mr. Dengklek has a rectangular farm conveniently divided into a grid of unit
 * squares. At this moment, each unit square contains at most one duck.
 * Moreover, each row and column of the farm also contains at most one duck. You
 * are given a String[] grid. The jth character of the ith element of grid
 * will be 'o' if there is exactly one duck in square (i, j), i.e., row i column
 * j, or '.' if there is no duck in that square.
 * 
 * Today, Mr. Dengklek wants to align the ducks so that the ducks form a
 * contiguous line. More precisely, assume that there are N ducks on the farm.
 * After the alignment, the ducks must either occupy N contiguous squares in
 * some row or N contiguous squares in some column. To accomplish that, he will
 * move the ducks one at a time. To move a duck in square (a, b) to another
 * empty square (c, d), he needs |ac| + |bd| seconds, where |x| denotes
 * the absolute value of x. Mr. Dengklek can always move any duck to any empty
 * square he desires - the other ducks are not obstacles.
 * 
 * Return the minimum time in seconds Mr. Dengklek needs to align the ducks.
 * Note that restrictions imposed on the initial placement of ducks guarantee
 * that a proper alignment is always possible.
 * 
 */
public class DucksAlignment {

	@Test
	public void test0() {
		assertEquals(1, minimumTime(new String[] {".o", "o."}));
	}

	@Test
	public void test1() {
		assertEquals(3, minimumTime(new String[] {".o...", "..o..", "....o"}));
	}

	@Test
	public void test2() {
		assertEquals(16, minimumTime(new String[] {"o..........", "..o........", ".......o...", "...........",
				"...........", "...........", "........o..", "..........."}));
	}

	@Test
	public void test3() {
		assertEquals(0, minimumTime(new String[] {".........", "....o....", "........."}));
	}

	@Test
	public void test4() {
		assertEquals(99, minimumTime(new String[] {"...o..........................",
				"............................o.",
				".o............................",
				"............o.................",
				".................o............",
				"......................o.......",
				"......o.......................",
				"....o.........................",
				"...............o..............",
				".......................o......",
				"...........................o..",
				".......o......................"}));
	}

	public int minimumTime(String[] grid) {
		// translate to boolean array
		//boolean[][] x = new boolean[grid.length][grid[0].length()];
		
		int[] minColumn = new int[grid[0].length()];
		int[] minRow = new int[grid.length];
		
		// eval min for each possible column
		for (int i = 0; i < minColumn.length; i++) {
			minColumn[i] = evalMinColumn(Arrays.copyOf(grid, grid.length), i);
		}
		
		// eval min for each possible row
		for (int i = 0; i < minRow.length; i++) {
			minRow[i] = evalMinRow(Arrays.copyOf(grid, grid.length), i);
		}

		// combine into overal min
		Arrays.sort(minColumn);
		Arrays.sort(minRow);
		
		return Math.min(minColumn[0], minRow[0]);
	}
	
	private int evalMinColumn(String[] grid, int column) {
		int count = 0;
		
		boolean adjustNeeded = false;
		int countO = 0;
		for (int i = 0; i < grid.length; i++) {
			int idx = grid[i].indexOf('o');
			if (idx != -1) {
				count += Math.abs(column - idx);
				countO++;
			} else {
				adjustNeeded = true;
			}
		}
		
		if (adjustNeeded && countO != 1) {
			//move all up
			
			
			//move all down
		}
		
		return count;
	}
	

	private int evalMinRow(String[] grid, int row) {
		int count = 0;

		boolean adjustNeeded = false;
		int countO = 0;
		for (int i = 0; i < grid.length; i++) {
			int idx = grid[i].indexOf('o');
			if (idx != -1) {
				count += Math.abs(row - idx);
				countO++;
			} else {
				adjustNeeded = true;
			}
		}
		
		
		if (adjustNeeded && countO != 1) {
			count += 3;
		}
		
		return count;
	}
	
}
