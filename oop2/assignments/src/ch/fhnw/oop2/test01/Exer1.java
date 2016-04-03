import java.util.*;

/**
 * Created by user on 20.03.16.
 */
public class Exer1 {
    public static void main() {
        List<PostItem> listB = new ArrayList<>();
        listB.add(new PostItem("Paul", 4.3, 'A'));
        listB.add(new PostItem("Anna", 0.5, 'B'));
        listB.add(new PostItem("Karl", 0.91, 'E'));
        listB.add(new PostItem("Peter", 3.5, 'B'));
        for (int i = listB.size() - 1; i > 0; i--) {
            System.out.println(listB.get(i));
        }
    }
}
