package demo;

public class LinkedListOfStringsClient {

	public static void main(String[] args) {
		LinkedListOfStrings list = new LinkedListOfStrings();
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		list.add("so stay woke.");
		list.add("they be creepin.");
		list.add("they gon' find you.");
		list.add("gon' catch you sleepin.");
		
		System.out.println(list.toString());
		
		list.remove();
		
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
				
	}

}
