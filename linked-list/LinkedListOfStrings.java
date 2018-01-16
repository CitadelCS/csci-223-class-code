package demo;

public class LinkedListOfStrings {

	// instance variables for LLoS
	private int size;
	private Node first;

	// methods for LLoS
	// I'll take the free constructor thanks!

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public void add(String item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}
	
	// only removes the first one.
	public void remove(){
		first = first.next;
		size--;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Node x = first; x != null; x = x.next){
			sb.append(x.item + "\n");
		}
		return sb.toString();
	}
	

	// inner classes for LLoS
	private static class Node {
		private String item;
		private Node next;
	}

}
