package zoo.mb.kata;

/**
 * Given a number N, how can I print out a Christmas tree of height N using the
 * least number of code characters? N is assumed constrained to a min val of 3, 
 * and a max val of 30 (bounds and error checking are not necessary). 
 * N is given as the one and only command line argument to your program or script.
 * 
 * Bonuse kudos and upvotes for original language attempts.
 * 
 * A Christmas tree is generated as such, with its "trunk" consisting of only a centered "*"
 * 
 * N defines the height of the branches not including the one line trunk.
 */
public class ChristmasTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(drawLevel(0, 3));
	}

	public static String drawLevel(int level, int height) {
		String levelString = "";
		for (int i = height; i > level; i--) {
			levelString += " ";
		}
		for (int i = 0; i < level; i++) {
			levelString += "**";
		}
		
		if (level == height) {
			return levelString + "*\n";
		} else {
			return levelString + "*\n" + drawLevel(++level, height);
		}
	}
}
