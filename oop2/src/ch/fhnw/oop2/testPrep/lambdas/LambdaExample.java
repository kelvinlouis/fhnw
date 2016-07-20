package ch.fhnw.oop2.testPrep.lambdas;

import java.util.*;
import java.util.stream.Collectors;


public class LambdaExample{
  
  public static void main(String[] args){
      Player bazooka = new Player("Bazooka", "Thunder");
      Player crunchy = new Player("Crunchy", "Stormey");
      Player darthvd = new Player("Darthvd", "Thunder");
      Player earthqk = new Player("Earthqk", "Thunder");
      Player faaancy = new Player("Faaancy", "Stormey");
      Player chieeef = new Player("Chieeef", "Keeeeef");

      List<Score> table = new ArrayList<>();

      table.add(new Score(earthqk, 3, 36));
      table.add(new Score(bazooka, 4, 99));
      table.add(new Score(bazooka, 3, 41));
      table.add(new Score(chieeef, 3, 41));
      table.add(new Score(crunchy, 4, 72));
      table.add(new Score(faaancy, 2, 25));
      table.add(new Score(crunchy, 4, 75));
      table.add(new Score(darthvd, 4, 96));


      // Beispiel 1 : Liste aller Teams (ohne Duplikate)
      List<String> res_1 = table.stream()
              .map(score -> score.getPlayer().getTeam())
              .distinct()
              .collect(Collectors.toList());
      System.out.println(res_1);

      // Beispiel 2 : alle Spieler eines Teams, sortiert nach Nickname
      List<Player> res_2 = table.stream()
              .map(Score::getPlayer)
              .filter(player -> player.getTeam().equals("Thunder"))
              .distinct()
              .sorted(Comparator.comparing(Player::getName))
              .collect(Collectors.toList());
      System.out.println(res_2);


      // Beispiel 3 : gibt es einen Spieler im Team "Blaark"?
      boolean b = table.stream()
              .anyMatch(score -> score.getPlayer()
                      .getTeam()
                      .equals("Blaark"));
      System.out.println(b);


      // Beispiel 4 : Namen aller Spieler als String
      String s = table.stream()
              .map(score -> score.getPlayer().getName())
              .distinct()
              .sorted()
              // "" indicates the type and is the starting value (n1) accumulator
              .reduce("", (n1, n2) -> n1 +  " " + n2);
      System.out.println(s);


      // a) alle Spieler einer bestimmten Runde, nach Punkten sortiert
      List<Score> res_3 = table.stream()
              .filter(t -> t.getRound() == 3)
              .sorted(Comparator.comparing(Score::getPoints))
              .collect(Collectors.toList());
      System.out.println(res_3);


      // b) alle Spieler des Teams "Stormey" in das Team "Blaark" umteilen
      table.stream()
              .map(Score::getPlayer)
              .filter(player -> player.getTeam().equals("Stormey"))
              .forEach(player -> player.setTeam("Blaark"));
      System.out.println(table);


      // c) max
      int max = table.stream()
              .map(Score::getPoints)
              // 0 indicates the type and starting value
              .reduce(0, Integer::max);
      System.out.println("c: " + max);


      // Find min differently
      int min = table.stream()
              .mapToInt(Score::getPoints)
              .min()
              .orElse(0);
      System.out.println(min);

      // Find min differently again
      int min2 = table.stream()
              .min((o1, o2) -> Integer.compare(o1.getPoints(), o2.getPoints()))
              .get().getPoints();
      System.out.println(min2);


      // d) wieviele Spieler besitzt das Team "Thunder"?
      long t = table.stream()
              .map(Score::getPlayer)
              .filter(player -> player.getTeam().equals("Thunder"))
              .distinct()
              .count();
      System.out.println("d: " + t);


      // e) Summe der Punkte des Teams "Thunder"
      int p = table.stream()
              .filter(score -> score.getPlayer().getTeam().equals("Thunder"))
              .collect(Collectors.summingInt(Score::getPoints));
      System.out.println("e: " + p);
  }
}
