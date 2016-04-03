import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 20.03.16.
 */
public class MeanOfTransport<T extends PostItem> {
    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public int getNumberOfItems() {
        return list.size();
    }

    public T getMaxElement() {
        return list.stream()
                .max((x, y) -> Double.compare(x.getWeight(),y.getWeight()))
                .get();
    }

    public List<T> getPostItems(String receiver) {
        return list.stream()
                .filter( x -> x.getReceiver().equals(receiver))
                .collect(Collectors.toList());
    }
}
