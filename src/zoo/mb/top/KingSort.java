package zoo.mb.top;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11740 KingSort SRM
 * 529 01.14.2012 misof Simple Math, Sorting, String Manipulation, String
 * Parsing 1 83.65% 2 65.97% details
 * 
 * Problem Statement Every good encyclopedia has an index. The entries in the
 * index are usually sorted in alphabetic order. However, there are some notable
 * exceptions. In this task we will consider one such exception: the names of
 * kings. In many countries it was common that kings of the same name received
 * ordinal numbers. This ordinal number was written as a Roman numeral and
 * appended to the actual name of the king. For example, "Louis XIII" (read:
 * Louis the thirteenth) was the thirteenth king of France having the actual
 * name Louis. In the index of an encyclopedia, kings who share the same name
 * have to be sorted according to their ordinal numbers. For example, Louis the
 * 9th should be listed after Louis the 8th. You are given a String[] kings.
 * Each element of kings is the name of one king. The name of each king consists
 * of his actual name, a single space, and a Roman numeral. Return a String[]
 * containing the names rearranged into their proper order: that is, the kings
 * have to be in ascending lexicographic order according to their actual name,
 * and kings with the same name have to be in the correct numerical order.
 * 
 * 
 * Constraints -Each actual name of a king will be a string containing between 1
 * and 20 characters, inclusive.-Each actual name will start by an uppercase
 * letter ('A'-'Z').-Each other character in each actual name will be a
 * lowercase letter ('a'-'z').-kings will contain between 1 and 50 elements,
 * inclusive.-Each element of kings will have the form "ACTUALNAME ORDINAL",
 * where ACTUALNAME is an actual name as defined above, and ORDINAL is a valid
 * Roman numeral representing a number between 1 and 50, inclusive.-The elements
 * of kings will be pairwise distinct.
 */
public class KingSort {

	@Test
	public void test0() {
		assertTrue(same(new String[]{"Louis VIII", "Louis IX" }, getSortedList(new String[]{"Louis IX", "Louis VIII"})));
		// Louis the 9th should be listed after Louis the 8th.
	}
	
	@Test
	public void test1() {
		assertTrue(same(new String[]{"Louis IX", "Philippe II" }, getSortedList(new String[]{"Louis IX", "Philippe II"})));
		// Actual names take precedence over ordinal numbers.
	}
	
	@Test
	public void test2() {
		assertTrue(same(new String[]{"Richard I", "Richard II", "Richard III" }, getSortedList(new String[]{"Richard III", "Richard I", "Richard II"})));
	}
	
	@Test
	public void test3() {
		assertTrue(same(new String[]{"John I", "John V", "John X", "John L" }, getSortedList(new String[]{"John X", "John I", "John L", "John V"})));
	}
	@Test
	public void test4() {
		assertTrue(same(new String[]{"Charles V", "Charles VI", "Charles VII", "Jean II", "Louis XI", "Philippe VI" }, getSortedList(new String[]{"Philippe VI", "Jean II", "Charles V", "Charles VI", "Charles VII","Louis XI"})));
		// These are the French monarchs who ruled between 1328 and 1483.
	}
	@Test
	public void test5() {
		assertTrue(same(new String[]{"Philip II", "Philippe II" }, getSortedList(new String[]{"Philippe II", "Philip II"})));
		// "Philippe" and "Philip" are distinct names, and "Philip" is lexicographically smaller than "Philippe".
	}


	
	public String[] getSortedList(String[] kings) {
		for (int i = 0; i < kings.length; i++) {
			String presumablyRomanNumeral = kings[i].split(" ")[1];
			//System.out.println (presumablyRomanNumeral);
			//kings[i] = kings[i].split(" ")[0] + "" + convertRomanToSortableString(presumablyRomanNumeral);
		}
		
		for (int i = 0; i < kings.length; i++) {
			//System.out.println (kings[i]);
		}
		
		// Arrays.sort(kings);
		for (int i = 0; i < kings.length; i++) {
			for (int j = i; j < kings.length; j++) {
				String ki = kings[i].split(" ")[0] + convertRomanToSortableString(kings[i].split(" ")[1]);
				String kj = kings[j].split(" ")[0] + convertRomanToSortableString(kings[j].split(" ")[1]);
				if (ki.compareTo(kj) > 0) {
					String temp = kings[i];
					kings[i] = kings[j];
					kings[j] = temp;
				}
			}
		}
		
		
		return kings;
	}

	/**
	 * The Roman numerals for 1 through 10 are I, II, III, IV, V, VI, VII,
	 * VIII, IX, and X.-The Roman numerals for 20, 30, 40, and 50 are XX, XXX,
	 * XL, and L.-The Roman numeral for any other two-digit number less than 50
	 * can be constructed by concatenating the numeral for its tens and the
	 * numeral for its ones. For example, 47 is 40 + 7 = "XL" + "VII" =
	 * "XLVII".-Standard string comparison routines give the correct ordering
	 * for the actual names of kings.-Formally, given two different strings A
	 * and B we say that A is lexicographically smaller than B if either (A is a
	 * prefix of B) or (there is at least one index where A and B differ, and
	 * for the smallest such index the character in A has a lower ASCII value
	 * than the character in B).
	 * 
	 * @param s
	 * @return
	 */
	private String convertRomanToSortableString(String s) {
		//System.out.println ("IN: " + s);
		String r = "";
		
		if (s.startsWith("L")) {
			s = s.replaceFirst("L", "");
			r += "5";
		} else if (s.startsWith("XL")) {
			s = s.replaceFirst("XL", "");
			r += "4";
		} else if (s.startsWith("XXX")) {
			s = s.replaceFirst("XXX", "");
			r += "3";
		} else if (s.startsWith("XX")) {
			s = s.replaceFirst("XX", "");
			r += "2";
		} else if (s.startsWith("X")) {
			s = s.replaceFirst("X", "");
			r += "1";
		} else {
			r += "0";
		}

		if (s.equals("IX")) r += "9";
		else if (s.equals("VIII")) r += "8";
		else if (s.equals("VII")) r += "7";
		else if (s.equals("VI")) r += "6";
		else if (s.equals("V")) r += "5";
		else if (s.equals("IV")) r += "4";
		else if (s.equals("III")) r += "3";
		else if (s.equals("II")) r += "2";
		else if (s.equals("I")) r += "1";
		else r += "0";
		
		//System.out.println ("OUT: " + r);
		
		return r;
	}
	
	
	public boolean same(String[] a, String[] b) {
		if (a.length != b.length) return false;
		
		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(b[i])) {
				//System.out.println ("ex " + a[i] +  "   got " + b[i]);
				return false;
			}
		}
		
		return true;
	}
}
