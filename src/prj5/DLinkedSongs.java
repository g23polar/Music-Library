// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Michael Beeson (mbeeson)
package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
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

    /**
     * @author Nikolai Long (nikolai)
     * @version Nov 18, 2019
     *
     * DLLIterator Class
     */
    private class DLListIterator<A> implements Iterator<T>
    {
        private Node<T> current;
        private boolean calledNext;

        /**
         * DLListIterator constructor
         */
        public DLListIterator()
        {
            current = head;
            calledNext = false;
        }

        /**
         * hasNext method
         * @return whether there is a next Node
         */
        public boolean hasNext()
        {
            return current.next().getData() != null;
        }

        /**
         * next method, moves the iterator
         * @return the song of the next node
         */
        public T next()
        {
            if (hasNext())
            {
                current = current.next();
                calledNext = true;
                return current.getData();
            }
            throw new NoSuchElementException();
        }
        
        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *        and  if the element has already been removed
         */
        @Override
        public void remove() {
            if (calledNext) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                calledNext = false;
            }
            else {
                throw new IllegalStateException("Next has not been called");
            }
        }
    }

    /**
     * @author Nikolai Long (nikolai)
     * @version Nov 18, 2019
     *
     * Node Class
     */
    private static class Node<T>
    {
        private Node<T> next;
        private Node<T> previous;
        private T data;

        /**
         * Node constructor
         * @param data song
         */
        public Node(T data)
        {
            this.data = data;
        }

        /**
         * setNext method
         * @param node to be set
         */
        public void setNext(Node<T> node)
        {
            next = node;
        }

        /**
         * setPrevious method
         * @param node to be set
         */
        public void setPrevious(Node<T> node)
        {
            previous = node;
        }

        /**
         * next method
         * @return the next node
         */
        public Node<T> next()
        {
            return next;
        }

        /**
         * previous method
         * @return the previous node
         */
        public Node<T> previous()
        {
            return previous;
        }

        /**
         * getData method
         * @return the data in the node
         */
        public T getData()
        {
            return data;
        }
        
        public void setData(T newData) {
            data = newData;
        }
    }


    public DLinkedSongs() {
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
        return lastIndexOf(entry) != -1;
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

    private Node<T> getNode(int index) {
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
        if (index > size) {
            throw new IndexOutOfBoundsException(">size");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("<0");
        }
        if (newEntry == null) {
            throw new IllegalArgumentException();
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
     * @return new DLListIterator object
     */
    public DLListIterator<Song> iterator() {
        return new DLListIterator<Song>();
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        DLListIterator<Song> iter = iterator();
        
        if (iter.hasNext()) {
            Node<T> curr = (Node<T>)iter.next();
            while (curr != tail) {
                str.append((curr).getData().toString());
                if (iter.hasNext()) {
                    str.append(", ");
                }  
                curr = curr.next();
            }
        }

        str.append("]");
        return str.toString();
    }
    
    
}
