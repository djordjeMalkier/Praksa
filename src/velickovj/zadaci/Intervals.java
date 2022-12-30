package velickovj.zadaci;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Intervals {

    public static void main(String[] args) {
//        Object object1=new Object(LocalDateTime.of(2019,11,25, 10,50),LocalDateTime.of(2019,11,26, 10,50));
        Object object2 = new Object(LocalDateTime.of(2019, 10, 20, 10, 50),
                LocalDateTime.of(2019, 10, 24, 12, 50));


        Object object3 = new Object(LocalDateTime.of(2019, 10, 27, 10, 50),
                LocalDateTime.of(2019, 10, 30, 10, 50));

        List<Object> objects = new ArrayList<>();
//        objects.add(object1);
        objects.add(object2);
        objects.add(object3);
        System.out.println(checkIntervals(objects));


    }


    public static boolean checkIntervals(List<Object> objects) {
        for (int i = 0; i < objects.size(); i++) {
            for (int j = 0; j < objects.size(); j++) {
                if (i == j)
                    continue;
                if (objects.get(i).getStartDate().isBefore(objects.get(j).getEndDate()) &&
                        objects.get(i).getEndDate().isAfter(objects.get(j).getStartDate()))

                    return true;
            }
        }
        return false;
    }
}
