class Person {
    protected String firstname;
    protected String lastname;
    private int height;

    public Person() {
        
    }

    public String getFirstname () {
        return firstname;
    }

    public void setFirstname (String name) {
        firstname = name;
    }

    public String getLastname () {
        return lastname;
    }

    public void setLastname (String name) {
        lastname = name;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }
    }

    public int getHeight() {
        return height;
    }
}