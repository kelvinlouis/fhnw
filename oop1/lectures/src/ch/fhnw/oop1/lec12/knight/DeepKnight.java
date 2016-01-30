package ch.fhnw.oop1.lec12.knight;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class DeepKnight implements DeepThought, KnightWhoSaysNi {
    public static void main(String[] args) {
        DeepKnight francis = new DeepKnight();

        System.out.println(DeepThought.answer);
        System.out.println(KnightWhoSaysNi.answer);

        String s = francis.sayAnswer();

    }

    @Override
    public String sayAnswer() {
        return null;
    }
}

