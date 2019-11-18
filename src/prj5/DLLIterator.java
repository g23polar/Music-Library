/**
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself 
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor 
 * will I accept the actions of those who do.
 * Nikolai Long (nikolai)
 */
package prj5E;

import java.util.NoSuchElementException;

/**
 * @author Nikolai Long (nikolai)
 * @version Nov 18, 2019
 *
 * DLLIterator Class
 */
private class DLListIterator<T> implements Iterator<T>
{
    private Node<T> current;
    private boolean calledNext;
    
    /**
     * DLListIterator constructor
     */
    public DLListIterator()
    {
        current = head;
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
}
