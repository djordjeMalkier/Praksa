public class TriVezanaBroja {
    public static void main(String[] args) {
        String[] strings = {"blablabla", "sasa123","sasfd23432", "dad32wds34", "asa32as21sa345", "dss123sdsd12d12", "123sad32sas32"};

        for (String string : strings){
            char[] chars = string.toCharArray();

            int counter = 0;
            for (char c : chars){
                if (Character.isDigit(c)) counter++;
                else {
                    if (counter >= 3) System.out.println(string);
                    counter = 0;
                }
            }
            if (counter >= 3) System.out.println(string);
            counter = 0;
        }
    }
}