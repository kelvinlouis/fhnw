import java.util.stream.Stream;

/**
 * Created by user on 20.03.16.
 */
public class Exer3 {
    public static void main(String[] args) {
        MeanOfTransport<PostItem> mot = new MeanOfTransport<>();
        mot.add(new PostItem("Paul", 4.3, 'A'));
        mot.add(new PostItem("Anna", 0.5, 'B'));
        mot.add(new PostItem("Karl", 4.91, 'E'));
        mot.add(new PostItem("Heinz", 0.4, 'E'));
        mot.add(new PostItem("Paul", 0.4, 'E'));

        System.out.println(mot.getNumberOfItems());
        System.out.println(mot.getMaxElement());
        Stream.of(mot.getPostItems("Paul")).forEach(System.out::println);
    }
}
