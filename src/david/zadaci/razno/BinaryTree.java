package david.zadaci.razno;

import java.util.Scanner;

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int data) {
        root = new Node(data);
    }

    public static void insert(Node node, int value) {
        if (value < node.data) {
            if (node.left != null)
                insert(node.left, value);
            else {
                System.out.println("Inserted " + value + " to left of Node " + node.data);
                node.left = new Node(value);
            }
        } else if (value > node.data) {
            if (node.right != null)
                insert(node.right, value);
            else {
                System.out.println("Inserted " + value + " to right of Node " + node.data);
                node.right = new Node(value);
            }
        }
    }

    public void insert(int value) {
        /*if (root == null) {
            root = new Node(value);
        }
        else insert( value, root);
        */
        root = insert(value, root);
    }

    public void insertElements() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert elements: ");
        while (sc.hasNextInt()) {
            insert(sc.nextInt());
        }

        sc.close();
    }

    public void print() {
        print("", root, false);
    }

    private void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public int height() {
        return height(root) + 1;
    }

    private int height(Node parent) {
        if (parent == null)
            return -1;

        int l = 0;
        int r = 0;

        if (parent.left != null)
            l = height(parent.left) + 1;

        if (parent.right != null)
            r = height(parent.right) + 1;

        return (Math.max(l, r));
    }

    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        else if (data < node.data) {
            node.left = insert( data, node.left );
            if (height( node.left ) - height( node.right ) == 2)
                if (data < node.left.data)
                    node = rotateWithLeftChild( node );
                else
                    node = doubleWithLeftChild( node );
        }
        else if (data > node.data) {
            node.right = insert( data, node.right );
            if (height( node.right ) - height( node.left ) == 2)
                if (data > node.right.data)
                    node = rotateWithRightChild( node );
                else
                    node = doubleWithRightChild( node );
        }
        // Duplicate; do nothing

        return node;
    }
    /* Rotate binary tree node with left child */
    private Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node k1) {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    private Node doubleWithLeftChild(Node k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private Node doubleWithRightChild(Node k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    //za dva broja, da li imaju zajednicki koren
    public boolean inSameSubTree(Node node, int x, int y) {
        if (node == null)
            return false;

        return (contains(node.left, x) && contains(node.left, y)) ||
                (contains(node.right, x) && contains(node.right, y));
    }

    private boolean contains(Node node, int num) {
        if (node == null)
            return false;

        if (node.data == num)
            return true;

        return contains(node.left, num) || contains(node.right, num);
    }

}
