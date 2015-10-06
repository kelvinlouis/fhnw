class Employee extends Person {
    private int id;
    private int wage;

    public Employee(int startingWage) {
        wage = startingWage;
    }

    public int getId () {
        return id;
    }

    public void promote () {
        wage += 500;
        setHeight(getHeight() + 10);

        System.out.println("Thanks buddy!");
    }

}