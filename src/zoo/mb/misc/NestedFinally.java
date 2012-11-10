package zoo.mb.misc;

public class NestedFinally {

	public static void main(String[] args) {
		

		try {

			try {
				Long.parseLong("ss");
			} catch (NumberFormatException nfe) {
				System.out.println ("nfe " + nfe);
			} finally {
				System.out.println ("inner finally");
			}

			
		} finally {
			System.out.println ("outer finally");
		}
	}

}
