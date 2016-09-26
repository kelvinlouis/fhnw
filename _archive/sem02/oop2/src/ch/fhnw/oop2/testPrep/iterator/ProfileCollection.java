package ch.fhnw.oop2.testPrep.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kelvin on 05-Jul-16.
 */
public class ProfileCollection implements Iterable<Profile> {
    private ArrayList<Profile> m_Profiles;

    public Iterator<Profile> iterator() {
        Iterator<Profile> iprof = m_Profiles.iterator();
        return iprof;
    }
}