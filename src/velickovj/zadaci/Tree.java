package velickovj.zadaci;

class Trunk
{
    Trunk prev;
    String str;

    Trunk(Trunk prev, String str)
    {
        this.prev = prev;
        this.str = str;
    }
};

public class Tree {
    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }
        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public static void printTree(Node root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.getRight(), trunk, true);

        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        }
        else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.getKey());

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.getLeft(), trunk, false);

    }

    public static int depth(Node root){
        if(root==null)
            return 0;

        if(root.getLeft()==null)
            return 1+depth(root.getRight());

        if(root.getRight()==null)
            return 1+depth(root.getLeft());

        return 1+Math.max(depth(root.getLeft()), depth(root.getRight()));
    }

    public static boolean isPresent(Node root, int number){
        if(root == null)
            return false;

        if(root.getKey() == number){
            return true;
        }

        return isPresent(root.getRight(),number) || isPresent(root.getLeft(),number);

    }

    public static boolean hasSameRoot(Node root, int number1, int number2){
        if(isPresent(root.getLeft(),number1) && isPresent(root.getLeft(),number2)){
            return true;
        }
        if(isPresent(root.getRight(),number1) && isPresent(root.getRight(),number2)){
            return true;
        }
        return false;

    }



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
        tree.insert(20);
        tree.insert(21);
        tree.insert(22);
        tree.insert(25);

        System.out.println("Binarno stablo");
        System.out.println();
        printTree(tree.getRoot(),null,false);
        System.out.println(depth(tree.getRoot()));
        System.out.println(hasSameRoot(tree.getRoot(),10,3));



        BalancedBinaryTree tree1 = new BalancedBinaryTree();
        tree1.setNode(tree1.insertNode(tree1.getNode(), 33));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 13));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 53));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 9));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 21));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 61));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 8));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 11));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 62));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 63));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 64));
        tree1.setNode(tree1.insertNode(tree1.getNode(), 65));

        System.out.println("Izbalansirano binarno stablo");
        System.out.println();
        printTree(tree1.getNode(),null,false);
        System.out.println(depth(tree1.getNode()));
        System.out.println(hasSameRoot(tree1.getNode(),33,13));


        BalancedBinaryTree tree2 = new BalancedBinaryTree();
        tree2.setNode(tree2.insertNode(tree2.getNode(), 6));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 4));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 8));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 3));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 11));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 2));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 1));
        tree2.setNode(tree2.insertNode(tree2.getNode(), 5));

        System.out.println("Izbalansirano binarno stablo");
        System.out.println();
        printTree(tree2.getNode(),null,false);
        System.out.println(depth(tree2.getNode()));
        System.out.println(hasSameRoot(tree2.getNode(), 3,8));


    }


}
