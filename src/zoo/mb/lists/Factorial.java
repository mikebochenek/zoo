package zoo.mb.lists;

public class Factorial {

	private static int globalCount = 0;
	
	public static void main(String[] args) {
		Factorial f = new Factorial();
		
		for (int i = 0; i < 100; i++) {
			f.printTest(i);
			globalCount = 0;
		}
	}
	
	public void printTest(int i) {
		System.out.println(i + " -> " + /*f(i) +*/ "  compare: " + fastf(i) + "  globalCount=" + globalCount);
	}
	
	public int fastf(int n) {
		if (n <= 1) return 1;
		
		int[] nums = new int[n];
		nums[0] = 1;
		nums[1] = 2;
		for (int i = 2; i < n; i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		
		return nums[n-1];//f(i);
	}
	/** funny how fast it overflows...
	 * 45 ->   compare: 1836311903  globalCount=0
	 * 46 ->   compare: -1323752223  globalCount=0
	 */
	
	public int f(int i) {
		globalCount++;
		
		if (i == 0 || i == 1) {
			return 1;
		} else {
			return f(i - 1) + f(i - 2);
		}
	}
}
