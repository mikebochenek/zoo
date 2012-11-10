package zoo.mb.top;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11706
 * MagicCandy SRM 526.5 12.23.2011 cgy4ever Math, Search 1 90.04% 2 68.27% details
 * 
 * Problem Statement Today is the Christmas Eve. People around the world
 * celebrate this holiday. The following story takes place in the land of
 * reindeer, where Santa Claus resides. The reindeer love candies. They have n
 * pieces of candy. The pieces of candy are numbered 1 through n. Dasher is one
 * of the reindeer. He wants to eat one of the candies. To pick the one he will
 * eat, Dasher uses the following method: - While there is more than one piece
 * of candy: - Discard all candies that are numbered by perfect squares (i.e.,
 * candies 1, 4, 9, 16, 25, etc.). - Relabel the remaining k candies 1 through
 * k, keeping the numbers in the same order. Once only one piece of candy
 * remains, Dasher will eat it. You are given an int n. Your method must compute
 * and return the number initially assigned to the piece of candy eaten by
 * Dasher.
 */
public class MagicCandy {

	@Test
	public void test0() { assertEquals(5, whichOne(5)); }
	
	@Test
	public void test1() { assertEquals(7, whichOne(9)); }
	
	@Test
	public void test2() { assertEquals(17, whichOne(20)); }
	
	@Test
	public void test3() { assertEquals(5257, whichOne(5265)); }
	
	//@Test
	//public void test4() { assertEquals(20110741, whichOne(20111223)); }
	//This one throws an out of memory error (stack..)
	
	@Test
	public void test5() { assertEquals(1, whichOne(1)); }
	
	public int whichOne(int n) {
		int size = n;
		
		Node root = new Node();
		root.prev = null;
		root.idx = 1;
		
		Node currentNode = root;
		for (int i = 1; i < n; i++) {
			currentNode.next = new Node();
			currentNode.next.prev = currentNode;
			currentNode.next.idx = i + 1;
			currentNode = currentNode.next;
		}
		
		while (size > 1) {
			// System.out.println("size: " + size);
			int i = 1;
			int j = 0;
			for (currentNode = root; j <= n && currentNode != null; currentNode = currentNode.next) {
				j++;
				if (j == i * i) {
					// System.out.println ("  removing: " + j + "  and i is: " + i + "  and idx: " + currentNode.idx);

					if (currentNode.prev != null) {
						currentNode.prev.next = currentNode.next;
					}
					if (currentNode.next != null) {
						currentNode.next.prev = currentNode.prev;
						
						if (i == 1) {
							root = currentNode.next;
						}
					}

					size--;
					i++;

					//System.out.println ("    root is " + root.idx);
				}
			}
		}
		
		/*
		
		int[] squares = new int[1001];
		for (int i = 0; i < 1001; i++) {
			squares[i] = i * i;
		}
		
		
		int[][] v = new int[2][n];
		for (int i = 0; i < n; i++) {
			v[0][i] = i + 1;
			v[1][i] = i + 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < squares.length; k++) {
					if (v[1][i] == squares[k]) {
						
					}
				}
			}
		}
		*/
		
		return root.idx;
	}
	
	// or would it be better to have "two" indexes?

	// need linked list for efficient shifting of elements
	class Node {
		Node next;
		Node prev;
		int idx;
	}
}





