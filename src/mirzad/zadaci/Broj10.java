package mirzad.zadaci;

public class Broj10 {
    public static void main(String[] args) {
        String[] strings = {"sa10sas","sa10sa20","20sds10s","sa102sas","10av20sa10gh"};

        if (strings != null){
            for (String string : strings){

                char[] chars = string.toCharArray();
                boolean flag = false;
                int n = chars.length;

                for (int i = 0; i < n; i++){
                    char c = chars[i];

                    if (Character.isDigit(c)){

                        if(c == '1') {
                            if(i+2 != n) {
                                if (chars[i+1] == '0' && Character.isAlphabetic(chars[i+2])) flag = true;
                            } else {
                                if (chars[i+1] == '0') flag = true;
                            }
                            continue;
                        }

                        if (c == '2') {
                            if(i+2 != n) {
                                if (chars[i+1] == '0' && Character.isAlphabetic(chars[i+2])) {
                                    if(flag){
                                        flag = false;
                                        break;
                                    }
                                    else flag = false;
                                }
                            } else {
                                if (chars[i+1] == '0') {
                                    if(flag){
                                        flag = false;
                                        break;
                                    }
                                    else flag = false;
                                }
                            }
                            continue;
                        }
                    }
                }
                if (flag) System.out.println(string);
            }
        }
    }
}
