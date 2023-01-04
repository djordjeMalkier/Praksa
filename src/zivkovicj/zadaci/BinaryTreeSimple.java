package zivkovicj.zadaci;


public class BinaryTreeSimple {
    public static void main(String[] args) {
        // br sa tastature, celi bez ponavljanja, automatski ih smestamo u binarno stablo,
        // 6 4 8 3 5 7 9
        BinaryTree tree = new BinaryTree();
        tree.insertElements();
        tree.printLevelOrder();

    }
}
