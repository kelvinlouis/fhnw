package ch.fhnw.oop2.testPrep.lambdas;

/**
 * Created by Kelvin on 05-Jul-16.
 */
class Player {
    private final String name;
    private String team;

    public Player(String name, String team){
        this.name = name;
        this.team = team;
    }

    public String getName(){ return this.name; }

    public String getTeam(){ return this.team; }

    public void setTeam(String team){ this.team = team; }

    @Override
    public String toString(){ return this.name + " @ " + this.team; }
}