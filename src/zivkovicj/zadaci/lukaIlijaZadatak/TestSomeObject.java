package zivkovicj.zadaci.lukaIlijaZadatak;

import velickovj.zadaci.Object;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestSomeObject {
    public static void main(String[] args) {

        SomeObject object1 = new SomeObject(LocalDateTime.of(2019, 11, 25, 10, 50),
                LocalDateTime.of(2019, 11, 26, 10, 50));
        SomeObject object2 = new SomeObject(LocalDateTime.of(2019, 10, 28, 10, 50),
                LocalDateTime.of(2019, 10, 30, 10, 50));
        SomeObject object3 = new SomeObject(LocalDateTime.of(2019, 10, 28, 10, 50),
                LocalDateTime.of(2019, 10, 30, 10, 50));

        List<SomeObject> objects = new ArrayList<>();
        objects.add(object1);
        objects.add(object2);
        objects.add(object3);
        System.out.println(checkInterval(objects));

    }
    public static boolean checkInterval(List<SomeObject> objects) {

        List<SomeObject> listOneList = objects.stream()
                .filter(two -> objects.stream()
                        .anyMatch(one ->
                                one.getStartDate().isBefore(two.getEndDate())
                                        && one.getEndDate().isAfter(two.getStartDate())
                                        && one!=two)).toList();

        for (SomeObject o : listOneList) {
            System.out.println(o.getStartDate());
            System.out.println(o.getEndDate());
            System.out.println();
        }
        return listOneList.size() != 0;
    }
}
