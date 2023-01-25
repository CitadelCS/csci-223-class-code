

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

	// here are the instance variables/data fields for the list  
  private int size;
  private Node<Item> first;

  // no constructor because default is fine.

	// here are the instance methods for the class
  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    Iterator<Item> iter = this.iterator();
    while (iter.hasNext())
      sb.append(iter.next().toString() + "\n");
    return sb.toString();
  }

  // add to beginning
  public void add(Item item) {
    Node<Item> oldFirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldFirst;
    size++;
  }

  // remove from beginning
  public Item remove(){
      Item doomed = null;
      if(!isEmpty()) {
          doomed = first.item;
          first = first.next;
          size--;
      }
      return doomed;
  }


  // --- homework LL methods go in here


  // ---
  
	// here's the method we must write to call ourselves Iterable
	// it's only job is to return an object that knows how to iterate over this
	// list.
  @Override
  public Iterator<Item> iterator() {
    return new FancyIterator<Item>(first);
  }

	// here come the inner classes used by the list.

	/*
	 * we don't need to write a constructor -- the default one is fine. we don't
	 * need getters/setters since it's a nested class. private means no other
	 * class can use this Node type static means this inner class can only
	 * access static members of the list class
	 */  
  private static class Node<Item> {
    Item item;
    Node<Item> next;
  }

	/*
	 * this class defines an iterator that knows how to traverse this
	 * collection. an iterator is like an arrow you advance through a collection
	 * one by one. in our case, our iterator knows that our data items are
	 * trapped inside of our linked list nodes.
	 */
  private static class FancyIterator<Item> implements Iterator<Item> {
		// the only instance variable is the reference to the next node to
		// process
    private Node<Item> nextNode;

    // the constructor needs a reference to the first node in the list to
		// set things up.
    public FancyIterator(Node<Item> startNode) {
      nextNode = startNode;
    }

    @Override
    public boolean hasNext() {
      return nextNode != null;
    }

    // this method is careful to return the item, not the node itself.
    @Override
    public Item next() {
      Node<Item> save = nextNode;
      nextNode = nextNode.next;
      return save.item;
    }

  }
}
