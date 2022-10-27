package david.zadaci.nedelja01;

public class Zadatak01 {
    public static void main(String[] args) {
       String[] str_array = {"123primer", "pri12mer1", "primer123", "pri123mer", "12pri12er34e1234a", "12pri12er1e", "r123456a", "tre123asf23"};

        for (String string: str_array) {
            int last_index = -1;
            int num = 0;
            for (int i=0; i<string.length(); i++) {
                if (string.charAt(i) >='0' && string.charAt(i) <='9') {
                if (last_index == -1)
                        last_index = i;
                    if (i - last_index == 0) {
                        num++;
                        if (num >= 3) {
                            System.out.println(string);
                            break;
                        }
                    }
                    else
                        num = 0;
                    last_index = i + 1;
                }
            }

        }
    }
}