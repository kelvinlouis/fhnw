import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by user on 20.03.16.
 */
public class Exer4 {
    public static void main(String[] args) {
        // a
        Letter[] letters = new Letter[4];
        letters[0]= new Letter("Paul", 4.3, 'A');
        letters[1]= new Letter("Anna", 0.5, 'B');
        letters[2]= new Letter("Karl", 0.91, 'E');
        letters[3]= new Letter("Peter", 3.5, 'B');
        List<Letter> expressLetter = extractExpress(letters);

        Parcel[] parcels= new Parcel[2];
        parcels[0]= new Parcel("Karl", 0.91, 'E');
        parcels[1]= new Parcel("Peter", 3.5, 'E');
        List<Parcel> expressParcels = extractExpress(parcels);

        expressLetter.forEach(System.out::println);
        expressParcels.forEach(System.out::println);

        // b
        List<Integer> intList= new ArrayList<>();
        intList.add(1);
        intList.add(4);
        intList.add(4);
        List<Integer> intOhneDoubles = removeDoubles(intList); // [1, 4]
        intOhneDoubles.stream().forEach(System.out::println);

        List<String> stringList= new LinkedList<>();
        stringList.add("Hallo");
        stringList.add("Hallo");
        stringList.add("Hallo");
        List<String> stringOhneDoubles = removeDoubles(stringList); // [Hallo]
        stringOhneDoubles.stream().forEach(System.out::println);
    }

    public static <T extends PostItem> List<T> extractExpress(T[] arr) {
        return Stream.of(arr)
                .filter(x -> x.getDispatchMode() == 'E')
                .collect(Collectors.toList());
    }

    public static <T> List<T> removeDoubles(List<T> orig) {
        return orig.stream().distinct().collect(Collectors.toList());
    }
}
