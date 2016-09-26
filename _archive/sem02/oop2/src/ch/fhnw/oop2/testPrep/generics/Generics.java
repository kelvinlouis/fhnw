package ch.fhnw.oop2.testPrep.generics;

//                  +-----------------
//                  | Kleidungstueck +-----+
//              +---------------------     |
//              |                          |
//              |                          |
//        +-----v----+                 +---v---+
//        | Oberteil |                 | Schuh |
//        +----------+                 +-------+
//          |       |                      |
//          |       |                      |
//  +-------v--+   +v--------+      +------v-------+
//  | Pullover |   |  Jacke  |      | Arbeitsschuh |
//  +----------+   +---------+      +--------------+
//
public class Generics {
    public static void main(String[] args) {
        Schrank<Oberteil> schrank = new Schrank<>();
        schrank.add(new Pullover());
        //Pullover p = schrank.getElement();
        // doesn't work: Es ist unklar ob das Element wirklich ein Pullover ist

        Schrank<Pullover> schrank1 = new Schrank<>();
        schrank1.add(new Pullover());
        Kleidungsstueck p1 = schrank1.getElement();
        // Funktioniert

        //Schrank<Schuh> schrank2 = new Schrank<Arbeitsschuh>();
        // doesn't work: incompatible types

        Schrank<?> schrank3 = new Schrank<Object>();
        //schrank3.add(new Kleidungsstueck());
        Object p3 = schrank3.getElement();
        // doesn't work: Referenz kann ein Schrank von irgendeinem Typ (Object, List, alles) sein,
        // deswegen kann kein spezifisches Element hinzugefügt werden.

        Schrank<? extends Oberteil> schrank4 = new Schrank<Pullover>();
        //schrank4.add(new Pullover());
        Oberteil p = schrank4.getElement();
        // doesn't work: Es ist unklar vom welchem Typ der Schrank ist.
        // Es könnte eine Jacke, Pullover oder ein Oberteil sein.
        // Deswegen muss man das Hinzufügen verbieten

        Schrank<? super Oberteil> schrank5 = new Schrank<Kleidungsstueck>();
        schrank5.add(new Oberteil());
        schrank5.add(new Pullover());
        //Pullover p5 = schrank5.getElement();
        // doesn't work: es ist unklar, was zurück kommt

        //schrank5.add(new Kleidungsstueck());
        // doesn't work: es ist unklar welcher Supertyp ich will: Object? Kleidungsstueck?
    }
}
