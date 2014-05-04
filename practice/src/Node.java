
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 *
 * @author Arun Kumar Parayatham
 */

/*
 * This class is a node in a tree which is used to create decision tree.
 */
public class Node<T> {

    private T data;
    private List<Node<T>> children;

    public Node() {
        super();
    }

    //Deafault constructor
    public Node(T data) {
        this();
        setData(data);
        if (children == null) {
            children = new ArrayList<Node<T>>();
        }
    }

    /**
     * Return the children of Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose children are represented by a List<Node<T>>. Each of
     * these Node<T> elements in the List can have children. The getChildren()
     * method will return the children of a Node<T>.
     * @return the children of Node<T>
     */
    public List<Node<T>> getChildren() {
        if (this.children == null) {
            return new ArrayList<Node<T>>();
        }
        return this.children;
    }

    /**
     * Sets the children of a Node<T> object. 
     * @param children the List<Node<T>> to set.
     */
    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    /**
     * Returns the number of immediate children of this Node<T>.
     * @return the number of immediate children.
     */
    public int getNumberOfChildren() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }

    /**
     * Adds a child to the list of children for this Node<T>. The addition of
     * the first child will create a new List<Node<T>>.
     * @param child a Node<T> object to set.
     */
    public Node addChild(Node<T> child) {
        if (children == null) {
            children = new ArrayList<Node<T>>();
        }
        children.add(child);
        return this;
    }

    /**
     * Inserts a Node<T> at the specified position in the child list. Will     * throw an ArrayIndexOutOfBoundsException if the index does not exist.
     * @param index the position to insert at.
     * @param child the Node<T> object to insert.
     * @throws IndexOutOfBoundsException if thrown.
     */
    private void insertChildAt(int index, Node<T> child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            // this is really an append
            addChild(child);
            return;
        } else {
            children.get(index); //just to throw the exception, and stop here
            children.add(index, child);
        }
    }

    /**
     * Remove the Node<T> element at index index of the List<Node<T>>.
     * @param index the index of the element to delete.
     * @throws IndexOutOfBoundsException if thrown.
     */
    private void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public T getData() {
        return this.data;
    }

    private void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(getData().toString()).append(",[");
        int i = 0;
        for (Node<T> e : getChildren()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(e.getData().toString());
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }
     /**
     * Check weather two nodes have same data and children
     */
    public boolean equals(Node<T> Second)
    {
        boolean isEqual = false;
        if (this.getClass() == Second.getClass())
        {
            if ((Second.data).equals(this.data) &&
                    (Second.children).equals(this.children))
            {
                isEqual = true;
            }
        }

        return isEqual;
    }
    /**
     * Returns the number of leaves of this Node<T>.
     * @return the number of leaves of this Node.
     */
    public int getNumberOfLeaves(){
        if(this==null){
            return 0;
        }
        if(this.getNumberOfChildren()==0){
           return 1;
        }
            
        else{
            int count=0;
            for(int i=0; i<this.getNumberOfChildren();i++){
                count+=this.getChildren().get(i).getNumberOfLeaves();
            }
            return count;
        }
    }
     /**
     * Return the leaves of Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose leaves are represented by a List<Node<T>>. Each of
     * these Node<T> elements in the List can have leaves. The getLeaves()
     * method will return the leaves of a Node<T>.
     * @return the leaves of Node<T>
     */
    public List<Node<T>> getLeaves(){
        if(this==null){
            return null;
        }
        if(this.getNumberOfChildren()==0){
           List<Node<T>> AL=new ArrayList<Node<T>>();
           AL.add(this);
            return AL;
        }

        else{
            List<Node<T>> AL=new ArrayList<Node<T>>();
            for(int i=0; i<this.getNumberOfChildren();i++){
                AL.addAll(this.getChildren().get(i).getLeaves());
            }
            return AL;

        }
    }
    public int[] getLeafLevels(int[] leafl, int k){
        if(this==null){
            return null;
        }
        if(this.getNumberOfChildren()==0){
            for(int p=0;p<leafl.length;p++){
             if(p==k){
                 leafl[p]++;
             }
            }
            return leafl;
        }

        else{
            k++;
            for(int i=0; i<this.getNumberOfChildren();i++){
                this.getChildren().get(i).getLeafLevels(leafl, k);
            }
            return leafl;

        }
    }

    public int[] getNodesatLevels(int[] nodes, int l){
        if(this==null){
            return null;
        }
        if(this.getNumberOfChildren()==0){
            return nodes;
        }

        else{
            nodes[l]++;
            l++;
            for(int i=0; i<this.getNumberOfChildren();i++){
                this.getChildren().get(i).getNodesatLevels(nodes, l);
            }
            return nodes;

        }
    }

    /**
     * Return the prune Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose leaves are represented by a List<Node<T>>.
     * If all of the leaf nodes of the root Node<T> have the same data of the Node,
     * then it returns a new Node with data of the root Node<T> and children is
     * a new list having only one leaf node.
     *@return the pruned Node<T> of the root Node<T>
     */
    private Node prune()throws IOException{
        List<Node<T>> AL=this.getLeaves();
        ListIterator iter = AL.listIterator();
        T str=AL.get(0).data;
        int flag=0;
        while (iter.hasNext()){
            T str1=((Node<T>)iter.next()).data;
            if(!str1.equals(str)){
                flag=1;
                break;
            }

        }
        if(flag!=0){
            return this;
        }
        else{
            Node<T> node1=new Node(str);
            List<Node<T>> LN=new ArrayList<Node<T>>();
            LN.add(node1);
            this.setChildren(LN);
            return this;
        }
    }
    /**
     * Return the prune Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose leaves are represented by a List<Node<T>>.
     * It prunes the root Node<T> and recursively prune its all children
     * and return the final pruned root <Node<T>
     * @return the complteprune Node<T> of the root Node<T>
     */
    private Node completePrune()throws IOException{
        if(this.getNumberOfChildren()==0){
        }
        else{
            this.prune();
            for(int i=0;i<this.getNumberOfChildren();i++){
                this.getChildren().get(i).completePrune();
            }

        }
        return this;
    }
    public Node getCompletePruneNode()throws IOException{
        this.completePrune();
        return this;
    }
}

