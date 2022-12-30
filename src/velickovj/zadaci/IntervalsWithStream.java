package velickovj.zadaci;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntervalsWithStream {
    public static void main(String[] args) {

        Object object1 = new Object(LocalDateTime.of(2019, 11, 25, 10, 50), LocalDateTime.of(2019, 11, 26, 10, 50));
        Object object2 = new Object(LocalDateTime.of(2019, 10, 28, 10, 50), LocalDateTime.of(2019, 10, 30, 10, 50));
        Object object3 = new Object(LocalDateTime.of(2019, 10, 28, 10, 50), LocalDateTime.of(2019, 10, 30, 10, 50));

        List<Object> objects = new ArrayList<>();
        objects.add(object1);
        objects.add(object2);
        objects.add(object3);


        System.out.println(checkIntervals(objects));


    }

    public static boolean checkIntervals(List<Object> objects) {

        List<Object> listOneList = objects.stream()
                .filter(two -> objects.stream()
                        .anyMatch(one ->
                                one.getStartDate().isBefore(two.getEndDate())
                                        && one.getEndDate().isAfter(two.getStartDate())
                                        && one!=two)).toList();

        for (Object o : listOneList) {
            System.out.println(o.getStartDate());
            System.out.println(o.getEndDate());
            System.out.println();
        }
        if (listOneList.size() == 0)
            return false;

        return true;
    }

}
