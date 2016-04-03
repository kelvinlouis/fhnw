/**
 * Created by user on 20.03.16.
 */
public class PostItem {
    private final String receiver;
    private final double weight;

    // Versandart (A = A-Post, B = B-Post, E = Express)
    private final char dispatchMode;


    public PostItem(String receiver, double weight, char dispatchMode) {
        this.receiver = receiver;
        this.weight = weight;
        this.dispatchMode = dispatchMode;
    }

    public PostItem() {
        this("Santa Clause", 0.2, 'E');
    }

    @Override
    public String toString() {
        return "PI[" + receiver + ", " + weight + ", " + dispatchMode + "]";
    }

    public String getReceiver() {
        return receiver;
    }

    public double getWeight() {
        return weight;
    }

    public char getDispatchMode() {
        return dispatchMode;
    }
}