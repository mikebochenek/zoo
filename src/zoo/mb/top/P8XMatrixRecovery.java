package zoo.mb.top;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A binary matrix is a matrix in which each element is either 0 or 1. There is
 * a secret binary matrix with R rows and C columns. Your task is to determine
 * its elements from two partial descriptions.
 * 
 * The first description is given as a String[] rows with R elements. Each
 * element of rows will be a string of C characters. Element i of rows describes
 * the i-th row of the secret matrix. Each character in each element of rows is
 * either '0', '1', or '?'. The meaning of '?' is that the corresponding element
 * of the matrix may be either 0 or 1.
 * 
 * The second description is given as a String[] columns with C elements. Each
 * element of columns will be a string of R characters. Each element of columns
 * describes one column of the secret matrix. Different elements of columns
 * represent different columns, but not necessarily in the correct order. Again,
 * each character in each element of columns is either '0', '1', or '?'.
 * 
 * You may assume that there is at least one binary matrix that corresponds to
 * both descriptions: its rows match the elements of rows (in the same order)
 * and its columns match the elements of columns (after a suitable permutation
 * is applied on columns). Your method must find the lexicographically smallest
 * of all such matrices. Return that matrix formatted as a String[].
 * 
 * Notes
 * -	Given two different matrices A and B, let i be the first 
 * row on which they differ, and let j be the first element in that row on which 
 * they differ. If A[i,j] < B[i,j], we say that A is lexicographically smaller
 * than B, and vice versa.
 * 
 * Constraints
 * -	rows will contain between 1 and 30 elements, inclusive.
 * -	Each element of rows will contain between 1 and 30 characters, inclusive.
 * -	All the elements of rows will contain the same number of character.
 * -	Each character in each element of rows will be either '0', '1', or '?'.
 * -	columns will contain exactly C elements, where C is the number of 
 * 		elements in rows[0].
 * -	Each element of columns will contain exactly R characters, 
 * 		where R is the number of elements in rows.
 * -	Each character in each element of columns will be '0', '1', or '?'.
 * -	There will be at least one binary matrix that corresponds to both 
 * 		rows and columns in the way described in the problem statement.
 */
public class P8XMatrixRecovery {
	
	@Test
	public void test0() {
		/* Note that columns[0] describes column 1 of the secret matrix, columns[1] describes column 0 and columns[2] describes column 2. */
		assertArrayEquals(new String[] {"101", "011" }, 
				solve(new String[] {"10?","?11"}, new String[] {"01","10","1?"}));
	}

	@Test
	public void test1() {
		/* There are two matrices that match both descriptions. We return the lexicographically smaller one. */
		assertArrayEquals(new String[] {"0", "0", "1" }, 
				solve(new String[] {"0","?","1"}, new String[] {"0?1"}));
	}

	@Test
	public void test2() {
		assertArrayEquals(new String[] {"010", "110", "101", "101" }, 
				solve(new String[]{"??0","11?","?01","1?1"}, new String[] {"1???","?111","0?1?"}));
	}
	
	@Test
	public void test3() {
		assertArrayEquals(new String[] {"101", "011" }, 
				solve(new String[] {"10?","?11"}, new String[] {"01","10","1?"}));
	}


	public String[] solve(String[] rows, String[] columns) {
		return null;
	}
}
