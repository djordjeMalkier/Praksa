package mirzad.zadaci.binaryTree;

import java.util.Scanner;

public class CreateBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers: ");

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int number = scanner.nextInt();
                tree.add(number);
            } else {
                System.out.println("Not a valid enter!");
                break;
            }
        }

        tree.printLevelOrder();

    }
}
