package chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class MyStack implements Iterable, Cloneable {
    private int N;                // size of the stack
    private Node first;     // top of stack

    // helper linked list class
    private static class Node implements Cloneable {
        private String item;
        private Node next;
        public Node(){
        	next = null;
        }
    }
    
	/**
     * Initializes an empty stack.
     */
    public MyStack() {
        first = null;
        N = 0;
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return N;
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     * @return the sequence of items in the stack in LIFO order, separated by spaces
     */
 /*   public String toString() {
        StringBuilder s = new StringBuilder();
        for (String item : this)
            s.append(item + " ");
        return s.toString();
    }*/
       

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator iterator() {
        return new ListIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator {
        private Node current;

        public ListIterator(Node first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String item = current.item;
            current = current.next; 
            return item;
        }
    }
    public MyStack copy(){
    	MyStack copy = new MyStack();
    	Iterator it = iterator();
    	
    	if(it.hasNext()){
    		copy.first = new Node();;
    		first.item = (String)it.next();
    		first.next = null;
    	}
    	Node p = copy.first;
    	Node q = null;
    	copy.N = 1;
    	while(it.hasNext()){
    		q = p;
    		p = new Node();
    		p.item =(String)it.next();
    		q.next = p;
    		copy.N ++;
    	}
    	return copy;
    }

    /**
     * Unit tests the <tt>Stack</tt> data type.
     */
    public static void main(String[] args) {
        MyStack s = new MyStack();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) s.pop();
        }
        MyStack copy = s.copy();
        StdOut.println("(" + copy.size() + " left on stack)");
    }
}
