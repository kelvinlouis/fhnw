package ch.fhnw.oop2.assignment02;

/**
 * Created by Kelvin on 17-Mar-16.
 */
public class TestGenerics {
    public static void main(String[] args) {
        Box box = new Box();

        Box<ClassA, Integer> aBox = new Box<>();
        Box<ClassB, Integer> bBox = new Box<>();
        Box<ClassC, Integer> cBox = new Box<>();
        Box<ClassD, Integer> dBox = new Box<>();

        ClassA a1 = new ClassA();
        ClassB b1 = new ClassB();
        ClassC c1 = new ClassC();
        ClassD d1 = new ClassD();

        // U7
        aBox.setValue(a1);
        aBox.setValue(b1);
        aBox.setValue(c1);
        aBox.setValue(d1);
        bBox.setValue(b1);
        bBox.setValue(d1);
        cBox.setValue(c1);
        dBox.setValue(d1);

        a1 = bBox.getValue();
        b1 = bBox.getValue();

        box = aBox;
        box = dBox;
        // aBox = bBox doesn't work,
        // because Box<ClassA> as a whole doesn't extend Box<ClassB>
        // just because ClassA extends ClassB, doesn't mean boxes of a type do
        // This is true for this example as well:
        // Box<Number> b = new Box<Integer>();

        // Wildcards
        Box<?,?> wBox = new Box<>();
        wBox = aBox;
        wBox = cBox;
        wBox = dBox;
    }
}
