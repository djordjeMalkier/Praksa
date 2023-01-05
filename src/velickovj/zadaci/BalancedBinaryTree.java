package velickovj.zadaci;

public class BalancedBinaryTree {
    private Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int height(Node N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }



    public Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.setHeight(Math.max(height(y.getLeft()),height(y.getRight()))+1);
        x.setHeight(Math.max(height(x.getLeft()),height(x.getRight()))+1);
        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        y.setHeight(Math.max(height(y.getLeft()),height(y.getRight()))+1);
        x.setHeight(Math.max(height(x.getLeft()),height(x.getRight()))+1);
        return y;
    }

    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }


    public Node insertNode(Node node, int key) {
        if (node == null)
            return (new Node(key));

        if (key < node.getKey())
            node.setLeft( insertNode(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insertNode(node.getRight(), key));
        else
            return node;



        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight()))+1);
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (key < node.getLeft().getKey()) {
                return rightRotate(node);
            } else if (key > node.getLeft().getKey()) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (key > node.getRight().getKey()) {
                return leftRotate(node);
            } else if (key < node.getRight().getKey()) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }
        return node;
    }



}
