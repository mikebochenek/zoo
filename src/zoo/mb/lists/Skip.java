package zoo.mb.lists;

import java.util.ArrayList;
import java.util.List;

public class Skip {

	public Skip(String n) {
		name = n;
		nextList.add(next);
		prevList.add(prev);
	}
	
	public static void main(String[] args) {
		Skip one = new Skip("one");
		Skip two = new Skip("two");
		Skip three = new Skip("three");
		
		two.add(three);
		one.add(two);
		
		
		two.remove(two);
		
		System.out.println(" one: " + one.toString());
		System.out.println(" one: " + two.next.backwardsToString());
		System.out.println(" one size: " + three.size());

	}

	
	private List<Skip> nextList = new ArrayList<Skip>();
	private List<Skip> prevList = new ArrayList<Skip>();
	
	private Skip next;
	private Skip prev;
	private String name;
	
	public void add(Skip s) {
		if (next != null) {
			next.prev = this;
		} else {
			s.prev = this;
		}
		next = s;
	}
	
	public Skip remove(Skip s) {
		Skip n = this;
		while (n != null) {
			if (s == n) {
				n.prev.next = n.next;
				if (n.next != null) n.next.prev = n.prev;
				return s;
			}
			n = next;
		}
		return null;
	}
	
	public String toString() {
		String ret = "";
		Skip n = this;
		while(n != null) {
			ret += n.name + " ";
			n = n.next;
		}
		return ret;
	}
	
	public String backwardsToString() {
		String ret = "(backwards) ";
		Skip n = this;
		while(n != null) {
			ret += n.name + " ";
			n = n.prev;
		}
		return ret;
	}
	
	public int size() {
		int s = 1;
		Skip n = this;
		while(n.next != null) {
			s++;
			n = n.next;
		}
		
		n = this;
		while(n.prev != null) {
			s++;
			n = n.prev;
		}
		
		return s;
	}

}
