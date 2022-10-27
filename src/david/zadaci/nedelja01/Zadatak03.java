package david.zadaci.nedelja01;

/*Ako je niz brojeva, deljiv sa 5 ili 3 ispisati teksualno
ako je sa oba ispisati "pet i tri"
*/
public class Zadatak03 {
    public static void main(String[] args) {
        int[] num_array = {1, 2, 3, 4, 5, 6, 10, 15, 17};
        division(num_array);
    }

    private static void division(int[] num_array) {
        if (num_array == null)
            return;

        for (int num: num_array) {
            System.out.print(num);
            if (num % 5 == 0 && num % 3 == 0)
                System.out.println(": pet i tri");
            else if (num % 3 == 0)
                System.out.println(": tri");
            else if (num % 5 == 0)
                System.out.println(": pet");
            else
                System.out.println();
        }
    }
}
