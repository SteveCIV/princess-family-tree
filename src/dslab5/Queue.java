package dslab5;

/**
 *
 * @author conor
 */
public interface Queue<E> {
    
    public void enqueue(E item) throws QueueException;
    
    public E dequeue() throws QueueException;
    
    public boolean isEmpty();
}
