package zoo.mb.chapter11;

public class MainTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleLinkQueue<String> queue = new SingleLinkQueue<String>();
		queue.add("Hello");
		queue.add("World");

		// queue.add(25); // INVALID: won't compile

		Cell<String> strCell = new Cell<String>("Hello");
		Cell<Integer> intCell = new Cell<Integer>(25);
		boolean same = (strCell.getClass() == intCell.getClass());
	}

}
