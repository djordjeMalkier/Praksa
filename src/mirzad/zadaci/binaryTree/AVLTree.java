package mirzad.zadaci.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class AVLTree {

    Node root;
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int value) {

        if (node == null)
            return (new Node(value));

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    public void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            if(temp!=null)
                System.out.print(temp.value + " ");

            if(temp == null) {
                System.out.println();
                if(queue.isEmpty()) break;
                queue.add(null);
                continue;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    int findDepth(Node node)
    {

        if (node == null)
            return 0;

        else {


            int leftDepth = findDepth(node.left);
            int rightDepth = findDepth(node.right);

            if (leftDepth > rightDepth)
                return (leftDepth + 1);

            else
                return (rightDepth + 1);

        }
    }

    Node commonAncestor(Node root, int p, int q) {
        if(root==null)
            return null;

        if(root.value==p || root.value==q)
            return root;

        Node left= commonAncestor(root.left,p,q);
        Node right= commonAncestor(root.right,p,q);

        if(left!=null && right!=null)
            return root;

        return(left!=null ? left : right);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 5);

        tree.printLevelOrder();
        System.out.println(tree.findDepth(tree.root));

        Node node = tree.commonAncestor(tree.root, 2, 4);
        System.out.println(node.value);
    }
}
