package zoo.mb.misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SortingTest extends TestCase {
	
	private long exchangeCount = 0;
	private long comparisonCount = 0;

	//TODO rewrite using generics
	//TODO re-try Flannan's two sample questions from January..
	
	public void sort(Comparable[] a) { 
		/* See Algorithms 2.1, 2.2, 2.3, 2.4, 2.5, or 2.7. */
		
		/* 
		 * Selection Sort: One of the simplest sorting algorithms works as follows: First, find
		 * the smallest item in the array and exchange it with the first entry (itself if the first entry
		 * is already the smallest). Then, find the next smallest item and exchange it with the second
		 * entry. Continue in this way until the entire array is sorted. This method is called
		 * selection sort because it works by repeatedly selecting the smallest remaining item. */
		for (int i = 0; i < a.length; i++) {
			
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			
			exch(a, minIndex, i);
		}
		
/*		
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (less(a[j], a[i])) {
					exch(a, j, i); // whoa, pretty funny that I guessed these two lines without thinking it through...
				} //hmmm... I don't think this is selection sort - this is more like bubble sort..
			}
		}
*/		
	}

	private boolean less(Comparable v, Comparable w) {
		comparisonCount++;
		return v.compareTo(w) < 0;
	}

	private void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		
		exchangeCount++;
	}

	private void show(Comparable[] a) { // Print the array, on a single line.
		
		System.out.print(" comparisonCount: " + (comparisonCount-a.length) 
				+  " exchangeCount: " + exchangeCount + " ---> ");
//		for (int i = 0; i < a.length; i++)
//			System.out.print(a[i] + " ");
		System.out.println();
	}

	public boolean isSorted(Comparable[] a) { // Test whether the array
																										// entries are in order.
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	@Test
	public void testStrings() {
		String[] a = {"xyz", "bob", "alice", "malice", "adam"};
		sort(a);
		assertTrue( isSorted(a) );
		show(a);
	}
	
	@Test
	public void testIntegers() {
		Integer[] i = {-2, 0, -4, 4, 0, -9, 10};
		sort(i);
		assertTrue ( isSorted(i) );
		show(i);
	}
	
	@Test
	public void testRandomIntegers() {
		Long[] i = new Long[10000];
		for (int j = 0; j < i.length; j++) {
			i[j] = Math.round((Math.random() * i.length));
		}
		sort(i);
		assertTrue ( isSorted(i) );
		show(i);
	}
	
	@Before
	public void before() {
		exchangeCount = 0;	
		comparisonCount = 0;
	}
}