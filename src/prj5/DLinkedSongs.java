// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Michael Beeson (mbeeson)
package prj5;

import java.util.Iterator;
import bag.Node;

/**
 * 
 * 
 * @author Michael Beeson (mbeeson)
 * @version 2019.11.18
 *
 * @param <E>
 *            The type of object the class will store
 */
public class DLinkedSongs<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;
    
    
    public DLinkedSongs(Reader reader) {
        init();
    }
    
    private void init() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }
    
    public boolean isEmpty() {
        return (size() == 0);
    }
    
    public int size() {
        return size;
    }
    
    public void clear() {
        init();
    }
    
    public boolean contains(T entry) {
        return lastIndexOf(obj) != -1;
    }
    
    /**
     * returns the last index of a node that contains the element given
     * or -1 if there are no nodes
     * @param obj the element to find
     * @return the last node index that contains that element
     */
    public int lastIndexOf(T obj) {
        Node<T> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1;
    }
    
    public T getData(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at " 
                + index);
        }
        else {
        return getNode(index).getData();
        }
    }
    
    public Node<T> getNode(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at " 
                + index);
        }
        Node<T> curr = head.next();
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr;
    }
    
    /**
     * Adds a node with the entry to the end of the list
     * @param newEntry the entry to add to the list
     */
    public void add(T newEntry) {
        add(size(), newEntry);
    }

    /**
     * Adds a node with the entry at the given index in the list.
     * 
     * @throws IndexOutOfBoundsException if the index
     *  is less than zero or greater than size
     * @throws IllegalArgumentException if newEntry is null
     */
    public void add(int index, T newEntry) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (newEntry == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<T> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        } 
        else {
            nodeAfter = getNode(index);
        }

        Node<T> addition = new Node<T>(newEntry);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }
    
    
    
    
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }
}
