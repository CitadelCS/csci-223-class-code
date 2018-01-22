import java.util.Iterator;

public class LinkedListClient {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();

		System.out.println(list.size());
		System.out.println(list.isEmpty());

		list.add("so stay woke.");
		list.add("they be creepin'.");
		list.add("they gon' find you.");
		list.add("gon' catch you sleepin'.");

		System.out.println(list.toString());

		list.remove();

		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		// only possible after implementing Iterable interface
		for(String s : list)
			System.out.println(s);
		
		// here's the long way (or manual way) of doing the above
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());

	}

}
