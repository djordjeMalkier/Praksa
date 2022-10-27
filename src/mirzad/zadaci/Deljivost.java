package mirzad.zadaci;

public class Deljivost {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        if (nums == null) return;

        for (int num : nums){
            if(num % 3 == 0 && num % 5 == 0) System.out.println("Tri i pet");
            else if(num % 3 == 0) System.out.println("Tri");
            else if(num % 5 == 0) System.out.println("Pet");
            else System.out.println(num);
        }
    }
}