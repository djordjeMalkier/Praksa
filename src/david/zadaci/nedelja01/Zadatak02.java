package david.zadaci.nedelja01;

public class Zadatak02 {
    public static void main(String[] args) {
        String[] str_array = {"12103primer", "pri12mer10", "20p10rimer123", "1210a20", "12p10ri120er1e", "10te20a10ase"};
        contains10Not20(str_array);
    }

    private static void contains10Not20(String[] str_array) {
        if (str_array == null)
            return;

        for (String string: str_array)
            if (string.contains("10")) {
                String[] str_split = string.split("10");
                //if 10 is at the end of the string
                if (str_split.length != 2)
                    System.out.println(string);
                else {
                    for (int i=1; i<str_split.length; i++)
                        if (str_split[i].contains("20"))
                            return;
                    System.out.println(string);
                }
            }
    }
}
