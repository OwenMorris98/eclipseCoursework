/*
 * COSC 310-001   Assignment 3

 * SLList.java
 *
 * This class creates a single link list 
 * that will be used with the employee list
 * 
 * @author  Owen Morris

 */
public class SLList<E extends Comparable> {
	private Node<E> head;

	private int size;

	public SLList() {
		head = null;
		size = 0;

	}

    public void add( E item )
    {
        head = new Node<E>( item, head );
        size++;
    }

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int position = 0;
		Node<E> p = head;
		while (position < index) {
			p = p.next;
			position++;
		}
		return p.data;
	}

	public int indexOf(E target) {
		Node<E> p = head;
		int index = 0;
		while (p != null) // check for end of list
		{
			if (target.compareTo(p.data) == 0) // target found
			{
				return index;
			}
			p = p.next;
			index++;
		}
		return -1; // target not found

	}

	public E remove(int index) {
		Node<E> p = head;
		int position = 0;
		while (position < index - 1) {
			p = p.next;
			position++;
		}
		p.next = p.next.next;
		size--;
		return p.data;

	}

	public int size() {
		return size;
	}

	/**
	 * Node inner class
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
}
