package dslab5;

/**
 *
 * @author conor
 */
public class Tree<E> {
    private TNode commonAncestor;
    private int size = 0;
    
    public Tree() {
        commonAncestor = null;
        size = 0;
    }
    
    public Tree(TNode ca) {
        this.commonAncestor = ca;
        this.size++;
    }
    
    public void setCommonAncestor(TNode newAncestor) {
        commonAncestor = newAncestor;
    }
    public TNode getCommonAncestor() {
        return commonAncestor;
    }
    public int getSize() {
        return size;
    }
}
