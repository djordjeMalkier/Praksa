package david.zadaci.razno;

public class BinaryTreeBasic {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(8);
        binaryTree.insert(3);
        binaryTree.insert(11);
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(5);

        //binaryTree.insertElements();
        binaryTree.print();
        System.out.println("Tree height: " + binaryTree.height());


        System.out.println(binaryTree.inSameSubTree(binaryTree.root, 11,3));


    }
}
