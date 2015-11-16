package ch.fhnw.oop1.dogs2;

/**
 * Created by Kelvin on 10.11.2015.
 */
public class Highlander extends Dog {
    private static Highlander instance;

    private Highlander(){
        super("Highlander", 100);
    }

    public synchronized static Highlander getInstance() {
        if (instance == null) {
            instance = new Highlander();
        }

        return instance;
    }
}
