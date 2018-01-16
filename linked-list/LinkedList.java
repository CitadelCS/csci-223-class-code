package demo;

import java.util.Iterator;

public class LinkedList<AnyType> implements Iterable<AnyType> {

	// here are the instance variables/data fields for the list
	private int size;
	private Node<AnyType> first;

	// here are the instance methods for the class

	// no constructor needed since default constructor is fine.

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void add(AnyType item) {
		Node<AnyType> oldFirst = first;
		first = new Node<AnyType>();
		first.item = item;
		first.next = oldFirst;
		size++;
	}

	// only removes the first one.
	public void remove() {
		first = first.next;
		size--;
	}

	public String toString() {
		// perhaps re-define this to use the iterator instead of doing it
		// manually.
		StringBuilder sb = new StringBuilder();
		for (Node<AnyType> x = first; x != null; x = x.next) {
			sb.append(x.item + "\n");
		}
		return sb.toString();
	}

	// here's the method we must write to call ourselves Iterable
	// it's only job is to return an object that knows how to iterate over this
	// list.
	@Override
	public Iterator<AnyType> iterator() {
		return new SuperFancyIterator<AnyType>(first);
	}

	// here come the inner classes used by the list.

	/*
	 * we don't need to write a constructor -- the default one is fine. we don't
	 * need getters/setters since it's a nested class. private means no other
	 * class can use this Node type static means this inner class can only
	 * access static members of the list class
	 */
	private static class Node<AnyType> {
		private AnyType item;
		private Node<AnyType> next;
	}

	/*
	 * this class defines an iterator that knows how to traverse this
	 * collection. an iterator is like an arrow you advance through a collection
	 * one by one. in our case, our iterator knows that our data items are
	 * trapped inside of our linked list nodes.
	 */
	private static class SuperFancyIterator<AnyType> implements Iterator<AnyType> {
		// the only instance variable is the reference to the next node to
		// process
		private Node<AnyType> nextNode;

		// the constructor needs a reference to the first node in the list to
		// set things up.
		public SuperFancyIterator(Node<AnyType> startNode) {
			nextNode = startNode;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		// this method is careful to return the item, not the node itself.
		public AnyType next() {
			Node<AnyType> save = nextNode;
			nextNode = nextNode.next;
			return save.item;
		}

	}

}
