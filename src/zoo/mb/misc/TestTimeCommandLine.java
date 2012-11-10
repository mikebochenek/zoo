package zoo.mb.misc;

import java.io.IOException;
import java.io.InputStream;

public class TestTimeCommandLine {

	public static void main(String[] args) {
		try {
			String command = "java";
			Process child = Runtime.getRuntime().exec(command);

			// Get the input stream and read from it
			InputStream in = child.getInputStream();
			int c;
			while ((c = in.read()) != -1) {
				// process((char)c);
				System.out.print(Character.toString((char)c));
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
