package zoo.mb.top;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11553 WhichDay SRM
 * 519 09.19.2011 misof Simple Search, Iteration, String Manipulation 1 97.23%
 * topcoder3.pdf
 * 
 * Problem Statement This week there will be an important meeting of your entire
 * department. You clearly remember your boss telling you about it. The only
 * thing you forgot is the day of the week when the meeting will take place. You
 * asked six of your colleagues about the meeting. None of them knew the day
 * when it will take place, but each of them remembered one day when it will not
 * take place. The days they remembered were distinct. For a clever programmer
 * like you, this was enough to determine the day of the meeting. You are given
 * a String[] notOnThisDay containing six weekdays when the meeting will not
 * take place. Return the weekday of the meeting.
 */
public class WhichDay {

	@Test
	public void test0() {
		assertEquals("Saturday", getDay(new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday","Friday"}));
	}

	@Test
	public void test1() {
		assertEquals("Saturday", getDay(new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Friday","Thursday"}));
	}

	@Test
	public void test2() {
		assertEquals("Wednesday", getDay(new String[]{"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"}));
	}

	@Test
	public void test3() {
		assertEquals("Thursday", getDay(new String[]{"Sunday", "Friday", "Tuesday", "Wednesday", "Monday","Saturday"}));
	}

	
	private final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public String getDay(String[] notOnThisDay) {
		boolean[] found = new boolean[days.length];
		for (String not : notOnThisDay) {
			for (int i = 0; i < days.length; i++) {
				if (not.equals(days[i])) {
					found[i] = true;
				}
			}
		}
		
		for (int i = 0; i < found.length; i++) {
			if (found[i] == false) {
				return days[i];
			}
		}
		
		return null;
	}
}
