package zoo.mb.lists;

public class WalkingSteps {

	public static void main(String[] args) {
		WalkingSteps ws = new WalkingSteps();
		ws.trysteps(2);
	}
	
	public void trysteps(int i) {
		System.out.println (i + " : " + count(i));
	}

	public int count(int steps) {
		if (steps <= 1) {
			return 1;
		}
		return 1;
	}
}
