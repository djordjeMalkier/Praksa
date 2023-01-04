package zivkovicj.zadaci;

import java.util.*;

public class BinaryTree {
    private Node root;
    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    // insert a new number into the binary tree
    public void insert(int value) {
        root = insert(root, value);
    }

    // recursive function to insert a new number into the binary tree
    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        int balance = getBalance(root);

        // Left-left case
        if (balance > 1 && value < root.left. value) {
            return rightRotate(root);
        }

        // Right-right case
        if (balance < -1 &&  value > root.right. value) {
            return leftRotate(root);
        }

        // Left-right case
        if (balance > 1 &&  value > root.left. value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right-left case
        if (balance < -1 &&  value < root.right. value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return node;
    }
    public void insertElements() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Koliko brojeva zelite da unesete?");
        int n = scanner.nextInt();

        System.out.print("Unesite brojeve:");
        for (int i = 0; i < n; i++) {
            insert(scanner.nextInt());
        }
    }
    public void printLevelOrder() {
        Queue<Node> queue = new LinkedList<>();
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

            /*Enqueue left child */
            if (temp.left != null) {
                queue.add(temp.left);
            }

            /*Enqueue right child */
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
    public  Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    public  Node rightRotate(Node node) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    private int getHeight(Node node)
    {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int getBalance( Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }

}
