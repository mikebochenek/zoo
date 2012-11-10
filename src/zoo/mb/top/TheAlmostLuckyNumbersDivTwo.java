package zoo.mb.top;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11462
 * TheAlmostLuckyNumbersDivTwo SRM 510 06.21.2011 Vasyl[alphacom] Simple Search,
 * Iteration 1 91.60%
 * 
 * Problem Statement John and Brus believe that the digits 4 and 7 are lucky and
 * all others are not. According to them, an almost lucky number is a number
 * that contains at most one non-lucky digit in its decimal representation.
 * Return the total number of almost lucky numbers between a and b, inclusive.
 * 
 * 14 minutes
 */
public class TheAlmostLuckyNumbersDivTwo {

	@Test
	public void Test0() {
		assertEquals(4, find(4,7));
	}
	
	@Test
	public void Test1() {
		assertEquals(4, find(8,19));
	}
	
	@Test
	public void Test2() {
		assertEquals(0, find(28,33));
	}
	
	@Test
	public void Test3() {
		assertEquals(36, find(1234,4321));
	}
	
	public int find(int a, int b) {
		int count = 0;
		
		for (int i = a; i <= b; i++) {
			String s = ""+i;

			int unluckyCharInstanceCount = 0;
			for (int j = 0; j < s.length(); j++) {
				if (!(s.charAt(j) == '7' || s.charAt(j) == '4')) {
					unluckyCharInstanceCount++;
				}
			}
			if (unluckyCharInstanceCount <= 1) {
				count++;
			}
		}
		
		return count;
	}
}
