package velickovj.zadaci;



public class Tree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);
        System.out.println(tree.getRoot());
        tree.printTree(tree.getRoot());
        System.out.println();


        BalancedBinaryTree tree1 = new BalancedBinaryTree();

        tree1.setNode(tree1.insertNode(tree1.getNode(), 33));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 13));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 53));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 9));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 21));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 61));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 8));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 11));
        tree1.printTree(tree1.getNode());

    }


}
