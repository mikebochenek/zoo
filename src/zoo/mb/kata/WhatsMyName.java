package zoo.mb.kata;

import java.util.Map;
import java.util.Properties;

public class WhatsMyName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> e = System.getenv();
		for (String key : e.keySet()) {
			//System.out.println(key + "   " + System.getenv(key));

		}
		
		Properties p = System.getProperties();
		
		
		System.out.println(System.getProperty("java.version"));

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		System.out.println(e.keySet());
		
	}

}
