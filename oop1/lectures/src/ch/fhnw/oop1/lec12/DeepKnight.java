package ch.fhnw.oop1.lec12;

/**
 * Created by Kelvin on 08-Dec-15.
 */
public class DeepKnight implements DeepThought, KnightsWhoSayNi {
    @Override
    public String toString() {
        return KnightsWhoSayNi.answer + " " + DeepThought.answer;
    }

    @Override
    public String sayAnswer() throws IllegalArgumentException, OutOfMemoryError{
        return "";
    }
}
