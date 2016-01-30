package ch.fhnw.oop1.lec12.knight;

import java.sql.SQLException;

/**
 * Created by Kelvin on 30-Jan-16.
 */
public interface KnightWhoSaysNi {
    String answer = "Ni";

    String sayAnswer() throws SQLException;
}
