
public class TreeNode<K extends Comparable<K>, V> {
    private Association<K, V> data;
    private TreeNode<K, V> leftChild;
    private TreeNode<K, V> rightChild;

    public TreeNode(Association<K, V> data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Getters y setters
    public Association<K, V> getData() {
        return data;
    }

    public void setData(Association<K, V> data) {
        this.data = data;
    }

    public TreeNode<K, V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<K, V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }
}