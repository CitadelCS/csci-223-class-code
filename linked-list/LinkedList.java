

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

  private int size;
  private Node<Item> first;

  // no constructor because default is fine.

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
  public void remove() {
    first = first.next;
    size--;
  }


  // --- homework LL methods go in here


  // ---

  @Override
  public Iterator<Item> iterator() {
    return new FancyIterator<Item>(first);
  }

  // helper static classes to follow.

  // this is a node.
  private static class Node<Item> {
    Item item;
    Node<Item> next;
  }

  // this is an iterator class for Items in this linked list.
  private static class FancyIterator<Item> implements Iterator<Item> {
    private Node<Item> nextNode;

    public FancyIterator(Node<Item> startNode) {
      nextNode = startNode;
    }

    @Override
    public boolean hasNext() {
      return nextNode != null;
    }

    @Override
    public Item next() {
      Node<Item> save = nextNode;
      nextNode = nextNode.next;
      return save.item;
    }

  }
}
