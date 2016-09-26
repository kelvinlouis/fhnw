import java.util.List;
import java.util.function.Predicate;

/**
 * Created by user on 3/22/16.
 */
public class Ex2 {

    public static void main(String[] args) {

    }

    public static void keepSameSize(List<Kleidungsstueck> kleidungstuecke, int size) {
        kleidungstuecke.removeIf(new Predicate<Kleidungsstueck>() {
            @Override
            public boolean test(Kleidungsstueck kleidungsstueck) {
                return false;
            }
        });

    }

    public static void replaceSize(List<Kleidungsstueck> kleidungstuecke, int size){
        kleidungstuecke.stream().forEach(x -> x.setSize(size));
    }

    public static int maxShoesize(List<Kleidungsstueck> kleidungsstuecke) {
        return kleidungsstuecke.stream()
                .filter( x -> x instanceof Schuh)
                .mapToInt( x -> x.getSize()).max()
                .getAsInt();
    }
 }
