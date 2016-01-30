package ch.fhnw.oop1.exam14;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public class Piece {
    private Material material;
    private double amount;
    public Piece(Material m, double mg){
        material = m;
        amount = mg;
    }
    public double getWeight(){
        return amount*material.getDensity();
    }
    public Material getMaterial(){
        return material;
    }
    public double getAmount(){
        return amount;
    }
    public void add(double amount){
        this.amount = this.amount+amount;
    }
}
