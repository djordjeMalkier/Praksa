package zivkovicj.zadaci.twoBinaryTrees;

import zivkovicj.zadaci.BinaryTree;

import java.util.*;

public class TwoBinaryTrees {
    private Node root;
    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // insert a new number into the binary tree
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // recursive function to insert a new number into the binary tree
    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        } else {
            // Value already exists
            return node;
        }
        return node;
    }
    public void insertElements() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Koliko cvorova zelite da unesete za stablo?");
        int n = scanner.nextInt();

        System.out.print("Unesite brojeve za stablo:");
        for (int i = 0; i < n; i++) {
            insert(scanner.nextInt());
        }

    }
    public static void print(Node root) {
        int maxLevel = TwoBinaryTrees.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TwoBinaryTrees.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TwoBinaryTrees.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            TwoBinaryTrees.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                TwoBinaryTrees.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    TwoBinaryTrees.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    TwoBinaryTrees.printWhitespaces(1);

                TwoBinaryTrees.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    TwoBinaryTrees.printWhitespaces(1);

                TwoBinaryTrees.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(TwoBinaryTrees.maxLevel(node.left), TwoBinaryTrees.maxLevel(node.right)) + 1;
    }
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public static boolean areTreesIdentical(Node root1, Node root2)
    {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return (root1.value == root2.value
                && areTreesIdentical(root1.left, root2.left)
                && areTreesIdentical(root1.right, root2.right));
    }

    public static boolean isTreeSubtree(Node tree, Node subtree)
    {
        if (tree == null)
            return false;

        if (subtree == null)
            return true;

        if (areTreesIdentical(tree, subtree))
            return true;

        // ako root nisu jednaki
        return isTreeSubtree(tree.left, subtree)|| isTreeSubtree(tree.right, subtree);
    }
    public static void main(String[] args) {
        // za dva zadata binarna stabla treba da utvrdite da li je stablo 1 podstablo stabla 2
        // ne mora da su balansirana
        TwoBinaryTrees tree = new TwoBinaryTrees();
        TwoBinaryTrees subtree = new TwoBinaryTrees();
        tree.insertElements();
        TwoBinaryTrees.print(tree.root);
        subtree.insertElements();
        TwoBinaryTrees.print(subtree.root);
        System.out.println("Da li je stablo 2 podstablo stabla 1: " + isTreeSubtree(tree.root, subtree.root));
    }

}
