package zoo.mb.coekaerts.be;

/**
 * http://wouter.coekaerts.be/2012/puzzle-clowns
 * 
 * Introduction
 * 
 * 
 * This is the first in a series of Java puzzles, that put your Java skills to
 * the test, in a challenging and fun way! A puzzle consists of some given Java
 * code with a line in it that seems to be impossible to reach. It�s up to you
 * to find the hole in it, abuse a subtle behavior of Java to make execution
 * reach that line anyways.
 * 
 * There almost aren't any rules; any cheating inside your code is allowed; it
 * is the whole point of the puzzle. [Clarification: Cheating the environment is
 * not]. You must run with the security manager enabled (java
 * -Djava.security.manager), otherwise it would be too easy (with setAccessible
 * for example). [Update: Use common sense, and see the exact rules if you're in
 * doubt]. The puzzle
 * 
 * How can you fit 20 clowns into a Volkswagen? Two classes are given: an empty
 * Clown class, and a Volkswagen class to which you can add clowns. When you try
 * to add a Clown, it is checked that it isn't already full. But if you just try
 * hard enough, there's always room for some extra clowns'
 * 
 * Write a class that when executed pushes 20 clowns into the little car, and
 * reaches the marked line. Here is one that won't really work, just to get you
 * started:
 */
class Mine {
	public static void main(String args[]) {
		// TODO put 20 clowns into a Volkswagen
		Volkswagen vw = new Volkswagen() { public void add(Clown c) {
				//super.add(c);
				System.out.println("adding " + c);
			};
		};
		for (int i = 0; i < 20; i++) {
			vw.add(new Clown());
		}
		vw.done();
	}
}

public class You {
    static int counter = 0;
    static Volkswagen vw = new Volkswagen();
 
    public static void main(String args[]) {
        vw.add(new RecursiveClown());
        vw.done();
    }
 
    static class RecursiveClown extends Clown {
        public int hashCode() {
            if (++counter < 20) {
                vw.add(new RecursiveClown());
            }
            return super.hashCode();
        }
    }
}