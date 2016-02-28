package ch.fhnw.oop2.assignment01;

/**
 * Created by Kelvin on 26-Feb-16.
 */
public class Person {
    private String firstname;
    private String lastname;
    private String enrolmentNumber;

    public Person(String first, String last, String number) {
        firstname = first;
        lastname = last;
        enrolmentNumber = number;
    }

    public String getEnrolmentNumber() {
        return enrolmentNumber;
    }

    public String toString() {
        return firstname + " " + lastname + " (" + enrolmentNumber + ")";
    }
}
