package mirzad.zadaci.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
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
}
