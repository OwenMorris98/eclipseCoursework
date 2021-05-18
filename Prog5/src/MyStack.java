/*
 * COSC 310-001   Assignment 5
 * Stack.java
 * 
 * Stack implemented using a single linked list
 * 
 * @author Owen Morris
 */
public class MyStack<E>
{
    private Node<E> top;
    private int size;
    
    public MyStack()
    {
        top = null;
        size = 0;
    }
    
    /*
     * Push item onto top of stack
     * 
     * @param item to be pushed onto stack
     */
    public void push( E item )
    {
        if( top == null )        // stack is empty
        {
            top = new Node<E>( item, null );
            size++;
        }
        else
        {
            top = new Node<E>( item, top );
            size++;
        }
    }
    
    /*
     * Pop item off top of stack and remove it
     * 
     * @return item on top of stack
     */
    public E pop()
    {
        if( top == null )        // stack is empty
        {
            return null;
        }
        else
        {
            E returnValue = top.data;
            top = top.next;
            return returnValue;
        }
    }

    /*
     * Return item off top of stack but do not remove it
     * 
     * @return item on top of stack
     */
    public E peek()
    {
        if( top == null )        // stack is empty
        {
            return null;
        }
        else
        {
            return top.data;
        }
    }
    
    /*
     * Check whether stack is empty
     * 
     * @return true  if stack is empty
     *         false otherwise
     */
    public boolean Empty()
    {
        return top == null;
    }

    /*
     * Node inner class
     */
    private static class Node<E>
    {
        private E data;
        private Node<E> next;
        
        public Node(E data, Node<E> next)
        {
            super();
            this.data = data;
            this.next = next;
        }
    }
}
