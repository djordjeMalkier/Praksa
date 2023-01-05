package velickovj.zadaci;

public class BinaryTree {
    private Node root;

    BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int key) {
        root = insertKey(root, key);
    }
    public Node insertKey(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.getKey())
           root.setLeft( insertKey(root.getLeft(), key));
        else if (key > root.getKey())
            root.setRight(insertKey(root.getRight(), key));

        return root;
    }

}
