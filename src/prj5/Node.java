/**
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself 
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor 
 * will I accept the actions of those who do.
 * Nikolai Long (nikolai)
 */
package prj5E;

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
}
