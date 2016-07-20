package ch.fhnw.oop2.testPrep.compare;

import java.math.BigDecimal;

/**
 * Created by Kelvin on 05-Jul-16.
 */
class Developer {
    private String name;
    private BigDecimal salary;
    private int age;

    Developer(String name, BigDecimal salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}