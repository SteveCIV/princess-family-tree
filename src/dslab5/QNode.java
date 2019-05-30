package dslab5;

/**
 *
 * @author conor
 */
public class QNode<E> {
    
    public E item;
    public QNode<E> next;

    public QNode(E item, QNode<E> next) {
        this.item = item;
        this.next = next;
    }

    public QNode(E item) {
        this(item, null);
    }
}