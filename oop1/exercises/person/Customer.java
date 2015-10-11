class Customer extends Person {
    private final int NUMBER;

    public Customer() {
    	NUMBER = createNumber();
    }

    public Customer(int number) {
        NUMBER = number;
    }

    public int getNumber () {
        return NUMBER;
    }

    public void warn () {
        
    }

    private static int createNumber() {
    	return (int) (Integer.MAX_VALUE * Math.random());
    }

}