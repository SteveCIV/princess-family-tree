package dslab5;

/**
 *
 * @author conor
 */
public class TNode<E> {
    private Princess princess;
    private TNode firstChild;
    private TNode nextSibling;
    
    public TNode() {
        this.princess = null;
        this.firstChild = null;
        this.nextSibling = null;
    }
    
    public TNode(Princess princess) {
        this.princess = princess;
        this.firstChild = null;
        this.nextSibling = null;
    }
    
    public Princess getPrincess() {
        return princess;
    }
    public void setPrincess(Princess princess) {
        this.princess = princess;
    }
    public TNode getFirstChild() {
        return firstChild;
    }
    public void setFirstChild(TNode child) {
        firstChild = child;
    }
    public TNode getNextSibling() {
        return nextSibling;
    }
    public void setNextSibling(TNode sibling) {
        this.nextSibling = sibling;
    }
    @Override
    public String toString() {
        return "Princess (" + princess.toString() + 
                ") First Child: " + ((firstChild == null) ? "null" : firstChild.princess.getName()) +
                " Next Sibling: " + ((nextSibling == null) ? "null" : nextSibling.princess.getName());
    }
}
