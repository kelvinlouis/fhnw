import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 20.03.16.
 */
public class Exer2 {
    public static void main(String[] args) {
        List<PostItem> listB = new ArrayList<>();
        listB.add(new PostItem("Paul", 4.3, 'A'));
        listB.add(new PostItem("Anna", 0.5, 'B'));
        listB.add(new PostItem("Karl", 0.91, 'E'));
        listB.add(new PostItem("Heinz", 0.4, 'E'));

        printSortedList(listB);
        System.out.println("++++++++++++++++");
        System.out.println(getExpressWeight(listB));
    }

    public static void printSortedList(List<PostItem> list) {
        list.sort(new Comparator<PostItem>() {
            @Override
            public int compare(PostItem o1, PostItem o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });

        list.forEach(System.out::println);
    }

    public static double getExpressWeight(List<PostItem> list) {
        return list.stream()
                .filter(x -> x.getDispatchMode() == 'E')
                .mapToDouble(PostItem::getWeight)
                .sum();
    }
}
