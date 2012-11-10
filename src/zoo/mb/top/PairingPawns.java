package zoo.mb.top;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11741 srm-529 div 1
 * 
 * Problem Statement "Pairing pawns" is a game played on a strip of paper,
 * divided into N cells. The cells are labeled 0 through N-1. Each cell may
 * contain an arbitrary number of pawns. You are given a int[] start with N
 * elements. For each i, element i of start is the initial number of pawns on
 * cell i. The goal of the game is to bring as many pawns as possible to cell 0.
 * The only valid move looks as follows: Find a pair of pawns that share the
 * same cell X (other than cell 0). Remove the pair of pawns from cell X. Add a
 * single new pawn into the cell X-1. You may make as many moves as you wish, in
 * any order. Return the maximum number of pawns that can be in cell 0 at the
 * end of the game.
 * 
 * 17 minutes
 */
public class PairingPawns {

	@Test
	public void Test0() {
		assertEquals(1, savedPawnCount(new int[]{0,2}));
		// There are two pawns on cell 1. You can remove them both and place a
		// pawn onto cell 0.
	}
	
	@Test
	public void Test1() {
		assertEquals(11, savedPawnCount(new int[]{10,3}));
		// There are 10 pawns already on cell 0. You can add another one by
		// removing two pawns from cell 1. Note that at the end of the game cell 1
		// will still contain one pawn that cannot be used anymore.
	}
	
	@Test
	public void Test2() {
		assertEquals(1, savedPawnCount(new int[]{0,0,0,8}));
		// After 7 moves you can get a single pawn to cell 0. The rest of the board
		// will be empty.
	}
	
	@Test
	public void Test3() {
		assertEquals(1, savedPawnCount(new int[]{0,1,1,2}));
		// Again, a single pawn can reach the leftmost cell.
	}
	
	@Test
	public void Test4() {
		assertEquals(0, savedPawnCount(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,123456}));
		// That's a lot of pawns! But they are too far away. In this case it is
		// impossible for a pawn to reach cell 0.
	}
	
	@Test
	public void Test5() {
		assertEquals(3921, savedPawnCount(new int[]{1000,2000,3000,4000,5000,6000,7000,8000}));
	}
	
	
	public int savedPawnCount(int[] start) {
		
		for (int i = start.length - 1; i > 0; i--) {
			start[i-1] += start[i] / 2;
		}
		
		return start[0];
	}
}
