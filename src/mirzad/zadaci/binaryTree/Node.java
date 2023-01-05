package mirzad.zadaci.binaryTree;

public class Node {
    int value;
    int height;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.height = 1;
        right = null;
        left = null;
    }
}
