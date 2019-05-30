package dslab5;

/**
 *
 * @author conor
 */
public class LQueue<E> implements Queue<E> {

    public QNode<E> front, back;

    public void enqueue(E obj) {

        QNode<E> temp = new QNode<E>(obj);

        if (isEmpty()) {
            front = back = temp;
        } else {
            back.next = temp;
            back = temp;
        }
    }

    public E dequeue() throws EmptyStructure {

        if (isEmpty()) {
            throw new EmptyStructure();
        } else {
            E temp = front.item;
            front = front.next;
            if (front == null) {
                back = null;
            }
            return (temp);
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}
