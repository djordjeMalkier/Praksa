package tamara.zadaci.lista_objekata;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ListOfObjectsOverlaps {
    public static void main(String[] args) {
        Objects o1 = new Objects(
                LocalDateTime.of(2022, 6, 12, 3, 21),
                LocalDateTime.of(2022, 6, 17, 3, 21)
        );

        Objects o2 = new Objects(
                LocalDateTime.of(2022, 7, 15, 3, 21),
                LocalDateTime.of(2022, 7, 17, 3, 21)
        );
        Objects o3 = new Objects(
                LocalDateTime.of(2022, 8, 12, 3, 21),
                LocalDateTime.of(2022, 8, 17, 3, 21)
        );

        List<Objects> objects = new ArrayList<>();
        objects.add(o1);
        objects.add(o2);
        objects.add(o3);

        boolean overlapList = overlapsWithList(objects);
        System.out.println(overlapList);

        System.out.println("\n");

        boolean overlapStream =overlapsWithStream(objects);
        System.out.println(overlapStream);
    }

    public static boolean overlapsWithList(List<Objects> objects) {
        for (int i = 0; i < objects.size(); i++) {
            Objects object1 = objects.get(i);
            Instant start1 = object1.getStartTime().toInstant(ZoneOffset.UTC);
            Instant end1 = object1.getEndTime().toInstant(ZoneOffset.UTC);

            for (int j = i + 1; j < objects.size(); j++) {
                Objects object2 = objects.get(j);
                Instant start2 = object2.getStartTime().toInstant(ZoneOffset.UTC);
                Instant end2 = object2.getEndTime().toInstant(ZoneOffset.UTC);

                if (
                    (start1.isBefore(start2) && end1.isAfter(start2)) ||
                            (start1.equals(start2) || end1.equals(end2)) ||
                            (start1.isBefore(end2) && end1.isAfter(end2))
                ) {
                    //System.out.println("Vremenski interval objekta " + (i+1) + " se poklapa sa vremenskim intervalom objekta " + (j+1));
                    return true;
                }
            }
        }
        System.out.println("Vremenski intervali objekata se NE poklapaju.");
        return false;
    }

    public static boolean overlapsWithStream(List<Objects> objects) {

        return objects.stream().anyMatch(object1 -> objects.stream()
                    .filter(object2 -> object1 != object2)
                        .anyMatch(object2 -> object1
                                .getStartTime()
                                .toInstant(ZoneOffset.UTC)
                                .isBefore(object2.getEndTime()
                                        .toInstant(ZoneOffset.UTC))
                                && object1
                                .getEndTime()
                                .toInstant(ZoneOffset.UTC)
                                .isAfter(object2.getStartTime()
                                        .toInstant(ZoneOffset.UTC))));
    }
}
