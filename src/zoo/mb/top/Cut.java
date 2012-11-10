package zoo.mb.top;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=11564 Cut SRM 528
 * 12.28.2011 ir5 Greedy, Simulation 1 64.98% 2 33.41%
 * 
 * Problem Statement Fox Ciel wants to eat eels as a celebration of this year's
 * end. Initially, Ciel has some eels of various lengths. She only likes to eat
 * eels of length exactly 10, no more, no less. Before she eats, she may cut the
 * eels to prepare pieces of desired length. However, she only has the time to
 * make at most maxCuts cuts. A single cut looks as follows: 1. Fox Ciel chooses
 * one of the eels. Let its length be x. She can only choose an eel of length
 * greater than 1. 2. She chooses an integer y such that 0 < y < x. 3. She cuts
 * the eel into two pieces so that one of them measures exactly y. In other
 * words, instead of one eel of length x she now has two eels of lengths y and
 * (x y), respectively. You are given a int[] eelLengths. Each element of
 * eelLengths is the length of one of the eels Ciel has at the beginning. You
 * are also given the int maxCuts. Return the maximum number of eels of length
 * exactly 10 she can produce.
 * 
 * 29 minutes
 */
public class Cut {

	@Test
	public void test0() {
		assertEquals(3, getMaximum(new int[] { 13, 20, 13 }, 2));
		/* First, cut eel 0 into two pieces of lengths 10 and 3. Next, cut eel 1
		 * into two equal parts of length 10 each. This produces a total of 3
		 * eels whose length is
		 */
	}

	@Test
	public void test1() {
		assertEquals(0, getMaximum(new int[] { 5, 5, 5, 5 }, 2));
		/* There are four eels whose length is 5. As you cannot combine eels, it
		 * is impossible to make an eel of length 10.
		 */
	}

	@Test
	public void test2() {
		assertEquals(5, getMaximum(new int[] { 34, 10, 48 }, 4));
		/* She already has one eel of length 10. By cutting the other two eels
		 * she can produce four more eels of the desired length.
		 */
	}

	@Test
	public void test3() {
		assertEquals(16, getMaximum(new int[] { 30, 50, 30, 50 }, 350));
		/* She may cut eels at most 350 times, but in this case she doesn't have
		 * to cut them so many times.
		 */
	}

	public int getMaximum(int[] eelLengths, int maxCuts) {
		int count = 0;
		
		for (int i = 0; i < eelLengths.length; i++) {
			if (eelLengths[i] == 10) {
				count++;
				eelLengths[i] -= 9;
			}
		}


		for (int i = 0; i < eelLengths.length && maxCuts > 0; i++) {
			int cuts = eelLengths[i] / 10;
			
			if (eelLengths[i] % 10 == 0 && cuts > 0) {
				cuts -= 1;
				count++;
			}

			if (cuts > 0 && cuts <= maxCuts) {
				count += cuts;
				maxCuts -= cuts;
			}
			
			if (cuts > 0 && cuts > maxCuts) {
				count += maxCuts;
				maxCuts = 0;
			}
		}
		
		return count;
	}
}
