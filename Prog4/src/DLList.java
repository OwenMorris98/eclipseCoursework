
/*
 * Double Linked List with Iterator
 * 
 * COSC 310
 * 
 * @author Owen Morris
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLList<E>
{
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    /*
     * Add node to tail of list
     */
    public void add( E item )
    {
        if( head == null )            // empty list
        {
            head = new Node<E>( item, null, null );
            tail = head;
            size++;
        }
        else
        {
            tail.next = new Node<E>( item, null, tail );
            tail = tail.next;
            size++;
        }
    }

    
    public E get( int index )
    {
        if( index < 0 || index >= size )
        {
            throw new IndexOutOfBoundsException( index );
        }
        
        Node<E> p = head;
        int position = 0;
        while( position < index )
        {
            p = p.next;
            position++;
        }
        return p.data;
    }
  
    public int size()
    {
        return size;
    }

    /*
     * iterator() method instantiates and return a ListIter object
     */
    public Iterator<E> iterator()
    {
        return new ListIter();
    }
    /*
     * revIterator() method instantiates and return a RevIter object
     */
    
    public Iterator<E> revIterator() {
    	return new RevIter();
    }
    
    /*
     * Node inner class
     * 
     */
    private static class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        
        public Node(E data, Node<E> next, Node<E> prev)
        {
            super();
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    /*
     * ListIter inner class
     */
    private class ListIter implements Iterator<E>
    {
        private Node<E> nextItem = head;
        private Node<E> lastItemReturned = null;
        
        public boolean hasNext()
        {
            return nextItem != null;
        }
        
        public E next()
        {
            if( !hasNext() )        // if no items left in list
            {
                throw new NoSuchElementException();
            }
            
            lastItemReturned = nextItem;
            nextItem = nextItem.next;

            return lastItemReturned.data;
        }
    }
    /*
     * RevIter inner class
     */
    private class RevIter implements Iterator<E> {
    	private Node<E> nextItem = tail;
    	private Node<E> lastItemReturned = null;
    	
    	public boolean hasNext() {
    	    return nextItem != null;
        }
        
        public E next()
        {
    		if(!hasNext()) {
    			throw new NoSuchElementException();
    			}
    		lastItemReturned = nextItem;
    		nextItem = nextItem.prev;
    		
    		return lastItemReturned.data;
    	}
    }
}
