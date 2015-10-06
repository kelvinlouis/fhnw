
class App {
	public static void main(String[] args) {
		Person person = new Person();
		person.setHeight(170);

		Employee employee = new Employee(3500);

		employee.setHeight(180);
		employee.promote();
		System.out.println(employee.getHeight());

		Customer customer = new Customer();
		System.out.println(customer.getNumber());

		Employee tomBrady = new Employee(1);
		Employee julianEdelmann = new Employee(2);

		System.out.println( averageWage(tomBrady, julianEdelmann) );
	}

	public static int averageWage(Employee a, Employee b) {
		return ( a.getWage() + b.getWage() ) / 2;
	}
}