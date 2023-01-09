package zivkovicj.zadaci.binarytree;

import velickovj.zadaci.Node;

import java.util.*;

public class BinaryTreeBalanced {
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
        }else{
            return node;
        }

       // node.setHeight(Math.max(getHeight(node.left), getHeight(node.right))+1);
        int balance = getBalance(node);

        // Left-left case
        if (balance > 1 && value < node.left.value) {
            return rightRotate(node);
        }

        // Right-right case
        if (balance < -1 &&  value > node.right.value) {
            return leftRotate(node);
        }

        // Left-right case
        if (balance > 1 &&  value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-left case
        if (balance < -1 &&  value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
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

    public  Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    public  Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    private int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return treeDepth(root.left) - treeDepth(root.right);
    }

    public static void printTree(Node root) {
        int maxLevel = treeDepth(root);

        printTreeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printTreeInternal(List< Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List< Node> newNodes = new ArrayList< Node>();
        for ( Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    public static int treeDepth(Node node) {
        if (node == null)
            return 0;

        return Math.max(treeDepth(node.left), treeDepth(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public boolean ifNodeExists(Node node, int value){
        if (node == null)
            return false;
        if (node.value == value)
            return true;

        boolean leftSubTree = ifNodeExists(node.left, value);
        boolean rightSubTree = ifNodeExists(node.right, value);

        return leftSubTree || rightSubTree;
    }

    public boolean ifTwoElementsSameRoot(Node root){
        if (root == null)
            return false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite 2 broja:");
        int node1 = scanner.nextInt();
        int node2 = scanner.nextInt();

        if(ifNodeExists(root.left, node1) && ifNodeExists(root.left, node2)){
            return true;
        } else if(ifNodeExists(root.right, node1) && ifNodeExists(root.right, node2)){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        // unosimo brojeve sa tastature, celi bez ponavljanja, automatski ih smestamo u binarno stablo i balansiramo
        // 6 4 8 3 5 7 9 - primer
        BinaryTreeBalanced tree = new BinaryTreeBalanced();
        tree.insertElements();
        BinaryTreeBalanced.printTree(tree.root);
        // dubina stabla
        System.out.println("Dubina stabla: " + BinaryTreeBalanced.treeDepth(tree.root));
        // da li imaju zajednickog pretka
        System.out.println(tree.ifTwoElementsSameRoot(tree.root));
    }

}
