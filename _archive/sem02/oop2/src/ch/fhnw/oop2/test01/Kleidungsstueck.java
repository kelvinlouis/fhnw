/**
 * Created by user on 3/22/16.
 */
public class Kleidungsstueck {
    private int size;
    private String name;
    private char gruppe;

    public Kleidungsstueck(int size, String name, char gruppe) {
        this.size = size;
        this.name =  name;
        this.gruppe = gruppe;
    }

    public Kleidungsstueck() {

    }

    @Override
    public String toString() {
        return "Kleidungsstueck [" + size + ", " + name + ", " + gruppe + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + size;
        hash = 71 * hash + gruppe;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Kleidungsstueck) {
            Kleidungsstueck other = (Kleidungsstueck) obj;
            return ((size == other.size) && (gruppe == other.gruppe));
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGruppe() {
        return gruppe;
    }

    public void setGruppe(char gruppe) {
        this.gruppe = gruppe;
    }
}
