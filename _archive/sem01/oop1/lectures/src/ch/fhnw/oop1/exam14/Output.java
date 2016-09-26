package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Output {
    private int mCounter, hCounter, sCounter;
    public Output(){ mCounter=0; hCounter=0; sCounter=0; }
    public void add(Material m){
        mCounter++;
        m.print();
        print();
    }
    public void add(Wood h){
        hCounter++;
        Material m= h;
        add(m);
    }
    public void add(Stone s){
        sCounter++;
        Material m= s;
        add(m);
    }
    public void print(){
        System.out.println(mCounter+" "+hCounter+" "+sCounter);
    }
}